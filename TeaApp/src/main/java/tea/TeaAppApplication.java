package tea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ActiveProfiles;

import app.util.ConfigProfil;

@SpringBootApplication
@ActiveProfiles(ConfigProfil.DEV)
public class TeaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeaAppApplication.class, args);
	}
}
