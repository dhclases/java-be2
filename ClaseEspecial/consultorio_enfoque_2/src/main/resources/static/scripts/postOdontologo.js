window.onload = () => {
    const formulario = document.getElementById("formularioOdontologo");

    formulario.addEventListener("submit", event => {
        event.preventDefault();
        agregarOdontologo();
    });
}

function agregarOdontologo() {
    const nombre = document.getElementById("nombre");
    const apellido = document.getElementById("apellido");
    const dni = document.getElementById("dni");
    const matricula = document.getElementById("matricula");

    const formData = {
      nombre: nombre.value,
      apellido: apellido.value,
      dni: dni.value,
      matricula: matricula.value,
    };

    const settings = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(formData),
    };

    fetch("http://localhost:8080/odontologos/", settings)
      .then((response) => response.json())
      .then(() => alert("Se creó el odontólogo"))
      .catch(() => alert("No se pudo crear el odontólogo"))
      .finally(() => {
          nombre.value = "";
          apellido.value = "";
          dni.value = "";
          matricula.value = "";
      })
}