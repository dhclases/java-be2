window.onload = () => {
    const formulario = document.getElementById("formularioTurno");

    formulario.addEventListener("submit", event => {
        event.preventDefault();
        agregarOdontologo();
    });
}

function agregarOdontologo() {
    const idOdontologo = document.getElementById("idOdontologo");
    const idPaciente = document.getElementById("idPaciente");
    const fecha = document.getElementById("fecha");
    const hora = document.getElementById("hora");

    const formData = {
      odontologo : {
        id: idOdontologo.value
      },
      paciente: {
        id:idPaciente.value
      },
      fecha: `${fecha.value}T${hora.value}`,
    };

    const settings = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(formData),
    };

    fetch("http://localhost:8080/turnos/", settings)
      .then((response) => response.json())
      .then(() => alert("Se creó el turno"))
      .catch(() => alert("No se pudo crear el turno"))
      .finally(() => {
          idOdontologo.value = "";
          idPaciente.value = "";
          fecha.value = "";
          hora.value = "";
      })
}