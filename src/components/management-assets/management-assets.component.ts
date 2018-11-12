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
  validationPrezzo: boolean;

  mapValidator = new Array<Map<string, boolean>>(); 

  ngOnInit() {
    this.visInsert = false;
    
    this.assetsService.getAllAssets().subscribe(async(response)=>{
      await(this.assets=response);
      
      //Tutte le righe disabilitate
      for(let i=0; i<response.length;i++){
        this.disabledRow[i]=true;
      }
      
      //Prezzo valido (per l'inserimento)
      this.validationPrezzo=true;
      

      for(let i=0; i<=response.length;i++){
        this.mapValidator[i]=new Map<string, boolean>(); 
        this.mapValidator[i].set("prezzo",true);
      }
      
      this.visButton=true;
    });
    
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
    this.assets[idx].prezzo=parseFloat(this.assets[idx].prezzo.toString().replace(",","."));

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
    this.insertAsset.prezzo=parseFloat(this.insertAsset.prezzo.toString().replace(",","."));
    
    this.assetsService.insert(0,this.insertAsset.tipo,this.insertAsset.descrizione, 
                            this.insertAsset.prezzo, this.insertAsset.flag)
                            .subscribe(async(response) => {
                             await(this.assets = response);
                                //this.visInsert = false;
                                this.ngOnInit();
                            });

  }


  valInsPrezzo(s:string){
    //Valori accettati: [6] [6.56] [6,56] 
    if(s.match(/^[0-9]+([.][0-9]{1,2})?([,][0-9]{1,2})?$/i)!=null){
      //OK
      this.validationPrezzo=true;
    }else{
      //ERROR
      this.validationPrezzo=false;
    } 
  }

  valModPrezzo(s:string, idx:number){
    //Valori accettati: [6] [6.56] [6,56] 
    if(s.match(/^[0-9]+([.][0-9]{1,2})?([,][0-9]{1,2})?$/i)!=null){
      //OK
      this.mapValidator[idx].set("prezzo",true);
    }else{
      //ERROR
      this.mapValidator[idx].set("prezzo",false);
    } 
  }

}
