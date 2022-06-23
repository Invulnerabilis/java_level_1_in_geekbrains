package lesson8.listeners;

import lesson8.components.CalculatorPanel;
import lesson8.model.CalculatorModel;

import java.awt.event.ActionEvent;

public class SymbolButtonActionListener extends CalculatorPanelUpdaterActionListener {

    private final CalculatorModel model;
    private final CalculatorModel.Symbol symbol;

    public SymbolButtonActionListener(CalculatorModel model, CalculatorPanel calculatorPanel, CalculatorModel.Symbol symbol) {
        super(model, calculatorPanel);
        this.model = model;
        this.symbol = symbol;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.addSymbol(symbol);
        super.actionPerformed(e);
    }
}
