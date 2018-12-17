using AmebaDevice.DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AmebaDevice.Converter
{
    public class FloorConverter
    {

        public static FloorDTO convertToDto(Floor f)
        {
            FloorDTO floor = new FloorDTO();
            floor.setId(f.FloorID);
            floor.setDescrizione(f.Descrizione);
            floor.setNomeFloor(f.Nome);
            floor.setBuilding(BuildingConverter.convertToDto(f.Building));
            return floor;
        }

        public static Floor convertToFloor(FloorDTO f)
        {
            Floor floor = new Floor();
            floor.FloorID=f.getId();
            floor.Descrizione=f.getDescrizione();
            floor.Nome=f.getNomeFloor();
            floor.Building=BuildingConverter.convertToBuilding(f.getBuilding());
            return floor;
        }

    }
}