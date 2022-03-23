using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace MVC01.Models
{
    public class VehiculosExtrasModelo
    {
        public int ID { get; set; }
        public VehiculoModel Vehiculo { get; set; }
        public int  ExtraId { get; set; }
        public int MyProperty { get; set; }
    }
}