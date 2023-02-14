import { Component } from '@angular/core';

@Component({
  selector: 'busqueda-busqueda',
  templateUrl: './busqueda.component.html',
  styleUrls: ['./busqueda.component.css']
})
export class BusquedaComponent {
  alumno = {
    nombre: '',
    apellido: '',
    edad: 0,
    ciclo:'',
    estudios:'',
  };
  estudio = '';
  filtrando: boolean = false;
  numeroAlumnosFiltro= 0;

  filtro = 0;

  arrayAlumnos: any[] = []

  agregarAlumno(nombreP:string,apellidoP:string,edadP:string,cicloP:string) {
    this.alumno = {
      nombre: nombreP,
      apellido: apellidoP,
      edad: Number(edadP),
      ciclo: cicloP,
      estudios:this.estudio,
    };

    this.arrayAlumnos.push(this.alumno)
  }

  capturaCambioEstudio(evento:any) {
    this.estudio = evento.target.value;
  }

  capturaCambioFiltro(evento:any) {
    this.filtro = Number(evento.target.value);
  }

  filtrarAlumno(ciclo:string,estudio:string) {
    this.filtrando = true
    if (this.filtro == 1) {
      this.numeroAlumnosFiltro = this.arrayAlumnos.filter((item)=> item.ciclo == ciclo).length
    } else {
      this.numeroAlumnosFiltro = this.arrayAlumnos.filter((item)=> item.estudios == estudio).length
    }
  }

}
