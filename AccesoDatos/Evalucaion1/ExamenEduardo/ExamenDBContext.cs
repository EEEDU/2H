using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Entity;

namespace ExamenEduardo
{
    public class ExamenDBContext : DbContext
    {
        public DbSet<Producto> Productos { get; set; }
        public DbSet<Componente> Componentes { get; set; }
        public DbSet<Marca> Marcas { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Producto>()
                .HasMany(x => x.Componentes)
                .WithMany(y => y.Productos)
                .Map(m =>
                {
                    m.ToTable("ProductosComponentes");
                    m.MapLeftKey("productoID");
                    m.MapRightKey("componenteID");
                });
        }
    }
}