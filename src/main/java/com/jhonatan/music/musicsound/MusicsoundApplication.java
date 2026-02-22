package com.jhonatan.music.musicsound;

import com.jhonatan.music.musicsound.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusicsoundApplication implements CommandLineRunner {
	private final Principal principal;
	public MusicsoundApplication(Principal principal) {
		this.principal = principal;
	}
	public static void main(String[] args) {
		SpringApplication.run(MusicsoundApplication.class, args);
	}
	@Override
	public void run(String... args) {
		principal.executar();
	}

}

