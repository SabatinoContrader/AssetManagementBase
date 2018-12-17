using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AmebaDevice.DTO
{
    public class FloorDTO
    {

        private int id;
        private string nomeFloor;
        private string descrizione;
        private BuildingDTO building;

        public FloorDTO()
        {
        }

        public FloorDTO(int id, string nomeFloor, string descrizione, BuildingDTO building)
        {
            this.id = id;
            this.nomeFloor = nomeFloor;
            this.descrizione = descrizione;
            this.building = building;
        }

        public int getId()
        {
            return id;
        }

        public void setId(int id)
        {
            this.id = id;
        }

        public string getNomeFloor()
        {
            return nomeFloor;
        }

        public void setNomeFloor(string nomeFloor)
        {
            this.nomeFloor = nomeFloor;
        }

        public string getDescrizione()
        {
            return descrizione;
        }

        public void setDescrizione(string descrizione)
        {
            this.descrizione = descrizione;
        }

        public BuildingDTO getBuilding()
        {
            return building;
        }

        public void setBuilding(BuildingDTO building)
        {
            this.building = building;
        }

    }
}