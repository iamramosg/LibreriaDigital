let alumnos;
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
    let contrasenia = document.getElementById("txtContrasenia").value;
    let matricula = document.getElementById("txtMatricula").value;
    let idUniversidad = document.getElementById("slcUniversidad").value;
    let idUsuario = document.getElementById("txtidUsuario").value;
    let idAlumno = document.getElementById("txtidAlumno").value;

    // Encriptar la contraseña antes de enviarla
    const contraseniaEncriptada = await encriptar(contrasenia);

    let usuario = {
        idUsuario: idUsuario,
        nombre: nombre,
        apellidoP: apellidoP,
        apellidoM: apellidoM,
        genero: genero,
        contrasenia: contraseniaEncriptada, // Enviamos la contraseña encriptada
    };

    let universidad = { idUniversidad: idUniversidad };
    let a = { idAlumno: idAlumno, usuario: usuario, matricula: matricula, universidad: universidad };
    let alumno = { datosAlumno: JSON.stringify(a) };
    let parametros = new URLSearchParams(alumno);

    fetch("../../api/restlibreria/actualizarAlumno", {
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


export function getAll(){
    let datos = {estatus: 1};
    let parametros = new URLSearchParams(datos); // nuestro json lo convierte en un bloque de parametros, se usa para post
    fetch("../../api/restlibreria/getAllAlumno", {method: "POST", body: parametros, headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}})
            .then(response => response.json())
            .then(data => {
//                    console.log(data);
//            alert(JSON.stringify(data));
                    if (data.error) {
                        alert(data.error);
                    }else{
                        cargarTablaALumnos(null,data);
                    }
                });      
}

export function cargarTablaALumnos(coincidencias, data){
    if(coincidencias){
        data = coincidencias;
    }else 
    alumnos = data;
    let contenido = "";
    data.forEach((alumno, index) =>{
        let nc = alumno.usuario.nombre+" "+alumno.usuario.apellidoP+" "+alumno.usuario.apellidoM;
        let un = alumno.universidad.nombre+", "+alumno.universidad.pais;

        
        contenido += "<tr>";
        contenido+="<td>"+nc+"</td>";
        contenido+="<td>"+un+"</td>";
        contenido+="<td>"+alumno.usuario.correo+"</td>";
        contenido+="<td>"+alumno.matricula+"</td>";
        contenido += "<td><button type='button' class='btn btn-danger m-3' onclick='ma.eliminar(" + alumno.usuario.idUsuario + "," + alumno.idAlumno + ")'>Eliminar</button></td>";
        contenido += "<td><button type='button' class='btn btn-warning m-3' onclick='ma.cargarForm("+index+")'>Ver</button></td>";
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

export function cargarForm(i){
    document.getElementById("txtNombre").value = alumnos[i].usuario.nombre;
    document.getElementById("txtApPaterno").value = alumnos[i].usuario.apellidoP;
    document.getElementById("txtApMaterno").value = alumnos[i].usuario.apellidoM;
    if(alumnos[i].usuario.genero === 'F'){
        document.querySelector('#slcgenero').value = 'F';
    }else if(alumnos[i].usuario.genero === 'M'){
        document.querySelector('#slcgenero').value = 'M';
    }else{
        document.querySelector('#slcgenero').value = 'O';
    }   
    //document.getElementById("txtContrasenia").value = "";
    document.getElementById("txtMatricula").value = alumnos[i].matricula;
    document.getElementById("slcUniversidad").value = alumnos[i].universidad.idUniversidad;
    document.getElementById("txtidUsuario").value = alumnos[i].usuario.idUsuario;
    document.getElementById("txtidAlumno").value = alumnos[i].idAlumno;      
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