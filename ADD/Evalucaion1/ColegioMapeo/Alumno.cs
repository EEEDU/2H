using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ColegioMapeo
{
    public class Alumno
    {
        public int ID { get; set; }
        public string Nombre { get; set; }
        public string Apellidos { get; set; }
        public string Genero { get; set; }
        public int Edad { get; set; }
        public Curso clase { get; set; }
    }
}