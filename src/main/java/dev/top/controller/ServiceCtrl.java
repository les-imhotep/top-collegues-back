package dev.top.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.top.entities.Avis;
import dev.top.entities.AvisView;
import dev.top.entities.Collegue;
import dev.top.repos.CollegueRepo;

@CrossOrigin
@RestController()
@RequestMapping("/collegues")
public class ServiceCtrl {

	private CollegueRepo collRepo;

	public ServiceCtrl(CollegueRepo collRepo) {
		super();
		this.collRepo = collRepo;
	}

	// *************************************GET***********************************************

	// Exposer le service GET /collegues qui récupère la liste des collègues au
	// format JSON
	@GetMapping
	public List<Collegue> findAll() {
		return this.collRepo.findAll();
	}

	// *************************************PATCH***********************************************

	// Exposer un service PATCH /collegues/PSEUDO/ qui permet de mettre à jour
	// le score d'un collègue
	@PatchMapping("/{pseudo}")
	public @ResponseBody ResponseEntity<Collegue> patch(@PathVariable String pseudo, @RequestBody AvisView avis) {

		Collegue updatedScore = new Collegue();

		// L'action AIMER incrémente le score de 10 points
		if (Avis.AIMER.equals(avis.getAction())) {
			Integer score = collRepo.findByPseudo(pseudo).getScore() + 10;
			updatedScore = collRepo.findByPseudo(pseudo);
			updatedScore.setScore(score);
		}

		// L'action DETESTER décrémente le score de 5 points.
		if (Avis.DETESTER.equals(avis.getAction())) {
			Integer score = collRepo.findByPseudo(pseudo).getScore() - 5;
			updatedScore = collRepo.findByPseudo(pseudo);
			updatedScore.setScore(score);
		}

		// on va sauvegarder le collègue avec le score updated
		collRepo.save(updatedScore);
		return new ResponseEntity<Collegue>(collRepo.findByPseudo(pseudo), HttpStatus.OK);
	}

	// *************************************POST************************************************
	/*
	 * @PostMapping public ResponseEntity<?> creerPizza(@RequestBody Pizza
	 * pizza) { this.pizzaRepo.save(pizza); return
	 * ResponseEntity.status(HttpStatus.CREATED).build(); }
	 */
}