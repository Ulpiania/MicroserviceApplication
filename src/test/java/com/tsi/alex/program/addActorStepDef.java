package com.tsi.alex.program;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
public class addActorStepDef {
    private static MyFirstMicroserviceApplication myFirstMicroserviceApplication;

    @Mock
    private static ActorRepository actorRepository;
    @Mock
    private static CategoryRepository categoryRepository;
    @Mock
    private static LanguageRepository languageRepository;
    @Mock
    private static FilmRepository filmRepository;

    @Before
    public static void init(){
        actorRepository=mock(ActorRepository.class);
        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication(actorRepository, categoryRepository, languageRepository, filmRepository);
    }

    String first_name;
    String last_name;
    @Given("I have the actors information")
    public void i_have_the_actors_information() {
        first_name = "Alex";
        last_name = "Ulpiani";

    }
    String actual;
    @When("I input the data into the database")
    public void i_input_the_data_into_the_database() {
        final Actor a = new Actor(first_name, last_name);
        Mockito.when(actorRepository.save(a)).thenThrow(IllegalStateException.class);
        actual = myFirstMicroserviceApplication.addNewActor(first_name, last_name);
    }

    String expected = "saved";
    @Then("I get the success return string")
    public void i_get_the_success_return_string() {
        ArgumentCaptor<Actor>actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        Assertions.assertEquals(expected, actual);
    }
}
