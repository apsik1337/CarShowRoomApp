package com.alex.controller.rest;

import com.alex.dto.ParametersDto;
import com.alex.dto.UserDto;
import com.alex.model.Car;
import com.alex.model.Parameters;
import com.alex.model.User;
import com.alex.service.CarService;
import com.alex.service.UserService;
import com.alex.util.RestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Alexandr Chesnokov
 * @project CarShowRoomApp
 */

@RestController
@RequestMapping(value = "/api/")
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    CarService carService;

    @Autowired
    RestValidator validator;


    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getCars() {

        return new ResponseEntity<>(carService.showAllCars(), HttpStatus.OK);
    }

    @GetMapping("/cars/{maker}")
    public ResponseEntity<List<Car>> getCarsByMaker(@PathVariable(name = "maker") String maker) {

        List<Car> cars = carService.findCarByMaker(maker);
        if (!cars.isEmpty()) {
            return new ResponseEntity<>(carService.findCarByMaker(maker), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(carService.findCarByMaker(maker), HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(value = "/cars/adv-search", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> searchCars(@RequestBody ParametersDto prm) {

        String validateResult = validator.carParamsValidate(prm);
        if (!validateResult.equals("ok")) {
            return new ResponseEntity<>(validateResult, HttpStatus.BAD_REQUEST);
        }

        List<Car> cars = carService.findCarByParams(prm.toParameters());

        if (cars.isEmpty()) {
            return new ResponseEntity<>(carService.findCarByParams(prm.toParameters()), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(carService.findCarByParams(prm.toParameters()), HttpStatus.OK);

    }

}