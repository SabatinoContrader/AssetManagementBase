import {Component} from "@angular/core";
import {User} from "../../models";
import {RestService} from "../../services/rest.service";

@Component({
    selector: 'user-list',
    template: require ('./user-list.component.html')
})
export class UserListComponent{

    users: User[]=[];
    constructor(private restService: RestService){
        restService.getListaUsers().subscribe((data:any)=>{
            this.users=data;
        });
    }
}