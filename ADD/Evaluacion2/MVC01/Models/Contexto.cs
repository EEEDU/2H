using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Entity;

namespace MVC01.Models
{
    public class Contexto :DbContext
    {
        public DbSet<MarcaModel> Marcas { get; set; }
        public DbSet<SerieModel> Series { get; set; }
        public DbSet<VehiculoModel> Vehiculos { get; set; }

    }
}