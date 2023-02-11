import java.util.Scanner;
import java.sql.*;

class Clients extends Person{
    Menu userMenu = new Menu();
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    private String surname;
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    private String password;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    private double balance;
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void login() {
        Clients acc = new Clients();
        Scanner sc = new Scanner(System.in);
        System.out.println("Login");
        System.out.println("Name:");
        String name = sc.nextLine();
        System.out.println("Surname:");
        String surname = sc.nextLine();
        System.out.println("Password:");
        String password = sc.nextLine();
    
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM clt WHERE cltname = ? AND cltsurname = ? AND cltpassword = ?");
            stmt.setString(1, name);
            stmt.setString(2, surname);
            stmt.setString(3, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Success!");
                acc.setName(rs.getString("cltname"));
                acc.setSurname(rs.getString("cltsurname"));
                acc.setPassword(rs.getString("cltpassword"));
            } else {
                System.out.println("Seems like you don't have an account or you entered your entered incorrect info");
                userMenu.firstMenu();
            }
        } catch (SQLException e) {
            System.out.println("Error accessing database: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }

    public void register()
    {
        Clients acc = new Clients();
        Scanner sc = new Scanner(System.in);
        System.out.println("Oh, new customer! What is your name?");
        String clientFN = sc.nextLine();
        System.out.println("What is your surname our new customer?");
        String clientSN = sc.nextLine();
        System.out.println("And the last one, what about your password?");
        String clientpassword = sc.nextLine();

        acc.setName(clientFN);
        acc.setSurname(clientSN);
        acc.setPassword(clientpassword);

        SaveDataInPostgreSQL saveDataInPostgreSQL= new SaveDataInPostgreSQL();
        saveDataInPostgreSQL.saveData(acc.getName(), acc.getSurname(), acc.getPassword());
    }

    public void getInfo()
    {
        Clients acc = new Clients();
        System.out.println("Name: " + acc.getName() + " "  + ", Surname: " + acc.getSurname() + " " + ", Password: " + acc.getPassword());
    }
}
