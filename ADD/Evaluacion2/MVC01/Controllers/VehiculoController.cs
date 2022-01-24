using MVC01.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Data.Entity;

namespace MVC01.Controllers
{
    public class VehiculoController : Controller
    {
        Contexto db = new Contexto();
        // GET: Vehiculo
        public ActionResult Index()
        {
            ViewBag.nomMarca = db.Marcas.ToList();
            var vehiculos = db.Vehiculos.Include( v=> v.Serie).ToList();
            return View(vehiculos); 
        }

        // GET: Vehiculo
        public ActionResult Listado(int MarcaId = 1, int SerieID = 0)
        {
            ViewBag.MarcaId = new SelectList(db.Marcas, "ID", "Nom_marca");
            ViewBag.SerieId= new SelectList(db.Series, "ID", "Nom_serie");
            var vehiculos = db.Vehiculos.ToList();
            return View(vehiculos);
        }

        public ActionResult ListadoColor(int MarcaId = 1, int SerieID = 0)
        {
            ViewBag.color = new SelectList(db.Vehiculos.Select(v => new { Color == v.color }).Distinct());
            var vehiculos = db.Database.SqlQuery<VehiculoTotal>("getSeriesVehiculosPorColor @ColorSel").ToList();
            return View(vehiculos);
        }

        // GET: Vehiculo
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
            var vehiculos = db.Vehiculos.Include(v => v.Serie).FirstOrDefault(v => v.ID == id);
            return View(vehiculos);
        }

        // GET: Vehiculo/Create
        public ActionResult Create()
        {

            ViewBag.SerieID = new SelectList(db.Series, "ID", "Nom_serie");
            return View();
        }

        // POST: Vehiculo/Create
        [HttpPost]
        public ActionResult Create(VehiculoModel vehiculo)
        {
            try
            {
                using (var db = new Contexto())
                {
                    db.Vehiculos.Add(vehiculo);
                    db.SaveChanges();
                }
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
