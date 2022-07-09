package gosk.szymon;

import gosk.szymon.fetching.DataSource;
import gosk.szymon.services.LegacyFetchingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Duration;
import java.time.LocalDateTime;

@Slf4j
@SpringBootApplication
public class FetcherApiApplication {

    public static void main(String[] args) {
        log.debug("Starting application");
        SpringApplication.run(FetcherApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(LegacyFetchingService fetchingService) {
        return args -> {
            LocalDateTime t1 = LocalDateTime.now();
            System.out.println((fetchingService.fetch(DataSource.STOP)));
            LocalDateTime t2 = LocalDateTime.now();
            var dt = Duration.between(t1, t2).toSeconds();
            System.out.println(dt);
        };
    }

}
