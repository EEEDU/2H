using MVC01.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVC01.Controllers
{
    public class SerieController : Controller
    {
        Contexto db = new Contexto();

        // GET: Serie
        public ActionResult Index()
        {
            return View();
        }

        // GET: Serie
        public ActionResult List(int id)
        {
            Contexto db = new Contexto();
            MarcaModel marca = db.Marcas.Find(id);
            return View(marca);
        }

        // GET: Serie/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Serie/Create
        public ActionResult Create()
        {
            ViewBag.MarcaID = new SelectList(db.Marcas, "ID", "Nom_marca");
            return View();
        }

        // POST: Serie/Create
        [HttpPost]
        public ActionResult Create(SerieModel serie)
        {
            try
            {
                using (var db = new Contexto())
                {
                    db.Series.Add(serie);
                    db.SaveChanges();
                }
                // TODO: Add insert logic here

                return RedirectToAction("Create");
            }
            catch
            {
                return View();
            }
        }

        // GET: Serie/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Serie/Edit/5
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

        // GET: Serie/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Serie/Delete/5
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
