using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace MVC02.Models
{
    public class EtapaModel
    {
        public int ID { get; set; }
        public string Acronimo { get; set; }
        public string Descripcion { get; set; }
        public List<CursoModel> Cursos { get; set; }
    }
}