using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ExamenEduardo
{
    public class ExamenRepositorio
    {
        ExamenDBContext examenDBContext = new ExamenDBContext();

        public List<Producto> GetProducts()
        {
            return examenDBContext.Productos.Include("Componentes").ToList();
        }
        public List<Marca> GetMarcas()
        {
            return examenDBContext.Marcas.ToList();
        }
        public List<Componente> GetComponents()
        {
            return examenDBContext.Componentes.ToList();
        }
    }
}