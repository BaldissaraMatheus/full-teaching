package com.fullteaching.backend.user;

import com.fullteaching.backend.course.Course;
import com.fullteaching.backend.session.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @DisplayName("Quando o chamar um construtor vazio, então deve retornar uma instância de User com todos os atributos iniciais")
    @Test
    public void testaConstrutorVazio() {
        User user = new User();
        Assertions.assertTrue(user instanceof User);
        Assertions.assertEquals(0, user.getId());
        Assertions.assertEquals(null, user.getNickName());
        Assertions.assertEquals(null, user.getCourses());
        Assertions.assertEquals(null, user.getPicture());
        Assertions.assertEquals(null, user.getPasswordHash());
        Assertions.assertEquals(null, user.getName());
        Assertions.assertEquals(0, user.getRegistrationDate());
        Assertions.assertEquals(null, user.getRoles());
    }

    @DisplayName("Quando o construtor for chamado com três parâmetros, então deve retornar uma instância de User com os valores passados")
    @Test
    public void testaConstrutorTrêsParametros() {
        User user = new User("Nome", "senha123", "apelido", "foto.png");
        HashSet<Course> courses = new HashSet<Course>();
        ArrayList<String> roles = new ArrayList<String>();

        Assertions.assertTrue(user instanceof User);
        Assertions.assertEquals(0, user.getId());
        Assertions.assertEquals("apelido", user.getNickName());
        Assertions.assertEquals(courses, user.getCourses());
        Assertions.assertEquals("foto.png", user.getPicture());
        Assertions.assertEquals("Nome", user.getName());
        Assertions.assertTrue(user.getRegistrationDate() <= System.currentTimeMillis());
        Assertions.assertEquals(roles, user.getRoles());
    }

    @Test
    void getId() {
        User user = new User();
        user.setId(25L);
        Assertions.assertEquals(25L, user.getId());
    }

    @Test
    void getName() {
        User user = new User();
        user.setName("João");
        Assertions.assertEquals("João", user.getName());
    }

    @Test
    void getPasswordHash() {
        User user = new User();
        user.setPasswordHash("isso-eh-um-hash");
        Assertions.assertEquals("isso-eh-um-hash", user.getPasswordHash());
    }

    @Test
    void getRoles() {
        ArrayList<String> roles = new ArrayList<String>();
        String role = "admin";
        roles.add(role);

        User user = new User();
        user.setRoles(roles);
        Assertions.assertEquals(roles, user.getRoles());
        Assertions.assertEquals("admin", user.getRoles().get(0));

    }

    @Test
    void getNickName() {
        User user = new User();
        user.setNickName("apelido");
        Assertions.assertEquals("apelido", user.getNickName());
    }

    @Test
    void getPicture() {
        User user = new User();
        user.setPicture("foto.png");
        Assertions.assertEquals("foto.png", user.getPicture());
    }

    @Test
    void getRegistrationDate() {
        User user = new User();
        Long rd = System.currentTimeMillis();
        user.setRegistrationDate(rd);
        Assertions.assertEquals(rd, user.getRegistrationDate());
    }

    @Test
    void getCourses() {
        Course course = new Course();
        HashSet<Course> courses = new HashSet<>();
        courses.add(course);
        User user = new User();
        user.setCourses(courses);
        Assertions.assertEquals(courses, user.getCourses());
        Assertions.assertTrue(user.getCourses().contains(course));
    }

    @Test
    void testHashCode() {
        User user = new User("Nome", "senha123", "apelido", "foto.png");
        int hash = "Nome".hashCode();
        Assertions.assertEquals(hash, user.hashCode());
    }

    @DisplayName("Quando passado para o método equals o valor null, então deve retornar false")
    @Test
    public void testaEqualsPassingNull() {
        User user = new User();
        Assertions.assertEquals(false, user.equals(null));
    }

    @DisplayName("Quando passado para o método equals a mesma instância, então deve retornar true")
    @Test
    public void testaEqualsPassingThis() {
        User user = new User();
        Assertions.assertEquals(true,  user.equals(user));
    }

    @DisplayName("Quando passado para o método equals a instancia de uma classe diferente, então deve retornar false")
    @Test
    public void testaEqualsPassingDiffernteClass() {
        User user = new User();
        Course course = new Course();
        Assertions.assertEquals(false, user.equals(course));
    }

    @DisplayName("Quando toString for chamado, então a mensagem resultante deve estar formatada corretamente")
    @Test
    void testToString() {
        User user = new User();
        user.setNickName("apelido");
        Assertions.assertEquals("apelido", user.toString());
    }
}