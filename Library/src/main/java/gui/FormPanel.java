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
    private JComboBox zhanrCombo;
    private JCheckBox checkBox;
    private JLabel laenutajaLabel;
    private JTextField laenutajaField;
    private JButton okBtn;

    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);
        Border innerBorder = BorderFactory.createTitledBorder("Raamatu sisestamine");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        pealkiriLabel = new JLabel("Pealkiri: ");
        pealkiriField = new JTextField(10);
        autorLabel = new JLabel("Autor: ");
        autorField = new JTextField(10);
        aastaLabel = new JLabel("Aasta: ");
        aastaField = new JTextField(10);
        zhanrCombo = new JComboBox<>();
        laenutajaLabel = new JLabel("Laenutaja: ");
        laenutajaField = new JTextField(10);
        checkBox = new JCheckBox();
        okBtn = new JButton("Sisesta");

        DefaultComboBoxModel comboModel = new DefaultComboBoxModel<>();
        comboModel.addElement("Õpik");
        comboModel.addElement("Elulugu");
        comboModel.addElement("Kriminull");
        zhanrCombo.setModel(comboModel);
        zhanrCombo.setSelectedIndex(1);

        laenutajaLabel.setEnabled(false);
        laenutajaField.setEnabled(false);
        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isTicked = checkBox.isSelected();
                laenutajaLabel.setEnabled(isTicked);
                laenutajaField.setEnabled(isTicked);
            }
        });

        layoutStuff();


    }

    public void layoutStuff() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        ////pealkiri////
        //label//
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(pealkiriLabel,gc);

        //textField//
        gc.gridx = 1;

        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(pealkiriField,gc);

        ////autor////
        //label
        gc.gridx = 0;
        gc.gridy++;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(autorLabel,gc);

        //textField//
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(autorField,gc);

        ////aasta////
        //label
        gc.gridx = 0;
        gc.gridy++;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(aastaLabel,gc);

        //textField//
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(aastaField,gc);

        ////zhanr////
        //label
        gc.gridx = 0;
        gc.gridy++;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(new JLabel("Zhanr: "),gc);

        //textField//
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(zhanrCombo,gc);

        ////checkbox////
        //label
        gc.gridx = 0;
        gc.gridy++;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(new JLabel("Kas välja laenutatud: "),gc);

        //textField//
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(checkBox,gc);

        ////laenutaja////
        //label
        gc.gridx = 0;
        gc.gridy++;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(laenutajaLabel,gc);

        //textField//
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(laenutajaField,gc);

        ////nupp////

        gc.weightx = 0.1;
        gc.weighty = 1;

        gc.gridx = 1;
        gc.gridy++;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,20);
        add(okBtn,gc);




    }
}
