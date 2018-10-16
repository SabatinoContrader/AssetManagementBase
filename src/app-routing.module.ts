import { NgModule } from '@angular/core';
import {
    RouterModule,
    Routes
} from '@angular/router';


import {
    AllgommeManufacturerComponent,
    GommaListComponent, GommeForSizeComponent, InsertGommaComponent, InsertUserComponent, MenuAdminComponent,
    UserListComponent
} from "./components";

import {LoginComponent} from "./components";

import {InsertVehicleComponent, SearchVehicleComponent, VehicleListComponent} from "./components";


const appRoutes: Routes = [

    {
        path: 'gomme',
        component: GommaListComponent
    },
    {
        path: 'newGomma',
        component: InsertGommaComponent
    },
    {
        path: 'vehicles',
        component: VehicleListComponent
    },
    {
        path: 'newVehicle',
        component: InsertVehicleComponent
    },
    {
        path: 'allgommeManufacturer',
        component: AllgommeManufacturerComponent

    },
    {
        path: 'gommeForSize',
        component: GommeForSizeComponent

    },
    {
        path: 'searchVehicle',
        component: SearchVehicleComponent

    },

    {
        path: 'login',
        component: LoginComponent

    },


    {
        path: 'users',
        component: UserListComponent

    },
    {
        path :'reg',
        component: InsertUserComponent

    },
    {
        path: 'menuAdmin',
        component: MenuAdminComponent
    },
    {
        path: '',
        pathMatch: 'full',
        redirectTo: '/gomme'
    }
];

@NgModule({
    imports: [
        RouterModule.forRoot(appRoutes, { useHash: true })
    ],
    exports: [
        RouterModule
    ]
})
export class AppRoutingModule {}
