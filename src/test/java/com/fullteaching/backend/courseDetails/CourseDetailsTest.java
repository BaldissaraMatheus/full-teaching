package com.fullteaching.backend.courseDetails;

import com.fullteaching.backend.course.Course;
import com.fullteaching.backend.coursedetails.CourseDetails;
import com.fullteaching.backend.filegroup.FileGroup;
import com.fullteaching.backend.forum.Forum;
import com.fullteaching.backend.user.User;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

public class CourseDetailsTest {

    @DisplayName("Quando o chamar um construtor vazio, então deve retornar uma instância de CourseDetails com todos os atributos iniciais")
    @Test
    public void testaConstrutorVazio() {
        CourseDetails courseDetails = new CourseDetails();
        Assertions.assertTrue(courseDetails instanceof CourseDetails);
        Assertions.assertTrue(courseDetails.getId() >= 0);
        Assertions.assertEquals(null, courseDetails.getCourse());
        Assertions.assertEquals(new ArrayList<>(), courseDetails.getFiles());
        Assertions.assertEquals("Forum[activated: \"false\", #entries: \"0\", #comments: \"0\"]", courseDetails.getForum().toString().trim());
        Assertions.assertEquals("", courseDetails.getInfo());
    }

    @DisplayName("Quando o construtor for chamado com todos os parâmetros, então deve retornar uma instância de CourseDetails com os valores passados")
    @Test
    public void testaConstrutorPassandoParametros() {
        User teacher = Mockito.mock(User.class);
        Course course = new Course("Introdução a JUnit", "java.png", teacher);

        CourseDetails courseDetails = new CourseDetails(course);
        Assertions.assertTrue(courseDetails instanceof CourseDetails);
        Assertions.assertTrue(courseDetails.getId() >= 0);
        Assertions.assertEquals(course, courseDetails.getCourse());
        Assertions.assertEquals(new ArrayList<>(), courseDetails.getFiles());
        Assertions.assertTrue(courseDetails.getForum() instanceof Forum);
        Assertions.assertEquals("", courseDetails.getInfo());
    }

    @DisplayName("Quando o campo 'id' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void testaSetEGetId() {
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setId(222);
        Assertions.assertEquals(222, courseDetails.getId());
    }

    @DisplayName("Quando o campo 'course' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void testaSetEGetCourse() {
        User teacher = Mockito.mock(User.class);
        Course course = new Course("Introdução a JUnit", "java.png", teacher);
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setCourse(course);
        Assertions.assertEquals(course, courseDetails.getCourse());
    }

    @DisplayName("Quando o campo 'files' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void testaSetEGetFiles() {
        FileGroup fileGroupOne = Mockito.mock(FileGroup.class);
        FileGroup fileGroupTwo = Mockito.mock(FileGroup.class);
        ArrayList<FileGroup> files = new ArrayList<FileGroup>();
        files.add(fileGroupOne);
        files.add(fileGroupTwo);
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setFiles(files);
        Assertions.assertEquals(files, courseDetails.getFiles());
    }

    @DisplayName("Quando o campo 'forum' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void testaSetEGetForum() {
        Forum forum = Mockito.mock(Forum.class);
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setForum(forum);
        Assertions.assertEquals(forum, courseDetails.getForum());
    }

    @DisplayName("Quando o campo 'info' for inserido com um setter, então seu valor deve ser obtido pelo getter")
    @Test
    public void testaSetEGetInfo() {
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setInfo("alo");
        Assertions.assertEquals("alo", courseDetails.getInfo());
    }
}
