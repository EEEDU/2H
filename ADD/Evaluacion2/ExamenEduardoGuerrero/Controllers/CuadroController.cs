using ExamenEduardoGuerrero.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace ExamenEduardoGuerrero.Controllers
{
    public class CuadroController : Controller
    {
        Contexto db = new Contexto();

        public class CuadroTotal
        {
            public int ID { get; set; }
            public string Titulo_Cuadro { get; set; }
        }
        // GET: Cuadro
        public ActionResult Index()
        {

            List<CuadroModel> cuadro = db.Cuadros.ToList();

            return View(cuadro);
        }
        // GET: Cuadro/Ejercicio1
        public ActionResult Ejercicio1(int exposicionID = 0)
        {
            ViewBag.exposicionID = new SelectList(db.Exposiciones, "ID", "Titulo_Exposicion");
            var lista = db.Database.SqlQuery<CuadroTotal>("getCuadrosExposiciones").Where(c => c.ID == exposicionID).ToList();
            return View(lista);
        }

        // GET: Cuadro/Ejercicio2
        public ActionResult Ejercicio2(int id = 0)
        {
            ViewBag.nomEstilo = db.Estilos.ToList();
            ViewBag.estilosCuadros = db.EstilosCuadros.ToList();
            ViewBag.nomPintor = db.Pintores.ToList();
            var exposicion = db.Exposiciones.Include("Cuadros").Single(e => e.ID == id);
            return View(exposicion);
        }

        // GET: Cuadro/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Cuadro/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Cuadro/Create
        [HttpPost]
        public ActionResult Create(CuadroModel cuadro)
        {
            try
            {

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Cuadro/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Cuadro/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add update logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Cuadro/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Cuadro/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}
