//accion a ejecutar con respuesta en futuro
    //respuesta -> hay exito -> then
    //rechazada -> no hay exito -> catch
//asincronia --> ejecuciones paralelas
//Promise((res,rej))
//fetch().then().catch()
let promesaPropia = new Promise((res,rej)=>{
    //logica de la promesa --> conecta con la url y obten las cabeceras
    let numero = Math.random() * 101;
    if (numero>=50) {
        res(numero);
    } else {
        rej("No se puede consultar, promesa rechazada")
    }
});

promesaPropia.then((exito) => {
    exito >= 80
        ? console.log("Muchas posibilidades")
        : console.log("posibilidades bajas");

    console.log(exito);
    return 7;
}).then((exito1)=>{
    console.log("Respuesta de la promesa encadenada "+ exito1);
})
.catch((err) => {
    console.log(err);
})