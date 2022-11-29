package com.dh.clinica.demo.controllers.impl;

import com.dh.clinica.demo.model.DomicilioDto;
import com.dh.clinica.demo.model.PacienteDto;
import com.dh.clinica.demo.service.impl.PacienteService;
import com.dh.clinica.demo.utils.Mapper;
import com.dh.clinica.demo.exceptions.IntegrityDataException;
import com.dh.clinica.demo.controllers.exceptions.GlobalExceptionsHandler;
import com.dh.clinica.demo.exceptions.EntityNotFoundException;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.doThrow;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(PacienteController.class)
@AutoConfigureMockMvc(addFilters = false)
public class PacienteControllerTests {

    private MockMvc mockMvc;

    @Mock
    private PacienteService pacienteService;

    @InjectMocks
    private PacienteController pacienteController;

    private PacienteDto paciente;
    private PacienteDto pacienteInexistente;
    private PacienteDto pacienteExistente;

    @Before
    public void reset() throws IntegrityDataException, EntityNotFoundException {
        mockMvc = MockMvcBuilders.standaloneSetup(pacienteController).setControllerAdvice(GlobalExceptionsHandler.class).build();
        DomicilioDto domicilio = new DomicilioDto("Siempreviva", 742, "Springfield", "Springfield");
        paciente = new PacienteDto("Homero", "Pepin", 123456789, domicilio);
        DomicilioDto domicilioConId = new DomicilioDto("Siempreviva", 742, "Springfield", "Springfield");
        domicilioConId.setId(1);
        pacienteInexistente = new PacienteDto("Homero", "Pepin", 123456789, domicilioConId);
        pacienteExistente = new PacienteDto("Homero", "Pepin", 123456789, domicilioConId);
        pacienteExistente.setId(1);
        pacienteExistente.setFechaIngreso(LocalDate.now());
        pacienteInexistente.setId(999);
        pacienteInexistente.setFechaIngreso(LocalDate.now());
        configureMockito();
    }

    public void configureMockito() throws IntegrityDataException, EntityNotFoundException {
        Mockito.when(pacienteService.buscarPorId(999)).thenThrow(new EntityNotFoundException("No se encontró el paciente con id 999"));
        Mockito.when(pacienteService.buscarPorId(1)).thenReturn(pacienteExistente);
        Mockito.when(pacienteService.buscar("Homero")).thenReturn(List.of(pacienteExistente));
        Mockito.when(pacienteService.actualizar(pacienteInexistente)).thenThrow(new EntityNotFoundException("No se encontró el paciente con id 999"));
        Mockito.when(pacienteService.actualizar(pacienteExistente)).thenReturn(pacienteExistente);
        doThrow(new EntityNotFoundException("No existe ningún paciente con id: 999")).when(pacienteService).eliminar(999);
    }

    @Test
    public void test01registrarPaciente() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/pacientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8")
                        .content(Mapper.mapObjectToJson(paciente)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void test02buscarPacientePorIdInexistenteDevuelveNotFound() throws Exception {
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/pacientes/{id}", "999"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andReturn();
        assertEquals(
                "{\"errorClass\":\"EntityNotFoundException\",\"errorDetail\":\"No se encontró el paciente con id 999\"}",
                response.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    public void test03buscarPacientePorIdExistenteDevuelveOk() throws Exception {
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/pacientes/{id}", "1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        assertEquals(Mapper.mapObjectToJson(pacienteExistente), response.getResponse().getContentAsString());
    }

    @Test
    public void test04buscarPacientesPorNombreInexistenteDevuelveOkYArrayVacio() throws Exception {
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders
                        .get("/pacientes")
                        .param("nombre", "José")
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        assertEquals("[]", response.getResponse().getContentAsString());
    }

    @Test
    public void test05buscarPacientesPorNombreExistenteDevuelveOkYArrayNoVacio() throws Exception {
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders
                        .get("/pacientes")
                        .param("nombre", "Homero")
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        assertNotEquals("[]", response.getResponse().getContentAsString());
    }

    @Test
    public void test06buscarPacientesPorNombreYApellidoInexistenteDevuelveOkYArrayVacio() throws Exception {
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders
                        .get("/pacientes")
                        .param("nombre", "José")
                        .param("apellido", "Pérez")
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        assertEquals("[]", response.getResponse().getContentAsString());
    }

    @Test
    public void test07buscarPacientePorDNIExistenteDevuelveOk() throws Exception {
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders
                        .get("/pacientes")
                        .param("dni", "111111111")
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        assertNotEquals("[]", response.getResponse().getContentAsString());
    }

    @Test
    public void test08ActualizarPacienteInexistenteDevuelveNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/pacientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8")
                        .content(Mapper.mapObjectToJson(pacienteInexistente))
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void test09ActualizarPacienteExistenteDevuelveOk() throws Exception {
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders
                        .put("/pacientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Mapper.mapObjectToJson(pacienteExistente))
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        assertEquals(Mapper.mapObjectToJson(pacienteExistente), response.getResponse().getContentAsString());
    }

    @Test
    public void test10eliminarPacientePorIdInexistenteDevuelveNotFound() throws Exception {
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.delete("/pacientes/{id}", "999"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andReturn();
        assertEquals(
                "{\"errorClass\":\"EntityNotFoundException\",\"errorDetail\":\"No existe ningún paciente con id: 999\"}",
                response.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    public void test11eliminarPacientePorIdExistenteDevuelveOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/pacientes/{id}", "1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

    @Test
    public void test12buscarTodosLosPacientes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/pacientes"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }
}