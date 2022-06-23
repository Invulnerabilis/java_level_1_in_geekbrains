package lesson8;

import lesson8.components.CalculatorPanel;
import lesson8.components.DigitsPanel;
import lesson8.components.ExtraPanel;
import lesson8.components.OperatorsPanel;
import lesson8.model.CalculatorModel;

import javax.swing.*;
import java.awt.*;

public class ApplicationForms extends JFrame {

    public ApplicationForms(String title) throws HeadlessException {
        super(title);
        setBounds(1000, 150, 350, 420);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        CalculatorModel model = new CalculatorModel();
        CalculatorPanel panel = new CalculatorPanel();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(new Color(202, 225, 238));

        JMenu menuFile = new JMenu("File");
        menuBar.add(menuFile);

        JMenuItem clearItem = menuFile.add(new JMenuItem("Clear"));
        clearItem.addActionListener(e -> {
            model.clear();
            panel.update(model);
        });

        JMenuItem aboutItem = menuFile.add(new JMenuItem("About"));
        aboutItem.addActionListener(e ->
                JOptionPane.showMessageDialog(this,
                        "This calculator was developed\nby Vitali Klepchinov"));

        JMenuItem exitItem = menuFile.add(new JMenuItem("Exit"));
        exitItem.addActionListener(e -> System.exit(0));

        setLayout(new BorderLayout());

        add(panel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        centerPanel.add(new DigitsPanel(model, panel, this), BorderLayout.CENTER);
        centerPanel.add(new OperatorsPanel(model, panel), BorderLayout.WEST);
        centerPanel.add(new ExtraPanel(model, panel), BorderLayout.EAST);
        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}
