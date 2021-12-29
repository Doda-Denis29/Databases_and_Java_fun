package Project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class Admin{
    private static JMenuBar mb;
    private static JMenu m1, m2, m3;
    private static JMenuItem m11, m21, m31;
    private static ImageIcon icon;
    private static JFrame frame, frame_emp, frame_users, frame_pr;
    public static void App_admin(){
        frame = new JFrame("Buy & Sell Fast");
        JPanel panel = new JPanel();
        frame.setSize(600, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        icon = new ImageIcon("icon/Chinease_funny.jpg");
        frame.setIconImage(icon.getImage());
        mb = new JMenuBar();
        m1 = new JMenu("USERS");
        m2 = new JMenu("PRODUCTS");
        m3 = new JMenu("EMPLOYEES");
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        m11 = new JMenuItem(new AbstractAction("Active users") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Baba");
            }
        });
        m1.add(m11);
        m31 = new JMenuItem(new AbstractAction("Details") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    _Emp();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        m3.add(m31);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.setVisible(true);
    }
    protected static void setFrame_emp() throws Exception {
        frame_emp = new JFrame("Buy & Sell Fast");
        JPanel panel = new JPanel();
        frame_emp.setSize(600, 550);
        frame_emp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_emp.add(panel);
        panel.setLayout(null);
        icon = new ImageIcon("icon/Chinease_funny.jpg");
        frame_emp.setIconImage(icon.getImage());
        mb = new JMenuBar();
        m1 = new JMenu("USERS");
        m2 = new JMenu("PRODUCTS");
        m3 = new JMenu("EMPLOYEES");
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        m31 = new JMenuItem("Details");
        m3.add(m31);
        frame_emp.getContentPane().add(BorderLayout.NORTH, mb);
        database d = new database();
        List<String> Emp_List = d.display_emp();
        frame_emp.add(new JList((ListModel) Emp_List));
        frame_emp.pack();
    }
    protected static void _Emp() throws Exception {
        frame.setVisible(false);
        setFrame_emp();
        frame_emp.setVisible(true);
    }
}
