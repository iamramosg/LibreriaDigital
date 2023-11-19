let libros = [];
export function inicializar() {
    getAll();
}

let pdfBase64; // Variable global para almacenar el PDF codificado

function codificarPDF() {
    const pdfInput = document.getElementById('txtArchivo');
    const file = pdfInput.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = function (event) {
            pdfBase64 = event.target.result.split(',')[1];
        };
        reader.readAsDataURL(file);
    } else {
        console.log('Por favor, selecciona un archivo PDF.');
    }
}

export function decodificarPDF(idPDF) {
    const base64String = libros[idPDF].archivo; // Reemplaza con tu cadena base64
    if (base64String) {
        const binaryString = atob(base64String);
        const byteArray = new Uint8Array(binaryString.length);

        for (let i = 0; i < binaryString.length; i++) {
            byteArray[i] = binaryString.charCodeAt(i);
        }
        const blob = new Blob([byteArray], {type: 'application/pdf'});
        // Puedes abrir el archivo PDF en una nueva ventana o realizar otras acciones aquí
        const pdfURL = URL.createObjectURL(blob);
        window.open(pdfURL, '_blank','width=800,height=600');
    } else {
        console.log('La cadena base64 está vacía.');
    }
}

export function insertar() {
    //if (validar() == false) {
    //return;
    //}
    codificarPDF();
    console.log(pdfBase64);
    let titulo = document.getElementById("txtTitulo").value;
    let autor = document.getElementById("txtAutor").value;
    let genero = document.getElementById("slcGenero").value;
    let idioma = document.getElementById("slcIdioma").value;

    let libro = {datosLibro: JSON.stringify({titulo: titulo, archivo: pdfBase64, autor: autor, idioma: idioma, genero: genero})};
    alert(libro);
    let parametros = new URLSearchParams(libro);
    fetch("../../api/restlibreria/insertarLibro", {method: "POST", body: parametros, headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}})
            .then(response => response.json())
            .then(data => function (data) {
                    console.log(data);
                    if (data.error) {
                        alert("Error");
                    } else if (data.idUsuario) {
                        alert("Libro almacenado de forma correcta");
                    } else {
                        JSON.stringify(data);
                    }
                    JSON.stringify(data);
                });
}

export function actualizar() {
    codificarPDF();
    alert(pdfBase64);
    let id = document.getElementById("id").value;
    let titulo = document.getElementById("txtTitulo").value;
    let autor = document.getElementById("txtAutor").value;
    let genero = document.getElementById("slcGenero").value;
    let idioma = document.getElementById("slcIdioma").value;
    let estatus = document.getElementById("slcEstatus").value;
    let libro = {datosLibro: JSON.stringify({idLibro: id, titulo: titulo, archivo: pdfBase64, autor: autor, idioma: idioma, genero: genero, estatus: estatus})};
    alert(libro);
    let parametros = new URLSearchParams(libro);
    fetch("../../api/restlibreria/restablecerLibro", {method: "POST", body: parametros, headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}})
            .then(response => response.json())
            .then(data => function (data) {
                    console.log(data);
                    if (data.error) {
                        alert(data.error);
                    } else if (data.idUsuario) {
                        alert("Libro actualizado de forma correcta");
                    } else {
                        JSON.stringify(data);
                    }

                });
    setTimeout(() => {
        getAll();
    }, 2000);
    getAll();
    limpiarForm();
}

export function eliminar(idLibro) {
    let libro = {idLibro};
    let parametros = new URLSearchParams(libro);
    fetch("../../api/restlibreria/eliminarLibro", {method: "POST", body: parametros, headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}})
            .then(response => response.json())
            .then(data => function (data) {
                    console.log(data);
                    if (data.error) {
                        alert(data.error);
                    } else if (data.idUsuario) {
                        alert("Libro eliminado de forma correcta");
                    } else {
                        JSON.stringify(data);
                    }
                });
}

export function buscar() {
    const busqueda = document.getElementById('txtSearch').value;
    const coincidencias = [];
    for (let i = 0; i < libros.length; i++) {
        const libro = libros[i];
        if (    libro.titulo.toLowerCase().includes(busqueda.toLowerCase())||
                libro.autor.toLowerCase().includes(busqueda.toLowerCase())||
                libro.idioma.toLowerCase().includes(busqueda.toLowerCase())||
                libro.genero.toLowerCase().includes(busqueda.toLowerCase())) {

            coincidencias.push(libro);
        }
        console.log(coincidencias);
        cargarTablaLibro(coincidencias, null);
    }
}

