export class Abbonamento{
    id:number;
    nome:string;
    prezzo:number;

    constructor(id:number, nome:string, prezzo:number){
        this.id=id;
        this.nome=nome;
        this.prezzo=prezzo;
    }

    public getIdByNome(nome:string):number{
        if(nome=="nomale")return 1;
        else if(nome=="silver") return 2;
        else if(nome=="gold") return 3
        return 4;
    }
}