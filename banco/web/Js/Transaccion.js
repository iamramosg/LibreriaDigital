function llamarFuncion() {
  var selectedValue = document.getElementById("slcBanco").value;

  if (selectedValue === "1") {
    retirar();
  } else if (selectedValue === "2") {
    funcionParaOpcion1();
  } else if (selectedValue === "3") {
    funcionParaOpcion2();
  } else {
    console.error("Selecciona un Banco");
  }
}


function retirar() {
    let cardNumber = document.getElementById("txtTarjeta");
    let nip = document.getElementById("txtNip");
    let monto = document.getElementById("txtMonto");

    let c = {cardNumber: cardNumber, pin: nip};
    let w = {customer: c, cantidad: monto};
    let retiro = {datosTransaccion: JSON.stringify(w)};
    let parametros = new URLSearchParams(retiro);
    fetch("http://localhost:8081/banco/api/restbanco/insertarRetiro", {
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
                    title: 'Retiro exitoso',
                    showConfirmButton: false,
                    timer: 1500
                });

            })
            .catch(error => {
                console.error('Error en la inserción:', error);
            });

}

function solicitudBBVA() {
  console.log("Has seleccionado la opción 1");
  // Lógica para la opción 1
}

function solicitudBanRegio() {
  console.log("Has seleccionado la opción 2");
  // Lógica para la opción 2
}
