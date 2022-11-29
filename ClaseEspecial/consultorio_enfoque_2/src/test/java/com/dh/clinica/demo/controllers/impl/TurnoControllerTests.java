package com.dh.clinica.demo.controllers.impl;

import com.dh.clinica.demo.model.DomicilioDto;
import com.dh.clinica.demo.model.OdontologoDto;
import com.dh.clinica.demo.model.PacienteDto;
import com.dh.clinica.demo.model.TurnoDto;
import com.dh.clinica.demo.service.impl.TurnoService;
import com.dh.clinica.demo.utils.Mapper;
import com.dh.clinica.demo.exceptions.IntegrityDataException;
import com.dh.clinica.demo.controllers.exceptions.GlobalExceptionsHandler;
import com.dh.clinica.demo.exceptions.EntityNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(TurnoController.class)
@AutoConfigureMockMvc(addFilters = false)
public class TurnoControllerTests {

    private MockMvc mockMvc;

    @Mock
    private TurnoService turnoService;

    @InjectMocks
    private TurnoController turnoController;


    private OdontologoDto odontologo;
    private OdontologoDto odontologoInexistente;
    private OdontologoDto odontologoExistente;
    private PacienteDto paciente;
    private PacienteDto pacienteInexistente;
    private PacienteDto pacienteExistente;
    private TurnoDto turno;
    private TurnoDto turnoVacio;
    private TurnoDto turnoExistente;
    private TurnoDto turnoInexistente;

