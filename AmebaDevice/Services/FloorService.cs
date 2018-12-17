﻿using AmebaDevice.Converter;
using AmebaDevice.DAL;
using AmebaDevice.DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AmebaDevice.Services
{
    public class FloorService
    {

        private ModelloDatiDbContext modelloDatiDbContext;

        public FloorService()
        {
            modelloDatiDbContext = new ModelloDatiDbContext();
        }


        public void Inserisci(Floor f)
        {
            modelloDatiDbContext.SaveChanges();
        }

        public void Associa(String nome, String descrizione, int idBuilding)
        {
            Building b = modelloDatiDbContext.Buildings.Find(idBuilding);
            Floor f = modelloDatiDbContext.Floors.Add(new Floor() { Nome = nome, Descrizione = descrizione, Building = b });
            Inserisci(f);
        }


        public List<FloorDTO> getAllByBuilding(int buildingid)
        {
            List<Floor> floors = modelloDatiDbContext.Floors.Where(f=>f.Building.BuildingID==buildingid).ToList();
            List<FloorDTO> toReturn = new List<FloorDTO>();
            floors.ForEach(floor=>toReturn.Add(FloorConverter.convertToDto(floor)));
            return toReturn;
        }

        public void Delete(int id)
        {
            Floor f = modelloDatiDbContext.Floors.Find(id);
            modelloDatiDbContext.Floors.Remove(f);
            modelloDatiDbContext.SaveChanges();
        }
    }
}