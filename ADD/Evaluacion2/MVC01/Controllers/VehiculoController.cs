using MVC01.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Data.Entity;
using System.Data.SqlClient;

namespace MVC01.Controllers
{
    public class VehiculoController : Controller
    {
        Contexto db = new Contexto();

        public class VehiculoTotal 
        {
            public string Nom_marca { get; set; }
            public string Nom_serie { get; set; }
            public string Matricula { get; set; }
        }
        
        // GET: Vehiculo
        public ActionResult Index()
        {
            ViewBag.nomMarca = db.Marcas.ToList();
            var vehiculos = db.Vehiculos.Include( v=> v.Serie).ToList();
            return View(vehiculos); 
        }

        // GET: Vehiculo/Listado
        public ActionResult Listado(int MarcaId = 1, int SerieId = 0)
        {
            ViewBag.MarcaId = new SelectList(db.Marcas, "ID", "Nom_marca");
            ViewBag.SerieId= new SelectList(db.Series.Where( s => s.MarcaID == MarcaId).OrderBy(x => x.Nom_serie), "ID", "Nom_serie");
            var vehiculos = db.Vehiculos.Where(x => x.SerieID == SerieId);
            return View(vehiculos);
        }

        // GET: Vehiculo/ListadoColor
        public ActionResult ListadoColor(string color = "", int MarcaId = 1, int SerieIDd= 0)
        {
            ViewBag.color = new SelectList(db.Vehiculos.Select(v => new { Color = v.Color }).Distinct(), "Color", "Color");
            var vehiculos = db.Database.SqlQuery<VehiculoTotal>("getSeriesVehiculosPorColor @ColorSel", new SqlParameter("@ColorSel", color)).ToList();
            return View(vehiculos);
        }

        // GET: Vehiculo/Listado2 
        public ActionResult Listado2()
        {
            var vehiculos = db.Database.SqlQuery<VehiculoTotal>("getSeriesVehiculos").ToList();
            return View(vehiculos);
        }

        public ActionResult Busqueda(string busca="")
        {
            var lista = (from v in db.Vehiculos where v.Matricula.Contains(busca) select v).ToList();   
            return View(lista);
        }
        public ActionResult BusquedaMatriculaEntera(string Matriculas = "")
        {
            ViewBag.Matriculas = new SelectList(db.Vehiculos, "Matricula", "Matricula");
            var lista = (from v in db.Vehiculos where v.Matricula == Matriculas select v).ToList();
            return View(lista);
        }

        public ActionResult BusquedaColor(string busca = "")
        {
            var lista = (from v in db.Vehiculos where v.Color == busca select v).ToList();
            return View(lista);
        }

        // GET: Vehiculo/Details/5
        public ActionResult Details(int id)
        {
            ViewBag.nomMarca = db.Marcas.ToList();
            var vehiculos = db.Vehiculos.Include(v => v.Serie).FirstOrDefault(v => v.ID == id);
            return View(vehiculos);
        }

        // GET: Vehiculo/Create
        public ActionResult Create()
        {
            ViewBag.SerieID = new SelectList(db.Series, "ID", "Nom_serie");
            ViewBag.ExtraList = new MultiSelectList(db.Extras, "ID", "Tipo_extra");
            return View();
        }

        // POST: Vehiculo/Create
        [HttpPost]
        public ActionResult Create(VehiculoModel vehiculo)
        {
            try
            {
                db.Vehiculos.Add(vehiculo);
                db.SaveChanges();

                foreach(var extraID in vehiculo.ExtrasSeleccionados)
                {
                    var obj = new VehiculosExtrasModel()
                    {
                        ExtraID = extraID,
                        VehiculoID = vehiculo.ID
                    };
                    db.VehiculosExtras.Add(obj);

                }
                db.SaveChanges();

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Vehiculo/Edit/5
        public ActionResult Edit(int id)
        {
            var vehiculo = db.Vehiculos.Find(id); // Buscar por el campo clave
            ViewBag.SerieID = new SelectList(db.Series, "ID", "Nom_serie", vehiculo.SerieID);
            vehiculo.ExtrasSeleccionados = db.VehiculosExtras.Where(v => v.VehiculoID == id).Select(e => e.ExtraID).ToList();
            ViewBag.ExtraList = new MultiSelectList(db.Extras, "ID", "Tipo_extra", vehiculo.ExtrasSeleccionados);

            return View(vehiculo);

        }

        // POST: Vehiculo/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, VehiculoModel vehiculo)
        {
            try
            {

                VehiculoModel vehAActualizar = db.Vehiculos.SingleOrDefault(x => x.ID == id);
                vehAActualizar.Matricula = vehiculo.Matricula;
                vehAActualizar.Color = vehiculo.Color;
                vehAActualizar.SerieID = vehiculo.SerieID;
                db.SaveChanges();

                //Elijo los extras de ese vehiculo, que habia en la tabla
                var extrasActuales = db.VehiculosExtras.Where(v => v.VehiculoID == vehiculo.ID);
                foreach(var extrasAEliminar in extrasActuales)
                {
                    db.VehiculosExtras.Remove(extrasAEliminar);
                }
                var extrasAnadir = vehiculo.ExtrasSeleccionados;
                foreach(var extrasAAnadir in extrasAnadir)
                {
                    var objVehiculoExtra = new VehiculosExtrasModel() { VehiculoID = vehiculo.ID, ExtraID = extrasAAnadir };
                    db.VehiculosExtras.Add(objVehiculoExtra);
                }
                db.SaveChanges();

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Vehiculo/Delete/5
        public ActionResult Delete(int id)
        {
            var vehiculos = db.Vehiculos.Include(v => v.Serie).FirstOrDefault(v => v.ID == id);
            return View(vehiculos);
        }

        // POST: Vehiculo/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            try
            {
                var vehiculo = db.Vehiculos.Find(id);
                db.Vehiculos.Remove(vehiculo);
                db.SaveChanges();

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}
