using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EF6
{
    public class Equipo
    {
        public int EquipoID { get; set; }   
        public string NombreEquipo { get; set; }
        public List<Futbolista> Futbolista { get; set; }
    }
}