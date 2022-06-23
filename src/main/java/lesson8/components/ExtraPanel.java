package lesson8.components;

import lesson8.listeners.BackspaceButtonActionListener;
import lesson8.listeners.CalculatorPanelUpdaterActionListener;
import lesson8.listeners.ClearButtonActionListener;
import lesson8.model.CalculatorModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ExtraPanel extends JPanel {
    public ExtraPanel(CalculatorModel model, CalculatorPanel panel) {
        setLayout(new GridLayout(2, 1));

        JButton clear = ButtonFactory.createOperatorButton("C");
        add(clear);
        clear.addActionListener(new CalculatorPanelUpdaterActionListener(model, panel) {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.clear();
                super.actionPerformed(e);
            }
        });

        JButton backward = ButtonFactory.createOperatorButton("←");
        add(backward);
        backward.addActionListener(new CalculatorPanelUpdaterActionListener(model, panel) {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.removeLast();
                super.actionPerformed(e);
            }
        });
    }
}
