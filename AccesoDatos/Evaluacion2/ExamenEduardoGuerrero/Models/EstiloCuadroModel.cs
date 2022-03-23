using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ExamenEduardoGuerrero.Models
{
    public class EstiloCuadroModel
    {
        public int ID { get; set; }
        public int CuadroID { get; set; }
        public CuadroModel Cuadros { get; set; }
        public int EstiloID { get; set; }
        public EstiloModel Estilos { get; set; }
    }
}