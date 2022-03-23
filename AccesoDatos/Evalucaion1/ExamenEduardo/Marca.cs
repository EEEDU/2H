using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ExamenEduardo
{
    public class Marca
    {
        public int MarcaId { get; set; }
        public string MarcaNombre { get; set; }
        public List<Componente> Componentes { get; set; }
    }
}