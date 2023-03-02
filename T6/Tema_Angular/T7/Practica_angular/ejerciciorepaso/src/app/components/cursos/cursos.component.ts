import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Asignatura } from 'src/app/model/Asignatura';
import { AsignaturasService } from 'src/app/service/asignaturas.service';

@Component({
  selector: 'ejerciciorepaso-cursos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css']
})
export class CursosComponent {

  dato = '';

  asignaturas:Asignatura[] = []

  constructor(private servicioAsignaturas:AsignaturasService, private gestorRutas: ActivatedRoute)
  {
    gestorRutas.params.subscribe((param)=>{
      this.dato = param['id']
      this.asignaturas = this.servicioAsignaturas.getAsgisnaturasFiltradas(this.dato)
    })
  }

}
