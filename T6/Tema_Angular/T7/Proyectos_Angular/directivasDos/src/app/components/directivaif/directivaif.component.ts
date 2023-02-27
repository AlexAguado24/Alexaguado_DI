import { Component } from '@angular/core';

@Component({
  selector: 'directivasDos-directivaif',
  templateUrl: './directivaif.component.html',
  styleUrls: ['./directivaif.component.css']
})
export class DirectivaifComponent {

  mostrarElemento = false

  cambiarValor() {
    this.mostrarElemento = !this.mostrarElemento
  }

  comprobarEstado(nombre:string) {
    nombre == 'Borja' ? this.mostrarElemento= true : this.mostrarElemento= false
  }


}
