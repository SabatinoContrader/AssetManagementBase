import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {Asset} from '../models/Asset';
import {catchError, tap} from 'rxjs/operators';
import {AssegnazioneBadge} from '../models/AssegnazioneBadge';
import {Prenotazione} from '../models/Prenotazione';

@Injectable({
    providedIn: 'root'
})
export class BookingsService {

    constructor(private http: HttpClient) {
    }

    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
            console.error(error);
            console.log('${operation} failed: ${error.message}');
            return of(result as T);
        };
    }
    getAllPrenotazioni(): Observable <Prenotazione[]> {
        return this.http.get<Prenotazione[]>('http://localhost:8080/HomePrenotazione/showPrenotazione', )
            .pipe(tap((response) => console.log(response), catchError(this.handleError('get all prenotazione error', {})))
            );
    }
    updatePren(id: number, idu: number, ida: number, orainizio: string, orafine: string): Observable <Prenotazione[]> {
        return this.http.get<Prenotazione[]>( 'http://localhost:8080/HomePrenotazione/update?id=' + id + '&id1=' + idu + '&id2=' + ida + '&orainizio=' + orainizio + '&orafine=' + orafine)
            .pipe(tap((response) => console.log(response)));
    }
    insertPren(idp: number, idu: number, ida: number, orainizio: string, orafine: string): Observable <Prenotazione[]> {
        return this.http.get<Prenotazione[]>( 'http://localhost:8080/HomePrenotazione/insert?id=' + idp + '&id1=' + idu + '&id2=' + ida + '&orainizio=' + orainizio + '&orafine=' + orafine)
            .pipe(tap((response) => console.log(response)));

    }

}