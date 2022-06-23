package lesson8.components;

import lesson8.listeners.SymbolButtonActionListener;
import lesson8.model.CalculatorModel;

import javax.swing.*;
import java.awt.*;

public class OperatorsPanel extends JPanel {
    public OperatorsPanel(CalculatorModel model, CalculatorPanel panel) {
        setLayout(new GridLayout(4, 1));

        CalculatorModel.Symbol[] operators = {
                CalculatorModel.Symbol.minus,
                CalculatorModel.Symbol.plus,
                CalculatorModel.Symbol.multiply,
                CalculatorModel.Symbol.divide,
        };

        for (CalculatorModel.Symbol operator : operators) {
            JButton button = ButtonFactory.createOperatorButton(String.valueOf(CalculatorModel.toChar(operator)));
            button.addActionListener(new SymbolButtonActionListener(model, panel, operator));
            add(button);
        }
    }
}
