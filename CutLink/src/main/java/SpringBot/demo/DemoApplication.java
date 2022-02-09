package SpringBot.demo;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DemoApplication {
	public static JFrame mainFrame ;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		System.setProperty("java.awt.headless", "false");
//		SwingUtilities.invokeLater(() -> {
//		    UpLoad f =new UpLoad();
//		    f.setVisible(true); 
//		});
	}

}
