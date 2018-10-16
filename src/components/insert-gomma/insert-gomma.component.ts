import {
    Component,
} from '@angular/core';
import {
    FormBuilder,
    FormGroup,
    Validators
} from '@angular/forms';


import {RestService} from "../../services/rest.service";
import {Gomma} from "../../models";

@Component({
    selector: 'insert-gomma',
    template: require('./insert-gomma.component.html')
})
export class InsertGommaComponent {

    insertSuccess: boolean = false;
    gommaForm: FormGroup;
    payload: string;
    gomme: Gomma[];

    constructor(private restService: RestService, private fb: FormBuilder) {
      this.createForm()
    }

    createForm() {
        this.gommaForm = this.fb.group({
            model: ['', Validators.required],
            manufacturer:  ['', Validators.required],
            price:  ['', Validators.required],
            width: ['', Validators.required],
            height: ['', Validators.required],
            diameter: ['', Validators.required],
            weight: ['', Validators.required],
            speed: ['', Validators.required],
            typeVehicle: ['', Validators.required],
            season: ['', Validators.required],
            quantity:['', Validators.required]
        });
    }


    submit() {
        this.payload = this.gommaForm.value;
        this.restService.insertGomma(this.payload).subscribe((data: any) => {
            this.insertSuccess = true;
            this.gomme = data;
        });
    }
}
