import { tap, catchError } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RouteConfigLoadEnd } from '@angular/router';
import { Movimento } from 'src/models/Movimento';



@Injectable({
    providedIn: 'root'
})
export class ExportService {

    constructor(private http: HttpClient) {
    }

    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
            console.error(error);
            console.log('${operation} failed: ${error.message}');
            return of(result as T);
        };
    }

    
    export(iduser:string,path:string,name:string):Observable<boolean>{
       if(iduser==null){
           iduser="all";
       }
       
        return this.http.get<boolean>('http://localhost:8080/Movimento/export?scelta='+iduser+'&dir='+path+'&name='+
        name)
        .pipe(tap((response) => console.log(response), catchError(this.handleError('export error', {})))
        );
        
    }



  
    
}