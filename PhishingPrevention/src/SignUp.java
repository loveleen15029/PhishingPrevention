
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.management.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/signuptest")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = "/home/om";
	private final String destPath="/home/om/workspace/PhishingPrevention";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
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
		KeyGenerator privateKey=new KeyGenerator();
		String key=privateKey.generateKey()+"";
//		System.out.println(key);
		
		EncryptFile encrpt=new EncryptFile();
	//	EllipticalCurve encrpt=new EllipticalCurve();
		String dest=Paths.get(".").toAbsolutePath().normalize().toString();
		String srcPath=request.getParameter("filename");
		/*System.out.println(srcPath+" "+dest);
		encrpt.encrypt(srcPath,dest+""+srcPath);*/
		
		String query=SignUpData.user;
		String sql="UPDATE users "+
				"SET imagename= ? "+
				"WHERE userid= ?";
		System.out.println(query+" "+srcPath);
		
		
		  //process only if its multipart content
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
              
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                        encrpt.encrypt(UPLOAD_DIRECTORY+"/"+name, destPath+"/"+name,key);
                        System.out.println("hello");
                        srcPath=name;
                    }
                }
           
               //File uploaded successfully
               request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
         
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }
        try{  
			//step1 load the driver class  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/Phishing","root","admin");  
			//here sonoo is database name, root is username and password  
			/*Statement stmt=con.createStatement();  
				stmt.executeUpdate(sql);*/
				PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
				pstmt.setString(1, srcPath);
				pstmt.setString(2, query);
				pstmt.executeUpdate();
			con.close();  
			  
			}catch(Exception e){ System.out.println(e);} 
    
        request.setAttribute("key", key);
        request.getRequestDispatcher("result.jsp").forward(request, response);
		
	}

}
