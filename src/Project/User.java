package Project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User implements ActionListener {
    private static JMenuBar mb;
    private static JMenu m1;
    private static JMenuItem m11, m12, m13;
    private static ImageIcon icon;
    public static void App_user(){
        JFrame frame = new JFrame("Buy & Sell Fast");
        JPanel panel = new JPanel();
        frame.setSize(600, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        icon = new ImageIcon("icon/Chinease_funny.jpg");
        frame.setIconImage(icon.getImage());
        mb = new JMenuBar();
        m1 = new JMenu("PRODUCTS");
        mb.add(m1);
        m11 = new JMenuItem("In stock");
        m12 = new JMenuItem("By Alphabetic order");
        m13 = new JMenuItem("By epicness");
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        m1.add(m11);
        m1.add(m12);
        m1.add(m13);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
