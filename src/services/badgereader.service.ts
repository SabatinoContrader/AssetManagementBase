import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { tap, catchError } from 'rxjs/operators';
import { BadgeReader } from '../models/BadgeReader';
import {Observable, of, BehaviorSubject, pipe} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class BadgereaderService {

constructor(private http: HttpClient) { }

private handleError<T>(operation = 'operation', result?: T) {
  return (error: any): Observable<T> => {
    console.error(error);
    console.log('${operation} failed: ${error.message}');
    return of(result as T);
  };
}

getAllBadgeReaders(): Observable <BadgeReader[]>{
  return this.http.get<BadgeReader[]>('http://localhost:8080/BadgeReader/showBadgeReader', )
  .pipe(tap((response) => console.log(response), catchError(this.handleError('get all badgereaders error', {})))
  );
}
insert(idAsset:number,descrizione:string, tipologia:string): Observable<BadgeReader[]>{
  return this.http.get<BadgeReader[]>('http://localhost:8080/BadgeReader/insert?idasset='+idAsset+'&tipologia='+tipologia+'&descrizione='+descrizione)
  .pipe(tap((response) => console.log(response), catchError(this.handleError('insert error', {})))
  );
}

    associa(idAsset:number,idbadger: number,descrizione:string, tipologia:string): Observable<BadgeReader[]>{
        return this.http.get<BadgeReader[]>('http://localhost:8080/BadgeReader/associa?idbadger=' + idbadger + '&idasset='+idAsset+'&tipologia='+tipologia+'&descrizione='+descrizione)
            .pipe(tap((response) => console.log(response), catchError(this.handleError('insert error', {})))
            );
    }
}
