import {Abbonamento} from './Abbonamento';
import {Stato} from './Stato';

export class User{
    
    iduser: number;
    username: string;
    password: string;
    ragioneSociale: string;
    telefono: string;
    mail: string;
    partitaiva: string;
    ruolo: string;
    abbonamento: Abbonamento;
    flag: Array<Stato>;


    constructor(iduser: number, username: string, password: string, telefono: string, ragioneSociale: string, partitaIva: string, ruolo: string, mail: string, nomeAbb: Abbonamento, flag: Array<Stato>){
        this.iduser = iduser;
        this.username = username;
        this.password = password;
        this.ragioneSociale = ragioneSociale;
        this.telefono = telefono;
        this.mail = mail;
        this.partitaiva = partitaIva;
        this.ruolo = ruolo;
        this.abbonamento = nomeAbb;
        this.flag = flag;
    }
}

