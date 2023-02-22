import { Component } from '@angular/core';

@Component({
  selector: 'directivasTres-eventos',
  templateUrl: './eventos.component.html',
  styleUrls: ['./eventos.component.css']
})
export class EventosComponent {

  valor = ''

  cambiarValor(valor:string) {
    this.valor = valor
  }



}
