import { Component, OnInit } from '@angular/core';
import {Asset} from '../../models/Asset';
import {AssetsService} from '../../services/assets.service';
import {UserService} from '../../services/user.service';
import {User} from '../../models/User';
import {BookingsService} from '../../services/bookings.service';
import {Prenotazione} from '../../models/Prenotazione';
import {NgForm} from '@angular/forms';
import {Abbonamento} from '../../models/Abbonamento';

@Component({
  selector: 'app-home-bookings',
  templateUrl: './home-bookings.component.html',
  styleUrls: ['./home-bookings.component.css', '../../app/app.component.css']
})
export class HomeBookingsComponent implements OnInit {

  constructor(private assetService: AssetsService, private userService: UserService, private prenotazioneService: BookingsService) {
  }
  assets = new Array<Asset>();
  users = new Array<User>();
  prens = new Array<Prenotazione>();
  disabledRow = new Array<boolean>();
  visButton = true;
  visInsert;
  asset = new Asset(0,"","",null,null);
  insertArray = new Array<any>(0 , 0 , '' , '');
  utente = new User(0,"","","","","","cliente","", new Abbonamento(3,"",0),null);
  insertPren = new Prenotazione(0, this.asset , this.utente , '' , '' );

  ngOnInit() {
      this.prenotazioneService.getAllPrenotazioni().subscribe((response) =>  {
          console.log(response);
          this.prens = response;
          for (let i = 0; i <= response.length; i++ )   {
              this.disabledRow[i] = true;

          }

      });
      this.assetService.getAllAssets().subscribe((response) => {
          console.log(response);
          this.assets = response;
  });
      this.userService.getAllUsers().subscribe((response) =>  {
         console.log(response);
          this.users = response;
      });
}

      modify(f: string, id: number): void {
          this.disabledRow[id] = false;
        this.visButton = false;
      }
      apply(c: String , idx: number, idu: number, ida: number, id: number ): void {
          console.log('TEST1:' + id);
      this.disabledRow[idx] = true;
      this.visButton = true;
      this.prenotazioneService.updatePren(id , idu, ida, this.prens[idx].orainizio, this.prens[idx].orafine)
          .subscribe((response) => {
              this.prens = response;
          });
      this.ngOnInit();
  }

      annulla(f: String): void {
          this.ngOnInit();
      this.visInsert = false;
          this.visButton = true;
  }
   insert(f: string): void {
    this.visInsert = true;
    this.visButton = false;
       this.insertArray = new Array<any>(0 , 0 , '' , '');


   }
    applyIns(a: string): void {
        this.visInsert = false;
        this.visButton = true;
        this.prenotazioneService.insertPren(0, this.insertArray[1], this.insertArray[0], this.insertArray[2], this.insertArray[3])
            .subscribe((response) => {
              this.prens = response;
            });
        this.ngOnInit();
    }
}