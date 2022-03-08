using MVC02.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Data.Entity;
using System.Data.SqlClient;

namespace MVC02.Controllers
{
    public class CursoController : Controller
    {
        Contexto db = new Contexto();

        // GET: Curso
        public ActionResult Index()
        {
            ViewBag.nomEtapa = db.Etapas.ToList();
            List<CursoModel> curso = db.Cursos.ToList();
            return View(curso);
        }

        // GET: Curso/Listado/5
        public ActionResult Listado(int id)
        {
            var etapa = db.Etapas.Include("Cursos").Single(e => e.ID == id);
            return View(etapa);
        }

        // GET: Curso/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Curso/Create
        public ActionResult Create()
        {
            ViewBag.etapaID = new SelectList(db.Etapas, "ID", "Acronimo");
            ViewBag.asgnaturaList = new MultiSelectList(db.Asignaturas, "ID", "Nom_asignatura");
            return View();
        }

        // POST: Curso/Create
        [HttpPost]
        public ActionResult Create(CursoModel curso)
        {
            try
            {
                db.Cursos.Add(curso);
                db.SaveChanges();
                //Tambien habria que añadir el AsignaturaCurso

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Curso/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Curso/Edit/5
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

        // GET: Curso/Delete/5
        public ActionResult Delete(int id)
        {
            CursoModel curso = db.Cursos.Include(c => c.Etapa).FirstOrDefault(c => c.ID == id);
            return View(curso);
        }

        // POST: Curso/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            try
            {
                var curso = db.Cursos.Find(id);
                db.Cursos.Remove(curso);
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
