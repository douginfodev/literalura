package com.douginfodev.literalura.literalura;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.douginfodev.literalura.view.UserInterface;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		UserInterface screenMenu = new UserInterface();
	    screenMenu.printMenu();
	}

}
