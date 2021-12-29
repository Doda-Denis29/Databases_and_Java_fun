package Project;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Create implements ActionListener {
    private static JLabel user, passw, passw_c;
    private static JTextField user_txt;
    private static JPasswordField passw_txt, passw_txt_c;
    private static JButton b, b2;
    private static JLabel suc;
    private static JFrame frame_c;
    private static ImageIcon icon;
    public void create_acc(){
        frame_c = new JFrame();
        JPanel panel = new JPanel();
        frame_c.setSize(500, 500);
        frame_c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_c.add(panel);
        panel.setLayout(null);
        icon = new ImageIcon("icon/Chinease_funny.jpg");
        frame_c.setIconImage(icon.getImage());
        user = new JLabel("Username");
        user.setBounds(10, 20, 80, 25);
        panel.add(user);
        user_txt = new JTextField(20);
        user_txt.setBounds(100, 20, 165, 25);
        panel.add(user_txt);
        passw = new JLabel("Password");
        passw.setBounds(10, 50, 80, 25);
        panel.add(passw);
        passw_txt = new JPasswordField();
        passw_txt.setBounds(100, 50, 165, 25);
        panel.add(passw_txt);
        passw_c = new JLabel("Confirm Pass");
        passw_c.setBounds(10, 75, 80, 25);
        panel.add(passw_c);
        passw_txt_c = new JPasswordField();
        passw_txt_c.setBounds(100, 75, 165, 25);
        panel.add(passw_txt_c);
        b = new JButton("Create a new user");
        b.setBounds(100, 110, 150, 30);
        panel.add(b);
        b2 = new JButton("Back to the login screen");
        b2.setBounds(100,145,185,30);
        panel.add(b2);
        b.addActionListener(this);
        b2.addActionListener(this);
        suc = new JLabel("");
        suc.setBounds(100, 165, 300, 25);
        panel.add(suc);
        frame_c.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String user_ = user_txt.getText();
        String pas = passw_txt.getText();
        String pas_c = passw_txt_c.getText();
        if(e.getSource() == b) {
            System.out.println("New User :" + user_ + " Pass :" + pas + " Pass_C :" + pas_c);
            if (user_.equals("") || pas.equals("")) {
                suc.setText("User name/Password not typed");
            } else if (pas.equals(pas_c) && pas_c.equals(pas)) {
                database d = new database();
                try {
                    d.addUsers(user_, pas);
                } catch (Exception ex) {
                    System.out.println(ex);
                } finally {
                    suc.setText("New user created");
                }
            } else if (!pas.equals(pas_c) || !pas.equals(pas)) {
                suc.setText("Password is not matching");
            }
        }
        else if(e.getSource() == b2){
            GUI roll_back = new GUI();
            roll_back.front_end();
        }
    }
}
