import { BadgeReader } from './BadgeReader';
import { AssegnazioneBadge } from 'src/models/AssegnazioneBadge';
import { Badge } from './Badge';

export class Movimento{
    badgereader:BadgeReader;
    badge:Badge;
    orainizio:string;
    orafine:string;
    assegnazione:AssegnazioneBadge;

    constructor(badgereader:BadgeReader, badge:Badge, orainizio:string, orafine:string, assegnazione:AssegnazioneBadge){
        this.badgereader=badgereader;
        this.badge=badge;
        this.orainizio=orainizio;
        this.orafine=orafine;
        this.assegnazione=assegnazione;
    }
}