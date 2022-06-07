package com.tsi.alex.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*")
@SpringBootApplication
@RestController  //handles GET, POST, DELETE, PUT requests
@RequestMapping("/Home")
public class MyFirstMicroserviceApplication {

	@Autowired
	private ActorRepository actorRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroserviceApplication.class, args);
	}

	public MyFirstMicroserviceApplication(ActorRepository actorRepository){
		this.actorRepository = actorRepository;
	}
	//@ResponseBody
	@PostMapping("/Add_New_Actor")
	public @ResponseBody String addNewActor(@RequestParam String first_name, @RequestParam String last_name){
		Actor a = new Actor(first_name, last_name);
		System.out.println(first_name + " " + last_name);
		actorRepository.save(a);
		return "saved";
	}

	//Get request / read function
	@GetMapping("/All_Actors")
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return actorRepository.findAll();
	}

	@DeleteMapping("/Delete_Actor_By_Id")
	public @ResponseBody
	void deleteActorById(@RequestParam int id){
		actorRepository.deleteById(id);
	}
}
