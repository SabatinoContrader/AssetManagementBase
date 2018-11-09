import { ExportService } from './../../services/export.service';
import { UserService } from 'src/services/user.service';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/models/User';

@Component({
  selector: 'app-management-export',
  templateUrl: './management-export.component.html',
  styleUrls: ['./management-export.component.css','../../app/app.component.css']
})
export class ManagementExportComponent implements OnInit {

  path: string;
  nameFile: string;

  utenti= new Array<User>();
  iduser:string;

  dis: boolean;

  //Visualizza/Nasconde la lista di utenti
  visUtenti;

  

  constructor(private userService: UserService, private exportService: ExportService) { }
 
  ngOnInit() {
    this.userService.getAllUsers().subscribe(async(response)=>{
      await(this.utenti=response);
      this.visUtenti=false;
    });
    
  }

  showUtente(){
    this.visUtenti=true;
  }

  hideUtente(){
    this.visUtenti=false;
  }

  disassocia(){
    this.dis=true;
    this.iduser=null;
    this.hideUtente();

  }

  //Se iduser è null restituirà tutti gli utenti altrimenti solo quello selezionato
  export(){
    this.exportService.export(this.iduser,this.path,this.nameFile).subscribe((response)=>{
    });
  }
  

}
