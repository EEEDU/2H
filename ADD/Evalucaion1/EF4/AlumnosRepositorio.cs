using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EF4
{
    public class AlumnosRepositorio
    {
        AlumnoDBContext alumnoDbContext = new AlumnoDBContext();

        public List<Alumno> GetAlumnos()
        {
            return alumnoDbContext.Alumnos.ToList();
        }

        public void InsertarAlumno(Alumno alumno)
        {
            alumnoDbContext.Alumnos.Add(alumno);
            alumnoDbContext.SaveChanges();
        }
        public void ActualizarAlumno(Alumno alumno)
        {
            Alumno alumnoAActualizar = alumnoDbContext.Alumnos.FirstOrDefault(a => a.ID == alumno.ID);

            alumnoAActualizar.Nombre = alumno.Nombre;
            alumnoAActualizar.Apellidos = alumno.Apellidos;
            alumnoAActualizar.Genero = alumno.Genero;
            alumnoAActualizar.Edad = alumno.Edad;

            alumnoDbContext.SaveChanges();
        }
        public void BorrarAlumno(Alumno alumno)
        {
            Alumno alumnoABorrar = alumnoDbContext.Alumnos.FirstOrDefault(a => a.ID == alumno.ID);

            alumnoDbContext.Alumnos.Remove(alumnoABorrar);

            alumnoDbContext.SaveChanges();
        }
    }
}