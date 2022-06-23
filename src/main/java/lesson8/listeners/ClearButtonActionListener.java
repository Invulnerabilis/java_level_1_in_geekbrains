package lesson8.listeners;

import lesson8.components.CalculatorPanel;
import lesson8.model.CalculatorModel;

import java.awt.event.ActionEvent;

public class ClearButtonActionListener extends CalculatorPanelUpdaterActionListener {

    private final CalculatorModel model;

    public ClearButtonActionListener(CalculatorModel model, CalculatorPanel calculatorPanel) {
        super(model, calculatorPanel);
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.clear();
        super.actionPerformed(e);
    }
}
