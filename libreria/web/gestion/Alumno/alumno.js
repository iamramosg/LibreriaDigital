//async function obtenerDatosDeURL() {
//    try {
//        const response = await fetch('../../api/restlibreria/getAllLibro');
//
//        if (!response.ok) {
//            throw new Error('Error en la solicitud');
//        }
//
//        const data = await response.json();
//        return data;
//    } catch (error) {
//
//        throw error;
//    }
//}
//
//async function obtenerDataGabo() {
//    try {
//        const response = await fetch('http://192.168.154.25:8081/libreria/api/restlibreria/getAllLibro');
//
//        if (!response.ok) {
//            throw new Error('Error en la solicitud');
//        }
//
//        const data = await response.json();
//        console.log(data);
//        return data;
//    } catch (error) {
//
//        throw error;
//    }
//}
//
//async function obtenerDataVictor() {
//    try {
//        const response = await fetch('http://192.168.154.169:8080/LibraryJava/api/libro/getAllLibro2');
//
//        if (!response.ok) {
//            throw new Error('Error en la solicitud');
//        }
//
//        const data = await response.json();
//        console.log(data);
//        return data;
//    } catch (error) {
//
//        throw error;
//    }
//}
//async function obtenerDataLalo() {
//    try {
//        const response = await fetch('http://192.168.154.86:8080/LibraryJava/api/libro/getAllLibro2');
//
//        if (!response.ok) {
//            throw new Error('Error en la solicitud');
//        }
//
//        const data = await response.json();
//        console.log(data);
//        return data;
//    } catch (error) {
//
//        throw error;
//    }
//}
//
//
//
//
//async function obtenerDataIvan() {
//    try {
//        const response = await fetch('http://192.168.154.127:8080/libreria/api/restlibreria/getAllLibro');
//
//        if (!response.ok) {
//            throw new Error('Error en la solicitud');
//        }
//
//        const data = await response.json();
//        console.log(data);
//        return data;
//    } catch (error) {
//
//        throw error;
//    }
//}

const decodificar = function (txtBase64) {
    if(txtBase64){
    const binaryData = atob(txtBase64);

    const arrayBuffer = new ArrayBuffer(binaryData.length);
    const uint8Array = new Uint8Array(arrayBuffer);
    for (let i = 0; i < binaryData.length; i++) {
        uint8Array[i] = binaryData.charCodeAt(i);
    }
    const blob = new Blob([arrayBuffer], {type: "application/pdf"});

    const pdfUrl = URL.createObjectURL(blob);
    return pdfUrl;        
    }
    else{
        console.log("No existe");
    }
};



function mapeoDeLibros(arrayLibros) {
    let todo = arrayLibros.map(function (li, index) {
        return `
        
           <div class="grid-item">
            <h1>${li.libro_nombre}</h1>
        
            <div class="modal fade" id="show-modal-${index}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-xl modal-fullscreen">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">${li.titulo}</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <iframe src ="${decodificar(li.archivo)}" width=100% height=100%></iframe>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
        
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#show-modal-${index}">
            Ver Libro
        </button>
        
        </div>

        `;

    });

    document.getElementById("grid-container").innerHTML = todo;


    for (var i = 0; i < respuesta.length; i++) {
        const botonAbrir = document.querySelectorAll(`.show-modal-${i}`);
        const modal = document.querySelector(`.modal-${i}`);
        console.log(botonAbrir);

        for (let j = 0; j < botonAbrir.length; j++) {
            botonAbrir[j].addEventListener('click', function () {
                modal.classList.add('modal');
                modal.classList.remove('hidden');
            });
        }
    }
}

/*function buscarLibro(arrLibros, query) {
    let result =arrLibros.filter((el) => el.titulo.toLowerCase().includes(query.toLowerCase()));
    if (result) {
        mapeoDeLibros(result);
    }else{
        alert("No existen libros con ese nombre");
    }
    
    

    console.log(result);
}*/

//function buscarLibro(arrLibros, query) {
//    let result = arrLibros.filter((el) => {
//        const tituloEnMinusculas = el.titulo.toLowerCase();
//        const autorEnMinusculas = el.autor.toLowerCase();
//        const generoEnMinusculas = el.genero.toLowerCase();
//        const idiomaEnMinusculas = el.idioma.toLowerCase();
//        const queryEnMinusculas = query.toLowerCase();
//
//        return tituloEnMinusculas.includes(queryEnMinusculas) || 
//               autorEnMinusculas.includes(queryEnMinusculas)  ||
//               generoEnMinusculas.includes(queryEnMinusculas) ||
//               idiomaEnMinusculas.includes(queryEnMinusculas);
//    });
// 
//    if (result.length > 0) {
//        mapeoDeLibros(result);
//    } else {
//        alert("No existen libros con ese nombre o autor");
//    }
// 
//    console.log(result);
//}



//async function libros(filtro) {
//    let respuesta = await obtenerDatosDeURL();
//    let respuestaGabo = await obtenerDataGabo();
//    let respuestaIvan = await obtenerDataIvan();
//    let respuestaVictor = await obtenerDataVictor();
//
//
//    let todoLibors = [...respuesta, ...respuestaGabo, ...respuestaIvan, ...respuestaVictor];
//
//    if (filtro === "") {
//        mapeoDeLibros(todoLibors);
//    } else if (filtro) {
//        buscarLibro(todoLibors, filtro);
//    }else if (filtro === undefined){
//        mapeoDeLibros(todoLibors);
//    }
//}

libros("");

//let botonBuscar = document.querySelector("#buscarLibro");
//
//botonBuscar.addEventListener('click', function () {
//    let libroBuscar = document.getElementById("txtBusLibro").value;
//    libros(libroBuscar);
//});

//function buscarL(){
//    let t = document.getElementById("myInput").value;
//    let libro = {titulo: t};
//    const url = new URLSearchParams(libro);
//        fetch("http://localhost:8081/libreria/api/restlibreria/buscarLibro", {
//        method: "POST",
//        body: url,
//        headers: {
//            'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
//        }
//    })
//    .then(response => response.json())
//    .then(data => {
//        console.log("Exito");
////        Swal.fire({
////            position: 'center',
////            icon: 'success',
////            title: 'Alumno actualizado exitosamente',
////            showConfirmButton: false,
////            timer: 1500
////        });
//
//    })
//    .catch(error => {
//        console.error('Error en la actualización:', error);
//    });
//}

function obtenerLibro(){
    let filtro = document.getElementById("txtBusLibro").value;
    
    fetch("http://192.168.43.222:8080/api/buscar-libro",{
        method: "POST",
        body:JSON.stringify({filtro:filtro}),
        headers:{
            'Content-Type': 'application/json',
            Authorization: "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bml2ZXJzaWRhZF9pZCI6IjIxMDAwMDA2Iiwibm9tYnJlIjoiMjEwMDAwMDYiLCJncnVwbyI6IjIxMDAwMDA2IiwiaWF0IjoxNjk3MDY3NTkwLCJleHAiOjE2OTcwNzExOTB9.O1LsPuMjf0Nda--OePDnLoDBd60x5D0STsQneIbWE7U"
        }
    })
            .then(response => response.json())
            .then(data => {
                console.log(data);
                mapeoDeLibros(data);
      
    });
}

