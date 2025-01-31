package com.fullteaching.backend.entry;

import com.fullteaching.backend.comment.Comment;
import com.fullteaching.backend.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

public class EntryTest {

    @DisplayName("Quando o chamar um construtor vazio, então deve retornar uma instância de Entry com todos os atributos iniciais")
    @Test
    public void testaConstrutorVazio() {
        Entry entry = new Entry();
        Assertions.assertTrue(entry instanceof Entry);
        Assertions.assertTrue(entry.getId() >= 0);
        Assertions.assertEquals(null, entry.getTitle());
        Assertions.assertEquals(null, entry.getComments());
        Assertions.assertEquals(0, entry.getDate());
        Assertions.assertEquals(null, entry.getUser());
    }

    @DisplayName("Quando o construtor for chamado com todos os parâmetros, então deve retornar uma instância de Entry com os valores passados")
    @Test
    public void testaConstrutorPassandoParametros() {
        User user = Mockito.mock(User.class);
        Entry entry = new Entry("Isso é um título", 12, user);
        Assertions.assertTrue(entry instanceof Entry);
        Assertions.assertTrue(entry.getId() >= 0);
        Assertions.assertEquals("Isso é um título", entry.getTitle());
        Assertions.assertEquals(12, entry.getDate());
        Assertions.assertEquals(user, entry.getUser());
        Assertions.assertEquals(new ArrayList<Comment>(), entry.getComments());
    }

    @DisplayName("Quando o campo 'id' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void testaSetEGetId() {
        Entry entry = new Entry();
        entry.setId(222);
        Assertions.assertEquals(222, entry.getId());
    }

    @DisplayName("Quando o campo 'title' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void getTitle() {
        Entry entry = new Entry();
        entry.setTitle("Isso é um título");
        Assertions.assertEquals("Isso é um título", entry.getTitle());
    }

    @DisplayName("Quando o campo 'date' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void getDate() {
        Entry entry = new Entry();
        entry.setDate(12);
        Assertions.assertEquals(12, entry.getDate());
    }

    @DisplayName("Quando o campo 'comments' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void getComments() {
        Comment firstComment = Mockito.mock(Comment.class);
        Comment secondComment = Mockito.mock(Comment.class);
        ArrayList<Comment> comments = new ArrayList<Comment>();
        comments.add(firstComment);
        comments.add(secondComment);
        Entry entry = new Entry();
        entry.setComments(comments);
        Assertions.assertEquals(comments, entry.getComments());
    }

    @DisplayName("Quando o campo 'user' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void getUser() {
        User user = Mockito.mock(User.class);
        Entry entry = new Entry();
        entry.setUser(user);
        Assertions.assertEquals(user, entry.getUser());
    }

    @DisplayName("Quando toString for chamado, então a mensagem deve estar formatada corretamente")
    @Test
    public void testToString() {
        User user = Mockito.mock(User.class);
        Mockito.when(user.getNickName()).thenReturn("Zé");

        Comment firstComment = Mockito.mock(Comment.class);
        Comment secondComment = Mockito.mock(Comment.class);
        ArrayList<Comment> comments = new ArrayList<Comment>();
        comments.add(firstComment);
        comments.add(secondComment);

        Entry entry = new Entry();
        entry.setUser(user);
        entry.setComments(comments);
        entry.setDate(12);
        entry.setTitle("Testando toString");
        Assertions.assertEquals(
                "Entry[title: \"Testando toString\", author: \"Zé\", date: 12, #comments: 2]",
                entry.toString()
        );
    }
}