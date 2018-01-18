

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.tool.EclipseCompilerImpl;

/**
 * Servlet implementation class DecryptServlet
 */
@WebServlet("/decryptservlet")
public class DecryptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String destPath="/home/om/workspace/PhishingPrevention/decrypt";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DecryptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		EncryptFile decrypt=new EncryptFile();
		//EllipticalCurve decrypt=new EllipticalCurve();
        String id = request.getParameter("privatekey");
       

        String dwnld=request.getParameter("download");
        String fileName = request.getParameter("filename");
        decrypt.decrypt(fileName, destPath+"/"+dwnld, id);
        String fileType = "image/png";
        fileName=destPath+"/"+dwnld;
        
        response.setContentType(fileType);
        response.setHeader("Content-disposition","attachment; filename=\"" + dwnld + "\"");
        File my_file = new File(fileName);
        OutputStream out = response.getOutputStream();
        FileInputStream in = new FileInputStream(my_file);
        byte[] buffer = new byte[4096];
        int length;
        while ((length = in.read(buffer)) > 0){
           out.write(buffer, 0, length);
        }
        in.close();
        out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
