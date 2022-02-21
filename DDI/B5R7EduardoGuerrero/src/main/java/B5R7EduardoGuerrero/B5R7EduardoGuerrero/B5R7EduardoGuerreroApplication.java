package B5R7EduardoGuerrero.B5R7EduardoGuerrero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class B5R7EduardoGuerreroApplication  extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(B5R7EduardoGuerreroApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(B5R7EduardoGuerreroApplication.class, args);
	}

}