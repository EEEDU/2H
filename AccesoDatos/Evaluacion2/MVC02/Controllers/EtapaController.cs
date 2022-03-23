using MVC02.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVC02.Controllers
{
    public class EtapaController : Controller
    {
        Contexto db = new Contexto();
        // GET: Etapa
        public ActionResult Index()
        {
            
            List<EtapaModel> etapa = db.Etapas.ToList();
            return View(etapa);
        }

        // GET: Etapa/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Etapa/Create
        public ActionResult Create()
        {

            return View();
        }

        // POST: Etapa/Create
        [HttpPost]
        public ActionResult Create(EtapaModel etapa)
        {
            try
            {
                db.Etapas.Add(etapa);
                db.SaveChanges();

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Etapa/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Etapa/Edit/5
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

        // GET: Etapa/Delete/5
        public ActionResult Delete(int id)
        {
            var etapa = db.Etapas.Find(id);
            return View(etapa);
        }

        // POST: Etapa/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            try
            {
                var etapa = db.Etapas.Find(id);
                db.Etapas.Remove(etapa);
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
