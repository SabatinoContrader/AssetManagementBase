//import { NumberValueAccessor } from "@angular/forms/src/directives";

export class Asset {
    idasset: number;
    descrizione: string;
    tipo: string;
    prezzo: number;

constructor(idasset: number, descrizione: string, tipo: string, prezzo: number){
    this.idasset=idasset;
    this.descrizione=descrizione;
    this.tipo=tipo;
    this.prezzo=prezzo;

}
}