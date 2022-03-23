using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace MVC02.Models
{
    public class AsignaturaModel
    {
        public int ID { get; set; }
        public String Nom_Asignatura { get; set; }
        public List<int> AsignaturasCursosID { get; set; }
        public List<AsignaturasCursosModel> AsignaturasCursos { get; set; }
    }
}