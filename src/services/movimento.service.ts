import { Movimento } from './../models/Movimento';
import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { tap, catchError } from 'rxjs/operators';
import {Observable, of, BehaviorSubject, pipe} from 'rxjs';

@Injectable({
    providedIn: 'root' 
  })
export class MovimentoService {
  
    constructor(private http: HttpClient) { }
  
    private handleError<T>(operation = 'operation', result?: T) {
      return (error: any): Observable<T> => {
        console.error(error);
        console.log('${operation} failed: ${error.message}');
        return of(result as T);
      }; 
    }

    getAllMovimenti(): Observable <Movimento[]>{
        return this.http.get<Movimento[]>('http://localhost:8080/Movimento/showMovimenti')
        .pipe(tap((response) => console.log(response), catchError(this.handleError('get all movimenti error', {})))
        );
    }
}