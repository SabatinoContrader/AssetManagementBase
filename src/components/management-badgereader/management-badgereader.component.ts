import { AssetsService } from './../../services/assets.service';
import { Asset } from './../../models/Asset';
import { BadgeReader } from './../../models/BadgeReader';
import { BadgereaderService } from './../../services/badgereader.service';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
/*import { BadgeReaderService } from './../../services/badgereader.service';*/

@Component({
  selector: 'app-management-badgereader',
  templateUrl: './management-badgereader.component.html',
  styleUrls: ['./management-badgereader.component.css','../../app/app.component.css']
})
export class ManagementBadgereaderComponent implements OnInit {

  constructor(private badgeReaderService: BadgereaderService,private assetsService: AssetsService) { }

  badgereaders = new Array<BadgeReader>();
  insertBadgeReader=new BadgeReader(0,new Asset(0,"","",0,1),null,null,1);
  
  assets= new Array<Asset>();
  disabledRow = new Array<boolean>();
  visButton=true;
  visInsert;
  visAssocia = false;
  idasset: number;
    idasset1: number;
  newassocia = new Array<any>();

  ngOnInit() {
  
  this.badgeReaderService.getAllBadgeReaders().subscribe((response)=>{
    console.log(response[0].descrizione);
    this.badgereaders=response;
    for(let i=0; i<response.length;i++){
      this.disabledRow[i]=true;
    }
    console.log(this.badgereaders);
  });
  this.visButton=true;
  this.visInsert=false;
  this.visAssocia = false;

    this.assetsService.getAllAssetsN().subscribe((response)=>{
      console.log(response[0].descrizione);
      this.assets=response;
      for(let i=0; i<response.length;i++){
        this.disabledRow[i]=true;
      }
      console.log(this.assets);
    });
    this.visButton=true;
    this.visInsert=false;
    
  }
  annulla(f:string):void{
    this.ngOnInit();
    this.visInsert=false;
  }
  insert(f:string):void{
    this.visButton=false;
    this.visInsert=true;
    //this.utenti.push(new User(0,"","","","","","","",new Abbonamento(3,"",0),null));
    
  }

    associa(f: string,idx: number): void {
        this.newassocia = new Array<any>();
        this.visAssocia = true;
        this.newassocia.push(this.badgereaders[idx].idBadgeReader);
      this.newassocia.push(this.badgereaders[idx].descrizione);
      this.newassocia.push(this.badgereaders[idx].tipologia);
    }
    applyInsert(f:string, descrizione:string, tipologia:string):void {
    
    //this.visButton=true;
    //this.utenti[idx+1].username
    this.badgeReaderService.insert(this.idasset,descrizione, tipologia)
                            .subscribe(async(response)=>{
                              await (this.badgereaders=response);


                              this.visInsert=false;
                              this.ngOnInit();
                            });    
    
  
  }

    applyAssocia(f:string):void{
    console.log(this.idasset1)
        this.badgeReaderService.associa(this.idasset1,this.newassocia[0], this.newassocia[1],this.newassocia[2])
            .subscribe(async(response)=>{
                await (this.badgereaders=response);


                this.visAssocia=false;

            });
        this.ngOnInit();

    }
}
