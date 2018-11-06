import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { tap, catchError } from 'rxjs/operators';
import { Badge } from '../models/Badge';
import {Observable, of, BehaviorSubject, pipe} from 'rxjs';

@Injectable({
  providedIn: 'root' 
})
export class BadgeService {

  constructor(private http: HttpClient) { }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      console.log('${operation} failed: ${error.message}');
      return of(result as T);
    };
  }


  getAllBadges(): Observable <Badge[]>{
    return this.http.get<Badge[]>('http://localhost:8080/Badge/showBadges', )
    .pipe(tap((response) => console.log(response), catchError(this.handleError('get all badges error', {})))
    );
  }

  delete(id:number): Observable<Badge[]>{
    return this.http.get<Badge[]>('http://localhost:8080/Badge/delete?id='+id)
    .pipe(tap((response) => console.log(response), catchError(this.handleError('delete error', {})))
    );
  }

  modify(idbadge:number, tipologia:string, descrizione:string): Observable<Badge[]>{
    return this.http.get<Badge[]>('http://localhost:8080/Badge/modify?idbadge='+idbadge+'&tipologia='+tipologia+'&descrizione='+
    descrizione)
    .pipe(tap((response) => console.log(response), catchError(this.handleError('modify error', {})))
    );
  }

  insert(idbadge:number, tipologia:string, descrizione:string): Observable<Badge[]>{
    return this.http.get<Badge[]>('http://localhost:8080/Badge/insert?idbadge='+idbadge+'&tipologia='+tipologia+'&descrizione='+
    descrizione)
    .pipe(tap((response) => console.log(response), catchError(this.handleError('modify error', {})))
    );
  }


}
