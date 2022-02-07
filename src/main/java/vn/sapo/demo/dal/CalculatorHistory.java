package vn.sapo.demo.dal;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@Table(name = "calculator_histories")
public class CalculatorHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int firstNumber;
    private int secondNumber;
    private Operator operator;
    private int result;
    @CreationTimestamp
    private Instant createdAt;


    public enum Operator {PLUS, MINUS}
}
