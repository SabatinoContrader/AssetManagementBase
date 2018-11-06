import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu-asset',
  templateUrl: './menu-asset.component.html',
  styleUrls: ['./menu-asset.component.css','../../app/app.component.css']
})
export class MenuAssetComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }
  redirectManagementAssets(): void{
    this.router.navigateByUrl('/managementAssets');
  }
  redirectmanagementBadgeReader(): void{
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
