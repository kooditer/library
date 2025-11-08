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
    private JLabel zhanrLabel;
    private JComboBox zhanrCombo;
    private JLabel hinnangLabel;
    private JComboBox hinnangCombo;
    private JLabel laenutusLabel;
    private JCheckBox isLaenutatud;
    private JLabel laenutajaLabel;
    private JTextField laenutajaField;
    private JButton OKbtn;
    private FormEventListener listener;

    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        Border innerBorder = BorderFactory.createTitledBorder("Raamatu Lisamine");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        pealkiriLabel = new JLabel("Pealkiri");
        pealkiriField = new JTextField(10);
        autorLabel = new JLabel("Autor");
        autorField = new JTextField(10);
        aastaLabel = new JLabel("Välja antud");
        aastaField = new JTextField(10);
        zhanrLabel = new JLabel("Zhanr");
        zhanrCombo = new JComboBox<>();
        hinnangLabel = new JLabel("Hinnang");
        hinnangCombo = new JComboBox<>();
        laenutusLabel = new JLabel("Laenutatud");
        isLaenutatud = new JCheckBox();
        laenutajaLabel = new JLabel("Laenutaja");
        laenutajaField = new JTextField(10);
        OKbtn = new JButton("Salvesta");

        //zhanrCombo seadistamine
        DefaultComboBoxModel zhanrModel = new DefaultComboBoxModel<>();
        zhanrModel.addElement("Väga hea");
        zhanrModel.addElement("Hea");
        zhanrModel.addElement("Keskmine");
        zhanrModel.addElement("Halb");
        zhanrModel.addElement("Väga halb");
        zhanrCombo.setModel(zhanrModel);
        zhanrCombo.setSelectedIndex(2);

        //hinnangcombo seadistamine
        DefaultComboBoxModel hinnangModel = new DefaultComboBoxModel<>();
        hinnangModel.addElement("Lasteraamat");
        hinnangModel.addElement("Õpik");
        hinnangModel.addElement("Eneseabi");
        hinnangModel.addElement("Kriminull");
        hinnangModel.addElement("Põnevik");
        hinnangModel.addElement("Käsiraamat");
        hinnangModel.addElement("Luuleraamat");
        hinnangModel.addElement("Elulood");
        hinnangModel.addElement("Muu");
        hinnangCombo.setModel(hinnangModel);
        hinnangCombo.setSelectedIndex(0);

        //checkbox seadistamine
        laenutajaLabel.setEnabled(false);
        laenutajaField.setEnabled(false);
        isLaenutatud.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isClicked = isLaenutatud.isSelected();
                laenutajaLabel.setEnabled(isClicked);
                laenutajaField.setEnabled(isClicked);            }
        });

        //ok nupu seadistamine
        OKbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pealkiri = pealkiriField.getText();
                String autor = autorField.getText();
                String aasta = aastaField.getText();
                String zhanr = (String) zhanrCombo.getSelectedItem();
                String hinnang = (String) hinnangCombo.getSelectedItem();
                boolean laenutatud = isLaenutatud.isSelected();
                String laenutaja = laenutajaField.getText();

                FormEvent ev = new FormEvent(this, pealkiri, autor, aasta,
                        zhanr, hinnang, laenutatud, laenutaja);
                if (listener!=null) {
                    listener.formEventOccured(ev);
                }
            }
        });
        LayoutSettings();



    }
    public void LayoutSettings() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        /// pealkiri rida
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(pealkiriLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(pealkiriField, gc);

        /// autor rida
        gc.gridx = 0;
        gc.gridy++;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(autorLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(autorField, gc);

        /// aasta rida
        gc.gridx = 0;
        gc.gridy++;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(aastaLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(aastaField, gc);

        /// zhanr rida
        gc.gridx = 0;
        gc.gridy++;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(zhanrLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(zhanrCombo, gc);

        /// hinnang rida
        gc.gridx = 0;
        gc.gridy++;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(hinnangLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(hinnangCombo, gc);

        /// isLaenutatud rida
        gc.gridx = 0;
        gc.gridy++;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(laenutusLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(isLaenutatud, gc);

        /// laenutaja rida
        gc.gridx = 0;
        gc.gridy++;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(laenutajaLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(laenutajaField, gc);

        /// nupu rida
        gc.weightx = 1;
        gc.weighty = 1;
        gc.gridx = 1;
        gc.gridy++;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,0);
        add(OKbtn, gc);
    }
    public void setFormListener(FormEventListener listener) {
        this.listener = listener;
    }



}
