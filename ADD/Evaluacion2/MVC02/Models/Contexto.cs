using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Entity;

namespace MVC02.Models
{
    public class Contexto : DbContext
    {
        public DbSet<EtapaModel> Etapas { get; set; }
        public DbSet<CursoModel> Cursos{ get; set; }
        public DbSet<AsignaturaModel> Asignaturas { get; set; }
        public DbSet<AsignaturasCursosModel> AsignaturasCursos { get; set; }
    }
}