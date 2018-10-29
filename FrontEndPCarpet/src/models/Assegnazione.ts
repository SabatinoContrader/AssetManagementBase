export class Assegnazione {
    iduser: number;
    idassegnazione: number;
    idbadge: number;
    nome: string;
    cognome: string;
    dataassegnazione: string;
    flag: number;

constructor(iduser: number, idassegnazione: number,idbadge: number,nome: string,cognome: string,dataassegnazione: string,flag: number){
    this.iduser=iduser;
    this.idassegnazione=idassegnazione;
    this.idbadge=idbadge;
    this.nome=nome;
    this.cognome=cognome;
    this.dataassegnazione=dataassegnazione;
    this.flag=flag;
}
}