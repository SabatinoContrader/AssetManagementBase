export class BadgeReader{
    idbadgereader: number;
    idasset: number;
    descrizione: string;
    tipologia: string;
    flag: number;

constructor(idbadgereader: number,idasset: number, descrizione: string, tipologia: string,flag: number){
    this.idbadgereader=idbadgereader;
    this.idasset=idasset;
    this.descrizione=descrizione;
    this.tipologia=tipologia;
    this.flag=flag;
    }
}