using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace MVC01.Models
{
    public class VehiculoModel
    {
        public int ID { get; set; }
        public String Matricula { get; set; }
        public String Color { get; set; }
        public int SerieID { get; set; }
        public SerieModel Serie { get; set; }
    }
}