using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ExamenEduardoGuerrero.Models
{
    public class ExposicionModel
    {
        public int ID { get; set; }
        public string Titulo_Exposicion { get; set; }
        public DateTime Fecha_Inicio { get; set; }
        public DateTime Fecha_Fin { get; set; }
        public string Lugar { get; set; }
        public List<int> CuadroID { get; set; }
        public List<CuadroModel> Cuadros { get; set; }
    }
}