import { Component } from '@angular/core';

@Component({
  selector: 'directivas-eventos',
  templateUrl: './eventos.component.html',
  styleUrls: ['./eventos.component.css']
})
export class EventosComponent {
  alumno = {
    nombre: `Borja`,
    apellido: `Martin`,
    edad: 40
  }
  urlImagen = 'src=https://assets.stickpng.com/images/5847ea22cef1014c0b5e4833.png'

  pulsacionBotonInicial (nombre: string, edad:Number) {
    /* console.log(`nombre pasado: ${nombre}, edad pasada: ${edad}`); */
    this.alumno.nombre = nombre;
  }
}
