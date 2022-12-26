package com.midgard.tyr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class TyrApplication {

	public static void main(String[] args) {
		SpringApplication.run(TyrApplication.class, args);

		//Startup Chrome browser
		startup();
	}

	public static void startup() {
		Runtime rt = Runtime.getRuntime();
		try {
			rt.exec("cmd /c start chrome.exe http://localhost:8080/hello");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
