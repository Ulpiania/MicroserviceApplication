package com.tsi.alex.program;

import io.cucumber.java.en_old.Ac;
import io.cucumber.java.jv.Lan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
//import org.mockito.Mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    private MyFirstMicroserviceApplication myFirstMicroserviceApplication;
    @Mock
    private ActorRepository actorRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private LanguageRepository languageRepository;

    @BeforeEach
    void setUp(){
        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication(actorRepository, categoryRepository, languageRepository);
    }

    @Test
    public void getAllActors(){
        myFirstMicroserviceApplication.getAllActors();
        verify(actorRepository).findAll();
    }

    @Test
    public void getAnActor(){
        Actor a = new Actor("Alex", "Ulpiani");
        Mockito.when(myFirstMicroserviceApplication.getAnActor(1)).thenReturn(Optional.of(a));
        Optional<Actor> actor = myFirstMicroserviceApplication.getAnActor(1);

        Assertions.assertEquals("Alex", actor.get().getFirst_name());
        Assertions.assertEquals("Ulpiani", actor.get().getLast_name());
    }

    @Test
    public void testAddNewActor(){
        Actor actor = new Actor("Alex", "Ulpiani");

        String expected = "saved";
        String Actual = myFirstMicroserviceApplication.addNewActor(actor.getFirst_name(), actor.getLast_name());

        ArgumentCaptor<Actor> actorArguementCaptor = ArgumentCaptor.forClass(Actor.class);

        verify(actorRepository).save(actorArguementCaptor.capture());
        actorArguementCaptor.getValue();

        Assertions.assertEquals(expected, Actual, "The actor was not saved successfully into the database");

    }

//    @Test
//    public void UpdateAnActor(){
//        Actor a = new Actor("ED", "Chase");
//        Optional<Actor> oActor = Optional.of(a);
//        Mockito.when(myFirstMicroserviceApplication,getAnActor(3)).thenReturn(oActor);
//        Actor b = new Actor("Chase", "ED");
//        String result = myFirstMicroserviceApplication.UpdateActor(3, b);
//        String expected = "Chase ED";
//        Assertions.assertEquals(result, expected, "The actor was not successfully updated");
////        myFirstMicroserviceApplication.getAnActor(199);
////        verify(actorRepository).findById(199);
//    }

    @Test
    public void testDeleteActor(){
          final Actor a = new Actor("Alex", "Ulpiani");
          Optional<Actor> optionalActor = Optional.of(a);
          Mockito.when(actorRepository.findById(1)).thenReturn(optionalActor);
          String actual = myFirstMicroserviceApplication.deleteActorById(1);
          Mockito.verify(actorRepository).delete(a);
          Assertions.assertEquals("Deleted", actual, "The actor was not deleted successfully");

    }

    @Test
    public void getAllCatergories(){
        myFirstMicroserviceApplication.getAllCategories();
        verify(categoryRepository).findAll();
    }

    @Test
    public void getACategory(){
        Category c = new Category("Anime");
        Mockito.when(myFirstMicroserviceApplication.getACategory(1)).thenReturn(Optional.of(c));
        Optional<Category> category = myFirstMicroserviceApplication.getACategory(1);

        Assertions.assertEquals("Anime", category.get().getName());
    }

    @Test
    public void testAddNewCategory(){
        Category category = new Category("Anime");

        String expected = "saved";
        String Actual = myFirstMicroserviceApplication.addNewCategory(category.getName());

        ArgumentCaptor<Category> categoryArguementCaptor = ArgumentCaptor.forClass(Category.class);

        verify(categoryRepository).save(categoryArguementCaptor.capture());
        categoryArguementCaptor.getValue();

        Assertions.assertEquals(expected, Actual, "The category was not saved successfully into the database");

    }

    @Test
    public void testDeleteCategory(){
        final Category c = new Category("Anime");
        Optional<Category> optionalCategory = Optional.of(c);
        Mockito.when(categoryRepository.findById(1)).thenReturn(optionalCategory);
        String actual = myFirstMicroserviceApplication.deleteCategoryById(1);
        Mockito.verify(categoryRepository).delete(c);
        Assertions.assertEquals("Deleted", actual, "The Category was not deleted successfully");

    }

    @Test
    public void getAllLanguages(){
        myFirstMicroserviceApplication.getAllLanguages();
        verify(languageRepository).findAll();
    }

    @Test
    public void getALanguage(){
        Language l = new Language("Korean");
        Mockito.when(myFirstMicroserviceApplication.getALanguage(1)).thenReturn(Optional.of(l));
        Optional<Language> language = myFirstMicroserviceApplication.getALanguage(1);

        Assertions.assertEquals("Korean", language.get().getName());
    }

    @Test
    public void testAddNewLanguage(){
        Language language = new Language("Korean");

        String expected = "saved";
        String Actual = myFirstMicroserviceApplication.addNewLanguage(language.getName());

        ArgumentCaptor<Language> languageArguementCaptor = ArgumentCaptor.forClass(Language.class);

        verify(languageRepository).save(languageArguementCaptor.capture());
        languageArguementCaptor.getValue();

        Assertions.assertEquals(expected, Actual, "The category was not saved successfully into the database");

    }

    @Test
    public void testDeleteLanguage(){
        final Language l = new Language("Korean");
        Optional<Language> optionalLanguage = Optional.of(l);
        Mockito.when(languageRepository.findById(1)).thenReturn(optionalLanguage);
        String actual = myFirstMicroserviceApplication.deleteLanguageById(1);
        Mockito.verify(languageRepository).delete(l);
        Assertions.assertEquals("Deleted", actual, "The language was not deleted successfully");
    }
}
