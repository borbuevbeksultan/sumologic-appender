package kg.iceknight.sumologicdemo.controller;

import kg.iceknight.sumologicdemo.model.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/api/sample")
public class SampleController {

    private static String message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum";

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> doPost() {
        Random random = new Random();
        Car car = new Car();
        car.setId(random.nextLong());
        car.setName(UUID.randomUUID().toString());
//        log.info(message);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

}
