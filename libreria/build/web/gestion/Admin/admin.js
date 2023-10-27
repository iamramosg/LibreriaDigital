/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
let ma = null;

cargarVista();

function cargarVista() {
    const vista = localStorage.getItem('vistaActual');
    switch (vista) {
        case 'alumno':
            cargarModuloAlumno();
            break;
        case 'libro':
            cargarModuloLibro();
            break;
        case 'universidad':
            cargarModuloUniversidad();
            break;
    }
}

function cargarModuloAlumno() {
    //Realizamos la petición al Servidor
    fetch('Alumno/alumno.html')
            //Convertimos la respuesta en texto HTML
            .then(response => {
                return response.text();
            })
            //Procesamos el texto HTML
            .then(function (data) {
                //Cargamos el contenido dentro del contenedor principal
                document.getElementById('contenedorPrincipal').innerHTML = data;
                import('./Alumno/alumno.js').then(obj => {
                    ma = obj;
                    ma.inicializar();
                    localStorage.setItem('vistaActual', 'alumno');
                });
            });
}

function cargarModuloLibro() {
    //Realizamos la petición al Servidor
    fetch('Libro/libro.html')
            //Convertimos la respuesta en texto HTML
            .then(response => {
                return response.text();
            })
            //Procesamos el texto HTML
            .then(function (data) {
                //Cargamos el contenido dentro del contenedor principal
                document.getElementById('contenedorPrincipal').innerHTML = data;
                import('./Libro/libro.js').then(obj => {
                    ma = obj;
                    ma.inicializar();
                    localStorage.setItem('vistaActual', 'libro');
                });
            });
}

function cargarModuloUniversidad() {
    //Realizamos la petición al Servidor
    fetch('Universidad/universidad.html')
            //Convertimos la respuesta en texto HTML
            .then(response => {
                return response.text();
            })
            //Procesamos el texto HTML
            .then(function (data) {
                //Cargamos el contenido dentro del contenedor principal
                document.getElementById('contenedorPrincipal').innerHTML = data;
                import('./Universidad/universidad.js').then(obj => {
                    ma = obj;
                    ma.inicializar();
                    localStorage.setItem('vistaActual', 'universidad');
                });
            });
}