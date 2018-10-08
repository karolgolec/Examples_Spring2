package pl.karolgolec.examples.scheduled.mains.bootstraps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@ComponentScan(value =  "pl.karolgolec.examples")
@EnableScheduling
@EnableJpaRepositories("pl.karolgolec.examples")
@EntityScan("pl.karolgolec.examples")
public class Bootstrap {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Bootstrap.class);
        Thread.sleep(600 * 1000);
    }
}
