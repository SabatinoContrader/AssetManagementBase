﻿using AmebaDevice.Converter;
using AmebaDevice.DAL;
using AmebaDevice.DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AmebaDevice.Services
{
    public class CustomerService
    {
        private ModelloDatiDbContext modelloDatiDbContext;

        public CustomerService()
        {
            modelloDatiDbContext = new ModelloDatiDbContext();
        }

        public void Inserisci(String nome, String cognome, String username, String password, String user_role, String email)
        {
            modelloDatiDbContext.Customers.Add(new Customer() { Nome = nome, Cognome = cognome, Username = username, Password = password, User_role = user_role, Email = email });
            modelloDatiDbContext.SaveChanges();
        }

        public IEnumerable<CustomerDTO> Get()
        {

            List<CustomerDTO> l=new List<CustomerDTO>();

            foreach(Customer c in modelloDatiDbContext.Customers)
            {
                l.Add(CustomerConverter.convertToDto(c));
                
            }
            
            return l;

        }

        public CustomerDTO Get(int id)
        {
            Customer c = modelloDatiDbContext.Customers.Where(custom => custom.CustomerID == id).FirstOrDefault();
            return CustomerConverter.convertToDto(c);
        }

    }
}