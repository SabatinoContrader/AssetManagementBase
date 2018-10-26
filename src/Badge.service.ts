import { Injectable } from "@angular/core";
import {HttpClient} from '@angular/common/http';
import {Observable, of, BehaviorSubject} from 'rxjs';
import { Badge } from "../models/Badge";
import { Assegnazione } from "../models/Assegnazione";
import { tap, catchError } from 'rxjs/operators';
/**
 * @description
 * @class
 */
@Injectable()
export class BadgeService {
  feedback: string;

  constructor(private http: HttpClient) { }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      console.log('${operation} failed: ${error.message}');
      return of(result as T);
    };
  }
  BadgeList(): Observable<any>{
    var user: User = JSON.parse(sessionStorage.getItem("user"));
    return this.http.get<any>('http://localhost:58708/api/BadgeList?username='+user.username)
    .pipe(tap((response) => console.log("BadgeList"), catchError(this.handleError("report error", {})))
  );
  }
 }