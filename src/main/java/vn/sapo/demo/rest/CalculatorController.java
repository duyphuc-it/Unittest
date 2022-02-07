package vn.sapo.demo.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.sapo.demo.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/plus")
    public CalculatorResponse plus(@RequestBody CalculatorRequest request) {
        var result = calculatorService.plus(request.getFirstNumber(), request.getSecondNumber());
        return new CalculatorResponse(result);
    }

}