export function getAll() {
    fetch("../../api/restlibreria/getAllLibro", {method: "GET", headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}})
            .then(response => response.json())
            .then(data => {
                console.log(data);
                if (data.error) {
                    alert(data.error);
                } else {
                    cargarTablaLibro(null, data);
                }
                JSON.stringify(data);
            });
}

export function cargarTablaLibro(coincidencias, data) {
    if (coincidencias) {
        data = coincidencias;
    } else
        libros = data;
    let contenido = "";
//    for (let i = 0; i < libros.length; i++) {
    data.forEach((libro, index) => {
        contenido += "<tr>";
        contenido += "<td style='display:none;'>" + libro.idLibro + "</td>";
        contenido += "<td>" + libro.titulo + "</td>";
        //contenido += "<td>" + libro.archivo + "</td>";
        contenido += "<td>" + libro.autor + "</td>";
        contenido += "<td>" + libro.genero + "</td>";
        contenido += "<td>" + libro.idioma + "</td>";
        if (libro.estatus === 1) {
            contenido += "<td>Privado</td>";
        } else {
            contenido += "<td><Público</td>";
        }
        contenido += "<td><button type='button' class='btn btn-warning btn-m m-2' onClick='ma.cargarForm(" + index + ")'>Ver</button></td>";
        contenido += "</tr>";
    });
    document.getElementById("tbLibro").innerHTML = contenido;
}


export function cargarForm(i) {
    document.getElementById("id").value = libros[i].idLibro;
    document.getElementById("txtTitulo").value = libros[i].titulo;
    document.getElementById("txtAutor").value = libros[i].autor;
    document.getElementById("slcIdioma").value = libros[i].idioma;
    document.getElementById("slcGenero").value = libros[i].genero;
    document.getElementById("slcEstatus").value = libros[i].estatus;
}

export function getOptionGenero() {
    selectElement = document.querySelector("#slcGenero");
    output = selectElement.options[selectElement.selectedIndex].value;
    document.querySelector('.output').textContent = output;
}

export function getOptionEstatus() {
    selectElement = document.querySelector("#slcEstatus");
    output = selectElement.options[selectElement.selectedIndex].value;
    document.querySelector('.output').textContent = output;
}

export function getOptionIdioma() {
    selectElement = document.querySelector("#slcIdioma");
    output = selectElement.options[selectElement.selectedIndex].value;
    document.querySelector('.output').textContent = output;
}

export function limpiarForm() {
    document.getElementById("id").value =  "";
    document.getElementById("txtTitulo").value = "";
    document.getElementById("txtAutor").value = "";
    document.getElementById("slcIdioma").value = "D";
    document.getElementById("slcGenero").value = "D";
    document.getElementById("slcEstatus").value = "D";
}

export function limpiarTabla() {
    document.getElementById("tbLibro").innerHTML = "";
}

