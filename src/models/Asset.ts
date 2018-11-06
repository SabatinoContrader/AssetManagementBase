export class Asset {
    idAsset:number;
    descrizione:string;
    tipo:string;
    prezzo:number;
    flag:number;

    constructor(idAsset:number, descrizione:string, tipo:string, prezzo:number,flag:number){
        this.idAsset=idAsset;
        this.descrizione=descrizione;
        this.tipo=tipo;
        this.prezzo=prezzo;
        this.flag=flag;
    }

} 