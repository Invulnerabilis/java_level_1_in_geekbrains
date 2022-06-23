package lesson8.components;

import lesson8.model.CalculatorModel;

import javax.swing.*;
import java.awt.*;

public class CalculatorPanel extends JLabel {
    public CalculatorPanel() {
        setFont(new Font("TimesRoman", Font.BOLD, 30));
        setForeground(new Color(70, 82, 93));
        setText(" 0 ");
    }

    public void update(CalculatorModel model) {
        String s = model.toString();
        setText(s.isEmpty() ? " 0 " : s);
    }
}
