///<reference path="../../services/rest.service.ts"/>
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {RestService} from "../../services/rest.service";
import {Component} from "@angular/core";
import {Gomma} from "../../models";

@Component({
    selector: 'search-vehicle',
    template: require('./search-vehicle.component.html')
})
export class SearchVehicleComponent {

    insertSuccess: boolean = false;
    vehicleSearchForm: FormGroup;
    payload: string;
    gommeVehicle: Gomma[];

    constructor(private restService: RestService, private fb: FormBuilder) {
        this.createForm()
        this.gommeVehicle = [];
    }

    createForm() {
        this.vehicleSearchForm = this.fb.group({
            brand: ['', Validators.required],
            model: ['', Validators.required],
            fuel:  ['', Validators.required],
            version:  ['', Validators.required],
            capacity: ['',Validators.required]
        });
    }


    submit() {
        this.payload = this.vehicleSearchForm.value;
        this.restService.searchVehicle(this.payload).subscribe((data:any) => {
            this.insertSuccess = true;
            this.gommeVehicle = data;
        });
    }
}
