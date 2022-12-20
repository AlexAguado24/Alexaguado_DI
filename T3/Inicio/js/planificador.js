let planificador =[
]

let notaUno = new Nota("Nota 1", "Nota 1 description", new Date())
let notaDos = new Nota("Nota 2", "Nota 2 description", new Date())
let notaTres = new Nota("Nota 3", "Nota 3 description", new Date())


planificador.push(notaUno);
planificador.push(notaDos);
planificador.push(notaTres);

planificador[0].agregarTarea(new Tarea("Tarea normal 1"))
planificador[0].agregarTarea(new TareaMultimedia("Tarea para escribir numeros","./images/images.png"))

planificador[1].agregarTarea(new Tarea("Tarea normal 2"))
planificador[1].agregarTarea(new Tarea("Tarea normal 2"))