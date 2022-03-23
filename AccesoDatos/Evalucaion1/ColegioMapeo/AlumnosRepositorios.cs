using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ColegioMapeo
{
    public class AlumnosRepositorios
    {
        public List<Curso> GetCursos()
        {
            AlumnosDBContext alumnosDBContext = new AlumnosDBContext();
            return alumnosDBContext.Clases.Include(Alumnos).ToList();
        }
    }
}