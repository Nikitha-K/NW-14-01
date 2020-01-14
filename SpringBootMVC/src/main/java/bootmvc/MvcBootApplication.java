package bootmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(basePackages = {"sample","bootmvc"})
public class MvcBootApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(MvcBootApplication.class,args);

		
	}

}
