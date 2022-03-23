using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Configuration;
using System.Data.SqlClient;
using System.Data;

namespace ExamenEduardo.App_Code
{
    public class Componente
    {
        public int ComponenteId { get; set; }
        public string ComponenteNombre { get; set; }
        public int ComponenteNumUnidades { get; set; }
        public float Precio { get; set; }
        public float PrecioUnidad { get; set; }
        public string nomMarcas { get; set; }
    }

    public class ComponenteData
    {
        public static List<Componente> GetComponentes()
        {
            List<Componente> lista = new List<Componente>();
            string Ejemplar = ConfigurationManager.ConnectionStrings["CONEXION"].ConnectionString;
            using (SqlConnection con = new SqlConnection(Ejemplar))
            {
                SqlCommand cmd = new SqlCommand("SELECT * FROM Componentes INNER JOIN Marcas ON Componentes.Marcas_MarcaId=Marcas.MarcaId;", con);
                con.Open();
                SqlDataReader rdr = cmd.ExecuteReader();
                while (rdr.Read())
                {
                    Componente componente = new Componente();
                    componente.ComponenteId = Convert.ToInt32(rdr["ComponenteId"]);
                    componente.ComponenteNombre = rdr["ComponenteNombre"].ToString();
                    componente.ComponenteNumUnidades = Convert.ToInt32(rdr["ComponenteNumUnidades"]);
                    componente.Precio = Convert.ToInt32(rdr["Precio"]);
                    componente.nomMarcas = rdr["MarcaNombre"].ToString();
                    componente.PrecioUnidad = componente.Precio / componente.ComponenteNumUnidades;

                    lista.Add(componente);
                }
            }
            return lista;
        }
    }
}