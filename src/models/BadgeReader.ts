import { Asset } from './Asset';
export class BadgeReader {
    idBadgeReader:number;
	asset:Asset;
	descrizione:string;
	tipologia:string;
	flag:number;

    constructor(idBadgeReader:number,asset:Asset, descrizione:string, tipologia:string, flag:number){
        this.idBadgeReader=idBadgeReader;
        this.asset=asset;
        this.descrizione=descrizione;
        this.tipologia=tipologia;
        this.flag=flag;
    }

} 