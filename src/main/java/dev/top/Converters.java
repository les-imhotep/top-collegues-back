package dev.top;

import org.springframework.core.convert.converter.Converter;

import dev.top.entities.Collegue;
import dev.top.entities.CollegueWeb;

public class Converters {

	public static Converter<Collegue, CollegueWeb> converterCollegueToCollegueWeb = source -> {
		CollegueWeb collegueWeb = new CollegueWeb();

		collegueWeb.setPseudo(source.getPseudo());
		collegueWeb.setScore(source.getScore());
		collegueWeb.setPhoto(source.getPhoto());

		return collegueWeb;
	};

	public static Converter<CollegueWeb, Collegue> converterCollegueWebToCollegue = source -> {
		Collegue collRepo = new Collegue();

		collRepo.setPseudo(source.getPseudo());
		collRepo.setScore(source.getScore());
		collRepo.setPhoto(source.getPhoto());

		return collRepo;
	};

}
