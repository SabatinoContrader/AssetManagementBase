import { ManagementAssetsComponent } from './../components/management-assets/management-assets.component';
import { HomeAssetComponent } from './../components/home-asset/home-asset.component';

import { ManagementAssegnazionebadgeComponent } from '../components/management-assegnazionebadge/management-assegnazionebadge.component';

import { HomeSegretariaComponent } from './../components/home-segretaria/home-segretaria.component';
import { LoginComponent } from './../components/login/login.component';
import { HomeCustomerComponent } from './../components/home-customer/home-customer.component';
import { NgModule } from '@angular/core';

import {RouterModule, Routes} from '@angular/router';
import { ManagementUserComponent } from 'src/components/management-user/management-user.component';
import { ManagementBadgeComponent } from 'src/components/management-badge/management-badge.component';



const routes: Routes = [
    { path: '', redirectTo: '/login', pathMatch: 'full' },
    { path: 'homeSegretaria', component: HomeSegretariaComponent },
    { path: 'login', component: LoginComponent },
    { path: 'homeCustomer', component: HomeCustomerComponent},
    { path: 'homeAsset', component: HomeAssetComponent},
    { path: 'managementUser', component: ManagementUserComponent},
    { path: 'managementBadge', component: ManagementBadgeComponent},
    { path: 'managementAssets', component: ManagementAssetsComponent},
    { path: 'managementAssegnazionebadge', component: ManagementAssegnazionebadgeComponent}

    
];

@NgModule({
    exports: [RouterModule],
    imports: [RouterModule.forRoot(routes, { useHash: true, onSameUrlNavigation: 'reload' })],
    declarations: []
})
export class AppRoutingModule { }