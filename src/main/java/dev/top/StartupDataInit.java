package dev.top;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.top.entities.Version;
import dev.top.repos.VersionRepo;

@Component
public class StartupDataInit {

	// bonne pratique : plutot utiliser le constructeur et non faire l'injection
	// sur le champ qui est privé (compliqué pour les tests unitaires)
	@Autowired
	private VersionRepo versionRepo;

	// on insere un jeu de données a chaque fois que l'appli est lancée par
	// init()
	@EventListener(ContextRefreshedEvent.class)
	public void init() {

		if (this.versionRepo.count() <= 0) {
			this.versionRepo.save(new Version("v1"));
			this.versionRepo.save(new Version("v2"));
			this.versionRepo.save(new Version("v3"));
			this.versionRepo.save(new Version("v4"));
		}

	}
}
