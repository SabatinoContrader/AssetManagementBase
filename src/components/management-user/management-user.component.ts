import { Abbonamento } from './../../models/Abbonamento';
import { NgForm } from '@angular/forms';
import { Component, OnInit, Output, Testability } from '@angular/core';
import { UserService } from 'src/services/user.service';
import { User } from '../../models/User';
import { AngularWaitBarrier } from 'blocking-proxy/built/lib/angular_wait_barrier';
import { Router } from '@angular/router';
import { stringify } from '@angular/core/src/render3/util';


@Component({
  selector: 'app-management-user',
  templateUrl: './management-user.component.html',
  styleUrls: ['./management-user.component.css','../../app/app.component.css']
})
export class ManagementUserComponent implements OnInit {
  
  
  utenti = new Array<User>();
  insertUtente = new User(0,"","","","","","cliente","",new Abbonamento(3,"",0),null);
  disabledRow = new Array<boolean>();
  validationRow = new Array<boolean>();
  visButton=true;
  visInsert;

  mapValidator = new Array<Map<string, boolean>>(); 

  


  constructor(private userService: UserService) {}

  ngOnInit() {

    this.userService.getAllUsers().subscribe(async(response)=>{
      //Ottenimento di tutti gli utenti dal DB
      await(this.utenti=response);


      //Tutte le righe disabilitate
      for(let i=0; i<=response.length;i++){
        this.disabledRow[i]=true;
      }

      //Tutti gli elementi delle righe validi (per l'inserimento)
      for(let i=0; i<=8;i++){
        this.validationRow[i]=true;
      }
      
      //Tutti gli elementi delle righe validi (per la modifica)
      //Ho scelto di creare un array di HashMap (invece che una matrice) per maggiore chiarezza nel codice. Ad ogni modifica
      //di un campo si accede alla riga corrispondenete (elemento dell'array) e si estra il valore dall'HashMap (idUtente,
      //username, ecc.).
      
      for(let i=0; i<=response.length;i++){
        this.mapValidator[i]=new Map<string, boolean>();
        //this.mapValidator[i].set("idUtente",true);
        this.mapValidator[i].set("username",true);
        this.mapValidator[i].set("password",true);
        this.mapValidator[i].set("ragioneSociale",true);
        this.mapValidator[i].set("telefono",true);
        this.mapValidator[i].set("email",true);
        this.mapValidator[i].set("partitaIva",true);
        //this.mapValidator[i].set("ruolo",true);
        //this.mapValidator[i].set("nomeAbbonamento",true);
      }

      //PROBLEMA: non fa riferimento al model (di Angular) neanche se specifico l'inserimento variabile per variabile (no aliasing).
      /*
      for(var index in response){
        this.utenti[index].iduser=response[index].iduser;
        this.utenti[index].partitaIva=response[index].partitaIva;
        console.log(this.utenti[0].partitaIva);
      }
      */


      //Bottoni visibili
      this.visButton=true;  

      //Riga insert non generata
      this.visInsert=false;
    });
    
    
  }

  delete(f:String,id:number):void{
    this.userService.delete(id).subscribe((response)=>{
      this.utenti=response;
    });
  }

  modify(f:String,idx:number):void{
    this.disabledRow[idx]=false;
    this.visButton=false;
  }

  //idx è il perfetto indice dell'array utenti (non id!).
  applyModify(c:String,idx:number,id:number):void{
    this.disabledRow[idx]=true;
    this.visButton=true;
    this.userService.modify(id,this.utenti[idx].username,this.utenti[idx].password, 
                              this.utenti[idx].ragioneSociale, this.utenti[idx].telefono, 
                              this.utenti[idx].mail, this.utenti[idx].partitaiva, this.utenti[idx].ruolo, 
                              this.utenti[idx].abbonamento.id)
                    .subscribe();
    
  
  }

  annulla(f:String,id:number):void{
    this.ngOnInit();
  }

