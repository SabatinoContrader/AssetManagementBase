import { Movimento } from './../../models/Movimento';
import { MovimentoService } from './../../services/movimento.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-management-movimento',
  templateUrl: './management-movimento.component.html',
  styleUrls: ['./management-movimento.component.css','../../app/app.component.css']
})
export class ManagementMovimentoComponent implements OnInit {

  movimenti = new Array<Movimento>();

  constructor(private movimentoService: MovimentoService) { }



  ngOnInit() {
    this.movimentoService.getAllMovimenti().subscribe((response)=>{
      this.movimenti=response;
    });
  }

  

}
