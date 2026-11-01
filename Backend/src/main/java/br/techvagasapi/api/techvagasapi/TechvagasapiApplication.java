package br.techvagasapi.api.techvagasapi;

import org.springframework.boot.SpringApplication; import org.springframework.boot.autoconfigure.SpringBootApplication; import org.springframework.boot.context.event.ApplicationReadyEvent; import org.springframework.context.event.EventListener;

@SpringBootApplication public class TechvagasapiApplication {

public static void main(String[] args) {
    SpringApplication.run(TechvagasapiApplication.class, args);
}

@EventListener(ApplicationReadyEvent.class)
public void abrirNavegador() {
    try {
    	String sistema = System.getProperty("os.name").toLowerCase();
    	
    	if (sistema.contains("linux")) {
            new ProcessBuilder("xdg-open", "http://localhost:8080/").start();

        } else if (sistema.contains("windows")) {
            new ProcessBuilder("cmd", "/c", "start", "", "http://localhost:8080/").start();

        } else if (sistema.contains("mac")) {
            new ProcessBuilder("open", "http://localhost:8080/").start();
        }

    } catch (Exception e) {
        System.out.println("Não foi possível abrir o navegador automaticamente.");
        e.printStackTrace();
    }
}

}