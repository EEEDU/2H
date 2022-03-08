using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace MVC01.Models
{
    public class VehiculosExtrasModel
    {
        public int ID { get; set; }
        public int VehiculoID { get; set; }
        public VehiculoModel Vehiculo { get; set; }
        public int ExtraID { get; set; }
        public ExtraModel Extra { get; set; }
    }
}