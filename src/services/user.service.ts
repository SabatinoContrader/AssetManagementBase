import { Injectable } from '@angular/core';
import { tap, catchError } from 'rxjs/operators';
import {HttpClient} from '@angular/common/http';
import { User } from '../models/User';
import {Observable, of, BehaviorSubject, pipe} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  feedback: string;

  constructor(private http: HttpClient) { }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      console.log('${operation} failed: ${error.message}');
      return of(result as T);
    };
  }


  login(username: string, password: string): Observable <User> {
    return this.http.get<User>('http://localhost:8080/HomeUser/login?username=' + username +'&password='+password, )
    .pipe(tap((response) => console.log(response), catchError(this.handleError('login error', {})))
  );
  }

  getAllUsers(): Observable <User[]>{
    return this.http.get<User[]>('http://localhost:8080/HomeUser/showUsers', )
    .pipe(tap((response) => console.log(response), catchError(this.handleError('get all users error', {})))
    );
  } 


  
  delete(id:number):  Observable <User[]>{
    return this.http.get<User[]>('http://localhost:8080/HomeUser/delete?id='+id, )
    .pipe(tap((response) => console.log(response), catchError(this.handleError('delete error', {})))
    );
    
  }


  getIdUser(id:number): Observable<User>{
    return this.http.get<User>('http://localhost:8080/HomeUser/getById?id='+id, )
    .pipe(tap((response) => console.log(response), catchError(this.handleError('get by id error', {})))
    );
  }

  modify(iduser:number, username:string, password:string, ragioneSociale:string, telefono:string, mail:string, partitaIva:string,
        ruolo:string, idAbb:number): Observable<User[]>{
    return this.http.get<User[]>('http://localhost:8080/HomeUser/modify?iduser='+iduser+'&username='+username+'&password='+password+
    '&ragioneSociale='+ragioneSociale+'&telefono='+telefono+'&mail='+mail+'&partitaIva='+partitaIva+'&ruolo='+ruolo+'&idAbb='+
    idAbb)
    .pipe(tap((response) => console.log(response), catchError(this.handleError('insert error', {})))
    );
  }


  insert(iduser:number, username:string, password:string, ragioneSociale:string, telefono:string, mail:string, partitaIva:string,
        ruolo:string, idAbb:number): Observable<User[]>{
      return this.http.get<User[]>('http://localhost:8080/HomeUser/insert?iduser='+iduser+'&username='+username+'&password='+password+
      '&ragioneSociale='+ragioneSociale+'&telefono='+telefono+'&mail='+mail+'&partitaIva='+partitaIva+'&ruolo='+ruolo+'&idAbb='+
      idAbb)
      .pipe(tap((response) => console.log(response), catchError(this.handleError('insert error', {})))
      );
  }

  signup(user: User): Observable <boolean> {
    return this.http.post<boolean>('http://localhost:58708/api/signupUser', user)
    .pipe(tap( (response) => console.log("Utente"), catchError(this.handleError("login error", {})))
  );
  }

  changeFeedback(message: string){
    this.feedback = message;
  }

  deleteFeedback(){
    this.feedback = "";
  }
}

