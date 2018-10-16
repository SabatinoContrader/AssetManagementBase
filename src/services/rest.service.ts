import { Injectable } from '@angular/core';
import {
    Http,
    Response
} from '@angular/http';

import 'rxjs/add/operator/map';

import {Gomma, User, Vehicle} from '../models';

@Injectable()
export class RestService {

    baseUrl : String = "http://localhost:8080/gommastore/";

    constructor(private http: Http) {}

    getListaGomme() {
        return this.http.get( this.baseUrl + 'gomme/allgomme')
                .map((response) => {
                    const json = response.json();
                    if (response.ok) {
                        return json.data as Gomma[];
                    } else {
                        return this.logError(json);
                    }
                });
    }

    insertGomma(gomma: any) {
        return this.http.post( this.baseUrl + 'gomme/insertGomme', gomma)
                .map((response) => {
                    const json = response.json();
                    if (response.ok) {
                        return json.data;
                    } else {
                        return this.logError(json);
                    }
                });
    }

    allgommeManufacturer(gomma: any){
        return this.http.get(this.baseUrl + 'gomme/allgommeManufacturer?manufacturer='+gomma.manufacturer+'&typeVehicle='+gomma.typeVehicle)
            .map((response)=>{
                const json=response.json();
                if(response.ok){
                    return json.data as Gomma[];
                }else{
                    return this.logError(json);
                }
            });
    }

    gommeForSize(gommaSize: any){
        return this.http.get(this.baseUrl +'gomme/gommeForSize?width='+gommaSize.width+'&height='+gommaSize.height+'&diameter='+gommaSize.diameter+'&weight='
        +gommaSize.weight+'&speed='+gommaSize.speed+'&season='+gommaSize.season+'&typeVehicle='+gommaSize.typeVehicle)
            .map((response)=>{
                const json=response.json();
                if(response.ok){
                    return json.data as Gomma[];
                }else{
                    return this.logError(json);
                }
            });
    }


    getListaVehicles() {
        return this.http.get( this.baseUrl + 'vehicle/allvehicles')
            .map((response) => {
                const json = response.json();
                if (response.ok) {
                    return json.data as Vehicle[];
                } else {
                    return this.logError(json);
                }
            });
    }
    insertVehicle(vehicle: String) {
        return this.http.post( this.baseUrl + 'vehicle/insertVehicle', vehicle)
            .map((response) => {
                const json = response.json();
                if (response.ok) {
                    return json.data;
                } else {
                    return this.logError(json);
                }
            });
    }


    login(param: any){
        return this.http.post(this.baseUrl + 'login/menu',param)
            .map((response)=>{
                const json=response.json();
                if(response.ok){
                    return json;
                }else{
                    return this.logError(json);
                }
            });
    }

    searchVehicle(vehicle: String){
        return this.http.post(this.baseUrl + 'vehicle/searchVehicle',vehicle)
            .map((response)=>{
                const json=response.json();
                if(response.ok){
                    return json.data as Gomma[];
                }else{
                    return this.logError(json);
                }
            });
    }
    getListaUsers(){
        return this.http.get( this.baseUrl + 'users/getUsers')
            .map((response) => {
                const json = response.json();
                if (response.ok) {
                    return json.data as User[];
                } else {
                    return this.logError(json);
                }
            });

    }

    insertUser(user: String) {
        return this.http.post( this.baseUrl + 'login/regControl', user)
            .map((response) => {
                const json = response.json();
                if (response.ok)
                {
                    return json;
                }
                else
                    {
                        return this.logError(json);
                    }
            });
    }


    private logError(error: any) {
        console.error(error.error);
        throw error;
    }
}
