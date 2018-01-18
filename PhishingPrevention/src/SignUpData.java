

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.codegen.VerificationTypeInfo;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class SignUpData
 */
@WebServlet("/signupdata")
public class SignUpData extends HttpServlet {
	public static String user="";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	    String userid=request.getParameter("userid");
		String fname=request.getParameter("firstname");
		String lname=request.getParameter("lastname");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		System.out.println(userid+" "+fname+" "+lname+" "+password+" "+email);
		user=userid;
				
		
		
		try{  
			//step1 load the driver class  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/Phishing","root","admin");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			String sql = "INSERT INTO users (userid, firstname, lastname, password, email, gender, imagename)" +
	                   "VALUES (?, ?, ?, ?, ?, ?, ?)";
			String sql1="select * from users where userid=?";
			PreparedStatement st =(PreparedStatement) con.prepareStatement(sql1);
			st.setInt(1,Integer.parseInt(userid));
			ResultSet resultSet = st.executeQuery();
			if(!resultSet.next())
			{
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
				preparedStatement.setString(1, userid);
				preparedStatement.setString(2, fname);
				preparedStatement.setString(3, lname);
				preparedStatement.setString(4, password);
				preparedStatement.setString(5, email);
				preparedStatement.setString(6, null);
				preparedStatement.setString(7, null);
				preparedStatement.executeUpdate(); 
				response.sendRedirect("visual.jsp");
				
			}
			else
			{
				response.sendRedirect("verification.jsp");
				
			}
			
			 
			con.close();  
			  
			}catch(Exception e){ System.out.println(e);} 
		
	}

}
