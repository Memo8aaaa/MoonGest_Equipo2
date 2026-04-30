package com.moongest.ingsoft.controller;

import com.moongest.ingsoft.model.Usuario;
import com.moongest.ingsoft.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credenciales) {
        String nombre = credenciales.get("nombre");
        String contrasena = credenciales.get("contrasena");
        Optional<Usuario> usuario = usuarioService.login(nombre, contrasena);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        }
        return ResponseEntity.status(401).body("Usuario o contraseña incorrectos");
    }

    // Listar todos
    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioService.listarTodos();
    }

    // Crear usuario
    @PostMapping
    public ResponseEntity<Usuario> crear(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.crear(usuario));
    }

    // Editar usuario
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Integer id, @RequestBody Usuario usuario) {
        Optional<Usuario> actualizado = usuarioService.editar(id, usuario);
        if (actualizado.isPresent()) {
            return ResponseEntity.ok(actualizado.get());
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        if (usuarioService.eliminar(id)) {
            return ResponseEntity.ok("Usuario eliminado correctamente");
        }
        return ResponseEntity.notFound().build();
    }
}
