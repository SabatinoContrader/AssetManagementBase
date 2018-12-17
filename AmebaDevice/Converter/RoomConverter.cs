using AmebaDevice.DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AmebaDevice.Converter
{
    public class RoomConverter
    {
        public static RoomDTO convertToDto(Room r)
        {
            RoomDTO room = new RoomDTO();
            room.setId(r.RoomId);
            room.setDescrizione(r.Descrizione);
            room.setFloor(FloorConverter.convertToDto(r.Floor));
            room.setNomeRoom(r.Nome);
            return room;
        }

        public static Room convertToRoom(RoomDTO r)
        {
            Room room = new Room();
            room.RoomId = r.getId();
            room.Descrizione = r.getDescrizione();
            room.Floor = FloorConverter.convertToFloor(r.getFloor());
            room.Nome = r.getNomeRoom();
            return room;
        }
    }
}