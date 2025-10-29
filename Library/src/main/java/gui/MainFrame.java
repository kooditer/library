package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private ToolBar toolBar;
    private TextPanel textPanel;
    private FormPanel formPanel;
    private Controller controller;
    private TablePanel tablePanel;


    public  MainFrame() {
        super("Minu Raamatukogu");
        setLayout(new BorderLayout());


        textPanel = new TextPanel();
        toolBar = new ToolBar();
        formPanel = new FormPanel();
        controller = new Controller();
        tablePanel = new TablePanel();
        tablePanel.setData(controller.getRaamatud());

        toolBar.setStringListener(new StringListener() {
            @Override
            public void textEmitted(String text) {
                textPanel.appendText(text);
            }
        });

        tablePanel.setBookTableListener(new BookTableListener() {
            @Override
            public void rowDeleted(int row) {
                System.out.println(row);
                controller.removeRaamat(row);

            }
        });

        formPanel.setFormListener(new FormListener() {
            @Override
            public void formEventOccured(FormEvent e) {
                controller.addRaamat(e);
                tablePanel.refresh();
//                String pealkiri = e.getPealkiri();
//                String autor = e.getAutor();
//                String aasta = e.getAasta();
//                String zhanr = e.getZhanr();
//                boolean laenutatud = e.isLaenutatud();
//                String laenutaja = e.getLaenutaja();
//
//                textPanel.appendText(pealkiri + aasta);
            }
        });


        //add(textPanel, BorderLayout.CENTER);
        add(tablePanel, BorderLayout.CENTER);
        add(toolBar, BorderLayout.NORTH);
        add(formPanel, BorderLayout.WEST);




        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
