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
public class DeleteActorStepDef {
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

    int actor_ID;
    @Given("I have the actors ID")
    public void i_have_the_actors_id() {
        actor_ID=1;
    }
    String actual;
    @When("An Actor is deleted from the table")
    public void an_actor_is_deleted_from_the_table() {
        final Actor a = new Actor("Alex", "Ulpiani");
        Optional<Actor> optionalActor = Optional.of(a);
        Mockito.when(actorRepository.findById(actor_ID)).thenReturn(optionalActor);
        actual=myFirstMicroserviceApplication.deleteActorById(actor_ID);
    }
    String expected = "Deleted";
    @Then("I get the Deleted return string")
    public void i_get_the_deleted_return_string() {
        ArgumentCaptor<Actor>actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).delete(actorArgumentCaptor.capture());
        actorArgumentCaptor.getValue();
        Assertions.assertEquals(expected, actual);
    }


}
