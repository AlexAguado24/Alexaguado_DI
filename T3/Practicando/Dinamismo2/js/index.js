/* let elementoPorId = document.getElementById("lista");
console.log(elementoPorId);
let elementoPorTag = document.getElementsByTagName("li")
console.log(elementoPorTag);
let elementoPorClass = document.getElementsByClassName("m-4")
console.log(elementoPorClass); */

//# para id/ .class para clases / tag para etiquetas
//elemento unico -> primer elemento -> Nodo
//let elementoQuery = document.querySelector("#lista")

//elemento multiple -> todos los elementos -> NodeList
//document.querySelectorAll("")
//let elementosQuery = document.querySelectorAll("#lista1 li")
//let elementosQuery = document.querySelectorAll("ul.clase1")
/* let elementosQuery = document.querySelectorAll("ul.clase2 li")

elementosQuery.forEach(element => {
    console.log(element.classList.contains("elemento1"));
}); */

//agregar
// 1- crearel li
/* let nodoLi = document.createElement("li")
//2- personalizar el li
nodoLi.classList.add("list-group-item");
nodoLi.classList.add("elemento1");
nodoLi.innerText = "Elemento 66"
//3 - agregar el li al ul
let elementoLista = document.querySelector("ul.clase2")
elementoLista.append(nodoLi) */

/* 
let elementoLista = document.querySelector("ul.clase2")

let listaHTML = elementoLista.innerHTML+
`<li class="list-group-item elemento1">Elemento66</li>`;

elementoLista.innerHTML=listaHTML */

/* let elementoLista = document.querySelector("ul.clase2")
let elementoBorrar = document.querySelector(".elemento3")
elementoLista.removeChild(elementoBorrar) */
let elementoLista1 = document.querySelector("ul.clase1");
let elementoLista2 = document.querySelector("ul.clase2");
let valorInput = document.querySelector("input");

let selecction = document.querySelector("select");
console.log(selecction.value);

document.querySelector("#boton_add").addEventListener("click", () => {
  console.log(selecction.value);

  if (selecction.value == 1) {
    let listaHTML =
      elementoLista1.innerHTML +
      `<li class="list-group-item elemento1">${valorInput.value}</li>`;

    elementoLista1.innerHTML = listaHTML;
    valorInput.innerText = "";
  } else {
    let listaHTML =
      elementoLista2.innerHTML +
      `<li class="list-group-item elemento1">${valorInput.value}</li>`;

    elementoLista2.innerHTML = listaHTML;
    valorInput.innerText = "";
  }
});
