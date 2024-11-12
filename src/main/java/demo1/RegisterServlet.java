package demo1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/reg")
public class RegisterServlet extends HttpServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String sid = req.getParameter("id");
		int id = Integer.parseInt(sid);
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String sphone = req.getParameter("phone");
		long phone = Long.parseLong(sphone);
		String password = req.getParameter("password");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/instagram", "root", "root");
			PreparedStatement ps = con.prepareStatement("insert into user values(?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setLong(4, phone);
			ps.setString(5, password);
			int row = ps.executeUpdate();
			if (row == 1) {
				PrintWriter pw = res.getWriter();
				pw.write("<html><body><h1>Your Account Created Successfully </h1></body></html>");
				RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
//				rd.forward(req, res);
				rd.include(req, res);
			}
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
