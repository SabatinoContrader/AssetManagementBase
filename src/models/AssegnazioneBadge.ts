import { User } from './User';
import { Badge } from "./Badge";
import { Data } from '@angular/router';

export class AssegnazioneBadge{
    idassegnazione:number;
    badge:Badge;
    user:User;
    nome:string;
    cognome:string;
    dataassegnazione:Data;

    constructor(idassegnazione:number, badge:Badge, user:User,nome:string, cognome:string, dataassegnazione:Data){
        this.idassegnazione=idassegnazione;
        this.badge=badge;
        this.user=user;
        this.nome=nome;
        this.cognome=cognome;
        this.dataassegnazione=dataassegnazione;
    }
}