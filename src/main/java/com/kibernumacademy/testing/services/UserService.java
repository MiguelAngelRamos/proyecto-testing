package com.kibernumacademy.testing.services;

import org.springframework.stereotype.Service;

import com.kibernumacademy.testing.model.User;
import com.kibernumacademy.testing.repository.UserRepository;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para manejar la lógica de negocio de los usuarios.
 */
@Service
public class UserService {
    
    private final UserRepository userRepository;
    
    /**
     * Inyección de dependencias por constructor.
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    /**
     * Obtener todos los usuarios.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    /**
     * Obtener un usuario por su ID.
     */
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    
    /**
     * Crear o actualizar un usuario.
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    
    /**
     * Eliminar un usuario por su ID.
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
