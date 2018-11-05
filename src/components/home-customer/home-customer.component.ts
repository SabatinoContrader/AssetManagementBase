import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-customer',
  templateUrl: './home-customer.component.html',
  styleUrls: ['./home-customer.component.css','../../app/app.component.css']
})
export class HomeCustomerComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit() {
  }
  
  
}
