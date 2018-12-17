using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AmebaDevice.DTO
{
    public class RoomDTO
    {
        private int id;
        private String nomeRoom;
        private String descrizione;
        private FloorDTO floor;

        public RoomDTO()
        {
        }

        public RoomDTO(int id, String nomeRoom, String descrizione, FloorDTO floor)
        {
            this.id = id;
            this.nomeRoom = nomeRoom;
            this.descrizione = descrizione;
            this.floor = floor;
        }

        public int getId()
        {
            return id;
        }

        public void setId(int id)
        {
            this.id = id;
        }

        public String getNomeRoom()
        {
            return nomeRoom;
        }

        public void setNomeRoom(String nomeRoom)
        {
            this.nomeRoom = nomeRoom;
        }

        public String getDescrizione()
        {
            return descrizione;
        }

        public void setDescrizione(String descrizione)
        {
            this.descrizione = descrizione;
        }

        public FloorDTO getFloor()
        {
            return floor;
        }

        public void setFloor(FloorDTO floor)
        {
            this.floor = floor;
        }
    }
}