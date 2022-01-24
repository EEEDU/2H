using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using MVC01.Models;

namespace MVC01.Controllers
{
    public class MarcaController : Controller
    {
        // GET: Marca
        public ActionResult Index()
        {
            Contexto db = new Contexto();
            List<MarcaModel> marcas = db.Marcas.ToList();
            return View(marcas);
        }

        public ActionResult Desplegable()
        {
            Contexto db = new Contexto();
            ViewBag.Marcas = new SelectList(db.Marcas, "ID", "Nom_marca");
            ViewBag.Marcas2 = db.Marcas.ToList();
            return View();
        }

        // GET: Marca/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Marca/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Marca/Create
        [HttpPost]
        public ActionResult Create(MarcaModel marca)
        {
            try
            {
                using(var bd = new Contexto())
                {
                    bd.Marcas.Add(marca);
                    bd.SaveChanges();
                }

                return RedirectToAction("Create");
            }
            catch
            {
                return View();
            }
        }

        // GET: Marca/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Marca/Edit/5
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

        // GET: Marca/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Marca/Delete/5
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
