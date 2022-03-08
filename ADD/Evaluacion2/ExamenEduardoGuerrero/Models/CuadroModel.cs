using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ExamenEduardoGuerrero.Models
{
    public class CuadroModel
    {
        public int ID { get; set; }
        public string Titulo_Cuadro { get; set; }
        public int PintorID { get; set; }
        public PintorModel Pintor { get; set; }
        public List<int> ExposicionID{ get; set; }
        public List<ExposicionModel> Exposiciones { get; set; }
        public List<int> EstiloCuadroID{ get; set; }
        public List<EstiloCuadroModel> EstilosCuadros { get; set; }
    }
}