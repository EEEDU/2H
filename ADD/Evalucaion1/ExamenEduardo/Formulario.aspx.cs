using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ExamenEduardo
{
    public partial class Formulario : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            ExamenDBContext examen = new ExamenDBContext();
            int numeroProducto;
            int numeroComponente;
            bool productoId = Int32.TryParse(DropDownList1.SelectedValue, out numeroProducto);
            bool componenteId = Int32.TryParse(DropDownList2.SelectedValue, out numeroComponente);
            if (productoId && componenteId)
            {
                Producto producto = examen.Productos.FirstOrDefault(x => x.ProductoId == numeroProducto);
                examen.Componentes.Include("Productos").FirstOrDefault(f => f.ComponenteId == numeroComponente).Productos.Add(producto);
                examen.SaveChanges();
            }
            // Tienes que salir y volver a entrar a la pagina, no sirve con refrescar para que se vea
        }
    }
}