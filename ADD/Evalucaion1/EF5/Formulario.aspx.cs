using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace EF5
{
    public partial class Formulario : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            Futbolin futbol = new Futbolin();
            GridView1.DataSource = (from Equipo in futbol.Equipos
                                   from Futbolista in Equipo.Futbolistas
                                   select new
                                   {
                                       NombreEquipo = Equipo.nomEquipo,
                                       NombreFutbolista = Futbolista.nomFutbolista
                                   }).ToList();
            GridView1.DataBind();
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            Futbolin futbol = new Futbolin();
            Equipo equipo = futbol.Equipos.FirstOrDefault(x => x.equipoID == 4);
            futbol.Futbolistas.FirstOrDefault(f => f.futbolistaID == 4).Equipos.Add(equipo);
            //Otra forma:
            //Futbolista futbolista= futbol.Futbolistas.FirstOrDefault(f => f.futbolistaID == 4);
            //futbol.Equipos.FirstOrDefault(x => x.equipoID== 4).Futbolistas.Add(futbolista);
            futbol.SaveChanges();
        }

        protected void Button2_Click(object sender, EventArgs e)
        {
            Futbolin futbol = new Futbolin();
            Equipo equipo = futbol.Equipos.FirstOrDefault(x => x.equipoID == 2);
            futbol.Futbolistas.FirstOrDefault(f => f.futbolistaID == 1).Equipos.Remove(equipo);
            futbol.SaveChanges();
        }
    }
}