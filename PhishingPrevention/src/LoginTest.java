

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class LoginTest
 */
@WebServlet("/logintest")
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String destPath="/home/om/workspace/PhishingPrevention";
	public static String imgUrl="";
	public String downLoadName="";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginTest() {
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
		 
		int ca=Integer.parseInt(request.getParameter("captcha"));
		int x=Integer.parseInt(request.getParameter("x"));
		int y=Integer.parseInt(request.getParameter("y"));
		int op=Integer.parseInt(request.getParameter("op"));
		int result = 0;
		switch (op) {
		case 0:
			result = x + y;
			break;
		case 1:
			result = x - y;
			break;
		case 2:
			result = x * y;
			break;
		}	
		ResultSet rs=null;
		String userid=request.getParameter("userid");
		String sql="select users.imagename from users where userid = '" + userid + "'";
		  try{  
				//step1 load the driver class  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/Phishing","root","admin");  
				Statement st = con.createStatement();
				rs=st.executeQuery(sql);
				if(rs.next())
				{
					imgUrl=destPath+"/"+rs.getString(1);
					downLoadName=rs.getString(1);
				}
				else
				{
					imgUrl="";
				}
				con.close();  
				  
				}catch(Exception e){ System.out.println(e);} 
		  System.out.println(imgUrl);
		
		if(result==ca) {
			request.setAttribute("imgUrl", imgUrl);
			request.setAttribute("dwn", downLoadName);
	        request.getRequestDispatcher("loginnext.jsp").forward(request, response);}
		else
		response.sendRedirect("login.jsp");
		
		
		
		
	}

}
