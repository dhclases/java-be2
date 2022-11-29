// noinspection JSIgnoredPromiseFromCall

function eliminarOdontologo(id) {
    const settings = {
        method: "DELETE"
    };
    // noinspection JSIgnoredPromiseFromCall
    fetch("http://localhost:8080/odontologos/"+id, settings)
          .then(response => response.text())
          .then((response) => alert(response))
          .catch((error) => alert("No se pudo eliminar el odontólogo "+ error))
          .finally(() => {
            location.reload();
          })
}

function actualizarOdontologo(id) {
    mostrarFormulario("Odontologo");
    document.getElementById("actualizarOdontologoBtn").addEventListener("click", event => {
        event.preventDefault();

        const nombre = document.getElementById("nombreOdontologo");
        const apellido = document.getElementById("apellidoOdontologo");
        const dni = document.getElementById("dniOdontologo");
        const matricula = document.getElementById("matricula");
        const formData = {
            id: id,
            nombre: nombre.value,
            apellido: apellido.value,
            dni: dni.value,
            matricula: matricula.value,
        };
        const settings = {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(formData),
        };

        fetch("http://localhost:8080/odontologos", settings)
            .then((response) => response.json())
            .then(() => alert("Se actualizó el odontólogo"))
            .catch(() => alert("No se pudo actualizar el odontólogo"))
            .finally(() => {
                ocultarFormulario("Odontologo");
                resetearCampos();
            })
    });

    document.getElementById("resetearOdontologoBtn").addEventListener("click", event => {
        event.preventDefault();
        resetearCampos();
    });

    function resetearCampos() {
        document.getElementById("nombreOdontologo").value = "";
        document.getElementById("apellidoOdontologo").value = "";
        document.getElementById("dniOdontologo").value = "";
        document.getElementById("matricula").value = "";
    }
}

function mostrarFormulario(formulario) {
    document.getElementById("informacionOdontologos").classList.add("display-none");
    document.getElementById(`actualizar${formulario}`).classList.remove("display-none");
}

function ocultarFormulario(formulario) {
    document.getElementById("informacionOdontologos").classList.remove("display-none");
    document.getElementById(`actualizar${formulario}`).classList.add("display-none");
}
