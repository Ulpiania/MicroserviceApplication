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
public class ReturnActorsByIDStepDef {
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

    int actor_id;
    @Given("I have the actors_ID")
    public void i_have_the_actors_id() {
        actor_id =  1;
    }
    String actual;
    @When("I Query the database using the ID")
    public void i_query_the_database_using_the_id() {
        final Actor a = new Actor("Alex", "Ulpiani");
        Optional<Actor> optionalActor = Optional.of(a);
        Mockito.when(actorRepository.findById(actor_id)).thenReturn(optionalActor);
        actual= String.valueOf(myFirstMicroserviceApplication.getAnActor(actor_id));
        System.out.println(actual);
    }

    String expected = "Alex Ulpiani";
    @Then("I get the corresponding actor to the ID returned")
    public void i_get_the_corresponding_actor_to_the_id_returned() {
//        ArgumentCaptor<Actor>actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
//        verify(actorRepository).findById(actorArgumentCaptor.capture());
//        actorArgumentCaptor.getValue();
//
//        Assertions.assertEquals(expected, actual);
    }
}
