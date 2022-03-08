using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ExamenEduardoGuerrero.Models
{
    public class EstiloModel
    {
        public int ID { get; set; }
        public string Nom_Estilo { get; set; }
        public List<int> EstiloCuadroID { get; set; }
        public List<EstiloCuadroModel> EstilosCuadros { get; set; }
    }
}