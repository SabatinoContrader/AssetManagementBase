import { BadgeReader } from './BadgeReader';
export class Movimento{

    idmovimento: number;
    idbadgereader: number;
    idbadge: number;
    orainizio: string;
    orafine: string;
constructor(idmovimento: number,idbadgereader: number,idbadge: number,orainizio: string,orafine:string){
    this.idmovimento=idmovimento;
    this.idbadgereader=idbadgereader;
    this.idbadge=idbadge;
    this.orainizio=orainizio;
    this.orafine=orafine;

    }
}