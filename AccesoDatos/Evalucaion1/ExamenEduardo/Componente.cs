using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ExamenEduardo
{
    public class Componente
    {
        public int ComponenteId { get; set; }
        public string ComponenteNombre { get; set; }
        public int ComponenteNumUnidades { get; set; }
        public float Precio { get; set; }
        public List<Producto> Productos { get; set; }
        public Marca Marcas { get; set; }
    }
}