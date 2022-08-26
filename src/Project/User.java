package Project;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Vector;

public class User {
    private static JMenuBar mb;
    private static JMenu m1;
    private static JMenuItem m11, m12;
    private static JTextField type_b, type_s, amount_b, amount_s;
    private static JButton buy, sell;
    private static ImageIcon icon;
    private static JFrame frame_u, frame_b, frame_s;
    public static void App_user(String username) {
        frame_u = new JFrame("Welcome to Buy & Sell Fast, "+username);
        JPanel panel = new JPanel();
        frame_u.setSize(600, 550);
        frame_u.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_u.add(panel);
        panel.setLayout(null);
        icon = new ImageIcon("icon/Chinease_funny.jpg");
        frame_u.setIconImage(icon.getImage());
        mb = new JMenuBar();
        m1 = new JMenu("PRODUCTS");
        mb.add(m1);
        m11 = new JMenuItem(new AbstractAction("Buy"){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    frame_u.setVisible(false);
                    setFrame_b();
                    frame_b.setVisible(true);
                }
                catch (Exception ex){
                    System.out.println(ex);
                }
            }
        });
        m1.add(m11);
        m12 = new JMenuItem(new AbstractAction("Sell") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    frame_u.setVisible(false);
                    setFrame_s();
                    frame_s.setVisible(true);
                }
                catch (Exception ex){
                    System.out.println(ex);
                }
            }
        });
        m1.add(m12);
        frame_u.getContentPane().add(BorderLayout.NORTH, mb);
        frame_u.setVisible(true);
    }
    protected static void setFrame_b() throws Exception {
        frame_b = new JFrame("Buy menu");
        frame_b.setSize(600, 550);
        frame_b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        icon = new ImageIcon("icon/Chinease_funny.jpg");
        frame_b.setIconImage(icon.getImage());
        DefaultTableModel model = new DefaultTableModel();
        String[] columnNames = {"Product Name", "Vegan", "Contains allergens", "Origin", "Quantity", "Expiration date"};
        model.setColumnIdentifiers(columnNames);
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        database d = new database();
        Vector v_n = d.display_products_n();
        Vector v_v = d.display_products_v();
        Vector v_c = d.display_products_c();
        Vector v_o = d.display_products_o();
        Vector v_q = d.display_products_q();
        Vector v_exp = d.display_products_exp();
        for(int i=0;i<v_n.size();i++){
            model.addRow(new Object[]{v_n.get(i), v_v.get(i), v_c.get(i), v_o.get(i), v_q.get(i), v_exp.get(i)});
        }
        frame_b.add(scroll);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Product name");
        type_b = new JTextField(20);
        JLabel label1 = new JLabel("Amount to buy");
        amount_b = new JTextField(5);
        buy = new JButton(new AbstractAction("Buy") {
            @Override
            public void actionPerformed(ActionEvent e) {
                database d = new database();
                String product_name = type_b.getText();
                String quant_string = amount_b.getText();
                int q = Integer.parseInt(quant_string);
                int total_amount = 0;
                try {
                    total_amount = d.get_Total_Quan(product_name);
                }
                catch (Exception ex) {
                    System.out.println(ex);
                }
                try {
                    d.bought(product_name, q, total_amount);
                    frame_b.setVisible(false);
                    setFrame_b();
                    frame_b.setVisible(true);
                }
                catch (Exception ex2) {
                    System.out.println(ex2);
                }
            }
        });
        panel.add(label);
        panel.add(type_b);
        panel.add(label1);
        panel.add(amount_b);
        panel.add(buy);
        frame_b.getContentPane().add(BorderLayout.SOUTH, panel);
        frame_b.getContentPane().add(BorderLayout.CENTER, table);
        frame_b.getContentPane().add(BorderLayout.NORTH, table.getTableHeader());
    }
    protected static void setFrame_s () throws Exception{
        frame_s = new JFrame("Sell menu");
        frame_s.setSize(600, 550);
        frame_s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        icon = new ImageIcon("icon/Chinease_funny.jpg");
        frame_s.setIconImage(icon.getImage());
        DefaultTableModel model = new DefaultTableModel();
        String[] columnNames = {"Product Name", "Vegan", "Contains allergens", "Origin", "Quantity", "Expiration date"};
        model.setColumnIdentifiers(columnNames);
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        database d = new database();
        Vector v_n = d.display_products_n();
        Vector v_v = d.display_products_v();
        Vector v_c = d.display_products_c();
        Vector v_o = d.display_products_o();
        Vector v_q = d.display_products_q();
        Vector v_exp = d.display_products_exp();
        for(int i=0;i<v_n.size();i++){
            model.addRow(new Object[]{v_n.get(i), v_v.get(i), v_c.get(i), v_o.get(i), v_q.get(i), v_exp.get(i)});
        }
        frame_s.add(scroll);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Product name");
        type_s = new JTextField(20);
        JLabel label1 = new JLabel("Amount to sell");
        amount_s = new JTextField(5);
        sell = new JButton(new AbstractAction("Sell") {
            @Override
            public void actionPerformed(ActionEvent e) {
                database d = new database();
                String product_name = type_s.getText();
                String quant_string = amount_s.getText();
                int q = Integer.parseInt(quant_string);
                int total_amount = 0;
                try {
                    total_amount = d.get_Total_Quan(product_name);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                try {
                    d.sold(product_name, q, total_amount);
                    frame_s.setVisible(false);
                    setFrame_s();
                    frame_s.setVisible(true);
                } catch (Exception ex2) {
                    System.out.println(ex2);
                }
            }
        });
        panel.add(label);
        panel.add(type_s);
        panel.add(label1);
        panel.add(amount_s);
        panel.add(sell);
        frame_s.getContentPane().add(BorderLayout.SOUTH, panel);
        frame_s.getContentPane().add(BorderLayout.CENTER, table);
        frame_s.getContentPane().add(BorderLayout.NORTH, table.getTableHeader());
    }
}
