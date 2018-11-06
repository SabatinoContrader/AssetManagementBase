import { Badge } from './../../models/Badge';
import { NgForm } from '@angular/forms';
import { BadgeService } from './../../services/badge.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-management-badge',
  templateUrl: './management-badge.component.html',
  styleUrls: ['./management-badge.component.css','../../app/app.component.css']
})
export class ManagementBadgeComponent implements OnInit {

  constructor(private badgeService: BadgeService) { }

  badges = new Array<Badge>();
  insertBadge = new Badge(0,"","");
  disabledRow = new Array<boolean>();
  visButton=true; 
  visInsert;

  ngOnInit() { 
    this.badgeService.getAllBadges().subscribe((response)=>{
      this.badges=response;

      for(let i=0; i<=response.length;i++){
        this.disabledRow[i]=true;
      }
    });
    
    //Bottoni visibili
    this.visButton=true;

    //Riga insert non generata
    this.visInsert=false;
  }

  delete(f:string, id:number) :void{
    this.badgeService.delete(id).subscribe((response)=>{
      this.badges=response;
    });
  }

  modify(f:string, id:number) :void{
    this.disabledRow[id]=false;
    this.visButton=false;
  }

  apply(c:String,idx:number,id:number,f: NgForm):void{
    console.log("TEST1:"+id);
    this.disabledRow[idx]=true;
    this.visButton=true;
    this.badgeService.modify(id,this.badges[idx].tipologia,this.badges[idx].descrizione)
                    .subscribe();
  }

  annulla(f:String):void{
    this.ngOnInit();
  }

  insert(f:string):void{
    this.visButton=false;
    this.visInsert=true;
    //this.utenti.push(new User(0,"","","","","","","",new Abbonamento(3,"",0),null));
    
  } 

  applyInsert(c:String):void{
    
    //this.visButton=true;
    //this.utenti[idx+1].username
    this.badgeService.insert(0,this.insertBadge.tipologia,this.insertBadge.descrizione)
                            .subscribe((response)=>{
                              this.badges=response;
                            });    
    //this.visInsert=false;

    this.ngOnInit();
  
  }


}
