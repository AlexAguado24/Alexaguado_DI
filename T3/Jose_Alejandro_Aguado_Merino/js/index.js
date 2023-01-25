let urlListaMonedas = "https://run.mocky.io/v3/16f71bfa-7bee-476f-ab6b-71348547a9d3"
let urlDetalles = "https://api.coingecko.com/api/v3/coins/"
let arrayFavs = []
let moneda = {
    nombre:"",
    simbolo:""
}

let seleccion = document.querySelector("select");
let rowCartas = document.querySelector("row")
let botonAgregar = document.querySelector("button.agregar")
let botonVerFavs = document.querySelector("button.favoritos")


//let idMoneda = seleccion.value
function borrarCarta() {
    rowCartas.innerHTML += ""
}

seleccion.addEventListener("click", ()=>{
    let idMoneda = seleccion.value
    cargarCartas(idMoneda)
})



function cargarMonedas() {
    fetch(urlListaMonedas)
        .then((res) => {
            return res.json();
        }).then((res1) => {
            res1.forEach(item => {
                seleccion.innerHTML +=
                    `<option value="${item.id}">${item.name}</option>"`
            });
        }).catch((err) => {
            err = "Sin exito en la conexion"
            console.log(err);
        }).finally(() => {
            console.log("Conexion Finalizada");
        })
}

function cargarCartas(idMoneda) {
    console.log(urlDetalles+idMoneda);
    //borrarCarta()
    fetch(urlDetalles + idMoneda) 
        .then((res) => {
            return res.json();
        })
        .then((res1) => {
                rowCartas.innerHTML =
                    `<div class="col">
                <div class="card" style="width: 18rem;">
                <div class="card-body">
                  <h5 class="card-title">${res1.name}</h5>
                  <p class="card-text">${res1.description.en}</p>
                  <button href="${res1.links.homepage[0]}" class="btn btn-info detalles">Ver Detalles</button>
                  <ul>${res1.categories.forEach(item=>{
                    `<li>${item}</li>`
                  })}</ul>
                  <button class="btn btn-success agregar">Agregar como favorito</button>
                </div>
              </div>
            </div>`
            ;
        })
        .catch((err) => {
            err = "Sin conexion"
            console.log(err);
        })
}

/* botonAgregar.addEventListener("click", ()=>{
    function aniadirFav() {
        arrayFavs.push(moneda)
    }
}) */



cargarMonedas();
