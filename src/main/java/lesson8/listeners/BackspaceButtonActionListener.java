package lesson8.listeners;

import lesson8.components.CalculatorPanel;
import lesson8.model.CalculatorModel;

import java.awt.event.ActionEvent;

public class BackspaceButtonActionListener extends CalculatorPanelUpdaterActionListener {

    private final CalculatorModel model;

    public BackspaceButtonActionListener(CalculatorModel model, CalculatorPanel calculatorPanel) {
        super(model, calculatorPanel);
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.removeLast();
        super.actionPerformed(e);
    }
}
