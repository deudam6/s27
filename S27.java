import java.sql.*; 
import javax.swing.*; 
import javax.swing.table.DefaultTableModel; 
public class CollegeDetailsJTable extends JFrame { 
 
 // database connection details 
 static final String DB_URL = "jdbc:mysql://localhost:3306/college"; 
 static final String DB_USER = "root"; 
 static final String DB_PASSWORD = "password"; 
 public CollegeDetailsJTable() { 
 super("College Details"); 
 
 // create a JTable 
 JTable table = new JTable(); 
 
 // set column names for the table 
 String[] columnNames = {"CID", "CName", "Address", "Year"}; 
 
 // create a default table model with the column names 
 DefaultTableModel model = new DefaultTableModel(columnNames, 0); 
 
 // add data to the table model 
 try { 
 // create a database connection 
 Connection conn = DriverManager.getConnection(DB_URL, DB_USER, 
DB_PASSWORD); 
 
 // create a statement 
 Statement stmt = conn.createStatement(); 
 
 // execute a query to get college details 
 ResultSet rs = stmt.executeQuery("SELECT * FROM college"); 
 
 // add each row to the table model 
 while (rs.next()) { 
 String cid = rs.getString("CID"); 
 String cname = rs.getString("CName"); 
 String address = rs.getString("Address"); 
 int year = rs.getInt("Year"); 
 model.addRow(new Object[] { cid, cname, address, year }); 
 } 
 
 // close the result set, statement and connection 
 rs.close(); 
 stmt.close(); 
 conn.close(); 
 } catch (SQLException e) { 
 e.printStackTrace(); 
 } 
 
 // set the table model to the JTable 
 table.setModel(model); 
 
 // create a scroll pane for the table 
 JScrollPane scrollPane = new JScrollPane(table); 
 
 // add the scroll pane to the frame 
 getContentPane().add(scrollPane); 
 
 // set frame properties 
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
 setLocationRelativeTo(null); 
 pack(); 
 setVisible(true); 
 } 
 public static void main(String[] args) { 
 new CollegeDetailsJTable(); 
 } 
} 
2.o/p
import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
public class ChangeSessionTimeout extends HttpServlet { 
 public void doGet(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException { 
 
 // Get the current session 
 HttpSession session = request.getSession(); 
 
 // Set the inactive time interval to 10 minutes (in seconds) 
 session.setMaxInactiveInterval(600); 
 
 // Display a message 
 response.setContentType("text/html"); 
 PrintWriter out = response.getWriter(); 
 out.println("<html><body>"); 
 out.println("<h3>Session Timeout Changed to 10 Minutes</h3>"); 
 out.println("</body></html>"); 
 } 
} 
