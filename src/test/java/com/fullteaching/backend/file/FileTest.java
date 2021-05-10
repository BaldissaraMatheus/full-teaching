package com.fullteaching.backend.file;

import com.fullteaching.backend.session.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;

public class FileTest {

    @DisplayName("Quando o chamar um construtor vazio, então deve retornar uma instância de File com todos os atributos iniciais")
    @Test
    public void testaConstrutorVazio() {
        File file = new File();
        Assertions.assertTrue(file instanceof File);
        Assertions.assertEquals(0, file.getId());
        Assertions.assertThrows(NullPointerException.class, () -> file.getFileExtension());
        Assertions.assertEquals(null, file.getLink());
        Assertions.assertEquals(null, file.getName());
        Assertions.assertEquals(0, file.getType());
        Assertions.assertEquals(null, file.getNameIdent());
        Assertions.assertEquals(0, file.getIndexOrder());
    }

    @DisplayName("Quando o construtor for chamado com dois parâmetros, então deve retornar uma instância de File com os valores passados")
    @Test
    public void testaConstrutor() {
        File file = new File(0, "arquivo.png");
        file.setNameIdent("arquivo-ident.png");
        Assertions.assertTrue(file instanceof File);
        Assertions.assertEquals(0, file.getId());
        Assertions.assertEquals("arquivo-ident.png", file.getNameIdent());
        Assertions.assertEquals("png", file.getFileExtension());
        Assertions.assertEquals("", file.getLink());
        Assertions.assertEquals("arquivo.png", file.getName());
        Assertions.assertEquals(0, file.getType());
        Assertions.assertEquals(0, file.getIndexOrder());
    }

    @DisplayName("Quando o construtor for chamado com três parâmetros, então deve retornar uma instância de File com os valores passados")
    @Test
    public void testaConstrutorTresParametros() {
        File file = new File(0, "arquivo.png", "https://google.com/images/arquivo.png");
        file.setNameIdent("arquivo-ident.png");
        Assertions.assertTrue(file instanceof File);
        Assertions.assertEquals(0, file.getId());
        Assertions.assertEquals("png", file.getFileExtension());
        Assertions.assertEquals("https://google.com/images/arquivo.png", file.getLink());
        Assertions.assertEquals("arquivo.png", file.getName());
        Assertions.assertEquals(0, file.getType());
        Assertions.assertEquals(0, file.getIndexOrder());
    }

    @DisplayName("Quando o construtor for chamado com quatrp parâmetros, então deve retornar uma instância de File com os valores passados")
    @Test
    public void testaConstrutorQuatro() {
        File file = new File(0, "arquivo.png", "https://google.com/images/arquivo.png", 2);
        file.setNameIdent("arquivo-ident.png");
        Assertions.assertTrue(file instanceof File);
        Assertions.assertEquals(0, file.getId());
        Assertions.assertEquals("png", file.getFileExtension());
        Assertions.assertEquals("https://google.com/images/arquivo.png", file.getLink());
        Assertions.assertEquals("arquivo.png", file.getName());
        Assertions.assertEquals(0, file.getType());
        Assertions.assertEquals("arquivo-ident.png", file.getNameIdent());
        Assertions.assertEquals(2, file.getIndexOrder());
    }

    @DisplayName("Quando o campo 'id' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void testaSetEGetId() {
        File file = new File(0, "arquivo.png");
        file.setId(222);
        Assertions.assertEquals(222, file.getId());
    }

    @DisplayName("Quando o campo 'type' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void getType() {
        File file = new File();
        file.setType(0);
        Assertions.assertEquals(0, file.getType());
    }

    @DisplayName("Quando o campo 'name' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void getName() {
        File file = new File();
        file.setName("arquivo.jpg");
        Assertions.assertEquals("arquivo.jpg", file.getName());
    }

    @DisplayName("Quando o campo 'nameIdent' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void getNameIdent() {
        File file = new File();
        file.setNameIdent("isso é um ident");
        Assertions.assertEquals("isso é um ident", file.getNameIdent());
    }

    @DisplayName("Quando o campo 'link' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void getLink() {
        File file = new File();
        file.setLink("https://google.com/images/arquivo.png");
        Assertions.assertEquals("https://google.com/images/arquivo.png", file.getLink());
    }

    @DisplayName("Quando o campo 'indexOrder' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void getIndexOrder() {
        File file = new File();
        file.setIndexOrder(22);
        Assertions.assertEquals(22, file.getIndexOrder());
    }

    @DisplayName("Quando o campo 'name' for inserido com um setter, então o getFileExtension deve retornar o conteúdo depois do . do valor inserido")
    @Test
    public void getFileExtension() {
        File file = new File();
        file.setNameIdent("foto.png");
        Assertions.assertEquals("png", file.getFileExtension());
    }

    @DisplayName("Quando passado para o método equals a instancias diferentes com o mesmo id, então deve retornar true")
    @Test
    public void testaEqualsPassingDifferentObjectWithSameId() {
        File file = new File();
        file.setId(5);
        File differentFile = new File();
        differentFile.setId(5);
        Assertions.assertEquals(true, file.equals(differentFile));
    }

    @DisplayName("Quando toString for chamado, então a mensagem resultante deve estar formatada corretamente")
    @Test
    public void testToString() {
        File file = new File(0, "arquivo.png", "https://google.com/images/arquivo.png", 2);
        file.setNameIdent("arquivo-ident.png");
        Assertions.assertEquals(
                "File[name: \"arquivo.png\", id: \"arquivo-ident.png\", link: \"https://google.com/images/arquivo.png, indexOrder: 2]",
                file.toString()
        );
    }
}