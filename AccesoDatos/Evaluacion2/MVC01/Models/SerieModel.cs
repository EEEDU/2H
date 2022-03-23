using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace MVC01.Models
{
    public class SerieModel
    {
        public int ID { get; set; }
        public String Nom_serie { get; set; }
        public int MarcaID { get; set; }
        public MarcaModel Marca { get; set; }
    }
}