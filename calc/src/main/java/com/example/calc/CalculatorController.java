package com.example.calc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {
    @FXML
    private TextField display;

    private double num1 = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    @FXML
    private void processDigit(ActionEvent event) {
        if (startNewNumber) {
            display.setText("");
            startNewNumber = false;
        }
        String digit = ((Button) event.getSource()).getText();
        display.setText(display.getText() + digit);
    }

    @FXML
    private void processOperator(ActionEvent event) {
        String currentOperator = ((Button) event.getSource()).getText();
        if (!operator.isEmpty() && !startNewNumber) {
            calculate();
        }
        operator = currentOperator;
        num1 = Double.parseDouble(display.getText());
        startNewNumber = true;
    }

    @FXML
    private void calculate() {
        double num2 = Double.parseDouble(display.getText());
        switch (operator) {
            case "+":
                display.setText(String.valueOf(num1 + num2));
                break;
            case "-":
                display.setText(String.valueOf(num1 - num2));
                break;
            case "*":
                display.setText(String.valueOf(num1 * num2));
                break;
            case "/":
                if (num2 == 0) {
                    display.setText("Ошибка");
                } else {
                    display.setText(String.valueOf(num1 / num2));
                }
                break;
        }
        startNewNumber = true;
        operator = "";
    }

    @FXML
    private void clear() {
        display.setText("0");
        num1 = 0;
        operator = "";
        startNewNumber = true;
    }
}