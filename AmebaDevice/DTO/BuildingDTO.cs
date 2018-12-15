using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AmebaDevice.DTO
{
    public class BuildingDTO
    {

        public int ID { get; set; }
        public String Address { get; set; }
        public String City { get; set; }
        public String Cap { get; set; }
        public String Interno { get; set; }

        public BuildingDTO()
        {
        }

        public BuildingDTO(int buildingId, String indirizzo, String citta, String cap, String interno, CustomerDTO owner, CustomerDTO installer)
        {
            this.ID = buildingId;
            this.Address = indirizzo;
            this.City = citta;
            this.Cap = cap;
            this.Interno = interno;
        }

       

    }
}