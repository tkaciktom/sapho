package cz.tkacikt.test.sapho.piggyfier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:application-context.xml")
public class PiggyfierApplication implements CommandLineRunner {

	@Autowired
	private AppRunner appRunner;

	public static void main(String[] args) {
		SpringApplication.run(PiggyfierApplication.class, args);
	}

	@Override
	public void run(String... args) {
		appRunner.run(args);
	}

}
