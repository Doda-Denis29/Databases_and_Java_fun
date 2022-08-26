package Project;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private static JLabel user, passw;
    private static JTextField user_txt;
    private static JPasswordField passw_txt;
    private static JButton b, b2;
    private static JLabel suc;
    private static JFrame frame;
    private static ImageIcon icon;
    public GUI() {}
    public void front_end (){
        frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        icon = new ImageIcon("icon/Chinease_funny.jpg");
        frame.setIconImage(icon.getImage());
        user = new JLabel("User");
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
        b = new JButton("Login");
        b.setBounds(100, 80, 80, 25);
        panel.add(b);
        b2 = new JButton("Create a new account");
        b2.setBounds(100,110,170,25);
        panel.add(b2);
        suc = new JLabel("");
        suc.setBounds(100, 130, 300, 25);
        panel.add(suc);
        b.addActionListener(this);
        b2.addActionListener(this);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String _user = user_txt.getText();
        String pas = passw_txt.getText();
        if(e.getSource() == b) {
            System.out.println("User :"+ _user +" Pass :"+ pas);
            database d = new database();
            if(_user.equals("Admin") && pas.equals("admin")){
                Admin a = new Admin();
                a.App_admin();
                frame.setVisible(false);
            }
            else {
                try {
                    if(d.Loggin(_user, pas)){
                        User u = new User();
                        u.App_user(_user);
                        frame.setVisible(false);
                    }
                    else {
                        suc.setText("Wrong password or username");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        else if(e.getSource() == b2){
            Create newUser = new Create();
            newUser.create_acc();
            frame.setVisible(false);
        }
    }
}
