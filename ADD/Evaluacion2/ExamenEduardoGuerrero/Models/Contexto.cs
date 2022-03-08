using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Entity;

namespace ExamenEduardoGuerrero.Models
{
    public class Contexto : DbContext
    {
        public DbSet<CuadroModel> Cuadros { get; set; }
        public DbSet<PintorModel> Pintores { get; set; }
        public DbSet<EstiloModel> Estilos { get; set; }
        public DbSet<ExposicionModel> Exposiciones { get; set; }
        public DbSet<EstiloCuadroModel> EstilosCuadros { get; set; }
    }
}