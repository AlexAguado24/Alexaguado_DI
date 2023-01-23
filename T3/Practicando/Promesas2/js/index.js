//let urlStringProductos = "https://dummyjson.com/products";
let urlStringProductos = "https://dummyjson.com/products/search?q=";
let urlStringCategorias = "https://dummyjson.com/products/categories";

/* fetch(urlString)
  .then((res) => {
    return res.json();
  })
  .then((res1) => {
    console.log(res1);
    res1.products.forEach((item) => {
      console.log(`${item.title} ${item.price}`);
    });
    let seleccion = document.querySelector(".form-select");
    let contador = 1;
    res1.forEach((element) => {
      seleccion.innerHTML += `<option value="${contador}">${element}</option>`;
    });
  })
  .catch((err) => {
    console.log("fetch sin exito");
  })
  .finally(() => {
    console.log("Fin");
  }); */

let seleccion = document.querySelector("select");
let rowCartas = document.querySelector(".row");
let botonFiltro = document.querySelector("button");

cargarCategorias();
botonFiltro.addEventListener("click", (e) => {
  let categoria = seleccion.value;
  cargarProductos(categoria);
});

function cargarProductos(categoria) {
  categoria =
    categoria.charAt(0).toLocaleUpperCase() +
    categoria.substring(1, categoria.length - 1);
  console.log(categoria);
  fetch(urlStringProductos + categoria)
    .then((res) => {
      return res.json();
    })
    .then((res1) => {
      res1.products.forEach((item) => {
        rowCartas.innerHTML += `<div class="col">
                <div class="card" style="width: 18rem;">
                    <img src="${item.images[0]}">
                    <div class="card-body">
                      <h5 class="card-title">${item.title}</h5>
                      <p class="card-text">${item.description}</p>
                      <h6>${item.price}</h6>
                    </div>
                  </div>
            </div>`;
      });
    })
    .catch((err) => {
      console.log("Error en la carga");
    })
    .finally(() => {
      console.log("Fin");
    });
}

function cargarCategorias() {
  fetch(urlStringCategorias)
    .then((res) => {
      return res.json();
    })
    .then((res1) => {
      console.log(res1);
      res1.forEach((element) => {
        seleccion.innerHTML += `<option value="${element}">${element}</option>`;
      });
    })
    .catch((err) => {
      console.log("fetch sin exito");
    })
    .finally(() => {
      console.log("Fin");
    });
}
