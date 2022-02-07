package vn.sapo.demo;

import org.springframework.stereotype.Service;
import vn.sapo.demo.dal.CalculatorHistory;
import vn.sapo.demo.dal.CalculatorHistoryRepository;

@Service
public class CalculatorService {

    private final CacheService cacheService;
    private final CalculatorHistoryRepository calculatorHistoryRepository;

    public CalculatorService(CacheService cacheService,
                             CalculatorHistoryRepository calculatorHistoryRepository) {
        this.cacheService = cacheService;
        this.calculatorHistoryRepository = calculatorHistoryRepository;
    }

    public int plus(int firstNumber, int secondNumber) {
        var cacheKey = firstNumber + "_plus_" + secondNumber;
        var data = cacheService.get(cacheKey);
        if (data != null) {
            saveHistory(firstNumber, secondNumber, data);
            return data;
        }

        var result = firstNumber + secondNumber;

        saveHistory(firstNumber, secondNumber, result);
        cacheService.set(cacheKey, result);
        return result;
    }

    private void saveHistory(int firstNumber, int secondNumber, int result) {
        var history = new CalculatorHistory();
        history.setFirstNumber(firstNumber);
        history.setSecondNumber(secondNumber);
        history.setOperator(CalculatorHistory.Operator.PLUS);
        history.setResult(result);
        calculatorHistoryRepository.save(history);
    }

}