const regexValidar = {
//validar letras, espacios y acentos
    letras: /^[a-zA-ZÁ-ÿ\s]{1,40}$/,
    //validar numeros y puntos
    numeros: /^[a-zA-Z0-9-]+$/,
    //validar numeros enteros
    numerosEnteros: /^[0-9]+$/,
    //validar letras, espacios, acentos, numeros, puntos, comas, guiones y máximo 240 caracteres
    letrasNumerosSimbolos: /^[a-zA-ZÁ-ÿ0-9\s.,-]{1,240}$/,
    //validar codigo postal
    cp: /^[0-9]{5}$/,
    //validar email
    email: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
    //validar contrasenia
    contrasenia: /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,20}$/,
    //validar telefono
    telefono: /^[0-9]{10}$/
};
//function validar() {
//    let nombre = document.getElementById("txtnombre").value;
//    let apePaterno = document.getElementById("txtapePaterno").value;
//    let apeMaterno = document.getElementById("txtapeMaterno").value;
//    let genero = document.getElementById("slcgenero").value;
//    let fechaNacimiento = document.getElementById("txtfechaNacimiento").value;
//    let calle = document.getElementById("txtcalle").value;
//    let numero = document.getElementById("txtnumero").value;
//    let colonia = document.getElementById("txtcolonia").value;
//    let cp = document.getElementById("txtcp").value;
//    let ciudad = document.getElementById("txtciudad").value;
//    let estado = document.getElementById("txtestado").value;
//    let telCasa = document.getElementById("txttelCasa").value;
//    let telMovil = document.getElementById("txttelMovil").value;
//    let email = document.getElementById("txtemail").value;
//    let nombreUsuario = document.getElementById("txtnombreUsuario").value;
//    let contrasenia = document.getElementById("txtcontrasenia").value;
//    let rol = document.getElementById("txtrol").value;
//    if (nombre == "" || apePaterno == "" || apeMaterno == "" || calle == "" || colonia == "" || numero == "" || cp == "" || ciudad == "" || telCasa == "" || telMovil == "" || email == "" || nombreUsuario == "" || contrasenia == "") {
//        Swal.fire({position: 'center', icon: 'warning', title: 'No se permiten campos vacíos.', showConfirmButton: false, timer: 1500});
//        return false;
//    }
//    if (!regexValidar.letras.test(nombre)) {
//        Swal.fire({position: 'center', icon: 'warning', title: 'El campo nombre solo puede contener letras.', showConfirmButton: false, timer: 1500});
//        return false;
//    }
//    if (!regexValidar.letras.test(apePaterno)) {
//        Swal.fire({position: 'center', icon: 'warning', title: 'El campo apellido paterno solo puede contener letras.', showConfirmButton: false, timer: 1500});
//        return false;
//    }
//    if (!regexValidar.letras.test(apeMaterno)) {
//        Swal.fire({position: 'center', icon: 'warning', title: 'El campo apellido materno solo puede contener letras.', showConfirmButton: false, timer: 1500});
//        return false;
//    }
//    if (!regexValidar.letras.test(calle)) {
//        Swal.fire({position: 'center', icon: 'warning', title: 'El campo calle solo puede contener letras.', showConfirmButton: false, timer: 1500});
//        return false;
//    }
//    if (!regexValidar.letras.test(colonia)) {
//        Swal.fire({position: 'center', icon: 'warning', title: 'El campo colonia solo puede contener letras.', showConfirmButton: false, timer: 1500});
//        return false;
//    }
//    if (!regexValidar.letras.test(ciudad)) {
//        Swal.fire({position: 'center', icon: 'warning', title: 'El campo ciudad solo puede contener letras.', showConfirmButton: false, timer: 1500});
//        return false;
//    }
//    if (!regexValidar.numeros.test(numero)) {
//        Swal.fire({position: 'center', icon: 'warning', title: 'El campo número solo puede contener números y letras.', showConfirmButton: false, timer: 1500});
//        return false;
//    }
//    if (!regexValidar.cp.test(cp)) {
//
//        Swal.fire({position: 'center', icon: 'warning', title: 'El campo C.P. solo puede contener 5 números.', showConfirmButton: false, timer: 1500});
//        return false;
//    }
//    if (!regexValidar.telefono.test(telCasa)) {
//        Swal.fire({position: 'center', icon: 'warning', title: 'El campo tel. Casa solo puede contener 10 números.', showConfirmButton: false, timer: 1500});
//        return false;
//    }
//    if (!regexValidar.telefono.test(telMovil)) {
//        Swal.fire({position: 'center', icon: 'warning', title: 'El campo tel. Movil solo puede contener 10 números.', showConfirmButton: false, timer: 1500});
//        return false;
//    }
//    if (!regexValidar.email.test(email)) {
//        Swal.fire({position: 'center', icon: 'warning', title: 'El campo email solo puede contener letras, números y caracteres (.,-+).', showConfirmButton: false, timer: 1500});
//        return false;
//    }
//    if (!regexValidar.letrasNumerosSimbolos.test(nombreUsuario)) {
//        Swal.fire({position: 'center', icon: 'warning', title: 'El campo usuario solo puede contener letras, números y simbolos.', showConfirmButton: false, timer: 1500});
//        return false;
//    }
//    if (!regexValidar.contrasenia.test(contrasenia)) {
//        Swal.fire({position: 'center', icon: 'warning', title: 'El campo contraseña debe contener de 8 a 20 letras.', showConfirmButton: false, timer: 1500});
//        return false;
//    }
//    return true;
//}