import { Component } from '@angular/core';

@Component({
  selector: 'busqueda-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'busquedasPractica';
  estudio = '';
  filtro = 0;
  alumnos: any[] = [];
  filtrando:boolean = false;
  numeroAlumnosFiltro = 0;
  agregarAlumno(nombreP:string,apellidoP:string,edadP:string,cicloP:string){
    let alumno = {
      nombre : nombreP,
      apellido : apellidoP,
      edad : Number(edadP),
      ciclo : cicloP
    };
    this.alumnos.push(alumno)
  }
  obtenerEstudio(evento:any){
    this.estudio = evento.target.value
  }
  cambioFiltro(evento:any){
    this.filtro = Number(evento.target.value)
  }
  filtrar(ciclo:string,estudio:string){
    this.filtrando = true;
    if(this.filtro == 1){
      this.numeroAlumnosFiltro = this.alumnos.filter((item)=>item.ciclo == ciclo).length
    } else {
      this.numeroAlumnosFiltro = this.alumnos.filter((item)=> item.estudios == estudio).length
    }
  }
}
