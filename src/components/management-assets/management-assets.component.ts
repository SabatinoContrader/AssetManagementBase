import { Asset } from './../../models/Asset';
import { AssetsService } from './../../services/assets.service';
import { NgForm } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import {async} from 'rxjs/internal/scheduler/async';

@Component({
  selector: 'app-management-assets',
  templateUrl: './management-assets.component.html',
  styleUrls: ['./management-assets.component.css','../../app/app.component.css']
})
export class ManagementAssetsComponent implements OnInit {

  constructor(private assetsService: AssetsService) { }

  assets = new Array<Asset>();
  insertAsset = new Asset(0,"","",null,null);
  disabledRow = new Array<boolean>();
  visButton = true;
  visInsert = false;
  ngOnInit() {
      this.visInsert = false;
    
    this.assetsService.getAllAssets().subscribe((response)=>{
      console.log(response[0].descrizione);
      this.assets=response;
      console.log(this.assets[0].descrizione);
      for(let i=0; i<response.length;i++){
        this.disabledRow[i]=true;
      }
    });
    this.visButton=true;
  }

  delete(f:string, id:number) :void{
    this.assetsService.delete(id).subscribe((response)=>{
      this.assets=response;
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
    this.assetsService.modify(id,this.assets[idx].tipo,this.assets[idx].descrizione,this.assets[idx].prezzo)
                    .subscribe();
  }

  annulla(f:String):void{
    this.ngOnInit();
    this.visInsert=false;
  }
   insert(f:string,):void{
    this.visButton=false;
    this.visInsert=true;
    this.insertAsset = new Asset(0,"","",null,null);

  } 

  applyInsert(c: String): void {

    this.assetsService.insert(0,this.insertAsset.tipo,this.insertAsset.descrizione, 
                            this.insertAsset.prezzo, this.insertAsset.flag)
                            .subscribe(async(response) => {
                             await(this.assets = response);
                                this.visInsert = false;
                            });


    this.ngOnInit();
  
  }
}
