import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu-customer',
  templateUrl: './menu-customer.component.html',
  styleUrls: ['./menu-customer.component.css','../../app/app.component.css']
})
export class MenuCustomerComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  redirectManagementUser():void{
    this.router.navigateByUrl('/managementUser');
  }

  redirectManagementBadge(): void{ 
    this.router.navigateByUrl('/managementBadge')
  } 

  redirectIndietro(): void{
    if(this.router.routerState.snapshot.url=="/homeCustomer"){
      this.router.navigateByUrl("/homeSegretaria");
    }else{
      this.router.navigateByUrl("/homeCustomer");
    }

  }


  redirectManagementAssegnazionebadge():void{
    console.log("ARRIVATO");
    this.router.navigateByUrl("/managementAssegnazionebadge");
  }
 
}
