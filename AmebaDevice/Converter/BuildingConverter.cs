using AmebaDevice.DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AmebaDevice.Converter
{
    public class BuildingConverter
    {

        public static BuildingDTO convertToDto(Building b)
        {
            BuildingDTO building = new BuildingDTO();
            building.ID=b.BuildingID;
            building.Cap=b.Cap;
            building.City=b.Citta;
            building.Address = b.Indirizzo;
            building.Interno = b.Interno;
            /*
            if (b.getInstaller() != null)
                building.setInstaller(CustomerConverter.convertToDto(b.getInstaller()));
            if (b.getOwner() != null)
                building.setOwner(CustomerConverter.convertToDto(b.getOwner()));
                */
            return building;
        }

        public static Building convertToBuilding(BuildingDTO b)
        {
            Building building = new Building();
            building.BuildingID = b.ID;
            building.Cap = b.Cap;
            building.Citta = b.City;
            building.Indirizzo = b.Address;
            building.Interno = b.Interno;
            
            /*
            if (b.getOwner() != null)
                building.setOwner(CustomerConverter.convertToCustomer(b.getOwner()));
            if (b.getInstaller() != null)
                building.setInstaller(CustomerConverter.convertToCustomer(b.getInstaller()));
                */
            return building;
        }

    }
}