  insert(f: string): void {
    this.visButton = false;
    this.visInsert = true;
      this.insertUtente = new User(0,"","","","","","cliente","",new Abbonamento(3,"",0),null);
  }

  applyInsert(c:String):void{
    
    //this.visButton=true;
    //this.utenti[idx+1].username
    this.userService.insert(0,this.insertUtente.username,this.insertUtente.password, 
                            this.insertUtente.ragioneSociale, this.insertUtente.telefono, 
                            this.insertUtente.mail, this.insertUtente.partitaiva, this.insertUtente.ruolo, 
                            this.insertUtente.abbonamento.id)
                            .subscribe((response)=>{
                              this.utenti=response;
                            });    
    //this.visInsert=false;

    this.ngOnInit();
  
  }




  //VALIDATORI PER L'INSERIMENTO

  valInsUsername(s:string){
    //Valori accettati: [qualsiasi] da 3 (escluso) a 10 (escluso) 
    if(s.match(/^(\S){4,10}$/i)!=null){
      //OK
      this.validationRow[1]=true;
    }else{
      //ERROR
      this.validationRow[1]=false;
    } 
  }

  valInsPassword(s:string){
    //Valori accettati: [qualsiasi] da 3 (escluso) a 10 (escluso)
    if(s.match(/^(\S){4,10}$/i)!=null){
      //OK
      this.validationRow[2]=true;
    }else{
      //ERROR
      this.validationRow[2]=false;
    }  
  }

  valInsTelefono(s:string){
    //Numeri accettati: [1234567890] [+391234567890] [+39 1234567890]
    if(s.match(/^([\+?][0-9]{2}[\s]?)?[0-9]{10}$/i)!=null){
      //OK
      this.validationRow[4]=true;
    }else{
      //ERROR
      this.validationRow[4]=false;
    } 
  }

  

  valInsMail(s:string){
    //Valori accettati: [qualsiasi] uno o più volte [@] una volta [qualsiasi] uno o più volte
    if(s.match(/^(\S)+(@)(\S)+$/i)!=null){
      //OK
      this.validationRow[5]=true;
    }else{
      //ERROR
      this.validationRow[5]=false;
    }  
  }

  valInsPartitaIva(s:string){
    //Valori accettati: [12345678901] undici numeri
    if(s.match(/^[0-9]{11}$/i)!=null){
      //OK
      this.validationRow[6]=true;
    }else{
      //ERROR
      this.validationRow[6]=false;
    }  
  }




  //VALIDATORI PER LA MODIFICA

  valModUsername(s:string,idx:number){
    
    if(s.match(/^(\S){4,10}$/i)!=null){
      //OK
      this.mapValidator[idx].set("username",true);
    }else{
      //ERROR
      this.mapValidator[idx].set("username",false);
    }  
  }

  valModPassword(s:string,idx:number){
    
    if(s.match(/^(\S){4,10}$/i)!=null){
      //OK
      this.mapValidator[idx].set("password",true);
    }else{
      //ERROR
      this.mapValidator[idx].set("password",false);
    }  
  }

  valModTelefono(s:string,idx:number){
    if(s.match(/^([\+?][0-9]{2}[\s]?)?[0-9]{10}$/i)!=null){
      //OK
      this.mapValidator[idx].set("telefono",true);
    }else{
      //ERROR
      this.mapValidator[idx].set("telefono",false);
    }  
  }

  valModEmail(s:string,idx:number){
    if(s.match(/^(\S)+(@)(\S)+$/i)!=null){
      //OK
      this.mapValidator[idx].set("email",true);
    }else{
      //ERROR
      this.mapValidator[idx].set("email",false);
    }  
  }

  valModPartitaIva(s:string,idx:number){
    if(s.match(/^[0-9]{11}$/i)!=null){
      //OK
      this.mapValidator[idx].set("partitaIva",true);
    }else{
      //ERROR
      this.mapValidator[idx].set("partitaIva",false);
    }  
  }


}//ManagementUserComponent