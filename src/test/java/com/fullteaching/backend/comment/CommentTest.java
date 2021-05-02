
package com.fullteaching.backend.comment;
import com.fullteaching.backend.user.User;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

@DisplayName("Teste da classe Comment")
public class CommentTest {

    User user;

    @BeforeEach
    public void inicializa() {
        user = new User();
        user.setNickName("Zé");
    }

    @DisplayName("Quando o chamar um construtor vazio, então deve retornar uma instância de Comment com todos os atributos iniciais")
    @Test
    public void testaConstrutorVazio() {
        Comment comment = new Comment();
        Assertions.assertTrue(comment instanceof Comment);
        Assertions.assertEquals(null, comment.getMessage());
        Assertions.assertEquals(0, comment.getDate());
        Assertions.assertEquals(null, comment.getUser());
        Assertions.assertEquals(null, comment.getReplies());
        Assertions.assertThrows(NullPointerException.class, () -> comment.getReplies().size());
        Assertions.assertEquals(null, comment.getCommentParent());
        Assertions.assertTrue(comment.getId() >= 0);
    }

    @DisplayName("Quando o construtor for chamado com todos os parâmetros, então deve retornar uma instância de Comment com os valores passados")
    @Test
    public void testaConstrutor() {
        User userOne = new User("Usuário 1", "123", "apelido", "batata.jpg", "");
        Comment firstReplyUserOne = new Comment("primeira resposta do usuario 1", 15, userOne);
        ArrayList<Comment> replies = new ArrayList<Comment>();
        replies.add(firstReplyUserOne);

        Comment parentComment = new Comment("Este é o comentário pai", 25, user);

        Comment comment = new Comment("criando comment", 25, user, parentComment);
        Assertions.assertTrue(comment instanceof Comment);
        Assertions.assertEquals("criando comment", comment.getMessage());
        Assertions.assertEquals(25, comment.getDate());
        Assertions.assertEquals(user, comment.getUser());
        Assertions.assertEquals(new ArrayList<>(), comment.getReplies());
        Assertions.assertEquals(0, comment.getReplies().size());
        Assertions.assertEquals(parentComment, comment.getCommentParent());
    }

    @DisplayName("Quando o campo 'message' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void testaSetEGetMessage() {
        Comment comment = new Comment("", 25, user);
        comment.setMessage("Qual doce é mais doce que o doce de batata doce?");
        Assertions.assertEquals("Qual doce é mais doce que o doce de batata doce?", comment.getMessage());
    }

    @DisplayName("Quando o campo 'date' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void testaSetEGetDate() {
        Comment comment = new Comment("", 25, user);
        comment.setDate(12);
        Assertions.assertEquals(12, comment.getDate());
    }

    @DisplayName("Quando o campo 'user' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void testaSetEGetUser() {
        Comment comment = new Comment("", 25, user);
        User newUser = new User("Usuário", "123", "apelido", "batata.jpg", "");
        comment.setUser(newUser);
        Assertions.assertEquals(newUser, comment.getUser());
    }

    @DisplayName("Quando o campo 'commentParent' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void testaSetEGetCommentParent() {
        User newUser = new User("Usuário", "123", "apelido", "batata.jpg", "");
        Comment childComment = new Comment("", 25, newUser);
        childComment.setUser(newUser);
        Comment parentComment = new Comment("Este é o comentário pai", 25, user);
        childComment.setCommentParent(parentComment);
        Assertions.assertEquals(parentComment, childComment.getCommentParent());
    }

    @DisplayName("Quando o campo 'replies' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void testaSetEGetReplies() {
        Comment originalComment = new Comment("", 5, user);

        User userOne = new User("Usuário 1", "123", "apelido", "batata.jpg", "");
        User userTwo = new User("Usuário 2", "123", "apelido", "repolho.jpg", "");

        Comment firstReplyUserOne = new Comment("primeira resposta do usuario 1", 15, userOne);
        Comment secondReplyUserOne = new Comment("segunda resposta do usuario 1", 19, userOne);
        Comment replyUserTwo = new Comment("resposta do usuario 2", 22, userTwo);

        ArrayList<Comment> replies = new ArrayList<Comment>();
        replies.add(firstReplyUserOne);
        replies.add(secondReplyUserOne);
        replies.add(replyUserTwo);

        originalComment.setReplies(replies);

        Assertions.assertEquals(replies, originalComment.getReplies());
        Assertions.assertEquals(replies.size(), originalComment.getReplies().size());
    }

    @DisplayName("Quando o campo 'id' for inserida com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void testaSetEGetId() {
        Comment comment = new Comment("", 25, user);
        comment.setId(222);
        Assertions.assertEquals(222, comment.getId());
    }

    @DisplayName("Quando toString for chamado e user, commentParent e replies não forem nulos, a mensagem resultante deve estar formatada corretamente")
    @Test
    public void testaToString() {
        User userOne = new User("Usuário 1", "123", "apelido", "batata.jpg", "");
        Comment firstReplyUserOne = new Comment("primeira resposta do usuario 1", 15, userOne);
        ArrayList<Comment> replies = new ArrayList<Comment>();
        replies.add(firstReplyUserOne);

        Comment parentComment = new Comment("Este é o comentário pai", 25, user);

        Comment comment = new Comment("criando comment", 25, user, parentComment);
        comment.setReplies(replies);

        Assertions.assertEquals(
                "Comment[message: \"criando comment\", author: \"Zé\", parent: \"" + parentComment.getMessage() + "\", #replies: 1date: \"25\"]",
                comment.toString()
        );
    }
}
