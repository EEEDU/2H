using ExamenEduardoGuerrero.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace ExamenEduardoGuerrero.Controllers
{
    public class ExposicionController : Controller
    {
        Contexto db = new Contexto();
        // GET: Exposicion
        public ActionResult Index()
        {
            List<ExposicionModel> exposicion = db.Exposiciones.ToList(); 
            return View(exposicion);
        }

        // GET: Exposicion/Ejercicio2
        public ActionResult Ejercicio2()
        {
            List<ExposicionModel> exposicion = db.Exposiciones.ToList();
            return View(exposicion);
        }

        // GET: Exposicion/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Exposicion/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Exposicion/Create
        [HttpPost]
        public ActionResult Create(FormCollection collection)
        {
            try
            {
                // TODO: Add insert logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Exposicion/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Exposicion/Edit/5
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

        // GET: Exposicion/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Exposicion/Delete/5
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
