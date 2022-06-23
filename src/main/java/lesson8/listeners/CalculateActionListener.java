package lesson8.listeners;

import lesson8.components.CalculatorPanel;
import lesson8.model.CalculatorModel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CalculateActionListener extends CalculatorPanelUpdaterActionListener {
    private final CalculatorModel model;
    private final JFrame frame;

    public CalculateActionListener(CalculatorModel model, CalculatorPanel calculatorPanel, JFrame frame) {
        super(model, calculatorPanel);
        this.model = model;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            CalculatorModel.OperationData operationData = model.getOperationData();
            double result = switch (operationData.operation()) {
                case plus -> operationData.leftNumber() + operationData.rightNumber();
                case minus -> operationData.leftNumber() - operationData.rightNumber();
                case multiply -> operationData.leftNumber() * operationData.rightNumber();
                case divide -> operationData.leftNumber() / operationData.rightNumber();
                default -> throw new IllegalStateException();
            };
            if (Double.isFinite(result)) {
                model.setNumber(result);
            } else {
                JOptionPane.showMessageDialog(frame, "Произошла арифметическая ошибка!");
            }
        } catch (IllegalStateException exception) {
            JOptionPane.showMessageDialog(frame, "Ошибка в выражении:\n" + exception.getMessage());
        }


        super.actionPerformed(e);
    }
}
