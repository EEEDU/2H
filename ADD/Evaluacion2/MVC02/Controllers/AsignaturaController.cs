using MVC02.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Data.SqlClient;
using System.Data;

namespace MVC02.Controllers
{
	public class AsignaturaController : Controller
	{
		Contexto db = new Contexto();
		// GET: Asignatura
		public ActionResult Index()
		{
			List<AsignaturaModel> asignatura = db.Asignaturas.ToList();
			return View(asignatura);
		}

		// GET: Asignatura/Listado
		public ActionResult Listado(int etapaID = 1, int cursoID = 1)
		{
            ViewBag.etapaID = new SelectList(db.Etapas, "ID", "Acronimo");
            ViewBag.cursoID = new SelectList(db.Cursos.Where(e => e.EtapaID == etapaID), "ID", "Nom_Curso");
            int asignaturasCursosID = db.AsignaturasCursos.FirstOrDefault(a => a.CursoID == cursoID).AsignaturaID;
            List<AsignaturaModel> asignatura = db.Asignaturas.Where(a => a.ID == asignaturasCursosID).ToList();
            return View(asignatura);
		}

		// GET: Asignatura/Details/5
		public ActionResult Details(int id)
		{
			return View();
		}

		// GET: Asignatura/Create
		public ActionResult Create()
		{
			SqlConnection con = new SqlConnection("server = localhost; database = Escuela; integrated security = true");
			SqlDataAdapter da = new SqlDataAdapter("CursoEtapas", con);
			DataTable dt = new DataTable();
			da.Fill(dt);
			List<SelectListItem> list = new List<SelectListItem>();

			foreach(DataRow row in dt.Rows)
            {
				list.Add(new SelectListItem()
				{
					Text = row["Nombre"].ToString(),
					Value = row["ID"].ToString()
				});
            }

			SelectList sl = new SelectList(list, "Value", "Text");
			ViewBag.CursosList = new MultiSelectList(sl, "Value", "Text");
			return View();

		}

		// POST: Asignatura/Create
		[HttpPost]
		public ActionResult Create(AsignaturaModel asignatura)
		{
			try
			{
				db.Asignaturas.Add(asignatura);

				foreach (var cursoID in asignatura.AsignaturasCursosID)
                {
					var objeto = new AsignaturasCursosModel()
					{
						CursoID = cursoID,
						AsignaturaID = asignatura.ID
					};
					db.AsignaturasCursos.Add(objeto);
                }

				db.SaveChanges();

				return RedirectToAction("Index");
			}
			catch
			{
				return View();
			}
		}

		// GET: Asignatura/Edit/5
		public ActionResult Edit(int id)
		{
			return View();
		}

		// POST: Asignatura/Edit/5
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

		// GET: Asignatura/Delete/5
		public ActionResult Delete(int id)
		{
			var asignatura = db.Asignaturas.Find(id);
			return View(asignatura);
		}

		// POST: Asignatura/Delete/5
		[HttpPost]
		public ActionResult Delete(int id, FormCollection collection)
		{
			try
			{
				var asignatura = db.Asignaturas.Find(id);
				db.Asignaturas.Remove(asignatura);
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
