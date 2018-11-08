import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu-badgereader',
  templateUrl: './menu-badgereader.component.html',
  styleUrls: ['./menu-badgereader.component.css','../../app/app.component.css']
})
export class MenuBadgereaderComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }
  redirectManagementAssets(): void{
    this.router.navigateByUrl('/managementAssets');
  }
  redirectManagementBadgeReader(): void{
    
    this.router.navigateByUrl('/managementBadgeReader');
  }
  redirectIndietro(): void{
    if(this.router.routerState.snapshot.url=="/homeAsset"){
      this.router.navigateByUrl("/homeSegretaria");
    }else{
      this.router.navigateByUrl("/homeAsset");
    }
}
}
