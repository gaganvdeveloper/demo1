package demo1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
@WebServlet("/a")
public class AServlet extends HttpServlet {

	public AServlet() {
		System.out.println("AServlet Constructor");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("AServlet Init method");
	
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("AServlet Service method");
	}
	
	
	@Override
	public void destroy() {
		System.out.println("AServlet Destroy Method");
	}
}
