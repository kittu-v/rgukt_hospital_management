package hospitalmanagement;
import java.sql.*;

public class conn {
   Connection c;
   Statement s;

   public conn() {
      try {
         Class.forName("com.mysql.jdbc.Driver");
         c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalmanagement", "root", "kittu1234");
         s = c.createStatement();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
