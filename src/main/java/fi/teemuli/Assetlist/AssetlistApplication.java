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
import fi.teemuli.Assetlist.domain.User;
import fi.teemuli.Assetlist.domain.UserRepository;


@SpringBootApplication
public class AssetlistApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssetlistApplication.class, args);
	}
	
	//Using CommandLineRunner to have some data in demo database
	@Bean
	public CommandLineRunner assetdemo(AssetRepository arepository, CategoryRepository crepository, EmployeeRepository erepository, UserRepository urepository) {
		return (args) -> {
			
			//Add few employee
			erepository.save(new Employee("Maija", "Meikäläinen", "maija@example.com", "0401234567"));
			erepository.save(new Employee("Matti", "Mallikas", "ma.ma@example.com", "0509873246"));
			erepository.save(new Employee("Pertti", "Testikammoinen", "pete@example.com", "0409874563"));
			
			//Add some categories
			crepository.save(new Category("Laptop"));
			crepository.save(new Category("Mobile"));
			crepository.save(new Category("Laptop accessories"));
			
			//Add some assets
			arepository.save(new Asset("Y720", "Lenovo", "12345678912345", crepository.findByName("Laptop").get(0), erepository.findByPhone("0401234567").get(0)));
			arepository.save(new Asset("ThinkPad", "Lenovo", "98765432112345", crepository.findByName("Laptop").get(0), erepository.findByPhone("0409874563").get(0)));
			arepository.save(new Asset("iPhone 12 pro", "Apple", "abp1234598765", crepository.findByName("Mobile").get(0), erepository.findByPhone("0409874563").get(0)));
			arepository.save(new Asset("Lumia 5", "Nokia", "fi8902412413", crepository.findByName("Mobile").get(0), erepository.findByPhone("0509873246").get(0)));
			arepository.save(new Asset("Flatron MD2262", "LG", "6543217890", crepository.findByName("Laptop accessories").get(0), erepository.findByPhone("0401234567").get(0)));
			
			//Create users "admin/admin", "user/user" & "hrdept/hrdept"
			//Role Admin can do everything, role user can only view list and role HR can add new employees
			urepository.save(new User("admin","$2a$10$3Z3F8VaNZ.2xynPhTascI.4orEaNN6UTp7pjT3I5uISQDiRJju7zm", "admin@example.com", "ADMIN"));
			urepository.save(new User("user","$2a$10$R30xQXgJyfZ31VT4yI.mJeAPn2AY.t2La/GWf9KmPbzfMMs/Ub6j2", "user@example.com", "USER"));
			urepository.save(new User("hrdept","$2a$10$Bq7r2AE.xT9osV1t6kpqBeViMChzroOqBYjP5uFe7tZghZ7T4LlDS", "hr@example.com", "HR"));
			
		};
	}

}