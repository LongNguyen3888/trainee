package JDBC;

import java.sql.*;

public class TestApplication {
    static final String dbUrl = "jdbc:mysql://localhost:3306/hello";
    static final String username = "root";
    static final String password = "Meomeo22$";
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(dbUrl, username, password);
                Statement stmt = conn.createStatement();
        ) {
            // Insert data
            System.out.println("Inserting a new student...");
            String Insert = "insert into sinhvien values ('Nguyen Van B', 22222222, 'Đà Nẵng', 21000832, '2003-12-08', 'IFB46')";
            int rowsInserted = stmt.executeUpdate(Insert);
            System.out.println(rowsInserted + " row(s) inserted.");

            // Select data
            System.out.println("Reading students...");
            String Select = "select * from sinhvien";
            ResultSet rs = stmt.executeQuery(Select);

            // Print result
            while (rs.next()) {
                String name = rs.getString("Hovaten");
                int CCCD = rs.getInt("CCCD");
                String hometown = rs.getString("Quequan");
                int MSV = rs.getInt("MaSV");
                Date date = rs.getDate("Ngaysinh");
                String lop = rs.getString("Lop");
                System.out.println(name + ", " + CCCD + ", " + hometown + ", " + MSV + ", " + date + ", " + lop);
            }

            // Update data
            System.out.println("Updating a student...");
            String Update = "update sinhvien set Lop = 'A2' where Hovaten = 'Nguyen Van B'";
            int rowsUpdated = stmt.executeUpdate(Update);
            System.out.println(rowsUpdated + " row(s) updated.");

            // Delete data
            System.out.println("Deleting a student...");
            String Delete = "delete from sinhvien where Lop = 'A2'";
            int rowsDeleted = stmt.executeUpdate(Delete);
            System.out.println(rowsDeleted + " row(s) deleted.");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}