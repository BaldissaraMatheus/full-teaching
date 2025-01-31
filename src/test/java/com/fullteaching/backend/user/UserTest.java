package com.fullteaching.backend.user;

import com.fullteaching.backend.course.Course;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashSet;

public class UserTest {

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

    @DisplayName("Quando o campo 'id' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void getId() {
        User user = new User();
        user.setId(25L);
        Assertions.assertEquals(25L, user.getId());
    }

    @DisplayName("Quando o campo 'name' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void getName() {
        User user = new User();
        user.setName("João");
        Assertions.assertEquals("João", user.getName());
    }

    @DisplayName("Quando o campo 'passwordHash' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void getPasswordHash() {
        User user = new User();
        user.setPasswordHash("isso-eh-um-hash");
        Assertions.assertEquals("isso-eh-um-hash", user.getPasswordHash());
    }

    @DisplayName("Quando o campo 'admin' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void getRoles() {
        ArrayList<String> roles = new ArrayList<String>();
        String role = "admin";
        roles.add(role);

        User user = new User();
        user.setRoles(roles);
        Assertions.assertEquals(roles, user.getRoles());
        Assertions.assertEquals("admin", user.getRoles().get(0));

    }

    @DisplayName("Quando o campo 'nickname' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void getNickName() {
        User user = new User();
        user.setNickName("apelido");
        Assertions.assertEquals("apelido", user.getNickName());
    }

    @DisplayName("Quando o campo 'picture' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void getPicture() {
        User user = new User();
        user.setPicture("foto.png");
        Assertions.assertEquals("foto.png", user.getPicture());
    }

    @Test
    public void getRegistrationDate() {
        User user = new User();
        Long rd = System.currentTimeMillis();
        user.setRegistrationDate(rd);
        Assertions.assertEquals(rd, user.getRegistrationDate());
    }

    @DisplayName("Quando o campo 'courses' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void getCourses() {
        Course course = Mockito.mock(Course.class);
        HashSet<Course> courses = new HashSet<>();
        courses.add(course);
        User user = new User();
        user.setCourses(courses);
        Assertions.assertEquals(courses, user.getCourses());
        Assertions.assertTrue(user.getCourses().contains(course));
    }

    @DisplayName("Quando o campo 'nbane' for inserido com um setter, então deve ser gerado o hashCode corretamente")
    @Test
    public void testHashCode() {
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
    public void testToString() {
        User user = new User();
        user.setNickName("apelido");
        Assertions.assertEquals("apelido", user.toString());
    }
}