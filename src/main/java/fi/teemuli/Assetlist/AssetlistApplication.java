package fi.teemuli.Assetlist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.teemuli.Assetlist.domain.Asset;
import fi.teemuli.Assetlist.domain.AssetRepository;
import fi.teemuli.Assetlist.domain.Category;
import fi.teemuli.Assetlist.domain.CategoryRepository;
import fi.teemuli.Assetlist.domain.Employee;
import fi.teemuli.Assetlist.domain.EmployeeRepository;


@SpringBootApplication
public class AssetlistApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssetlistApplication.class, args);
	}
	
	//Using CommandLineRunner to have some data in demo database
	@Bean
	public CommandLineRunner assetdemo(AssetRepository arepository, CategoryRepository crepository, EmployeeRepository erepository) {
		return (args) -> {
			
			//Add few employee
			erepository.save(new Employee("Maija", "Meikäläinen", "maija@example.com", "0400123456"));
			erepository.save(new Employee("Matti", "Mallikas", "ma.ma@example.com", "0501245789317"));
			erepository.save(new Employee("Pertti", "Testikammoinen", "pete@example.com", "040321456987"));
			
			//Add some categories
			crepository.save(new Category("Laptop"));
			crepository.save(new Category("Mobile"));
			crepository.save(new Category("Laptop accessories"));
			
			//Add some assets
			arepository.save(new Asset("Y720", "Lenovo", "12345678912345", crepository.findByName("Laptop").get(0), erepository.findByEmail("maija@example.com").get(0)));
			arepository.save(new Asset("ThinkPad", "Lenovo", "98765432112345", crepository.findByName("Laptop").get(0), erepository.findByEmail("pete@example.com").get(0)));
			arepository.save(new Asset("iPhone 12 pro", "Apple", "abp1234598765", crepository.findByName("Mobile").get(0), erepository.findByEmail("pete@example.com").get(0)));
			arepository.save(new Asset("Lumia 5", "Nokia", "fi8902412413", crepository.findByName("Mobile").get(0), erepository.findByEmail("ma.ma@example.com").get(0)));
			arepository.save(new Asset("Flatron MD2262", "LG", "6543217890", crepository.findByName("Laptop accessories").get(0), erepository.findByEmail("maija@example.com").get(0)));
			
		};
	}

}
