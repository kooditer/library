import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JPanel implements ActionListener {
    private JButton nupp1;
    private JButton nupp2;
    private JButton nupp3;
    private StringListener listener;

    public ToolBar() {
        setBorder(BorderFactory.createEtchedBorder());
        nupp1 = new JButton("NUPP 1");
        nupp2 = new JButton("NUPP 2");
        nupp3 = new JButton("NUPP 3");

        nupp1.addActionListener(this);
        nupp2.addActionListener(this);
        nupp3.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(nupp1);
        add(nupp2);
        add(nupp3);
    }

    public  void setStringListener(StringListener listener) {
        this.listener = listener;
    }

    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        if (clicked==nupp1) {
            if (listener!=null)
                listener.textEmitted("Nupp 1\n");
            System.out.println("nupp nr 1");
        } else if (clicked==nupp2) {
            if (listener!=null)
                listener.textEmitted("Nupp2\n");
            System.out.println("nupp nr 2");
        } else {
            if (listener!=null)
                listener.textEmitted("Nupp3\n");
            System.out.println("nupp nr 3");
        }

    }
}
