package vn.sapo.demo.rest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CalculatorResponse {

    private int result;

    public CalculatorResponse(int result) {
        this.result = result;
    }

}
