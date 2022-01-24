using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ExamenEduardo
{
    public class Producto
    {
        public int ProductoId { get; set; }
        public string ProdcutoNombre { get; set; }
        public int ProductoPrecio { get; set; }
        public List<Componente> Componentes { get; set; }
    }
}