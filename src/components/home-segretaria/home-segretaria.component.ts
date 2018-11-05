import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-segretaria',
  templateUrl: './home-segretaria.component.html',
  styleUrls: ['./home-segretaria.component.css','../../app/app.component.css']
})
export class HomeSegretariaComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit() {
  }
  
}
