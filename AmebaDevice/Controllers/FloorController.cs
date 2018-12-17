using AmebaDevice.DTO;
using AmebaDevice.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace AmebaDevice.Controllers
{
    public class FloorController : ApiController
    {

        FloorService floorService;

        public FloorController()
        {
            floorService = new FloorService();
        }

        // GET: api/Floor
        public IEnumerable<string> Get()
        {
            return new string[] { "value1", "value2" };
        }

        // GET: api/Floor/5
        public string Get(int id)
        {
            return "value";
        }

        [HttpGet]
        [Route("GetByBuilding")]
        public IEnumerable<FloorDTO> GetByBuilding(int idBuilding)
        {
            return floorService.getAllByBuilding(idBuilding);
        }

        [HttpGet]
        [Route("InserisciF")]
        public String Inserisci(String nome, String descrizione, int idBuilding)
        {
            floorService.Associa(nome, descrizione, idBuilding);
            return "Il floor con nome" + nome + " è stato inserito";
        }

        // POST: api/Floor
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/Floor/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE: api/Floor/5
        public string Delete(int id)
        {
            floorService.Delete(id);
            return "Il floor con id" + id + " è stato eliminato";
        }
    }
}
