import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-asset',
  templateUrl: './home-asset.component.html',
  styleUrls: ['./home-asset.component.css','../../app/app.component.css']
})
export class HomeAssetComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit() {
  }

}
