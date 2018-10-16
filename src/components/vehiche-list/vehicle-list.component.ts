import { Component } from '@angular/core';
import {Vehicle} from '../../models';
import { RestService } from '../../services/rest.service';

@Component({
    selector: 'vehicle-list',
    template: require('./vehicle-list.component.html'),
    styles: []
})
export class VehicleListComponent {
    vehicles: Vehicle[] = [];

    constructor(private restService: RestService) {
        restService.getListaVehicles().subscribe((data: any) => {
            this.vehicles = data;
        });
    }
}