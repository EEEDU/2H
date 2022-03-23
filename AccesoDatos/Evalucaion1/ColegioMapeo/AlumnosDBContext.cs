using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Entity;

namespace ColegioMapeo
{
    public class AlumnosDBContext : DbContext
    {
        public DbSet<Curso> Clases { get; set; }
        public DbSet<Alumno> Alumnos { get; set; }
    }
}