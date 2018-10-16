///<reference path="../../services/rest.service.ts"/>
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {RestService} from "../../services/rest.service";
import {Component} from "@angular/core";
import {Gomma} from "../../models";

@Component({
    selector: 'allgomme-manufacturer',
    template: require('./allgomme-manufacturer.component.html')
})
export class AllgommeManufacturerComponent {

    insertSuccess: boolean = false;
    allgommeManufacturerForm: FormGroup;
    payload: any;
    gommeManufacturer: Gomma[];

    constructor(private restService: RestService, private fb: FormBuilder) {
        this.createForm();
        this.gommeManufacturer = [];
    }

    createForm() {
        this.allgommeManufacturerForm = this.fb.group({
            manufacturer: ['', Validators.required],
            typeVehicle: ['',Validators.required]
        });
    }


    submit() {
        this.payload = this.allgommeManufacturerForm.value;
        this.restService.allgommeManufacturer(this.payload).subscribe((data:any) => {
            this.insertSuccess = true;
this.gommeManufacturer = data;
});
}
}
