package com.fullteaching.backend.forum;

import com.fullteaching.backend.comment.Comment;
import com.fullteaching.backend.entry.Entry;
import com.fullteaching.backend.file.File;
import com.fullteaching.backend.filegroup.FileGroup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ForumTest {

    @DisplayName("Quando o chamar um construtor vazio, então deve retornar uma instância de Forum com todos os atributos iniciais")
    @Test
    public void testaConstrutorVazio() {
        Forum forum = new Forum();
        Assertions.assertTrue(forum instanceof Forum);
        Assertions.assertEquals(0, forum.getId());
        Assertions.assertEquals(null, forum.getEntries());
        Assertions.assertEquals(false, forum.isActivated());
    }

    @DisplayName("Quando o construtor for chamado com um parâmetro, então deve retornar uma instância de Forum com os valores passados")
    @Test
    public void testaConstrutorUmParametro() {
        ArrayList<Entry> entries = new ArrayList<Entry>();
        Forum forum = new Forum(true);
        Assertions.assertTrue(forum instanceof Forum);
        Assertions.assertEquals(0, forum.getId());
        Assertions.assertEquals(entries, forum.getEntries());
        Assertions.assertEquals(true, forum.isActivated());
    }

    @DisplayName("Quando o campo 'id' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    void getId() {
        Forum forum = new Forum(true);
        forum.setId(25);
        Assertions.assertEquals(25, forum.getId());
    }

    @DisplayName("Quando o campo 'activated' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    void isActivated() {
        Forum forum = new Forum(true);
        forum.setActivated(false);
        Assertions.assertEquals(false, forum.isActivated());
    }

    @DisplayName("Quando o campo 'entries' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    void getEntries() {
        Entry entryOne = new Entry("primeira entry", 12, null);
        Entry entryTwo = new Entry("segunda entry", 25, null);
        ArrayList<Entry> entries = new ArrayList<Entry>();
        entries.add(entryOne);
        entries.add(entryTwo);

        Forum forum = new Forum();
        forum.setEntries(entries);

        Assertions.assertEquals(entries, forum.getEntries());
        Assertions.assertEquals(entryOne.getTitle(), forum.getEntries().get(0).getTitle());
        Assertions.assertEquals(entryTwo.getTitle(), forum.getEntries().get(1).getTitle());
    }

    @DisplayName("Quando toString for chamado, então a mensagem resultante deve estar formatada corretamente")
    @Test
    void testToString() {
        Comment comment = new Comment("Isso é um comentário", 13, null);
        ArrayList<Comment> comments = new ArrayList<Comment>();
        comments.add(comment);
        Entry entryOne = new Entry("primeira entry", 12, null);
        entryOne.setComments(comments);
        Entry entryTwo = new Entry("segunda entry", 25, null);
        ArrayList<Entry> entries = new ArrayList<Entry>();
        entries.add(entryOne);
        entries.add(entryTwo);

        Forum forum = new Forum(true);
        forum.setEntries(entries);

        Assertions.assertEquals("Forum[activated: \"true\", #entries: \"2\", #comments: \"1\"]", forum.toString());
    }
}