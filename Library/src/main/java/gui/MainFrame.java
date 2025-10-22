package gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private ToolBar toolBar;
    private TextPanel textPanel;
    private FormPanel formPanel;


    public  MainFrame() {
        super("Minu Raamatukogu");
        setLayout(new BorderLayout());


        textPanel = new TextPanel();
        toolBar = new ToolBar();
        formPanel = new FormPanel();

        toolBar.setStringListener(new StringListener() {
            @Override
            public void textEmitted(String text) {
                textPanel.appendText(text);
            }
        });


        add(textPanel, BorderLayout.CENTER);
        add(toolBar, BorderLayout.NORTH);
        add(formPanel, BorderLayout.WEST);




        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
