package com.kibernumacademy.testing.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.kibernumacademy.testing.model.User;
import com.kibernumacademy.testing.repository.UserRepository;

public class UserServiceTest {
  // Mock del Repositorio
  private UserRepository userRepository;
  // Servicio a probar 
  private UserService userService;

  @BeforeEach  // Configuración inicial antes de cada prueba
  void setUp() {
    // Crear el mock del repositorio
    userRepository = Mockito.mock(UserRepository.class);
    // Inyeccion de dependencia por constructor
    userService = new UserService(userRepository);
  }

  @Test
  void testGetAllUsers() {
    // Datos simulados para el mock
    User user1 = new User(1L, "user1", "user1@test.com", "academy");
    User user2 = new User(2L, "user2", "user2@test.com", "academy");
    
    // Configurar el mock parea que devuelva una lista de estos datos simulados, realizando una emulacion del metodo findAll del JpaRepository que extiende del CrudRepository
    when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

    // Llamando al servicio
    List<User> result = userService.getAllUsers();

    // Entonces esperamos que la lista tenga 2 usuarios
    assertEquals(2, result.size());
    assertEquals("user1", result.get(0).getUsername());
    assertEquals("user2", result.get(1).getUsername());

  }

  @Test
  void testGetUserById_Found() {
    // Por medio de un ID Testear qeu ese usuario existe con este id determinado
    User user = new User(1L, "sofia", "sofia@test.com", "academy");
    when(userRepository.findById(1L)).thenReturn(Optional.of(user));

    Optional<User> result = userService.getUserById(1L);

    // Entonces esperamos que el optionaal este presente y que el nombre de usuario sea "sofia"
    assertTrue(result.isPresent());
    assertEquals("sofia", result.get().getUsername());
  }
}
