using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EF2
{
    public class CARepositorio
    {
        public List<Clase> GetClases() 
        { 
            AlumnosDBcontext alumnosDBContext = new AlumnosDBcontext();
            return alumnosDBContext.Clases.ToList();
        }
    }
}