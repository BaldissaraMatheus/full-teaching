package com.fullteaching.backend.filegroup;

import com.fullteaching.backend.file.File;
import com.fullteaching.backend.session.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

public class FileGroupTest {

    @DisplayName("Quando o chamar um construtor vazio, então deve retornar uma instância de FileGroup com todos os atributos iniciais")
    @Test
    public void testaConstrutorVazio() {
        FileGroup fg = new FileGroup();
        Assertions.assertTrue(fg instanceof FileGroup);
        Assertions.assertEquals(0, fg.getId());
        Assertions.assertEquals(null, fg.getFileGroupParent());
        Assertions.assertEquals(null, fg.getFiles());
        Assertions.assertEquals(null, fg.getTitle());
        Assertions.assertEquals(null, fg.getFileGroups());
    }

    @DisplayName("Quando o construtor for chamado com um parâmetro, então deve retornar uma instância de FileGroup com os valores passados")
    @Test
    public void testaConstrutorUmParametro() {
        FileGroup fg = new FileGroup("Este é um file-group");
        Assertions.assertTrue(fg instanceof FileGroup);
        Assertions.assertEquals(0, fg.getId());
        Assertions.assertEquals(null, fg.getFileGroupParent());
        Assertions.assertEquals(new ArrayList<File>(), fg.getFiles());
        Assertions.assertEquals("Este é um file-group", fg.getTitle());
        Assertions.assertEquals(new ArrayList<FileGroup>(), fg.getFileGroups());
    }

    @DisplayName("Quando o construtor for chamado com dois parâmetros, então deve retornar uma instância de FileGroup com os valores passados")
    @Test
    public void testaConstrutorDoisParametros() {
        FileGroup fgParent = new FileGroup();
        FileGroup fg = new FileGroup("Este é um file-group", fgParent);
        Assertions.assertTrue(fg instanceof FileGroup);
        Assertions.assertEquals(0, fg.getId());
        Assertions.assertEquals(fgParent, fg.getFileGroupParent());
        Assertions.assertEquals(new ArrayList<File>(), fg.getFiles());
        Assertions.assertEquals("Este é um file-group", fg.getTitle());
        Assertions.assertEquals(new ArrayList<FileGroup>(), fg.getFileGroups());
    }

    @DisplayName("Quando o campo 'id' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void getId() {
        FileGroup fg = new FileGroup();
        fg.setId(222);
        Assertions.assertEquals(222, fg.getId());
    }

    @DisplayName("Quando o campo 'title' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void getTitle() {
        FileGroup fg = new FileGroup();
        fg.setTitle("titulo");
        Assertions.assertEquals("titulo", fg.getTitle());
    }

    @DisplayName("Quando o campo 'files' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void getFiles() {
        FileGroup fg = new FileGroup();
        File fileOne = Mockito.mock(File.class);
        File fileTwo = Mockito.mock(File.class);
        ArrayList<File> files = new ArrayList<File>();
        files.add(fileOne);
        files.add(fileTwo);
        fg.setFiles(files);

        Assertions.assertEquals(files, fg.getFiles());
        Assertions.assertEquals(fileTwo.getName(), fg.getFiles().get(1).getName());
    }

    @DisplayName("Quando o campo 'fileGroups' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void getFileGroups() {
        FileGroup fg = new FileGroup();

        FileGroup fgOne = new FileGroup("Primeiro fileGroup");
        FileGroup fgTwo = new FileGroup("Segundo fileGroup");
        ArrayList<FileGroup> fgs = new ArrayList<FileGroup>();
        fgs.add(fgOne);
        fgs.add(fgTwo);
        fg.setFileGroups(fgs);

        Assertions.assertEquals(fgs, fg.getFileGroups());
        Assertions.assertEquals(fgOne.getTitle(), fg.getFileGroups().get(0).getTitle());
    }

    @DisplayName("Quando o campo 'fileGroupParent' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void getFileGroupParent() {
        FileGroup fg = new FileGroup();
        FileGroup fgParent = new FileGroup("fileGroup parent");

        fg.setFileGroupParent(fgParent);

        Assertions.assertEquals(fgParent, fg.getFileGroupParent());
        Assertions.assertEquals(fgParent.getTitle(), fg.getFileGroupParent().getTitle());
    }

    @DisplayName("Quando passado para o método equals a instancia de uma classe diferente, então deve retornar false")
    @Test
    public void testaEqualsPassingDiffernteClass() {
        FileGroup fg = new FileGroup();
        fg.setId(5);
        Session session = new Session();
        Assertions.assertEquals(false, fg.equals(session));
    }

    @DisplayName("Quando toString for chamado, então a mensagem resultante deve estar formatada corretamente")
    @Test
    public void testToString() {
        File fileOne = Mockito.mock(File.class);
        File fileTwo = Mockito.mock(File.class);
        ArrayList<File> files = new ArrayList<File>();
        files.add(fileOne);
        files.add(fileTwo);

        FileGroup fgParent = new FileGroup("fileGroup parent");

        FileGroup fgOne = new FileGroup("Primeiro child fileGroup");
        FileGroup fgTwo = new FileGroup("Segundo child fileGroup");
        ArrayList<FileGroup> fgs = new ArrayList<FileGroup>();
        fgs.add(fgOne);
        fgs.add(fgTwo);

        FileGroup fg = new FileGroup();
        fg.setTitle("titulo do fileGroup");
        fg.setFiles(files);
        fg.setFileGroupParent(fgParent);
        fg.setFileGroups(fgs);

        Assertions.assertEquals("FileGroup[title: \"titulo do fileGroup\", parentFileGroup: \"fileGroup parent\", #files: 2, #childrenFileGroups: 2]", fg.toString());
    }
}