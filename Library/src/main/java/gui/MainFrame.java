package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private ToolBar toolBar;
    private TextPanel textPanel;
    private FormPanel formPanel;
    private TablePanel tablePanel;
    private Controller controller;


    public  MainFrame() {
        super("Minu Raamatukogu");
        setLayout(new BorderLayout());


        textPanel = new TextPanel();
        toolBar = new ToolBar();
        formPanel = new FormPanel();
        controller = new Controller();
        tablePanel = new TablePanel();
        tablePanel.setData(controller.getBooks());

        tablePanel.setBookTableListener(new BookTableListener() {
            public void rowDeleted(int row) {
                System.out.println(row);
                controller.removeBook(row);
            }
        });

        toolBar.setStringListener(new StringListener() {
            @Override
            public void textEmitted(String text) {
                textPanel.appendText(text);
            }
        });

        formPanel.setFormListener(new FormListener() {
            @Override
            public void formEventOccured(FormEvent e) {
                controller.addBook(e);
                tablePanel.refresh();
//                String pealkiri = e.getPealkiri();
//                String autor = e.getAutor();
//                String aasta = e.getAasta();
//                String zhanr = e.getZhanr();
//                String hinnang = e.getHinnang();
//                boolean laenutatud = e.isCheckBox();
//                String laenutaja = e.getLaenutaja();
//
//                textPanel.appendText(pealkiri + " " + "-" + " " + autor + " " + "-" + " " + aasta + " " + "-" + " " + zhanr + " " + "-" + " " + hinnang + " " + "-" + " " + laenutaja + "\n");

            }
        });

        add(tablePanel, BorderLayout.CENTER);
        //add(textPanel, BorderLayout.CENTER);
        add(toolBar, BorderLayout.NORTH);
        add(formPanel, BorderLayout.WEST);




        setSize(1200, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
