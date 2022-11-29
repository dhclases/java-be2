window.onload = () => {
  fetch("http://localhost:8080/turnos/")
      .then((response) => response.json())
      .then((data) => cargarInformacionTurnos(data));
};

function cargarInformacionTurnos(turnos) {
  const tablaTurnos = document
    .getElementById("tablaTurnos")
    .getElementsByTagName("tbody")[0];
    
  turnos.forEach((turno) => {
    tablaTurnos.innerHTML += `
        <tr>
            <td>${turno.id}</td>
            <td>${turno.paciente.id}</td>
            <td>${turno.odontologo.id}</td>
            <td>${turno.fecha}</td>
            <td><button onClick="actualizarTurno(${turno.id})">Editar✏️</button></td> 
            <td><button onClick="eliminarTurno(${turno.id})">Eliminar❌</button></td> 
        </tr>
    `;
  });
}