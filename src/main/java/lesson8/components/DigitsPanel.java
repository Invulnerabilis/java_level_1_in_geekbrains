package lesson8.components;

import lesson8.listeners.CalculateActionListener;
import lesson8.listeners.SymbolButtonActionListener;
import lesson8.model.CalculatorModel;

import javax.swing.*;
import java.awt.*;

public class DigitsPanel extends JPanel {
    public DigitsPanel(CalculatorModel model, CalculatorPanel panel, JFrame frame) {
        setLayout(new GridLayout(4, 3));

        CalculatorModel.Symbol[] digitsOnGrid = {
                CalculatorModel.Symbol.one,
                CalculatorModel.Symbol.two,
                CalculatorModel.Symbol.three,
                CalculatorModel.Symbol.four,
                CalculatorModel.Symbol.five,
                CalculatorModel.Symbol.six,
                CalculatorModel.Symbol.seven,
                CalculatorModel.Symbol.eight,
                CalculatorModel.Symbol.nine,
                CalculatorModel.Symbol.zero,
                CalculatorModel.Symbol.dot,
        };

        for (CalculatorModel.Symbol buttonSymbol : digitsOnGrid) {
            JButton btn = ButtonFactory.createNumberButton(String.valueOf(CalculatorModel.toChar(buttonSymbol)));
            btn.addActionListener(new SymbolButtonActionListener(model, panel, buttonSymbol));
            add(btn);
        }

        JButton calc = ButtonFactory.createOperatorButton("=");
        calc.addActionListener(new CalculateActionListener(model, panel, frame));
        add(calc);
    }
}
