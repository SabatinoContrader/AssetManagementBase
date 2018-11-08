import { Asset } from './../models/Asset';
import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { tap, catchError } from 'rxjs/operators';
import {Observable, of, BehaviorSubject, pipe} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AssetsService {

  constructor(private http: HttpClient) { }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      console.log('${operation} failed: ${error.message}');
      return of(result as T);
    };
  }


  getAllAssets(): Observable <Asset[]>{
    return this.http.get<Asset[]>('http://localhost:8080/Asset/showAssets', )
    .pipe(tap((response) => console.log(response), catchError(this.handleError('get all badges error', {})))
    );
  }
  getAllAssetsN(): Observable <Asset[]>{
    return this.http.get<Asset[]>('http://localhost:8080/BadgeReader/showAssetsN', )
    .pipe(tap((response) => console.log(response), catchError(this.handleError('get all assets error', {})))
    );
  }
  

  delete(idAsset:number): Observable<Asset[]>{
    return this.http.get<Asset[]>('http://localhost:8080/Asset/delete?id='+idAsset)
    .pipe(tap((response) => console.log(response), catchError(this.handleError('delete error', {})))
    );
  }

  modify(idAsset:number, tipo:string, descrizione:string, prezzo:number): Observable<Asset[]>{
    return this.http.get<Asset[]>('http://localhost:8080/Asset/modify?idasset='+idAsset+'&tipo='+tipo+'&descrizione='+
    descrizione+'&prezzo='+prezzo)
    .pipe(tap((response) => console.log(response), catchError(this.handleError('modify error', {})))
    );
  }
  insert(idAsset:number, tipo:string, descrizione:string, prezzo:number,flag:number): Observable<Asset[]>{
  return this.http.get<Asset[]>('http://localhost:8080/Asset/insert?idasset='+idAsset+'&tipo='+tipo+'&descrizione='+descrizione+
  '&prezzo='+prezzo+'&flag='+flag)
  .pipe(tap((response) => console.log(response), catchError(this.handleError('insert error', {})))
  );
}

}
