import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-menu-booking',
  templateUrl: './menu-booking.component.html',
  styleUrls: ['./menu-booking.component.css', '../../app/app.component.css']
})
export class MenuBookingComponent implements OnInit {

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  redirectIndietro(): void {
      this.router.navigateByUrl('/homeSegretaria');
  }
    redirectHomeExport(): void {
        this.router.navigateByUrl('/managementExport');
    }
}
