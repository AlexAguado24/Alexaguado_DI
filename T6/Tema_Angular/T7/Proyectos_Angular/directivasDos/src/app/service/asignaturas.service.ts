import { Injectable } from '@angular/core';
import { Asignatura } from '../model/asignatura';

@Injectable({
  providedIn: 'root'
})
export class AsignaturasService {

  //datos
  private asignaturas: Asignatura[] = [
    {
      nombre: 'Desarrollo de interfaces',
      imagen : 'https://m.media-amazon.com/images/I/810Cwks+FaL.jpg',
      siglas : 'DI',
      curso: 2,
      ciclo: 'DAM',
      profesor:'Borja',
      conocimientos: ['java','js','angular']
    },
    {
      nombre: 'Kotlin',
      imagen : 'https://www.adslzone.net/app/uploads-adslzone.net/2019/12/android-malware-apps.jpg?x=480&y=375&quality=40',
      siglas : 'K',
      curso: 2,
      ciclo: 'DAM',
      profesor:'Borja',
      conocimientos: ['android','Kotlin']
    },
    {
      nombre: 'JS',
      imagen : 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/99/Unofficial_JavaScript_logo_2.svg/1200px-Unofficial_JavaScript_logo_2.svg.png',
      siglas : 'js',
      curso: 2,
      ciclo: 'DAM',
      profesor:'Borja',
      conocimientos: ['js']
    },
    {
      nombre: 'Programación',
      imagen : 'https://cdn.euroinnova.edu.es/img/subidasEditor/programacion-1605169849.webp',
      siglas : 'PP',
      curso: 2,
      ciclo: 'DAM',
      profesor:'Borja',
      conocimientos: ['java']
    },
    {
      nombre: 'Base de datos',
      imagen : 'https://cdn.euroinnova.edu.es/img/subidasEditor/programacion-1605169849.webp',
      siglas : 'BBDD',
      curso: 1,
      ciclo: 'DAM',
      profesor:'Edu',
      conocimientos: ['MYSQL','workbench']
    },
  ]
  constructor() { }

  getAllAsignaturas(): Asignatura[] {
    return this.asignaturas
  }
}
