let alumnos;
let usuario;
export function inicializar() {
    getAll();
}
function encriptar(texto) {
    return new Promise((resolve, reject) => {
        const encoder = new TextEncoder(); // Invocamos la clase que convierte un String en bytes
        const data = encoder.encode(texto); // Hace la conversión
        crypto.subtle.digest('SHA-256', data)
            .then(hash => {
                const hashArray = Array.from(new Uint8Array(hash)); // convierte el buffer en un arreglo de bytes
                const hashHex = hashArray.map((b) => b.toString(16).padStart(2, '0')).join(''); // convierte los bytes en string
                resolve(hashHex);
            })
            .catch(reject);
    });
}

// Función para insertar el alumno
function insertar() {
    let nombre = document.getElementById("txtNombre").value;
    let apellidoP = document.getElementById("txtApPaterno").value;
    let apellidoM = document.getElementById("txtApMaterno").value;
    let genero = document.getElementById("slcgenero").value;
    let correo = document.getElementById("txtCorreo").value;
    let contrasenia = document.getElementById("txtContrasenia").value;
//    let matricula = document.getElementById("txtMatricula").value;
//    let idUniversidad = document.getElementById("slcUniversidad").value;

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

//            let universidad = { idUniversidad: idUniversidad };
            let a = { usuario: usuario};
            let alumno = { datosAlumno: JSON.stringify(a) };
            let parametros = new URLSearchParams(alumno);

            fetch("api/restlibreria/insertarCliente", {
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
                    title: 'Usuario agregado exitosamente',
                    showConfirmButton: false,
                    timer: 1500
                });
                
            })
            .catch(error => {
                console.error('Error en la inserción:', error);
            });
        })
        .catch(error => {
            console.error('Error en la encriptación:', error);
        });
}

function limpiarForm(){
    document.getElementById("txtnombre").value = "";
    document.getElementById("txtapePaterno").value = "";
    document.getElementById("txtapeMaterno").value = "";
    document.getElementById("slcgenero").value = "D";
    document.getElementById("txtcorreo").value = "";
    document.getElementById("txtcontrasenia").value = "";
    document.getElementById("txtcontrasenia").value = "";
    document.getElementById("slcUniversidad").value = "D";    
}

// Función para actualizar el alumno
export async function actualizar() {
    let nombre = document.getElementById("txtNombre").value;
    let apellidoP = document.getElementById("txtApPaterno").value;
    let apellidoM = document.getElementById("txtApMaterno").value;
    let genero = document.getElementById("slcgenero").value;
    let correo = document.getElementById("txtCorreo").value;
    let contrasenia = document.getElementById("txtContrasenia").value;
//    let matricula = document.getElementById("txtMatricula").value;
//    let idUniversidad = document.getElementById("slcUniversidad").value;
    let idUsuario = document.getElementById("txtidUsuario").value;
//    let idAlumno = document.getElementById("txtidAlumno").value;

    // Encriptar la contraseña antes de enviarla
    const contraseniaEncriptada = await encriptar(contrasenia);

    let user = {
        idUsuario: idUsuario,
        nombre: nombre,
        apellidoP: apellidoP,
        apellidoM: apellidoM,
        genero: genero,
        correo:correo,
        contrasenia: contraseniaEncriptada // Enviamos la contraseña encriptada
    };

//    let universidad = { idUniversidad: idUniversidad };

    let usr = { datosUsuario: JSON.stringify(user) };
    let parametros = new URLSearchParams(usr);

    fetch("../../api/restlibreria/restablecerContra", {
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
            title: 'Alumno actualizado exitosamente',
            showConfirmButton: false,
            timer: 1500
        });
    })
    .catch(error => {
        console.error('Error en la actualización:', error);
    });
}


export function getAll(){ // nuestro json lo convierte en un bloque de parametros, se usa para post
    fetch("../../api/restlibreria/getAllUsuarioPublic", {method: "GET", headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}})
            .then(response => response.json())
            .then(data => {
//                    console.log(data);
//            alert(JSON.stringify(data));
                    if (data.error) {
                        alert(data.error);
                    }else{
                        cargarTablaAlumnos(null,data);
                    }
                });      
}

