package lesson8.components;

import javax.swing.*;
import java.awt.*;

public class ButtonFactory {
    public static JButton createNumberButton(String label) {
        return createButton(label,
                new Font("TimesRoman", Font.PLAIN, 30),
                new Color(180, 202, 232));
    }

    public static JButton createOperatorButton(String label) {
        return createButton(label,
                new Font("TimesRoman", Font.BOLD, 30),
                new Color(172, 210, 252));
    }

    private static JButton createButton(String label, Font font, Color color) {
        JButton button = new JButton(label);
        button.setFont(font);
        button.setBackground(color);
        return button;
    }
}
