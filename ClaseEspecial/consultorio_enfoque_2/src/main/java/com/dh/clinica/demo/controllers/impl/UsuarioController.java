package com.dh.clinica.demo.controllers.impl;

import com.dh.clinica.demo.exceptions.IntegrityDataException;
import com.dh.clinica.demo.persistence.entities.auth.Usuario;
import com.dh.clinica.demo.service.impl.UsuarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @ApiOperation(value = "Crea un nuevo usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success | OK"),
            @ApiResponse(code = 400, message = "Bad Request") })
    @PostMapping("/crear-usuario")
    public ResponseEntity<Usuario> crear(@RequestBody Usuario u) throws IntegrityDataException {
        Usuario usuario = usuarioService.crear(u);
        return ResponseEntity.ok(usuario);
    }

    @ApiOperation(value = "Busca todos los usuarios")
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Bad Request") })
    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> consultarTodos() {
        return ResponseEntity.ok(usuarioService.consultarTodos());
    }

    @GetMapping("/403")
    public String error() {
        return "<h1>Error 403: Acceso denegado o prohibido</h1>";
    }
}
