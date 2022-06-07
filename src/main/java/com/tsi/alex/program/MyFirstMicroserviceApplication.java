package com.tsi.alex.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//@CrossOrigin(origins="*")
@SpringBootApplication
@RestController  //handles GET, POST, DELETE, PUT requests
@RequestMapping("/Home")
public class MyFirstMicroserviceApplication {

	@Autowired
	private ActorRepository actorRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroserviceApplication.class, args);
	}

	public MyFirstMicroserviceApplication(ActorRepository actorRepository, CategoryRepository categoryRepository){
		this.actorRepository = actorRepository;
	}

	//Get request / read function
	@GetMapping("/All_Actors")
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return actorRepository.findAll();
	}

	@GetMapping("/Get_An_Actor")
	public Optional<Actor>getAnActor(@RequestParam Integer actor_id){
		return actorRepository.findById(actor_id);
	}

	@PostMapping("/Add_New_Actor")
	public @ResponseBody String addNewActor(@RequestParam String first_name, @RequestParam String last_name){
		Actor a = new Actor(first_name, last_name);
		System.out.println(first_name + " " + last_name);
		actorRepository.save(a);
		return "saved";
	}

	@PutMapping("/Update_An_Actor")
	public ResponseEntity<Actor> String (@RequestParam int actor_id, String first_name, String last_name){
		Actor a = actorRepository.findById(actor_id).orElseThrow();
		a.setFirst_name(first_name);
		a.setLast_name(last_name);
		actorRepository.save(a);
		return ResponseEntity.ok(a);
	}

	@DeleteMapping("/Delete_Actor_By_Id")
	public @ResponseBody
	void deleteActorById(@RequestParam int actor_id){
		actorRepository.deleteById(actor_id);
	}

	//Get request / read function
	@GetMapping("/All_Categories")
	public @ResponseBody
	Iterable<Category>getAllCategories(){
		return categoryRepository.findAll();
	}

	@PostMapping("/Add_New_Category")
	public @ResponseBody String addNewCategory(@RequestParam String name){
		Category c = new Category(name);
		categoryRepository.save(c);
		return "saved";
	}

	@DeleteMapping("/Delete_Category_By_Id")
	public @ResponseBody
	void deleteCategoryById(@RequestParam int category_id){
		categoryRepository.deleteById(category_id);
	}
}
