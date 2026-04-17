package com.rsproject.your_punchbread;

import jakarta.annotation.PostConstruct; // Import this
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.TimeZone; // Import this

@SpringBootApplication
public class YourPunchbreadApplication {

	@PostConstruct
	public void init() {
		// This forces the entire app to use Myanmar Time (+6:30)
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Yangon"));
	}

	public static void main(String[] args) {
		SpringApplication.run(YourPunchbreadApplication.class, args);
	}
}