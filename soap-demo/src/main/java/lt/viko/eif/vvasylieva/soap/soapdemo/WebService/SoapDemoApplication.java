package lt.viko.eif.vvasylieva.soap.soapdemo.WebService;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "lt.viko.eif.vvasylieva.soap.soapdemo")
public class SoapDemoApplication {
//	@Bean
//	public ModelMapper modelMapper() {
//		return new ModelMapper();
//	}
	public static void main(String[] args) {
		SpringApplication.run(SoapDemoApplication.class, args);
	}
}
