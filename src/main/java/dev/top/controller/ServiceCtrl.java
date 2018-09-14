package dev.top.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.top.entities.Collegue;
import dev.top.repos.CollegueRepo;

@RestController()
@RequestMapping("/collegues")
public class ServiceCtrl {

	private CollegueRepo collRepo;

	public ServiceCtrl(CollegueRepo collRepo) {
		super();
		this.collRepo = collRepo;
	}

	@GetMapping
	public List<Collegue> findAll() {
		return this.collRepo.findAll();
	}

	/*
	 * @PostMapping public ResponseEntity<?> creerPizza(@RequestBody Pizza
	 * pizza) { this.pizzaRepo.save(pizza); return
	 * ResponseEntity.status(HttpStatus.CREATED).build(); }
	 */

}
