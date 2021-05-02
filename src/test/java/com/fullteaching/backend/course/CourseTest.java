package com.fullteaching.backend.course;

import com.fullteaching.backend.comment.Comment;
import com.fullteaching.backend.coursedetails.CourseDetails;
import com.fullteaching.backend.session.Session;
import com.fullteaching.backend.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CourseTest {
    @DisplayName("Quando o chamar um construtor vazio, então deve retornar uma instância de Course com todos os atributos iniciais")
    @Test
    public void testaConstrutorVazio() {
        Course course = new Course();
        Assertions.assertTrue(course instanceof Course);
        Assertions.assertTrue(course.getId() >= 0);
        Assertions.assertEquals(null, course.getCourseDetails());
        Assertions.assertEquals(null, course.getAttenders());
        Assertions.assertEquals(null, course.getImage());
        Assertions.assertEquals(null, course.getSessions());
        Assertions.assertEquals(null, course.getTeacher());
        Assertions.assertEquals(null, course.getTitle());
    }
    @DisplayName("Quando o construtor for chamado com todos os parâmetros, então deve retornar uma instância de Course com os valores passados")
    @Test
    public void testaConstrutorPassandoParametros() {
        User teacher = new User();
        CourseDetails courseDetails = new CourseDetails();
        Course course = new Course("Introdução a JUnit", "java.png", teacher, courseDetails);
        Assertions.assertTrue(course instanceof Course);
        Assertions.assertTrue(course.getId() >= 0);
        Assertions.assertEquals(courseDetails, course.getCourseDetails());
        Assertions.assertEquals(new HashSet<User>(), course.getAttenders());
        Assertions.assertEquals(new HashSet<User>(), course.getSessions());
        Assertions.assertEquals(teacher, course.getTeacher());
        Assertions.assertEquals("java.png", course.getImage());
        Assertions.assertEquals("Introdução a JUnit", course.getTitle());
    }

    @DisplayName("Quando o campo 'id' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void testaSetEGetId() {
        Course course = new Course();
        course.setId(222);
        Assertions.assertEquals(222, course.getId());
    }

    @DisplayName("Quando o campo 'title' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void testaSetEGetTitle() {
        Course course = new Course();
        course.setTitle("Introdução a JUnit");
        Assertions.assertEquals("Introdução a JUnit", course.getTitle());
    }

    @DisplayName("Quando o campo 'image' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void testaSetEGetImage() {
        Course course = new Course();
        course.setImage("java.png");
        Assertions.assertEquals("java.png", course.getImage());
    }

    @DisplayName("Quando o campo 'teacher' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void testaSetEGetTeacher() {
        User teacher = new User("Professor", "123", "zé", "fotinho.png", "");
        Course course = new Course();
        course.setTeacher(teacher);
        Assertions.assertEquals(teacher, course.getTeacher());
    }

    @DisplayName("Quando o campo 'couseDetails' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void testaSetEGetCourseDetails() {
        CourseDetails courseDetails = new CourseDetails();
        Course course = new Course();
        course.setCourseDetails(courseDetails);
        Assertions.assertEquals(courseDetails, course.getCourseDetails());
    }

    @DisplayName("Quando o campo 'attenders' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void testaSetEGetAttenders() {
        User attenderOne = new User("Atendente 1", "123", "Jão", "fotinho.png", "");
        User attenderTwo = new User("Atendente 2", "senha-segura", "Zé", "fotopng", "");
        HashSet<User> atendentes = new HashSet<User>();
        atendentes.add(attenderOne);
        atendentes.add(attenderTwo);
        Course course = new Course();
        course.setAttenders(atendentes);
        Assertions.assertEquals(atendentes, course.getAttenders());
    }

    @DisplayName("Quando o campo 'sessions' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void testaSetEGetSessions() {
        Set<Session> sessions = new HashSet<Session>();
        Session session1 = new Session("Sessão 1", "Esta é uma sessão", 12);
        Session session2 = new Session("Sessão 2", "Esta é outra sessão", 24);
        sessions.add(session1);
        sessions.add(session2);
        Course course = new Course();
        course.setSessions(sessions);
        Assertions.assertEquals(sessions, course.getSessions());
    }

    @DisplayName("Quando toString for chamado, então a mensagem resultante deve estar formatada corretamente")
    @Test
    public void testaToString() {
        User teacher = new User("José", "123", "zé", "fotinho.png", "");
        Session session1 = new Session("Sessão 1", "Esta é uma sessão", 12);
        Set<Session> sessions = new HashSet<Session>();
        sessions.add(session1);
        User attenderOne = new User("Atendente 1", "123", "Jão", "fotinho.png", "");
        User attenderTwo = new User("Atendente 2", "senha-segura", "Carlinhos", "foto.png", "");
        HashSet<User> atendentes = new HashSet<User>();
        atendentes.add(attenderOne);
        atendentes.add(attenderTwo);
        Course course = new Course("Introdução a JUnit", "java.png", teacher);
        course.setSessions(sessions);
        course.setAttenders(atendentes);
        Assertions.assertEquals(
                "Course[title: \"Introdução a JUnit\", teacher: \"zé\", #attenders: 2, #sessions: 1]",
                course.toString()
        );
    }

    @DisplayName("Quando passado para o método equals o valor null, então deve retornar false")
    @Test
    public void testaEqualsPassingNull() {
        Course course = new Course();
        course.setId(5);
        Assertions.assertEquals(false, course.equals(null));
    }
    @Test
    public void testaEqualsPassingThis() {
        Course course = new Course();
        course.setId(5);
        Assertions.assertEquals(true, course.equals(course));
    }

    @DisplayName("Quando passado para o método equals a instancia de uma classe diferente, então deve retornar false")
    @Test
    public void testaEqualsPassingDiffernteClass() {
        Course course = new Course();
        Session session = new Session();
        course.setId(5);
        Assertions.assertEquals(false, course.equals(session));
    }

    @DisplayName("Quando passado para o método equals a instancias diferentes com o mesmo id, então deve retornar true")
    @Test
    public void testaEqualsPassingDifferentObjectWithSameId() {
        Course course = new Course();
        Course differentCourse = new Course();
        course.setId(5);
        differentCourse.setId(5);
        Assertions.assertEquals(true, course.equals(differentCourse));
    }
}
