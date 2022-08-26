package Project;
import java.sql.*;
import java.util.Vector;

public class database {
    protected static Connection getCon() throws Exception{
        try{
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/users";
            String user = "root";
            String password = "1234";
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection done");
            return con;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    protected static void addUsers(String user_, String pas_) throws Exception{
        try{
            Connection connection = getCon();
            PreparedStatement addU = connection.prepareStatement("INSERT INTO _users (username,password) VALUES ('"+user_+"', '"+pas_+"')");
            addU.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println("Inserted completed \n New user added");
        }
    }
    protected static boolean Loggin(String user_, String pas_) throws Exception{
        try{
            Connection connection = getCon();
            PreparedStatement checkU = connection.prepareStatement("SELECT username,password FROM _users WHERE username = '"+user_+"' AND password = '"+pas_+"'");
            ResultSet result = checkU.executeQuery();
            while (result.next()){
                System.out.println("Username: "+result.getString("username")+" Password: "+result.getString("password"));
                if(result.getString("username").equals(user_) && result.getString("password").equals(pas_)){
                    return true;
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println("Process has ended");
        }
        return false;
    }
    protected static Vector display_users_username() throws Exception{
        Vector v = new Vector();
        try{
            Connection connection = getCon();
            PreparedStatement statement = connection.prepareStatement("SELECT username FROM _users");
            ResultSet result = statement.executeQuery();
            while(result.next()){
                v.add(result.getString("username"));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println("The process has ended");
        }
        return v;
    }
    protected static Vector display_users_password() throws Exception{
        Vector v = new Vector();
        try{
            Connection connection = getCon();
            PreparedStatement statement = connection.prepareStatement("SELECT password FROM _users");
            ResultSet result = statement.executeQuery();
            while(result.next()){
                v.add(result.getString("password"));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println("The process has ended");
        }
        return v;
    }
    private static void addEmp(String first_name, String last_name, String dept) throws Exception{
        try{
            Connection connection = getCon();
            PreparedStatement addE = connection.prepareStatement("INSERT INTO emp (first_name,last_name,dept) VALUES ('"+first_name+"', '"+last_name+"', '"+dept+"')");
            addE.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println("Insertion completed");
        }
    }
    protected static Vector display_emp_first() throws Exception{
        Vector v = new Vector();
        try{
            Connection connection = getCon();
            PreparedStatement statement = connection.prepareStatement("SELECT first_name FROM emp");
            ResultSet result = statement.executeQuery();
            while(result.next()){
                v.add(result.getString("first_name"));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println("The process has ended");
        }
        return v;
    }
    protected static Vector display_emp_last() throws Exception{
        Vector v = new Vector();
        try{
            Connection connection = getCon();
            PreparedStatement statement = connection.prepareStatement("SELECT last_name FROM emp");
            ResultSet result = statement.executeQuery();
            while(result.next()){
                v.add(result.getString("last_name"));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println("The process has ended");
        }
        return v;
    }
    protected static Vector display_emp_dept() throws Exception{
        Vector v = new Vector();
        try{
            Connection connection = getCon();
            PreparedStatement statement = connection.prepareStatement("SELECT dept FROM emp");
            ResultSet result = statement.executeQuery();
            while(result.next()){
                v.add(result.getString("dept"));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println("The process has ended");
        }
        return v;
    }
    protected static Vector display_products_n() throws Exception{
        Vector v = new Vector();
        try{
            Connection connection = getCon();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM pro");
            ResultSet result = statement.executeQuery();
            while(result.next()){
                v.add(result.getString("product_name"));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println("The process has ended");
        }
        return v;
    }
    protected static Vector display_products_v() throws Exception{
        Vector v = new Vector();
        try{
            Connection connection = getCon();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM pro");
            ResultSet result = statement.executeQuery();
            while(result.next()){
                v.add(result.getString("Vegan"));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println("The process has ended");
        }
        return v;
    }
    protected static Vector display_products_c() throws Exception{
        Vector v = new Vector();
        try{
            Connection connection = getCon();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM pro");
            ResultSet result = statement.executeQuery();
            while(result.next()){
                v.add(result.getString("con_allergens"));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println("The process has ended");
        }
        return v;
    }
    protected static Vector display_products_o() throws Exception{
        Vector v = new Vector();
        try{
            Connection connection = getCon();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM pro");
            ResultSet result = statement.executeQuery();
            while(result.next()){
                v.add(result.getString("origin"));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println("The process has ended");
        }
        return v;
    }
    protected static Vector display_products_q() throws Exception{
        Vector v = new Vector();
        try{
            Connection connection = getCon();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM pro");
            ResultSet result = statement.executeQuery();
            while(result.next()){
                v.add(result.getString("quantity"));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println("The process has ended");
        }
        return v;
    }
    protected static Vector display_products_exp() throws Exception{
        Vector v = new Vector();
        try{
            Connection connection = getCon();
            PreparedStatement statement = connection.prepareStatement("SELECT DATE_FORMAT(expDate, '%d-%M-%y') as date FROM pro");
            ResultSet result = statement.executeQuery();
            while(result.next()){
                v.add(result.getString("date"));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println("The process has ended");
        }
        return v;
    }
    protected static boolean is_in_Stock(String product_name, int q) throws Exception{
        try{
            Connection connection = getCon();
            PreparedStatement statement = connection.prepareStatement("SELECT product_name, quantity FROM pro");
            ResultSet result = statement.executeQuery();
            while(result.next()){
                if(result.getString("product_name").equals(product_name) && result.getInt("quantity") > 0){
                    return true;
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println("The process has ended");
        }
        return false;
    }
    protected static boolean is_in_Stock(String product_name) throws Exception{
        try{
            Connection connection = getCon();
            PreparedStatement statement = connection.prepareStatement("SELECT product_name, quantity FROM pro");
            ResultSet result = statement.executeQuery();
            while(result.next()){
                if(result.getString("product_name").equals(product_name) && result.getInt("quantity") > 0){
                    return true;
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println("The process has ended");
        }
        return false;
    }
    protected static int get_Total_Quan(String product_name) throws Exception{
        int t = 0;
        try{
            Connection connection = getCon();
            PreparedStatement statement = connection.prepareStatement("SELECT quantity FROM pro WHERE product_name = '"+product_name+"'");
            ResultSet result = statement.executeQuery();
            if(is_in_Stock(product_name)){
                while (result.next()){
                  t = result.getInt("quantity");
                }
            }
            else{
                System.out.println("Cannot get the item");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println("The process has ended");
        }
        return t;
    }
    protected static void bought(String product_name, int amount_to_be_bought, int total_amount) throws Exception{
        try{
            Connection connection = getCon();
            PreparedStatement statement = connection.prepareStatement("SELECT product_name FROM pro WHERE product_name = '"+product_name+"'");
            ResultSet result = statement.executeQuery();
            int rez = total_amount - amount_to_be_bought;
            if(is_in_Stock(product_name) && rez <= total_amount && rez >= 0){
                while (result.next()){
                    statement.executeUpdate("UPDATE pro SET quantity =  '"+rez+"' WHERE product_name = '"+product_name+"'");
                }
            }
            else{
                System.out.println("Cannot buy the item since it either does not exit or it is out of stock");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println("The process has ended");
        }
    }
    protected static void sold(String product_name, int amount_to_be_sold, int total_amount) throws Exception{
        try{
            Connection connection = getCon();
            PreparedStatement statement = connection.prepareStatement("SELECT product_name FROM pro WHERE product_name = '"+product_name+"'");
            ResultSet result = statement.executeQuery();
            int rez = amount_to_be_sold + total_amount;
            if(rez >= 0 && amount_to_be_sold >= 0) {
                while (result.next()) {
                    statement.executeUpdate("UPDATE pro SET quantity =  '" + rez + "' WHERE product_name = '" + product_name + "'");
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println("The process has ended");
        }
    }
}
