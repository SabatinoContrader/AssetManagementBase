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
  visButton=true;
  visInsert;


  constructor(private userService: UserService) { }

  ngOnInit() {

    this.userService.getAllUsers().subscribe((response)=>{
      //Ottenimento di tutti gli utenti dal DB
      this.utenti=response;


      //Tutte le righe disabilitate
      for(let i=0; i<=response.length;i++){
        this.disabledRow[i]=true;
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


}