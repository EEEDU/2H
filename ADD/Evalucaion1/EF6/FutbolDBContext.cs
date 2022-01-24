using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Entity;

namespace EF6
{
    public class FutbolDBContext :DbContext
    {
        public DbSet<Equipo> Equipos { get; set; }
        public DbSet<Futbolista> Futbolistas { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Equipo>()
                .HasMany(x => x.Futbolista)
                .WithMany(y => y.Equipo)
                .Map(m =>
                {
                    m.ToTable("EquiposFutbolistas");
                    m.MapLeftKey("futbolistaID");
                    m.MapRightKey("equipoID");
                });
            
            base.OnModelCreating(modelBuilder);

        }

    }
}