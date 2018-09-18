package dev.top;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.top.entities.Collegue;
import dev.top.repos.CollegueRepo;

@Component
public class StartupDataInit {

	private CollegueRepo collRepo;

	public StartupDataInit(CollegueRepo collRepo) {
		super();
		this.collRepo = collRepo;
	}

	// on insere un jeu de données a chaque fois que l'appli est lancée par
	// init()
	@EventListener(ContextRefreshedEvent.class)
	public void init() {

		if (this.collRepo.count() <= 0) {

			this.collRepo.save(new Collegue("lana44", 100,
					"https://vignette.wikia.nocookie.net/loveinterest/images/9/9f/Lana_kane.jpg/revision/latest?cb=20140519224029"));

			this.collRepo.save(new Collegue("lana53", 100,
					"https://vignette.wikia.nocookie.net/loveinterest/images/9/9f/Lana_kane.jpg/revision/latest?cb=20140519224029"));
			/*
			 * /* this.versionRepo.save(new Version("v2"));
			 * this.versionRepo.save(new Version("v3"));
			 * this.versionRepo.save(new Version("v4"));
			 */
		}

	}
}
