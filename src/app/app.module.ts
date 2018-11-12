import { StatisticheService } from './../services/statistiche.service';
import { ExportService } from './../services/export.service';
import { BookingsService } from './../services/bookings.service';
import { BadgereaderService } from './../services/badgereader.service';
import { MenuBadgereaderComponent } from './../menu/menu-badgereader/menu-badgereader.component';
import { ManagementBadgereaderComponent } from './../components/management-badgereader/management-badgereader.component';
import { MovimentoService } from './../services/movimento.service';
import { ManagementAssetsComponent } from './../components/management-assets/management-assets.component';
import { MenuAssetComponent } from './../menu/menu-asset/menu-asset.component';
import { HomeAssetComponent } from './../components/home-asset/home-asset.component';
import { AssegnazionebadgeService } from './../services/assegnazionebadge.service';
import { BadgeService } from 'src/services/badge.service';
import { HomeCustomerComponent } from './../components/home-customer/home-customer.component';
import { UserService } from './../services/user.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from '../components/login/login.component';
import { HomeSegretariaComponent } from '../components/home-segretaria/home-segretaria.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
//import { AgmCoreModule } from '@agm/core';
import { AppRoutingModule } from './app-routing.module';
import { ManagementUserComponent } from '../components/management-user/management-user.component';
import { MenuCustomerComponent } from '../menu/menu-customer/menu-customer.component';
import { MenuHomeSegretariaComponent } from '../menu/menu-home-segretaria/menu-home-segretaria.component';
import { ManagementBadgeComponent } from '../components/management-badge/management-badge.component';
import { ManagementAssegnazionebadgeComponent } from '../components/management-assegnazionebadge/management-assegnazionebadge.component';
import { HomeBookingsComponent } from '../components/home-bookings/home-bookings.component';
import { MenuBookingComponent } from '../menu/menu-booking/menu-booking.component';
import { ManagementMovimentoComponent } from '../components/management-movimento/management-movimento.component';
import { ManagementExportComponent } from '../components/management-export/management-export.component';
import { ManagementStatisticheComponent } from '../components/management-statistiche/management-statistiche.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeSegretariaComponent,
    HomeCustomerComponent,
    HomeAssetComponent,
    ManagementUserComponent,
    ManagementBadgereaderComponent,
    ManagementAssetsComponent,
    MenuCustomerComponent,
    MenuAssetComponent,
    MenuHomeSegretariaComponent,
    MenuBadgereaderComponent,
    ManagementBadgeComponent,
    ManagementAssegnazionebadgeComponent,
    HomeBookingsComponent,
    MenuBookingComponent,
    ManagementMovimentoComponent,
    ManagementExportComponent,
    ManagementStatisticheComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],

  providers: [UserService,BadgeService,AssegnazionebadgeService,BadgereaderService,BookingsService,MovimentoService, ExportService,StatisticheService],

  bootstrap: [AppComponent]
})
export class AppModule { }
