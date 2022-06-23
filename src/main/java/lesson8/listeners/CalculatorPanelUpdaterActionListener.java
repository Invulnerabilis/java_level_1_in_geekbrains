package lesson8.listeners;

import lesson8.components.CalculatorPanel;
import lesson8.model.CalculatorModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorPanelUpdaterActionListener implements ActionListener {

    private final CalculatorPanel calculatorPanel;
    private final CalculatorModel model;

    public CalculatorPanelUpdaterActionListener(CalculatorModel model, CalculatorPanel calculatorPanel) {
        this.calculatorPanel = calculatorPanel;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        calculatorPanel.update(model);
    }
}
