/* class Asignatura {
  constructor(
    private nombre:string,
    private siglas:string,
    private ciclo:string,
    private curso:number,
    private profesor:string,
    private conocimientos:string[]
    ) {}
} */

export interface Asignatura{
  nombre:string,
  imagen:string,
  siglas:string,
  ciclo:string,
  curso:number,
  profesor:string,
  conocimientos:string[]
}
