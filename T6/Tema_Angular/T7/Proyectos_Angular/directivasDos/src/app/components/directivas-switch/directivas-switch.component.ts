import { Component } from '@angular/core';

@Component({
  selector: 'directivasDos-directivas-switch',
  templateUrl: './directivas-switch.component.html',
  styleUrls: ['./directivas-switch.component.css']
})
export class DirectivasSwitchComponent {

  opcion = 1;

  cambioOpcion(valor:any) {
    this.opcion = valor.target.value
  }

}
