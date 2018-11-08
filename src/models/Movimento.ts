import { AssegnazioneBadge } from 'src/models/AssegnazioneBadge';
import { Badge } from './Badge';
export class Movimento{
    //badgeReader:BadgeReader;
    badge:Badge;
    orainizio:string;
    orafine:string;
    assegnazione:AssegnazioneBadge;

    constructor(/*badgeReader:BadgeReader,*/badge:Badge, orainizio:string, orafine:string, assegnazione:AssegnazioneBadge){
        //this.badgeReader=badgeReader;
        this.badge=badge;
        this.orainizio=orainizio;
        this.orafine=orafine;
        this.assegnazione=assegnazione;
    }
}