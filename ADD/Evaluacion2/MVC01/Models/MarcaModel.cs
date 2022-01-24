using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace MVC01.Models
{
    public class MarcaModel
    {
        public int ID { get; set; }
        public String Nom_marca { get; set; }

        public List<SerieModel> Series { get; set; }
    }
}