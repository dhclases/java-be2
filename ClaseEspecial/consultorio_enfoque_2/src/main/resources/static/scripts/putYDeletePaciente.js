// noinspection JSIgnoredPromiseFromCall

function eliminarPaciente(id) {
    const settings = {
        method: "DELETE"
    };
    // noinspection JSIgnoredPromiseFromCall
    fetch("http://localhost:8080/pacientes/"+id, settings)
              .then(response => response.text())
              .then((response) => alert(response))
              .catch((error) => alert("No se pudo eliminar el paciente "+ error))
              .finally(() => {
                location.reload();
              })
}

function actualizarPaciente(id) {
    mostrarFormulario("Paciente");

    document.getElementById("actualizarPacienteBtn").addEventListener("click", event => {
        event.preventDefault();
        const nombre = document.getElementById("nombrePaciente");
        const apellido = document.getElementById("apellidoPaciente");
        const dni = document.getElementById("dniPaciente");
        const calle = document.getElementById("calle");
        const numero = document.getElementById("numero");
        const localidad = document.getElementById("localidad");
        const provincia = document.getElementById("provincia");
        const formData = {
            id: id,
            nombre: nombre.value,
            apellido: apellido.value,
            dni: dni.value,
            calle: calle.value,
            numero: numero.value,
            localidad: localidad.value,
            provincia: provincia.value,
        };
        const settings = {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(formData),
        };

        fetch("http://localhost:8080/pacientes", settings)
            .then((response) => response.json())
            .then(() => alert("Se actualizó el paciente"))
            .catch(() => alert("No se pudo actualizar el paciente"))
            .finally(() => {
                resetearCampos();
                ocultarFormulario("Paciente");
            })
    });

    document.getElementById("resetearPacienteBtn").addEventListener("click", event => {
        event.preventDefault();
        resetearCampos();
    });

    function resetearCampos() {
        document.getElementById("nombrePaciente").value = "";
        document.getElementById("apellidoPaciente").value = "";
        document.getElementById("dniPaciente").value = "";
        document.getElementById("calle").value = "";
        document.getElementById("numero").value = "";
        document.getElementById("localidad").value = "";
        document.getElementById("provincia").value = "";
    }
}

function mostrarFormulario(formulario) {
    document.getElementById("informacionPacientes").classList.add("display-none");
    document.getElementById(`actualizar${formulario}`).classList.remove("display-none");
}

function ocultarFormulario(formulario) {
    document.getElementById("informacionPacientes").classList.remove("display-none");
    document.getElementById(`actualizar${formulario}`).classList.add("display-none");
}
