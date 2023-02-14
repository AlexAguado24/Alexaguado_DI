import { Component } from '@angular/core';

@Component({
  selector: 'directivas-directivaswitch',
  templateUrl: './directivaswitch.component.html',
  styleUrls: ['./directivaswitch.component.css']
})
export class DirectivaswitchComponent {

  opcion = '';

  cambioRadio(valor: any) {
    this.opcion = valor.target.value
  }

}
