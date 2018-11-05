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
  disabledRow = new Array<boolean>();
  visButton=true;

  ngOnInit() { 
    this.badgeService.getAllBadges().subscribe((response)=>{
      this.badges=response;

      for(let i=0; i<response.length;i++){
        this.disabledRow[i]=true;
      }
    });
    this.visButton=true;
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


}
