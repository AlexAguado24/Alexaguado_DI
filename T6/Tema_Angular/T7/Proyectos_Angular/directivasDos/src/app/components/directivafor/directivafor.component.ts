import { Component } from '@angular/core';
import { Asignatura } from 'src/app/model/asignatura';
import { AsignaturasService } from 'src/app/service/asignaturas.service';

@Component({
  selector: 'directivasDos-directivafor',
  templateUrl: './directivafor.component.html',
  styleUrls: ['./directivafor.component.css']
})
export class DirectivaforComponent {

  elementos: string[] = ['elemento 1','elemento 2','elemento 3','elemento 4',]

  aniadirElemento(elemento:string){
    this.elementos.push(elemento);
  }

  asignaturas: Asignatura[]

  constructor(private servicioAsignaturas:AsignaturasService){
    this.asignaturas = servicioAsignaturas.getAllAsignaturas()
  }

  evaluarCambio(evento:any){

    this.asignaturas = this.servicioAsignaturas.getAsignaturasFiltradas(Number(evento.target.value))

  }

  buscarCiclo(ciclo:string){
    this.asignaturas = this.servicioAsignaturas.getFiltroCiclo(ciclo)
  }


}
