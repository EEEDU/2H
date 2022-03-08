using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace MVC02.Models
{
    public class CursoModel
    {
        public int ID { get; set; }
        public string Nom_Curso { get; set; }
        public int EtapaID { get; set; }
        public EtapaModel Etapa { get; set; }
        public List<int> AsignaturasCursosID { get; set; }
        public List<AsignaturasCursosModel> AsignaturasCursos { get; set; }
    }
}