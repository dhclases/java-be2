window.onload = () => {
  fetch("http://localhost:8080/pacientes/")
      .then((response) => response.json())
      .then((data) => cargarInformacionPacientes(data));
};

function cargarInformacionPacientes(pacientes) {
  const tablaPacientes = document
    .getElementById("tablaPacientes")
    .getElementsByTagName("tbody")[0];

    pacientes.forEach((paciente) => {
      const { domicilio } = paciente;
      tablaPacientes.innerHTML += `
        <tr>
            <td>${paciente.id}</td>
            <td>${paciente.nombre}</td>
            <td>${paciente.apellido}</td>
            <td>${paciente.dni}</td>
            <td>${domicilio.calle}</td>
            <td>${domicilio.numero}</td>
            <td>${domicilio.localidad}</td>
            <td>${domicilio.provincia}</td>
            <td><button onClick="actualizarPaciente(${paciente.id})">Editar✏️</button></td>
            <td><button onClick="eliminarPaciente(${paciente.id})">Eliminar❌</button></td>
        </tr>
    `;
    });
}