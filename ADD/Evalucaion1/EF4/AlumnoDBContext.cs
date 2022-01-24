using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Entity;

namespace EF4
{
    public class AlumnoDBContext : DbContext
    {
        public DbSet<Alumno> Alumnos { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Alumno>().MapToStoredProcedures();
            base.OnModelCreating(modelBuilder);

        }
    }
}