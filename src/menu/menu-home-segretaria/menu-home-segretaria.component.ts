import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu-home-segretaria',
  templateUrl: './menu-home-segretaria.component.html',
  styleUrls: ['./menu-home-segretaria.component.css','../../app/app.component.css']
})
export class MenuHomeSegretariaComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  redirectHomeCustomer(): void{
    this.router.navigateByUrl('/homeCustomer');
  }
  redirectHomeAsset(): void{
    this.router.navigateByUrl('/homeAsset');
  }
}
