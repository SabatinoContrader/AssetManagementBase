import { catchError, tap } from 'rxjs/operators';
import { Movimento } from 'src/models/Movimento';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
    providedIn: 'root' 
  })
export class StatisticheService {
  
    constructor(private http: HttpClient) { }
  
    private handleError<T>(operation = 'operation', result?: T) {
      return (error: any): Observable<T> => {
        console.error(error);
        console.log('${operation} failed: ${error.message}');
        return of(result as T);
      };  
    }

    getAllStats(): Observable <number[]>{
        return this.http.get<number[]>('http://localhost:8080/Movimento/statistiche')
        .pipe(tap((response) => console.log(response), catchError(this.handleError('statistiche error', {})))
        );
    }
}