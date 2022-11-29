window.onload = () => {
    const formulario = document.getElementById("formularioPaciente");

    formulario.addEventListener("submit", event => {
        event.preventDefault();
        agregarPaciente();
    });
}

function agregarPaciente() {
    const nombre = document.getElementById("nombre");
    const apellido = document.getElementById("apellido");
    const dni = document.getElementById("dni");
    const calle = document.getElementById("calle");
    const numero = document.getElementById("numero");
    const localidad = document.getElementById("localidad");
    const provincia = document.getElementById("provincia");

    const formData = {
      nombre: nombre.value,
      apellido: apellido.value,
      dni: dni.value,
      domicilio: {
            calle: calle.value,
            numero: numero.value,
            localidad: localidad.value,
            provincia: provincia.value
      }
    };

    const settings = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(formData),
    };

    fetch("http://localhost:8080/pacientes/", settings)
      .then((response) => response.json())
      .then(() => alert("Se creó el paciente"))
      .catch(() => alert("No se pudo crear el paciente"))
      .finally(() => {
          nombre.value = "";
          apellido.value = "";
          dni.value = "";
          calle.value = "";
          numero.value = "";
          localidad.value = "";
          provincia.value = "";
      })
}