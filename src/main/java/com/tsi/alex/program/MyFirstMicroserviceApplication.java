package com.tsi.alex.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;




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

	@Autowired
	private LanguageRepository languageRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroserviceApplication.class, args);
	}

	public MyFirstMicroserviceApplication(ActorRepository actorRepository, CategoryRepository categoryRepository, LanguageRepository languageRepository){
		this.actorRepository = actorRepository;
		this.categoryRepository = categoryRepository;
		this.languageRepository = languageRepository;
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
	public ResponseEntity<Actor> UpdateActor (@RequestParam int actor_id, String first_name, String last_name)throws ResourceNotFoundException{
		Actor a = actorRepository.findById(actor_id).orElseThrow(()-> new ResourceNotFoundException("Employee not found for this ID :: "+ actor_id));
		a.setFirst_name(first_name);
		a.setLast_name(last_name);
		actorRepository.save(a);
		return ResponseEntity.ok(a);
	}

	@DeleteMapping("/Delete_Actor_By_Id")
	public
	String deleteActorById(@PathVariable("actor_id") int aID) throws ResourceNotFoundException{
		Actor a = actorRepository.findById(aID).orElseThrow( () -> new ResourceNotFoundException("Actor not found for this ID :: " + aID));
		actorRepository.delete(a);
		return "Deleted";
	}

	//Get request / read function
	@GetMapping("/All_Categories")
	public @ResponseBody
	Iterable<Category>getAllCategories(){
		return categoryRepository.findAll();
	}

	@GetMapping("/Get_A_Category")
	public Optional<Category>getACategory(@RequestParam Integer category_id){
		return categoryRepository.findById(category_id);
	}

	@PostMapping("/Add_New_Category")
	public @ResponseBody String addNewCategory(@RequestParam String name){
		Category c = new Category(name);
		categoryRepository.save(c);
		return "saved";
	}

	@PutMapping("/Update_A_Category")
	public ResponseEntity<Category> updateCategory (@RequestParam int category_id, String name)throws ResourceNotFoundException{
		Category c = categoryRepository.findById(category_id).orElseThrow(()-> new ResourceNotFoundException("Category not found for this ID :: "+ category_id));
		c.setName(name);
		categoryRepository.save(c);
		return ResponseEntity.ok(c);
	}

	@DeleteMapping("/Delete_Category_By_Id")
	String deleteCategoryById(@PathVariable("category_id") int cID) throws ResourceNotFoundException{
		Category c = categoryRepository.findById(cID).orElseThrow( () -> new ResourceNotFoundException("Category not found for this ID :: " + cID));
		categoryRepository.delete(c);
		return "Deleted";
	}

	@GetMapping("/All_Languages")
	public @ResponseBody
	Iterable<Language>getAllLanguages(){
		return languageRepository.findAll();
	}

	@GetMapping("/Get_A_Language")
	public Optional<Language>getALanguage(@RequestParam Integer language_id){
		return languageRepository.findById(language_id);
	}

	@PostMapping("/Add_New_Language")
	public @ResponseBody String addNewLanguage(@RequestParam String name){
		Language l = new Language(name);
		languageRepository.save(l);
		return "saved";
	}

	@PutMapping("/Update_A_Language")
	public ResponseEntity<Language> updateLanguage (@RequestParam int language_id, String name)throws ResourceNotFoundException{
		Language l = languageRepository.findById(language_id).orElseThrow(()-> new ResourceNotFoundException("Language not found for this ID :: "+ language_id));
		l.setName(name);
		languageRepository.save(l);
		return ResponseEntity.ok(l);
	}

	@DeleteMapping("/Delete_Language_By_Id")
	String deleteLanguageById(@PathVariable("language_id") int lID) throws ResourceNotFoundException{
		Language l = languageRepository.findById(lID).orElseThrow( () -> new ResourceNotFoundException("Language not found for this ID :: " + lID));
		languageRepository.delete(l);
		return "Deleted";
	}
}
