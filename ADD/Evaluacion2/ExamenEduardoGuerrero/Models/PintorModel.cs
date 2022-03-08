using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ExamenEduardoGuerrero.Models
{
    public class PintorModel
    {
        public int ID { get; set; }
        public string Nom_Pintor { get; set; }
        public List<int> CuadroID { get; set; }
        public List<CuadroModel> Cuadros { get; set; }
    }
}