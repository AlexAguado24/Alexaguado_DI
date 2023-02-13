import { Component } from '@angular/core';

@Component({
  selector: 'directivas-eventos',
  templateUrl: './eventos.component.html',
  styleUrls: ['./eventos.component.css']
})
export class EventosComponent {
  alumno = {
    nombre: ``,
    apellido: ``,
    estudios:``,
    ciclo:``,
    experiencia: false
  };
  estudio = ''
  estado = false
  urlImagen = 'src=https://assets.stickpng.com/images/5847ea22cef1014c0b5e4833.png'

  pulsacionBotonInicial (nombre: string, apellido: string, estudios: string, ciclo:string) {
    /* console.log(`nombre pasado: ${nombre}, edad pasada: ${edad}`); */
    /* this.alumno.nombre = nombre; */
    this.alumno.nombre = nombre
    this.alumno.apellido = apellido
    this.alumno.estudios = estudios
    this.alumno.ciclo = this.estudio

  }

  capturaValores(nombre:string,apellido:string,estudios:string) {
    if (nombre&&apellido&&estudios) {
      this.alumno.nombre = nombre
      this.alumno.apellido = apellido
      this.alumno.estudios = estudios
      this.alumno.ciclo = this.estudio
      this.alumno.experiencia = this.estado
    } else {
      alert("Algun dato esta mal")
    }

  }
  capturaCambio(ciclo:string) {
    this.estudio = ciclo;
  }
  cambioEstado(experiencia:boolean) {
    this.estado = experiencia
  }
  capturaEvento(evento:any) {
    evento.target.value
  }
}
