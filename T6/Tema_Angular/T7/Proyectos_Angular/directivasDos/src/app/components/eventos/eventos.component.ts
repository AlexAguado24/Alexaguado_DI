import { Component } from '@angular/core';

@Component({
  selector: 'directivasDos-eventos',
  templateUrl: './eventos.component.html',
  styleUrls: ['./eventos.component.css']
})
export class EventosComponent {

  alumno = {
    nombre: "",
    apellido: "",
    ciclo: "",
    estudios:"",
  }

  estudios = ''


  img ="https://assets.stickpng.com/images/5847ea22cef1014c0b5e4833.png"

  capturaValores(nombre:string, apellido:string, ciclo:string) {

    this.alumno.nombre = nombre
    this.alumno.apellido = apellido
    this.alumno.ciclo = ciclo
    this.alumno.estudios = this.estudios
  }

  capturarEstudio(estudio:any) {
    this.estudios = estudio.target.value
  }

}
