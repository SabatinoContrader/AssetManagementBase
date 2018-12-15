using AmebaDevice.DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AmebaDevice.Converter
{
    public class CustomerConverter
    {

        public static CustomerDTO convertToDto(Customer c)
        {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setId(c.CustomerID);
            customerDTO.setNome(c.Nome);
            customerDTO.setCognome(c.Cognome);
            customerDTO.setEmail(c.Email);
            customerDTO.setUsername(c.Username);
            customerDTO.setPassword(c.Password);
            customerDTO.setUserRole(c.User_role);
            return customerDTO;
        }

        public Customer convertToCustomer(CustomerDTO c)
        {
            Customer customer = new Customer();
            customer.CustomerID = c.getId();
            customer.Nome = c.getNome();
            customer.Cognome = c.getCognome();
            customer.Email = c.getEmail();
            customer.Username = c.getUsername();
            customer.Password = c.getPassword();
            customer.User_role = c.getUserRole();
            return customer;
        }

    }
}