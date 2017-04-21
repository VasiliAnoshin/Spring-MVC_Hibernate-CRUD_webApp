package DB;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class testDBservlet
 */
@WebServlet("/testDBservlet")
public class testDBservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// setup connection variables
		String user = "springstudent";
		String pass ="springstudent";
		String jdbc = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		
		//get connection to database
		try{
			//Can send responces to the browser
			PrintWriter out = response.getWriter();
			
			out.println("connecting to databas: " + jdbc);
			//It obtains a reference to the class object with the FQCN (fully qualified class name) 
			//It doesn't "do" anything in terms of connecting to a database, aside from ensure that the specified class is loaded by the current classloader.
			//load my dataBase driver
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(jdbc,user,pass);
			
			out.println("SUCCESS");
			conn.close();
			
		}catch(Exception ex){
			ex.printStackTrace();
			throw new ServletException(ex);
		}		
	}
}
