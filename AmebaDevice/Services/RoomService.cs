using AmebaDevice.Converter;
using AmebaDevice.DAL;
using AmebaDevice.DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AmebaDevice.Services
{
    public class RoomService
    {
        private ModelloDatiDbContext modelloDatiDbContext;

        public RoomService()
        {
            modelloDatiDbContext = new ModelloDatiDbContext();
        }

        public void Inserisci(Room r)
        {
            modelloDatiDbContext.SaveChanges();
        }

        public void Associa(String nome, String descrizione, int idFloor)
        {
            Floor f = modelloDatiDbContext.Floors.Find(idFloor);
            Room r = modelloDatiDbContext.Rooms.Add(new Room() { Nome = nome, Descrizione = descrizione, Floor = f });
            Inserisci(r);
        }

        public IEnumerable<RoomDTO> getAllByFloor(int idFloor)
        {
            List<Room> rooms = modelloDatiDbContext.Rooms.Where(r => r.Floor.FloorID == idFloor).ToList();
            List<RoomDTO> toReturn = new List<RoomDTO>();
            rooms.ForEach(r => toReturn.Add(RoomConverter.convertToDto(r)));
            return toReturn;
        }

        public void Delete(int id)
        {
            modelloDatiDbContext.Rooms.Remove(modelloDatiDbContext.Rooms.Find(id));
            modelloDatiDbContext.SaveChanges();
        }
       
    }
}