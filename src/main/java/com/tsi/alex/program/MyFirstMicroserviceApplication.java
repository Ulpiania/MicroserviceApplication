package com.tsi.alex.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

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

	@PostMapping("/Add_New_Actor")
	public @ResponseBody String addNewUser (@RequestParam String first_name
			, @RequestParam String last_name){
		Actor a = new Actor();
		a.setFirst_name(first_name);
		a.setLast_name(last_name);
		actorRepository.save(a);
		return "Saved";
	}

	//Get request / read function
	@GetMapping("/All_Actors")
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return actorRepository.findAll();
	}
}
