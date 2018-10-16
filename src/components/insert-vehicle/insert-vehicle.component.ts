import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {RestService} from "../../services/rest.service";
import {Component} from "@angular/core";

@Component({
    selector: 'insert-vehicle',
    template: require('./insert-vehicle.component.html')
})
export class InsertVehicleComponent {

    insertSuccess: boolean = false;
    vehicleForm: FormGroup;
    payload: string;

    constructor(private restService: RestService, private fb: FormBuilder) {
        this.createForm()
    }

    createForm() {
        this.vehicleForm = this.fb.group({
            brand: ['', Validators.required],
            model: ['', Validators.required],
            fuel:  ['', Validators.required],
            version:  ['', Validators.required],
            capacity: ['',Validators.required]
        });
    }


    submit() {
        this.payload = this.vehicleForm.value;
        this.restService.insertVehicle(this.payload).subscribe((data) => {
            this.insertSuccess = true;
        });
    }
}
