package indi.axikuazei.pigletter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author axikuazei
 * @date 2020/9/17 下午3:59
 */

@SpringBootApplication
@RestController
public class PigletterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PigletterApplication.class, args);
    }




}
