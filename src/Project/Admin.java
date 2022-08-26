package Project;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Vector;

public class Admin{
    private static JMenuBar mb;
    private static JMenu m1, m2;
    private static JMenuItem m11, m21;
    private static ImageIcon icon;
    private static JFrame frame, frame_emp, frame_users;
    public static void App_admin(){
        frame = new JFrame("Buy & Sell Fast");
        JPanel panel = new JPanel();
        frame.setSize(600, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        //icon = new ImageIcon("icon/Chinease_funny.jpg");
        //frame.setIconImage(icon.getImage());
        mb = new JMenuBar();
        m1 = new JMenu("USERS");
        m2 = new JMenu("EMPLOYEES");
        mb.add(m1);
        mb.add(m2);
        m11 = new JMenuItem(new AbstractAction("Active users") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    _DUsers();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        m1.add(m11);
        m21 = new JMenuItem(new AbstractAction("Details") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    _Emp();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        m2.add(m21);
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
        DefaultTableModel model = new DefaultTableModel();
        String[] columnNames = {"First name", "Last Name", "Department"};
        model.setColumnIdentifiers(columnNames);
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        database d = new database();
        Vector v_f = d.display_emp_first();
        Vector v_l = d.display_emp_last();
        Vector v_d = d.display_emp_dept();
        for(int i=0;i<v_d.size();i++){
            model.addRow(new Object[]{v_f.get(i), v_l.get(i), v_d.get(i)});
        }
        frame_emp.add(scroll);
        frame_emp.getContentPane().add(BorderLayout.CENTER, table);
        frame_emp.getContentPane().add(BorderLayout.NORTH, table.getTableHeader());
    }
    protected static void setFrame_users() throws Exception{
        frame_users = new JFrame("Buy & Sell Fast");
        JPanel panel = new JPanel();
        frame_users.setSize(600, 550);
        frame_users.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_users.add(panel);
        panel.setLayout(null);
        icon = new ImageIcon("icon/Chinease_funny.jpg");
        frame_users.setIconImage(icon.getImage());
        DefaultTableModel model = new DefaultTableModel();
        String[] columnNames = {"Username", "Password"};
        model.setColumnIdentifiers(columnNames);
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        database d = new database();
        Vector v_u = d.display_users_username();
        Vector v_p = d.display_users_password();
        for(int i=0;i<v_p.size();i++){
            model.addRow(new Object[]{v_u.get(i), v_p.get(i)});
        }
        frame_users.add(scroll);
        frame_users.getContentPane().add(BorderLayout.CENTER, table);
        frame_users.getContentPane().add(BorderLayout.NORTH, table.getTableHeader());
    }
    protected static void _Emp() throws Exception {
        frame.setVisible(false);
        setFrame_emp();
        frame_emp.setVisible(true);
    }
    protected static void _DUsers() throws Exception{
        frame.setVisible(false);
        setFrame_users();
        frame_users.setVisible(true);
    }
}
