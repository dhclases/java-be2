// noinspection JSIgnoredPromiseFromCall

function eliminarTurno(id) {
    const settings = {
        method: "DELETE"
    };
    // noinspection JSIgnoredPromiseFromCall
    fetch("http://localhost:8080/turnos/"+id, settings)
                .then(response => response.text())
              .then((response) => alert(response))
              .catch((error) => alert("No se pudo eliminar el turno "+ error))
              .finally(() => {
                location.reload();
              })
}

function actualizarTurno(id) {
    mostrarFormulario("Turno");

    document.getElementById("actualizarTurnoBtn").addEventListener("click", event => {
        event.preventDefault();

        const idPaciente = document.getElementById("idPaciente");
        const idOdontologo = document.getElementById("idOdontologo");
        const fecha = document.getElementById("fecha");
        const hora = document.getElementById("hora");
        const formData = {
            id: id,
            idPaciente: idPaciente.value,
            idOdontologo: idOdontologo.value,
            fecha: `${fecha.value}T${hora.value}`,
        };
        const settings = {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(formData),
        };

        fetch("http://localhost:8080/turnos", settings)
            .then((response) => response.json())
            .then(() => alert("Se actualizó el paciente"))
            .catch(() => alert("No se pudo actualizar el paciente"))
            .finally(() => {
                resetearCampos();
                ocultarFormulario();
            })
    });

    document.getElementById("resetearTurnoBtn").addEventListener("click", event => {
        event.preventDefault();
        resetearCampos();
    });

    function resetearCampos() {
        document.getElementById("idPaciente").value = "";
        document.getElementById("idOdontologo").value = "";
        document.getElementById("fecha").value = "";
        document.getElementById("hora").value = "";
    }
}

function mostrarFormulario(formulario) {
    document.getElementById("informacionTurnos").classList.add("display-none");
    document.getElementById(`actualizar${formulario}`).classList.remove("display-none");
}

function ocultarFormulario(formulario) {
    document.getElementById("informacionTurnos").classList.remove("display-none");
    document.getElementById(`actualizar${formulario}`).classList.add("display-none");
}
