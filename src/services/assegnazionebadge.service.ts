import { AssegnazioneBadge } from 'src/models/AssegnazioneBadge';
import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { tap, catchError } from 'rxjs/operators';
import { Badge } from '../models/Badge';
import {Observable, of, BehaviorSubject, pipe} from 'rxjs';


@Injectable({
  providedIn: 'root'
}) 

export class AssegnazionebadgeService {

  constructor(private http: HttpClient) { }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      console.log('${operation} failed: ${error.message}');
      return of(result as T);
    };
  }

  getAllAssBadges(): Observable <AssegnazioneBadge[]>{
    return this.http.get<AssegnazioneBadge[]>('http://localhost:8080/Assegnazione/showAss', )
    .pipe(tap((response) => console.log(response), catchError(this.handleError('get all assegnazioni badges error', {})))
    );
  }

  delete(iduser:number, idbadge:number):  Observable <AssegnazioneBadge[]>{
    return this.http.get<AssegnazioneBadge[]>('http://localhost:8080/Assegnazione/delete?iduser='+iduser+'&idbadge='+idbadge, )
    .pipe(tap((response) => console.log(response), catchError(this.handleError('delete error', {})))
    );
    
  }

  
  insert(iduser:number, idbadge:number, nome:string, cognome:string): Observable<AssegnazioneBadge[]>{
    
    return this.http.get<AssegnazioneBadge[]>('http://localhost:8080/Assegnazione/insert?iduser='+iduser+'&idbadge='+idbadge+
                                            '&nome='+nome+'&cognome='+cognome)
                                  .pipe(tap((response) => console.log(response), catchError(this.handleError('insert error', {})))
                                  );

  }


getAllBadgesN(): Observable <Badge[]>{
  return this.http.get<Badge[]>('http://localhost:8080/Assegnazione/showBagesN', )
  .pipe(tap((response) => console.log(response), catchError(this.handleError('get all badges error', {})))
  );
}

}
