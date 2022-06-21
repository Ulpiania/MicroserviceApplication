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
import org.springframework.http.ResponseEntity;

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
    @Mock
    private FilmRepository filmRepository;

    @BeforeEach
    void setUp(){
        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication(actorRepository, categoryRepository, languageRepository, filmRepository);
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

    @Test
    public void UpdateAnActor(){
        Actor a = new Actor("ED", "Chase");
        Optional<Actor> oActor = Optional.of(a);
        Mockito.when(myFirstMicroserviceApplication.getAnActor(3)).thenReturn(oActor);
        Actor b = new Actor("Alex", "Ulpiani");
        ResponseEntity result = myFirstMicroserviceApplication.UpdateActor(3, b.getFirst_name(), b.getLast_name());
        ResponseEntity expected = ResponseEntity.ok(b);
        Assertions.assertEquals(expected.getStatusCode(), result.getStatusCode(), "The actor was not successfully updated");
    }

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
    public void UpdateAnCategory(){
        Category c = new Category("Anime");
        Optional<Category> optionalCategory = Optional.of(c);
        Mockito.when(myFirstMicroserviceApplication.getACategory(3)).thenReturn(optionalCategory);
        Category d = new Category("Cartoon");
        ResponseEntity result = myFirstMicroserviceApplication.updateCategory(3, d.getName());
        ResponseEntity expected = ResponseEntity.ok(d);
        Assertions.assertEquals(expected.getStatusCode(), result.getStatusCode(), "The Category was not successfully updated");
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
    public void UpdateAnLanguage(){
        Language l = new Language("Korean");
        Optional<Language> optionalLanguage = Optional.of(l);
        Mockito.when(myFirstMicroserviceApplication.getALanguage(3)).thenReturn(optionalLanguage);
        Language a = new Language("Chinese");
        ResponseEntity result = myFirstMicroserviceApplication.updateLanguage(3, a.getName());
        ResponseEntity expected = ResponseEntity.ok(a);
        Assertions.assertEquals(expected.getStatusCode(), result.getStatusCode(), "The Language was not successfully updated");
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

    @Test
    public void getAllFilms(){
        myFirstMicroserviceApplication.getAllFilms();
        verify(filmRepository).findAll();
    }

    @Test
    public void getAFilm(){
        Film f = new Film("Test", "Cool Film", 2006, null, null, 5, 0.55f, 55, 15.99f, "PG", "Deleted scenes");
        Mockito.when(myFirstMicroserviceApplication.getAFilm(1)).thenReturn(Optional.of(f));
        Optional<Film> film = myFirstMicroserviceApplication.getAFilm(1);

        Assertions.assertEquals("Test", film.get().getTitle());
        Assertions.assertEquals("Cool Film", film.get().getDescription());
        Assertions.assertEquals(2006, film.get().getRelease_year());
        Assertions.assertEquals(null, film.get().getLanguage_id());
        Assertions.assertEquals(null, film.get().getOriginal_language_id());
        Assertions.assertEquals(5, film.get().getRental_duration());
        Assertions.assertEquals(0.55f, film.get().getRental_rate());
        Assertions.assertEquals(55, film.get().getLength());
        Assertions.assertEquals(15.99f, film.get().getReplacement_cost());
        Assertions.assertEquals("PG", film.get().getRating());
        Assertions.assertEquals("Deleted scenes", film.get().getSpecial_features());
    }

    @Test
    public void testAddNewFilm(){
        Film film = new Film("Test", "Cool Film", 2006, null, null, 5, 0.55f, 55, 15.99f, "PG", "Deleted scenes");

        String expected = "saved";
        String Actual = myFirstMicroserviceApplication.addNewFilm(film.getTitle(), film.getDescription(), film.getRelease_year(), film.getLanguage_id(), film.getOriginal_language_id(), film.getRental_duration(), film.getRental_rate(), film.getLength(), film.getReplacement_cost(), film.getRating(), film.getSpecial_features());

        ArgumentCaptor<Film> filmArguementCaptor = ArgumentCaptor.forClass(Film.class);

        verify(filmRepository).save(filmArguementCaptor.capture());
        filmArguementCaptor.getValue();

        Assertions.assertEquals(expected, Actual, "The Film was not saved successfully into the database");

    }

//    @Test
//    public void UpdateAFilm(){
//        Film f = new Film("Test", "Cool Film", 2006, 1, null, 5, 0.55f, 55, 15.99f, "PG", "Deleted scenes");
//        Optional<Film> optionalFilm = Optional.of(f);
//        Mockito.when(myFirstMicroserviceApplication.getAFilm(3)).thenReturn(optionalFilm);
//        Film a = new Film("Test2", "Cool Film2", 2007, 2, null, 6, 1.55f, 65, 25.99f, "R", "Trailers");
//        ResponseEntity result = myFirstMicroserviceApplication.updateFilm(3, a.getTitle(), a.getDescription());
//        ResponseEntity expected = ResponseEntity.ok(a);
//        Assertions.assertEquals(expected.getStatusCode(), result.getStatusCode(), "The film was not successfully updated");
//    }

    @Test
    public void testDeleteFilm(){
        final Film f = new Film("Test", "Cool Film", 1, null, 5, 5, 0.55f, 55, 15.99f, "PG", "Deleted scenes");
        Optional<Film> optionalFilm = Optional.of(f);
        Mockito.when(filmRepository.findById(1)).thenReturn(optionalFilm);
        String actual = myFirstMicroserviceApplication.deleteFilmById(1);
        Mockito.verify(filmRepository).delete(f);
        Assertions.assertEquals("Deleted", actual, "The film was not deleted successfully");

    }
}
