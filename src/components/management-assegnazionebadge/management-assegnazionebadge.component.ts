import { User } from './../../models/User';
import { UserService } from 'src/services/user.service';
import { BadgeService } from './../../services/badge.service';
import { AssegnazioneBadge } from 'src/models/AssegnazioneBadge';
import { AssegnazionebadgeService } from './../../services/assegnazionebadge.service';
import { Component, OnInit } from '@angular/core';
import { Badge } from 'src/models/Badge';

@Component({
  selector: 'app-management-assegnazionebadge',
  templateUrl: './management-assegnazionebadge.component.html',
  styleUrls: ['./management-assegnazionebadge.component.css', '../../app/app.component.css']
})
export class ManagementAssegnazionebadgeComponent implements OnInit {

  constructor(private assegnazionebadgeService: AssegnazionebadgeService, private badgeService: BadgeService,private userService: UserService) {
   }

  assbadges = new Array<AssegnazioneBadge>();
  badges = new Array<Badge>();
  utenti = new Array<User>();
  disabledRow = new Array<boolean>();
  visButton = true;
  visInsert;
  d = new Date();

  insertArray = new Array<any>(0 , 0 , '' , '');
  



  ngOnInit() {

    //Assegnazioni
    this.assegnazionebadgeService.getAllAssBadges().subscribe((response)=>{
      this.assbadges=response;
      
      for(let i=0; i<=response.length;i++){
        this.disabledRow[i]=true;
      }
    });
    
    //Badges
    this.assegnazionebadgeService.getAllBadgesN().subscribe((response)=>{
      this.badges=response;
    });

    //Utenti
    this.userService.getAllUsers().subscribe((response)=>{
      this.utenti=response;
    });

    //Bottoni visibili
    this.visButton=true;

    //Riga insert non generata
    this.visInsert=false;
    
  }


  delete(f:string,iduser:number,idbadge:number):void{
    this.assegnazionebadgeService.delete(iduser,idbadge).subscribe(async (response)=>{
      await (this.assbadges=response);
      this.assegnazionebadgeService.getAllBadgesN().subscribe((response)=>{
        (this.badges=response);
     });
    });

    
  }

  insert(f:string,idbadge:number, iduser:number, nome:string, cognome:string):void{
    this.assegnazionebadgeService.insert(iduser,idbadge,nome,cognome).subscribe(async (response)=>{
      await (this.assbadges=response);
      this.assegnazionebadgeService.getAllBadgesN().subscribe((response)=>{
        this.badges=response;
      });
    });

    this.insertArray[2]="";
    this.insertArray[3]="";

  }

}
 