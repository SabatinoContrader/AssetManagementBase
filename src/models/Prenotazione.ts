import { User } from './User';
import { Asset } from './Asset';
import { Data } from '@angular/router';

export class Prenotazione {
    idprenotazione: number;
    asset: Asset;
    user: User;
    orainizio: string;
    orafine: string;

    constructor(idprenotazione: number, asset: Asset, user: User, orainizio: string, orafine: string) {
        this.idprenotazione = idprenotazione;
        this.asset = asset;
        this.user = user;
        this.orainizio = orainizio;
        this.orafine = orafine;
    } }