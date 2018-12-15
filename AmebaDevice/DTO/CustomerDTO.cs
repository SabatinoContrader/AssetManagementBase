using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AmebaDevice.DTO
{
    public class CustomerDTO
    {

        private int ID;
        private String Nome;
        private String Cognome;
        private String Username;
        private String Password;
        private String User_role;
        private String Email;

        public CustomerDTO()
        {

        }

        public CustomerDTO(int id, String nome, String cognome, String email, String username,
                String password, String userRole)
        {
            this.ID = id;
            this.Nome = nome;
            this.Cognome = cognome;
            this.Email = email;
            this.Username = username;
            this.Password = password;
            this.User_role = userRole;
        }

        public int getId()
        {
            return ID;
        }

        public String getNome()
        {
            return Nome;
        }

        public String getCognome()
        {
            return Cognome;
        }
        
        public String getEmail()
        {
            return Email;
        }

        public String getUsername()
        {
            return Username;
        }

        public String getPassword()
        {
            return Password;
        }

        public String getUserRole()
        {
            return User_role;
        }

        public void setId(int id)
        {
            this.ID = id;
        }

        public void setNome(String nome)
        {
            this.Nome = nome;
        }

        public void setCognome(String cognome)
        {
            this.Cognome = cognome;
        }
        

        public void setEmail(String email)
        {
            this.Email = email;
        }

        public void setUsername(String username)
        {
            this.Username = username;
        }

        public void setPassword(String password)
        {
            this.Password = password;
        }

        public void setUserRole(String userRole)
        {
            this.User_role = userRole;
        }

    }
}