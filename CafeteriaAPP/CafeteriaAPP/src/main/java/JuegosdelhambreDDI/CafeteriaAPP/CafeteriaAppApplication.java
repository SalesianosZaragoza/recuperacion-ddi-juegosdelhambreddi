package JuegosdelhambreDDI.CafeteriaAPP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories // habilita los repositorios de JPA
@EntityScan
public class CafeteriaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CafeteriaAppApplication.class, args);
	}

}
