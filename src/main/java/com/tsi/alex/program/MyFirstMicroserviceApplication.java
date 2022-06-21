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

	@Autowired
	private FilmRepository filmRepository;

	public MyFirstMicroserviceApplication(ActorRepository actorRepository, CategoryRepository categoryRepository, LanguageRepository languageRepository, FilmRepository filmRepository){
		this.actorRepository = actorRepository;
		this.categoryRepository = categoryRepository;
		this.languageRepository = languageRepository;
		this.filmRepository = filmRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroserviceApplication.class, args);
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
		System.out.println(name);
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
		System.out.println(name);
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

	@GetMapping("/All_Films")
	public @ResponseBody
	Iterable<Film>getAllFilms(){
		return filmRepository.findAll();
	}

	@GetMapping("/Get_A_Film")
	public Optional<Film>getAFilm(@RequestParam Integer film_id){
		return filmRepository.findById(film_id);
	}

	@PostMapping("/Add_New_Film")
	public @ResponseBody String addNewFilm(@RequestParam String title, String description, int release_year, Language language_id, Integer original_language_id, int rental_duration, float rental_rate, int length, float replacement_cost, String rating, String special_features){
		Film f = new Film(title, description, release_year, language_id, original_language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features);
		filmRepository.save(f);
		return "saved";
	}

	@PutMapping("/Update_A_Film")
	public ResponseEntity<Film> updateFilm (@PathVariable("film_id")int fId, @RequestBody Film film) throws ResourceNotFoundException{
		Film f = filmRepository.findById(fId).orElseThrow(()-> new ResourceNotFoundException("Film not found for this ID :: "+ fId));
		f.setTitle(film.getTitle());
		f.setDescription(film.getDescription());
		f.setRelease_year(film.getRelease_year());
		f.setLanguage_id(film.getLanguage_id());
		f.setOriginal_language_id(film.getOriginal_language_id());
		f.setRental_duration(film.getRental_duration());
		f.setLength(film.getLength());
		f.setReplacement_cost(film.getReplacement_cost());
		f.setRating(film.getRating());
		f.setSpecial_features(film.getSpecial_features());
		filmRepository.save(f);
		return ResponseEntity.ok(f);
	}

	@DeleteMapping("/Delete_Film_By_Id")
	String deleteFilmById(@PathVariable("film_id") int fID) throws ResourceNotFoundException{
		Film f = filmRepository.findById(fID).orElseThrow( () -> new ResourceNotFoundException("Film not found for this ID :: " + fID));
		filmRepository.delete(f);
		return "Deleted";
	}
}
