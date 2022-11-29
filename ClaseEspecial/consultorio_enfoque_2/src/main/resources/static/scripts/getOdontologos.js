window.onload = () => {
  fetch("http://localhost:8080/odontologos/")
      .then((response) => response.json())
      .then((data) => cargarInformacionOdontologos(data));
};

function cargarInformacionOdontologos(odontologos) {
  const tablaOdontologos = document
    .getElementById("tablaOdontologos")
    .getElementsByTagName("tbody")[0];

    odontologos.forEach((odontologo) => {
      tablaOdontologos.innerHTML += `
        <tr>
            <td>${odontologo.id}</td>
            <td>${odontologo.nombre}</td>
            <td>${odontologo.apellido}</td>
            <td>${odontologo.matricula}</td>
            <td><button onClick="actualizarOdontologo(${odontologo.id})">Editar✏️</button></td> 
            <td><button onClick="eliminarOdontologo(${odontologo.id})">Eliminar❌</button></td> 
        </tr>
    `;
    });
}