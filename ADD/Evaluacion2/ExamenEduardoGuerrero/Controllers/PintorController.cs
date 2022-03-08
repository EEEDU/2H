using ExamenEduardoGuerrero.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace ExamenEduardoGuerrero.Controllers
{
    public class PintorController : Controller
    {
        Contexto db = new Contexto();
        // GET: Pintor
        public ActionResult Index()
        {
            List<PintorModel> pintor = db.Pintores.ToList();
            return View(pintor);
        }

        // GET: Pintor/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Pintor/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Pintor/Create
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

        // GET: Pintor/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Pintor/Edit/5
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

        // GET: Pintor/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Pintor/Delete/5
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
