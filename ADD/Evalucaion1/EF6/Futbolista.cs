using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EF6
{
    public class Futbolista
    {
        public int FutbolistaID { get; set; }
        public string NombreFutbolista { get; set; }
        public List<Equipo> Equipo { get; set; }
    }
}