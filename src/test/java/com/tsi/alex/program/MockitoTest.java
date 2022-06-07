package com.tsi.alex.program;

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

    @BeforeEach
    void setUp(){
        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication(actorRepository, categoryRepository);
    }

    @Test
    public void getAllActors(){
        myFirstMicroserviceApplication.getAllActors();
        verify(actorRepository).findAll();
    }

    @Test
    public void getAnActor(){
        myFirstMicroserviceApplication.getAnActor(199);
        verify(actorRepository).findById(199);
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
    public void testDeleteActor(){
        myFirstMicroserviceApplication.deleteActorById(199);
        verify(actorRepository, times(1)).deleteById(199);

    }
}