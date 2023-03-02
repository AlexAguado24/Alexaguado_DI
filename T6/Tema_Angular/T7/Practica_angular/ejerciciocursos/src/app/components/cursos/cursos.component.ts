import { Component } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Asignatura } from 'src/app/model/Asignatura';
import { AsignaturasService } from 'src/app/service/asignaturas.service';

@Component({
  selector: 'ejerciciocursos-cursos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css']
})
export class CursosComponent {

  dato = '';

  asignaturas: Asignatura[] = []

  constructor(private servicioAsignatura: AsignaturasService, private gestorDeRutas: ActivatedRoute)
  {
    gestorDeRutas.params.subscribe((param)=>{
      this.dato = param['id'];
      this.asignaturas = this.servicioAsignatura.getAsgnaturasFiltradas(this.dato)
    })

  }
}
