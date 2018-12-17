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
    public class RoomController : ApiController
    {

        RoomService roomService;

        public RoomController()
        {
            roomService = new RoomService();
        }

        // GET: api/Room
        public IEnumerable<string> Get()
        {
            return new string[] { "value1", "value2" };
        }

        // GET: api/Room/5
        public string Get(int id)
        {
            return "value";
        }

        // POST: api/Room
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/Room/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE: api/Room/5
        public String Delete(int id)
        {
            roomService.Delete(id);
            return "La room con id = " + id + "è stata eliminata";
        }

        [HttpGet]
        [Route("GetByFloor")]
        public IEnumerable<RoomDTO> GetByFloor(int idFloor)
        {
            return roomService.getAllByFloor(idFloor);
        }


        [HttpPost]
        [Route("InserisciR")]
        public String Inserisci(String nome, String descrizione, int idFloor)
        {
            roomService.Associa(nome, descrizione, idFloor);
            return "La room con nome= " + nome + " è stata inserita";
        }

      
    }
}
