using AmebaDevice.Converter;
using AmebaDevice.DAL;
using AmebaDevice.DTO;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace AmebaDevice.Services
{
    public class BuildingService
    {

        private ModelloDatiDbContext modelloDatiDbContext;
        private FloorService floorService;

        public BuildingService()
        {
            modelloDatiDbContext = new ModelloDatiDbContext();
            floorService = new FloorService();
        }

        
        public void Inserisci(Building b)
        {
            modelloDatiDbContext.SaveChanges();
        }

        public void Associa(String indirizzo, String citta, String cap, String interno, int id)
        {
            Customer c=modelloDatiDbContext.Customers.Find(id);
            Building b=modelloDatiDbContext.Buildings.Add(new Building() { Indirizzo = indirizzo, Citta = citta, Cap = cap, Interno = interno, Customer = c });
            Inserisci(b);
        }

        public IEnumerable<BuildingDTO> Get()
        {
            List<BuildingDTO> l = new List<BuildingDTO>();

            foreach (Building b in modelloDatiDbContext.Buildings)
            {
                l.Add(BuildingConverter.convertToDto(b));
            }
            

            return l;
        }


        public BuildingDTO Get(int id)
        {
            Building b=modelloDatiDbContext.Buildings.Where(build=>build.BuildingID==id).FirstOrDefault();
            return BuildingConverter.convertToDto(b);
        }

        public void Delete(int id)
        {
            Building building = modelloDatiDbContext.Buildings.Find(id);
            modelloDatiDbContext.Buildings.Remove(building);
            modelloDatiDbContext.SaveChanges();
        }

    }
}