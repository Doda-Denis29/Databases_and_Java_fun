package Project;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    protected static List<String> display_emp() throws Exception{
        List<String> list = new ArrayList<>();
        try{
            Connection connection = getCon();
            PreparedStatement statement = connection.prepareStatement("SELECT first_name,last_name,dept FROM emp");
            ResultSet result = statement.executeQuery();
            while(result.next()){
                list.add(result.getString("first_name")+" "+result.getString("last_name")+" "+result.getString("dept"));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println("The process has ended");
        }
        return list;
    }
}
