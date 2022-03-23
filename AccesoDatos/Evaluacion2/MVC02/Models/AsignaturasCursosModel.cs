using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace MVC02.Models
{
    public class AsignaturasCursosModel
    {
        public int ID { get; set; }
        public int AsignaturaID { get; set; }
        public AsignaturaModel Asignatura { get; set; }
        public int CursoID { get; set; }
        public CursoModel Curso { get; set; }
    }
}