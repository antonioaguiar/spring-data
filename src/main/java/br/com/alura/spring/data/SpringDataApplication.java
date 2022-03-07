package br.com.alura.spring.data;

import br.com.alura.spring.data.model.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataApplication  implements CommandLineRunner {

	private final CargoRepository cargoRepository;

	public SpringDataApplication(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Cargo cargo1 = new Cargo();
		cargo1.setDescricao("DESCRIÇÃO DO CARGO");
		cargoRepository.save(cargo1);

		//
		cargoRepository.findAll().forEach(cargo -> {
			System.out.println(cargo.toString());
		});

	}
}
