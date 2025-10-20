package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel extends JPanel {
    private JLabel pealkiriLabel;
    private JTextField pealkiriField;
    private JLabel autorLabel;
    private JTextField autorField;
    private JLabel aastaLabel;
    private JTextField aastaField;
    private JLabel hinnangLabel;
    private JComboBox hinnangCombobox;
    private JLabel zhanrLabel;
    private JComboBox zhanrCombobox;
    private JCheckBox checkBox;
    private JLabel laenutusLabel;
    private JTextField laenutajaField;
    private JButton okNupp;

    private FormListener listener;

    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        Border innerBorder = BorderFactory.createTitledBorder("Raamatu Lisamine");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        pealkiriLabel = new JLabel("Pealkiri: ");
        pealkiriField = new JTextField(10);
        autorLabel = new JLabel("Raamatu autor: ");
        autorField = new JTextField(10);
        aastaLabel = new JLabel("Trükiaasta: ");
        aastaField = new JTextField(10);
        zhanrLabel = new JLabel("Raamatu zhanr: ");
        zhanrCombobox = new JComboBox<>();
        hinnangLabel = new JLabel("Hinnang: ");
        hinnangCombobox = new JComboBox<>();
        checkBox = new JCheckBox();
        laenutusLabel = new JLabel("Laenutaja: ");
        laenutajaField = new JTextField(10);
        okNupp = new JButton("Salvesta");

        DefaultComboBoxModel kategooriaModel = new DefaultComboBoxModel<>();
        kategooriaModel.addElement("Lasteraamat");
        kategooriaModel.addElement("Õpik");
        kategooriaModel.addElement("Eneseabi");
        kategooriaModel.addElement("Kriminull");
        kategooriaModel.addElement("Põnevik");
        kategooriaModel.addElement("Luuleraamat");
        kategooriaModel.addElement("Muu");
        zhanrCombobox.setModel(kategooriaModel);
        zhanrCombobox.setSelectedIndex(0);

        DefaultComboBoxModel hinnangModel = new DefaultComboBoxModel<>();
        hinnangModel.addElement("Väga hea");
        hinnangModel.addElement("Hea");
        hinnangModel.addElement("Keskmine");
        hinnangModel.addElement("Halb");
        hinnangModel.addElement("Väga halb");
        hinnangCombobox.setModel(hinnangModel);
        hinnangCombobox.setSelectedIndex(0);

        laenutusLabel.setEnabled(false);
        laenutajaField.setEnabled(false);
        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isTicked = checkBox.isSelected();
                laenutusLabel.setEnabled(isTicked);
                laenutajaField.setEnabled(isTicked);
            }
        });

        okNupp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pealkiri = pealkiriField.getText();
                String autor = autorField.getText();
                String aasta = aastaField.getText();
                String zhanr = (String) zhanrCombobox.getSelectedItem();
                String hinnang = (String) hinnangCombobox.getSelectedItem();
                boolean laenutatud = checkBox.isSelected();
                String laenutaja = laenutajaField.getText();

                FormEvent ev = new FormEvent(this, pealkiri, autor, aasta, zhanr, hinnang, laenutatud, laenutaja);
                if (listener!=null) {
                    listener.formEventOccured(ev);
                }

            }
        });//okNupp ActionPerformed lõpp

        LayOutSettings();

    }//gui.FormPanel construction lõpp
    public void LayOutSettings() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        /// pealkirja rida ///
        //label
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(pealkiriLabel, gc);

        //textField
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(pealkiriField, gc);

        /// autor rida ///
        //label
        gc.gridx = 0;
        gc.gridy++;

        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(autorLabel, gc);

        //textField
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(autorField, gc);

        /// aasta rida ///
        //label
        gc.gridx = 0;
        gc.gridy++;

        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(aastaLabel, gc);

        //textField
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(aastaField, gc);

        /// zhanr rida ///
        //label
        gc.gridx = 0;
        gc.gridy++;

        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(zhanrLabel, gc);

        //textField
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(zhanrCombobox, gc);

        /// hinnang rida ///
        //label
        gc.gridx = 0;
        gc.gridy++;

        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(hinnangLabel, gc);

        //textField
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(hinnangCombobox, gc);

        /// checkBox rida ///
        //label
        gc.gridx = 0;
        gc.gridy++;

        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(new JLabel("Välja laenutatud: "), gc);

        //textField
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(checkBox, gc);

        /// laenutaja rida ///
        //label
        gc.gridx = 0;
        gc.gridy++;

        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(laenutusLabel, gc);

        //textField
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(laenutajaField, gc);

        /// okNupp rida ///
        gc.weighty = 1;
        gc.weightx = 1;
        gc.gridx = 1;
        gc.gridy++;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(okNupp, gc);

    }

    public void setFormListener(FormListener listener) {
        this.listener = listener;
    }

}//gui.FormPanel class lõpp

//class Rating {
//    private int id;
//    private String text;
//
//    public Rating(int id, String text) {
//        this.id = id;
//        this.text = text;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    @Override
//    public String toString() {
//        return text;
//    }
//}
