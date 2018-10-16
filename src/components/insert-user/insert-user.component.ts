import {Component} from "@angular/core";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {RestService} from "../../services/rest.service";

@Component({
    selector: 'insert-user',
    template: require('./insert-user.component.html')
})
export class InsertUserComponent{

    insertSuccess: boolean=false;
    userForm: FormGroup;
    payload: string;
    esito: string;

    constructor(private restService: RestService, private fb: FormBuilder)
    {
        this.createForm();
    }
    createForm() {
        this.userForm=this.fb.group({
            username: ['', Validators.required],
            password: ['',Validators.required],
            firstname: ['',Validators.required],
            lastname: ['',Validators.required],
            dateofbirth: ['',Validators.required],
            fiscalcode: ['', Validators.required],
            businessname: ['', Validators.required],
            vat: ['', Validators.required],
            municipality: ['', Validators.required],
            post: ['', Validators.required],
            city: ['', Validators.required],
            address: ['', Validators.required],
            telephone: ['', Validators.required],
            role: ['user']
        });
    }
    submit() {
        this.payload = this.userForm.value;
        this.restService.insertUser(this.payload).subscribe((data) =>
        {
            if(data.response==0)
               this.esito="Utente non registrato"
            else
                this.esito="insermento avvenuto";
            this.insertSuccess =true;
        });
    }
}