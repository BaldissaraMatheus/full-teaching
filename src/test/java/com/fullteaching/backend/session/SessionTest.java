package com.fullteaching.backend.session;

import com.fullteaching.backend.course.Course;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;
import org.mockito.Mockito;

public class SessionTest {

    @DisplayName("Quando o chamar um construtor vazio, então deve retornar uma instância de Session com todos os atributos iniciais")
    @Test
    public void testaConstrutorVazio() {
        Session session = new Session();
        Assertions.assertTrue(session instanceof Session);
        Assertions.assertEquals(0, session.getId());
        Assertions.assertEquals(null, session.getCourse());
        Assertions.assertEquals(null, session.getTitle());
        Assertions.assertEquals(null, session.getDescription());
        Assertions.assertEquals(0, session.getDate());
    }

    @DisplayName("Quando o construtor for chamado com três parâmetros, então deve retornar uma instância de Session com os valores passados")
    @Test
    public void testaConstrutorTrêsParametros() {
        Session session = new Session("titulo", "descricao", 10);
        Assertions.assertTrue(session instanceof Session);
        Assertions.assertEquals(0, session.getId());
        Assertions.assertEquals(null, session.getCourse());
        Assertions.assertEquals("titulo", session.getTitle());
        Assertions.assertEquals("descricao", session.getDescription());
        Assertions.assertEquals(10, session.getDate());
    }

    @DisplayName("Quando o construtor for chamado com quatro parâmetros, então deve retornar uma instância de Session com os valores passados")
    @Test
    public void testaConstrutorQuatroParametros() {
        Course course = Mockito.mock(Course.class);
        Session session = new Session("titulo", "descricao", 10, course);
        Assertions.assertTrue(session instanceof Session);
        Assertions.assertEquals(0, session.getId());
        Assertions.assertEquals(course, session.getCourse());
        Assertions.assertEquals("titulo", session.getTitle());
        Assertions.assertEquals("descricao", session.getDescription());
        Assertions.assertEquals(10, session.getDate());
    }

    @DisplayName("Quando o campo 'id' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void getId() {
        Session session = new Session();
        session.setId(23);
        Assertions.assertEquals(23, session.getId());
    }

    @DisplayName("Quando o campo 'title' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void getTitle() {
        Session session = new Session();
        session.setTitle("titulo");
        Assertions.assertEquals("titulo", session.getTitle());
    }

    @DisplayName("Quando o campo 'description' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void getDescription() {
        Session session = new Session();
        session.setDescription("descricao");
        Assertions.assertEquals("descricao", session.getDescription());
    }

    @DisplayName("Quando o campo 'date' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void getDate() {
        Session session = new Session();
        session.setDate(13);
        Assertions.assertEquals(13, session.getDate());
    }

    @DisplayName("Quando o campo 'course' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void getCourse() {
        Course course = Mockito.mock(Course.class);
        Session session = new Session();
        session.setCourse(course);
        Assertions.assertEquals(course, session.getCourse());
    }

    @DisplayName("Quando passado para o método equals a instancias diferentes com o mesmo id, então deve retornar true")
    @Test
    public void testaEqualsPassingDifferentObjectWithSameId() {
        Session sessionOne = new Session();
        sessionOne.setId(35);
        Session sessionTwo = new Session();
        sessionTwo.setId(35);
        Session sessionThree = new Session();
        sessionThree.setId(12);

        Assertions.assertEquals(true, sessionOne.equals(sessionTwo));
        Assertions.assertNotEquals(true, sessionOne.equals(sessionThree));
    }

    @DisplayName("Quando toString for chamado, então a mensagem resultante deve estar formatada corretamente")
    @Test
    public void testToString() {
        Session session = new Session();
        session.setTitle("titulo");
        session.setDescription("descricao");
        session.setDate(11);
        Assertions.assertEquals(
                "Session[title: \"titulo\", description: \"descricao\", date: \"11\"]",
                session.toString()
        );
    }
}