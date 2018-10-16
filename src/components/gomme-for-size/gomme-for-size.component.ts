///<reference path="../../services/rest.service.ts"/>
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {RestService} from "../../services/rest.service";
import {Component} from "@angular/core";
import {Gommasize} from "../../models";

@Component({
    selector: 'gomme-for-size',
    template: require('./gomme-for-size.component.html')
})
export class GommeForSizeComponent {

    insertSuccess: boolean = false;
    gommeForSizeForm: FormGroup;
    payload: any;
    gommeSize: Gommasize[];

    constructor(private restService: RestService, private fb: FormBuilder) {
        this.createForm();
        this.gommeSize = [];
    }

    createForm() {
        this.gommeForSizeForm = this.fb.group({
            width: ['', Validators.required],
            height: ['', Validators.required],
            diameter: ['', Validators.required],
            weight: ['', Validators.required],
            speed: ['', Validators.required],
            season: ['', Validators.required],
            typeVehicle: ['', Validators.required]
        });
    }


    submit() {
        this.payload = this.gommeForSizeForm.value;
        this.restService.gommeForSize(this.payload).subscribe((data:any) => {
            this.insertSuccess = true;
this.gommeSize = data;
});
}
}
