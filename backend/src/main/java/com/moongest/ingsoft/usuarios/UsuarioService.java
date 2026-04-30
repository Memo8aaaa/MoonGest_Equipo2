package com.moongest.ingsoft.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Login
    public Optional<Usuario> login(String nombre, String contrasena) {
        return usuarioRepository.findByNombreAndContrasena(nombre, contrasena);
    }

    // Listar todos
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    // Crear usuario
    public Usuario crear(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Editar usuario
    public Optional<Usuario> editar(Integer id, Usuario datosNuevos) {
        return usuarioRepository.findById(id).map(u -> {
            u.setNombre(datosNuevos.getNombre());
            u.setContrasena(datosNuevos.getContrasena());
            u.setRol(datosNuevos.getRol());
            return usuarioRepository.save(u);
        });
    }

    // Eliminar usuario
    public boolean eliminar(Integer id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