    @Before
    public void reset() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(turnoController).setControllerAdvice(GlobalExceptionsHandler.class).build();
        resetearOdontologos();
        resetearTurnos();
        turno = new TurnoDto(LocalDateTime.now(), paciente, odontologo);
        turnoVacio = new TurnoDto(LocalDateTime.now(), null, null);
        turnoExistente = new TurnoDto(LocalDateTime.now(), pacienteExistente, odontologoExistente);
        turnoInexistente = new TurnoDto(LocalDateTime.now(), pacienteInexistente, odontologoInexistente);
        configureMockito();
    }

    private void resetearOdontologos() {
        odontologo = new OdontologoDto();
        odontologoInexistente = new OdontologoDto(123456788, "Homero", "Simpson", 123456);
        odontologoExistente = new OdontologoDto(123456788, "Homero", "Simpson", 123456);
        odontologo.setId(1);
        odontologoExistente.setId(1);
        odontologoExistente.setId(1);
    }

    private void resetearTurnos() {
        DomicilioDto domicilioConId = new DomicilioDto("Siempreviva", 742, "Springfield", "Springfield");
        domicilioConId.setId(1);
        paciente = new PacienteDto();
        pacienteInexistente = new PacienteDto("Homero", "Simpson", 123456789, domicilioConId);
        pacienteExistente = new PacienteDto("Homero", "Simpson", 123456789, domicilioConId);
        paciente.setId(1);
        pacienteExistente.setId(1);
        pacienteExistente.setFechaIngreso(LocalDate.now());
        pacienteInexistente.setFechaIngreso(LocalDate.now());
    }

    private void configureMockito() throws Exception {
        Mockito.when(turnoService.crear(turno)).thenReturn(turnoExistente);
        Mockito.when(turnoService.crear(turnoInexistente)).thenThrow(new IntegrityDataException("El turno u odontólogo no existen"));
        Mockito.when(turnoService.crear(turnoVacio)).thenThrow(new IntegrityDataException("El turno u odontólogo es null"));
        Mockito.when(turnoService.buscarPorId(999)).thenThrow(new EntityNotFoundException("No se encontró el turno con id 999"));
        Mockito.when(turnoService.buscarPorId(1)).thenReturn(turnoExistente);
        Mockito.when(turnoService.buscar("Homero", "Simpson")).thenReturn(List.of(turnoExistente));
        Mockito.when(turnoService.buscar(123456, 123456789)).thenReturn(List.of(turnoExistente));
        Mockito.when(turnoService.actualizar(turnoInexistente)).thenThrow(new EntityNotFoundException("No se encontró el turno con id 999"));
        Mockito.when(turnoService.actualizar(turnoExistente)).thenReturn(turnoExistente);
        doThrow(new EntityNotFoundException("No existe ningún turno con id: 999")).when(turnoService).eliminar(999);
    }

    @Test
    public void test01registrarTurno() throws Exception {
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/turnos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8")
                        .content(Mapper.mapObjectToJson(turno)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }

    @Test
    public void test02noSePuedeRegistrarTurnoSinPacienteUOdontologo() throws Exception {
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/turnos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8")
                        .content(Mapper.mapObjectToJson(turnoVacio)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest()).andReturn();

        assertFalse(response.getResponse().getContentAsString().isEmpty());
    }

    @Test
    public void test03noSePuedeRegistrarTurnoSinLosIdsDePacienteYOdontologo() throws Exception {
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/turnos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8")
                        .content(Mapper.mapObjectToJson(turnoInexistente)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest()).andReturn();

        assertFalse(response.getResponse().getContentAsString().isEmpty());
    }

    @Test
    public void test04buscarTurnoPorIdInexistenteDevuelveNotFound() throws Exception {
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/turnos/{id}", "999"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andReturn();
        assertEquals(
                "{\"errorClass\":\"EntityNotFoundException\",\"errorDetail\":\"No se encontró el turno con id 999\"}",
                response.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }


    @Test
    public void test05buscarPacientePorIdExistenteDevuelveOk() throws Exception {
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/turnos/{id}", "1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        assertEquals(Mapper.mapObjectToJson(turnoExistente), response.getResponse().getContentAsString());
    }

    @Test
    public void test06buscarTurnosPorNombreInexistenteDevuelveOkYArrayVacio() throws Exception {
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders
                        .get("/turnos")
                        .param("nombre", "José")
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        assertEquals("[]", response.getResponse().getContentAsString());
    }

    @Test
    public void test07buscarTurnosPorNombreYApellidoDeOdontologoExistenteDevuelveOkYArrayNoVacio() throws Exception {
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders
                        .get("/turnos")
                        .param("nombreOdontologo", "Homero")
                        .param("apellidoOdontologo", "Simpson")
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        assertNotEquals("[]", response.getResponse().getContentAsString());
    }

    @Test
    public void test08buscarTurnosPorNombreYApellidoInexistenteDevuelveOkYArrayVacio() throws Exception {
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders
                        .get("/turnos")
                        .param("nombre", "José")
                        .param("apellido", "Pérez")
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        assertEquals("[]", response.getResponse().getContentAsString());
    }

    @Test
    public void test09buscarPacientePorDniYMatriculaExistentesDevuelveOkYArrayNoVacio() throws Exception {
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders
                        .get("/turnos")
                        .param("dni", "123456789")
                        .param("matricula", "123456")
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        assertNotEquals("[]", response.getResponse().getContentAsString());
    }

    @Test
    public void test10ActualizarPacienteInexistenteDevuelveNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/turnos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8")
                        .content(Mapper.mapObjectToJson(turnoInexistente))
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void test11ActualizarPacienteExistenteDevuelveOk() throws Exception {
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders
                        .put("/turnos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Mapper.mapObjectToJson(turnoExistente))
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        assertEquals(Mapper.mapObjectToJson(turnoExistente), response.getResponse().getContentAsString());
    }

    @Test
    public void test12eliminarPacientePorIdInexistenteDevuelveNotFound() throws Exception {
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.delete("/turnos/{id}", "999"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andReturn();
        assertEquals("{\"errorClass\":\"EntityNotFoundException\",\"errorDetail\":\"No existe ningún turno con id: 999\"}",
                response.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    public void test12eliminarPacientePorIdExistenteDevuelveOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/turnos/{id}", "1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

    @Test
    public void test14buscarTodosLosTurnos() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/turnos"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }
}
