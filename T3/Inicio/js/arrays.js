let jugadores =[];

//agrega datos al final del array y obtengo la nueva longitud
jugadores.push("jugador 1","jugador 2","jugador 3");

 jugadores.unshift("jugador nuevo", "otro jugador"),

 //borrar datos
console.log(`Eliminado jugador ${jugadores.pop()}`); 

// filtrar por una condicion indicada
jugadores.filter((item)=>
    // pregunta -> if 
    //T o F
    !item.includes("2")
).forEach((item2)=> {
    console.log(item2);
})

console.log(
    jugadores.find((item)=>{
        return item.includes("2");
    }).length
);


console.log(jugadores);