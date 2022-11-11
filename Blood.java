import java.sql.*;
import java.util.Scanner;

public class Blood {
    public static void main(String args[])
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankdb","root","");

        }
        catch (Exception e){
            System.out.println("e");
        }
        int choice;
        String name,address,bloodgroup,phoneno;
        Scanner s= new Scanner(System.in);
        while(true){
            System.out.println("select any option");
            System.out.println("1.insert");
            System.out.println("2.select");
            System.out.println("3.search");
            System.out.println("4.update");
            System.out.println("5.delete");
            System.out.println("6.exit");
            System.out.println("enter the choice");
            choice= s.nextInt();
            switch (choice){
                case 1:
                    System.out.println("insert data");
                    System.out.println("enter name");
                    name=s.next();
                    System.out.println("enter address");
                    address=s.next();
                    System.out.println("enter phone number");
                    phoneno=s.next();
                    System.out.println("enter blood group");
                    bloodgroup=s.next();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankdb","root","");
                        String sql="INSERT INTO `bloodbank`( `name`, `address`, `phoneno`, `bloodgroup`) VALUES (?,?,?,?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setString(1,name);
                        stmt.setString(2,address);
                        stmt.setString(3,phoneno);
                        stmt.setString(4,bloodgroup);

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }

                case 2:
                    System.out.println("select data");
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankdb","root","");
                        String sql="SELECT `id`, `name`, `address`, `phoneno`, `bloodgroup` FROM `bloodbank`";

                        Statement stmt = con.createStatement();
                        ResultSet rs= stmt.executeQuery(sql);
                        while (rs.next()){
                            String getname=rs.getString("name");
                            String getaddress=rs.getString("address");
                            String getphoneno=rs.getString("phoneno");
                            String getbloodgroup=rs.getString("bloodgroup");
                            System.out.println("name="+getname);
                            System.out.println("address="+getaddress);
                            System.out.println("phone="+getphoneno);
                            System.out.println("bloodgroup="+getbloodgroup+"\n");



                        }
                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }
                case 3:
                    System.out.println("search  data");
                    System.out.println("enter bloodbroup:");
                    bloodgroup=s.next();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankdb","root","");
                        String sql="SELECT  `name`, `address`, `phoneno`, `bloodgroup` FROM `bloodbank` WHERE `bloodgroup`='"+bloodgroup+"'";
                        Statement stmt = con.createStatement();
                        ResultSet rs= stmt.executeQuery(sql);
                        while (rs.next()){
                            String getname=rs.getString("name");
                            String getaddress=rs.getString("address");
                            String getphoneno=rs.getString("phoneno");
                            String getbloodgroup=rs.getString("bloodgroup");
                            System.out.println("name="+getname);
                            System.out.println("address="+getaddress);
                            System.out.println("phone="+getphoneno);
                            System.out.println("bloodgroup="+getbloodgroup+"\n");

                        }
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                case 4:
                    System.out.println("update data");
                    System.out.println("enter bloodgroup");
                    bloodgroup=s.next();
                    System.out.println("enter  name to be updated");
                    name=s.next();
                    System.out.println("enter address to be updated");
                    address=s.next();
                    System.out.println("enter phone numbet to be updated");
                    phoneno=s.next();
                    System.out.println("enter blood group to be updated");
                    String bloodg=s.next();


                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankdb","root","");
                        String sql="UPDATE `bloodbank` SET `name`='"+name+"' ,`address`='"+address+"',`phoneno`='"+phoneno+"',`bloodgroup`='"+bloodg+"' WHERE `bloodgroup`='"+bloodgroup+"'";
                        Statement stmt =con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("update successfully");
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }


                case 5:
                    System.out.println("delete data");
                    System.out.println("enter blood group:");
                    String blood=s.next();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankdb","root","");
                        String sql="DELETE FROM `bloodbank` WHERE `bloodgroup`="+blood;
                        Statement stmt =con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("deleted successfully");
                    }
                    catch (Exception e){
                        System.out.println((e));
                    }
                case 6:
                    System.out.println("exit");
                    break;

            }
        }
    }
}


