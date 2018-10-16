///<reference path="components/menu-admin/menu-admin.component.ts"/>
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';

import { RestService } from './services/rest.service';

import {
    AppComponent,
    InsertGommaComponent,
    GommaListComponent,
    NavbarComponent,
    VehicleListComponent,
    InsertVehicleComponent,
    SearchVehicleComponent,
    FooterComponent,
    AllgommeManufacturerComponent,
    GommeForSizeComponent,
    UserListComponent,
    InsertUserComponent,
    MenuAdminComponent,
    LoginComponent

} from './components';




@NgModule({
    bootstrap: [ AppComponent ],
    declarations: [
        AppComponent,
        InsertGommaComponent,
        GommaListComponent,
        NavbarComponent,
        VehicleListComponent,
        InsertVehicleComponent,
        SearchVehicleComponent,
        FooterComponent,
        AllgommeManufacturerComponent,
        GommeForSizeComponent,
        UserListComponent,
        InsertUserComponent,
        MenuAdminComponent,
        LoginComponent],

    imports: [
        AppRoutingModule,
        BrowserModule,
        HttpModule,
        ReactiveFormsModule
    ],
    providers: [
        RestService
    ]
})
export class AppModule {}