export function getByCorreo(correoi){ // nuestro json lo convierte en un bloque de parametros, se usa para post
    let usuario = { datosUsuario: JSON.stringify({correo:alumnos[correoi].usrname}) };
    let parametros = new URLSearchParams(usuario);
    fetch("../../api/restlibreria/buscarByCorreo", {
        method: "POST",
        body: parametros,
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
        }
    })
            .then(response => response.json())
            .then(data => {
//                    console.log(data);
//            alert(JSON.stringify(data));
                    if (data.error) {
                        alert(data.error);
                    }else{
                        console.log(data);
                        cargarForm(data);
                    }
                });      
}

export function cargarTablaAlumnos(coincidencias, data){
    if(coincidencias){
        data = coincidencias;
    }else 
    alumnos = data;
    let contenido = "";
    data.forEach((usuario, index) =>{
//        let nc = usuario.nombre+" "+usuario.apellidoP+" "+usuario.apellidoM;
//        let un = alumno.universidad.nombre+" "+alumno.universidad.pais;

        
        contenido += "<tr>";
//        contenido+="<td>"+nc+"</td>";
//        contenido+="<td>"+un+"</td>";
        contenido+="<td>"+usuario.usrname+"</td>";
//        contenido+="<td>"+alumno.matricula+"</td>";
        //contenido += "<td><button type='button' class='btn btn-danger m-3' onclick='ma.eliminar(" + usuario.usrid + ")'>Eliminar</button></td>";
        contenido += "<td><button type='button' class='btn btn-light m-3' onclick='ma.getByCorreo("+index+")'>Ver</button></td>";
        contenido += "</tr>";
    });
    document.getElementById("tbAlumno").innerHTML=contenido;        
}

export function eliminar(idUsuario, idAlumno){
    let usuario = {idUsuario:idUsuario};
    let a = {idAlumno:idAlumno,usuario:usuario};
    
    let alumno = {datosAlumno: JSON.stringify(a)};
    let parametros = new URLSearchParams(alumno);
        fetch("../../api/restlibreria/eliminarAlumno",{method:"POST",body:parametros,headers:{'Content-Type':'application/x-www-form-urlencoded;charset=UTF-8'}})
            .then(response => response.json())
            .then(data => {
                    Swal.fire({
                    position: 'center',
                    icon: 'success',
                    title: 'Alumno eliminado exitosamente',
                    showConfirmButton: false,
                    timer: 1500
    });
    });    
}

export function cargarForm(usuario){
//    console.log(alumnos[i].usrname);
//    getByCorreo(alumnos[i].usrname);
//    console.log(usuario);
    
    document.getElementById("txtNombre").value = usuario.nombre;
    document.getElementById("txtApPaterno").value = usuario.apellidoP;
    document.getElementById("txtApMaterno").value = usuario.apellidoM;
    document.getElementById("txtCorreo").value = usuario.correo;
    if(usuario.genero === 'F'){
        document.querySelector('#slcgenero').value = 'F';
    }else if(usuario.genero === 'M'){
        document.querySelector('#slcgenero').value = 'M';
    }else{
        document.querySelector('#slcgenero').value = 'O';
    }   
    //document.getElementById("txtContrasenia").value = "";
//    document.getElementById("txtMatricula").value = alumnos[i].matricula;
//    document.getElementById("slcUniversidad").value = alumnos[i].universidad.idUniversidad;
    document.getElementById("txtidUsuario").value = usuario.idUsuario;
//    document.getElementById("txtidAlumno").value = alumnos[i].idAlumno;      
}

function limpiarTablaAlumno(data){
    document.getElementById("tbAlumno").innerHTML="";
}

export function Rbusqueda(){
    const busqueda = document.getElementById("myInput").value;
    const coincidencias = [];
    for(let i=0; i < alumnos.length; i++){
        const alumno = alumnos[i];
        
        if(alumno.usuario.nombre.toLowerCase().includes(busqueda.toLowerCase()) ||
                alumno.usuario.apellidoP.toLowerCase().includes(busqueda.toLowerCase()) ||
                alumno.usuario.apellidoM.toLowerCase().includes(busqueda.toLowerCase()) ||
                alumno.usuario.correo.toLowerCase().includes(busqueda.toLowerCase()) ||
                alumno.matricula.toLowerCase().includes(busqueda.toLowerCase()) ||
                alumno.universidad.nombre.toLowerCase().includes(busqueda.toLowerCase()) ||
                alumno.universidad.pais.toLowerCase().includes(busqueda.toLowerCase()) 
                ){
            coincidencias.push(alumno);
                }
    }
    console.table(coincidencias);
    cargarTablaALumnos(coincidencias,null);
}