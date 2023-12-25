package calculator.calculatordemo.controller;

import calculator.calculatordemo.CalculatordemoApplication;
import calculator.calculatordemo.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.CalculatorService;

@RestController
public class CalculatorController {

    private final CalculatorService service;

    public CalculatorController(CalculatorService service) {
        this.service = service;
    }

    @GetMapping("/calculator")
    public String hello() {
        return "Калькулируйте на здоровье";
    }

    // /calculator/plus?num1=5&num2=5
    @GetMapping("/calculator/plus")
    public String plus(@RequestParam int num1, @RequestParam int num2) {
        return num1 + " + " + num2 + " = " + service.plus(num1, num2);
    }
    @GetMapping("/calculator/minus")
    public String minus(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "Один из аргументов не передан!";
        }
        return num1 + " + " + num2 + " = " + service.minus(num1, num2);
    }
    @GetMapping("/calculator/multiply")
    public String multiply(@RequestParam int num1, @RequestParam int num2) {
        return num1 + " * " + num2 + " = " + service.multiply(num1, num2);
    }
    @GetMapping("/calculator/divide")
    public String division(@RequestParam int num1, @RequestParam int num2) {
        if (num2 == 0) {
            return "На 0 делить нельзя!";
        }
        return num1 + " / " + num2 + " = " + service.divide(num1, num2);
    }
}

