async function encriptar(texto) {
    const encoder = new TextEncoder(); //Invocamos la clase q convierte un String en bytes
    const data = encoder.encode(texto);//Hace la conversión
    const hash = await crypto.subtle.digest('SHA-256', data); //crypto toma los bytes y los encripta, devuelve un buffer
    const hashArray = Array.from(new Uint8Array(hash)); // convierte el buffer en un arreglo de bytes
    const hashHex = hashArray.map((b) => b.toString(16).padStart(2, '0')).join(''); // convierte los bytes en string
    return hashHex;
}

function login() {
    let user = document.getElementById("txtCorreo").value;
    let contrasenia = document.getElementById("txtPassword").value;


    encriptar(contrasenia).then((textoEncriptado) => {
    let usuario = {"datosUsuario": JSON.stringify({"correo": user, "contrasenia": textoEncriptado})};

    const url = new URLSearchParams(usuario);
    fetch('api/restlibreria/login',
            {
                method: "POST",
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
                body: url
            })
            .then(response => response.json())
            .then(data => {
                if (data.error) {
                    alert(data.error);
                } else if (data.rol === 'Alumno') {
                    //localStorage.setItem('currentUser', JSON.stringify(data));
                    Swal.fire({
                        position: 'center',
                        icon: 'success',
                        title: 'Acceso Concedido ' + data.nombre,
                        showConfirmButton: false,
                        timer: 1500
                    });
                    setTimeout(() => {
                        console.log("2 segundos esperado");
                    }, 2000);

                    window.location.href = "/libreria/gestion/Alumno/index.html";

                } else if(data.rol === 'Administrador'){
                    window.location.href = "/libreria/gestion/Admin/index.html";
                } else {
                    Swal.fire({
                        position: 'center',
                        icon: 'error',
                        title: 'uyyyy...',
                        text: 'Ha ocurrido un error'
                    });
                }
                JSON.stringify(data);
                //limpiarForm();
            });
    });

}

// Función para insertar el alumno
async function insertar() {
    let nombre = document.getElementById("txtNombre").value;
    let apellidoP = document.getElementById("txtApPaterno").value;
    let apellidoM = document.getElementById("txtApMaterno").value;
    let genero = document.getElementById("slcGenero").value;
    let correo = document.getElementById("txtCorreo").value;
    let contrasenia = document.getElementById("txtPassword").value;
    let matricula = document.getElementById("txtMatricula").value;
    let idUniversidad = document.getElementById("slcUniversidad").value;

    // Encriptar la contraseña antes de enviarla
    encriptar(contrasenia)
        .then(contraseniaEncriptada => {
            let usuario = {
                nombre: nombre,
                apellidoP: apellidoP,
                apellidoM: apellidoM,
                genero: genero,
                correo: correo,
                contrasenia: contraseniaEncriptada // Enviamos la contraseña encriptada
            };

            let universidad = { idUniversidad: idUniversidad };
            let a = { usuario: usuario, matricula: matricula, universidad: universidad };
            let alumno = { datosAlumno: JSON.stringify(a) };
            let parametros = new URLSearchParams(alumno);

            fetch("api/restlibreria/insertarAlumno", {
                method: "POST",
                body: parametros,
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
                }
            })
            .then(response => response.json())
            .then(data => {
                Swal.fire({
                    position: 'center',
                    icon: 'success',
                    title: 'Alumno agregado exitosamente',
                    showConfirmButton: false,
                    timer: 1500
                });
                //redirigir despues de 1.5 segundos (1500 ms)
                setTimeout(function(){
                    window.location.href = "../libreria/index.html";
                }, 1500);
                
            })
            .catch(error => {
                console.error('Error en la inserción:', error);
            });
        })
        .catch(error => {
            console.error('Error en la encriptación:', error);
        });
}