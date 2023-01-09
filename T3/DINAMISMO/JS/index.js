//trabajar con etiquetas
//trabajar con clases
//trabajar con id

//elemento que tenga el id --> unico
//let elementoPorId = document.getElementById("lista");
//console.log(elementoPorId);
//elemento que tenga la etiqueta -->  unico
/* let elementoPorTag = document.getElementsByTagName("li")
console.log(elementoPorTag); */
//elemento que tenga el class --> unico
/* let elementoPorClass = document.getElementsByClassName("m-4");
console.log(elementoPorClass) */

// #id .class tag
// --> elemento unico --> primer elemento --> Node
//let elementoQuery = document.querySelector("#lista");


// --> elemento multiple --> todos los elemento --> Nodelist
//document.querySelectorAll();
//let elementosQuery = document.querySelectorAll("ul.clase1");
//let elementosQuery = document.querySelectorAll("#lista1.clase1");
//let elementosQuery = document.querySelectorAll("#lista1 li");
/* let elementosQuery = document.querySelectorAll(" ul.clase2 li");
elementosQuery.forEach((element) => {
    console.log(element.textContent);
}) */

//agregar

//primera forma

/* let elementoLista = document.querySelector("ul.clase2")
//1 - Crear un li
let nodoLi = document.createElement("li")
//2 - personalizar li (agregar las clases y poner el contenido)
//nodoLi.className = "list-group-item"
nodoLi.classList.add("list-group-item")
nodoLi.classList.add("elemento1")
nodoLi.innerText = "Elemento 66"
//3 - agregar el li al ul (encontrado!)
elementoLista.append(nodoLi) */

//segunda forma

/* let elementoLista = document.querySelector("ul.clase2");
let listaHTML = elementoLista.innerHTML + `<li class="list-group-item">Elemento 66</li>`

elementoLista.innerHTML = listaHTML;
 */
// borrar
/* let elementoLista = document.querySelector("ul.clase2")
let nodoLiBuscado = document.querySelector(".elemento3")
elementoLista.removeChild(nodoLiBuscado) */

let seleccion = document.querySelector("select")


document.querySelector("#boton-add").addEventListener("click", () => {
    let elementoLista = document.querySelector("ul.clase2");
    console.log(seleccion)
    let listaHTML = elementoLista.innerHTML + `<li class="list-group-item">Elemento 66</li>`

    elementoLista.innerHTML = listaHTML;
})
