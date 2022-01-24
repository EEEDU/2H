using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace EF6
{
    public partial class Formulario : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            FutbolDBContext futbol = new FutbolDBContext();
            GridView1.DataSource = (from Equipo in futbol.Equipos
                                    from Futbolista in Equipo.Futbolista
                                    select new
                                    {
                                        NombreEquipo = Equipo.NombreEquipo,
                                        NombreFutbolista = Futbolista.NombreFutbolista
                                    }).ToList();
            GridView1.DataBind();
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            FutbolDBContext futbol = new FutbolDBContext();
            Equipo equipo = futbol.Equipos.FirstOrDefault(x => x.EquipoID == 4);
            futbol.Futbolistas.Include("equipo").FirstOrDefault(f => f.FutbolistaID == 4).Equipo.Add(equipo);
            futbol.SaveChanges();
        }

        protected void Button2_Click(object sender, EventArgs e)
        {
            FutbolDBContext futbol = new FutbolDBContext();
            Equipo equipo = futbol.Equipos.FirstOrDefault(x => x.EquipoID == 2);
            futbol.Futbolistas.Include("equipo").FirstOrDefault(f => f.FutbolistaID == 1).Equipo.Remove(equipo);
            futbol.SaveChanges();
        }
    }
}