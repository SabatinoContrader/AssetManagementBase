export class User{
    iduser: number;
    username: string;
    password: string;
    ragioneSociale: string;
    telefono: string;
    mail: number;
    partitaiva: string;
    ruolo: string;
    nomeAbb: string;
    flag:number;

    constructor(iduser: number,username: string, password: string, ragioneSociale: string, trelefono: string, mail: number, partitaiva: string, ruolo: string, nomeAbb: string, flag: number){
        this.iduser=iduser;
        this.username = username;
        this.password = password;
        this.ragioneSociale=ragioneSociale;
        this.telefono = this.telefono;
        this.mail = mail;
        this.partitaiva = partitaiva;
        this.ruolo = ruolo;
        this.nomeAbb = nomeAbb;
        this.flag=flag;
    }


}