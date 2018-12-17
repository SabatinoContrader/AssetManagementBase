using AmebaDevice.DAL;
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
    public class CustomerController : ApiController
    {

        //private ModelloDatiDbContext modelloDatiDbContext;
        private CustomerService customerService;

        public CustomerController()
        {
            customerService = new CustomerService();
            //modelloDatiDbContext = new ModelloDatiDbContext();
        }

        // GET: api/Customer
        public IEnumerable<CustomerDTO> Get()
        {
            System.Diagnostics.Debug.WriteLine("CustomerNome:" + customerService.Get().Last().getNome());
            return customerService.Get();
        }

        // GET: api/Customer/5
        public CustomerDTO Get(int id)
        {
            return customerService.Get(id);
        }

        // POST: api/Customer
        public void Post([FromBody]string value)
        {
        }
        

        //GET: Inserisci/?nome=<nome>&cognome=<cognome>&username=<username>&password=<password>&user_role=<user_role>&email=<email>
        [HttpGet]
        [Route("Inserisci")]
        public string Inserisci(string nome, string cognome, string username, string password, string user_role, string email)
        {
            customerService.Inserisci(nome,cognome,username,password,user_role,email);
            return "Inserito utente con nome:" + username;
        }


        // PUT: api/Customer/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE: api/Customer/5
        public string Delete(int id)
        {
            customerService.Delete(id);
            return "Customer con id " + id + " eliminato";
        }
        
    }
}
