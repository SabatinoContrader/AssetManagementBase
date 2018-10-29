export class Prenotazione{

    iduser: number;
    idasset: number;
    orainizio: string;
    orafine: string;
constructor(iduser: number, idasset: number,orainizio: string,orafine: string){
    this.iduser=iduser;
    this.idasset=idasset;
    this.orainizio=orainizio;
    this.orafine=orafine;
    }
}