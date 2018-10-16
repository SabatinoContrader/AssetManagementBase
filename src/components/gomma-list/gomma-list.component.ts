import { Component } from '@angular/core';
import { Gomma } from '../../models';
import { RestService } from '../../services/rest.service';

@Component({
    selector: 'gomma-list',
    template: require('./gomma-list.component.html'),
    styles: []
})
export class GommaListComponent {
  gomme: Gomma[] = [];

  constructor(private restService: RestService) {
      restService.getListaGomme().subscribe((data: any) => {
          this.gomme = data;
      });
  }
}
