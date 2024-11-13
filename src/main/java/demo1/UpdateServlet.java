package demo1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		long phone = Long.parseLong(req.getParameter("phone"));
		String password = req.getParameter("password");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/instagram", "root", "root");
			PreparedStatement ps = con.prepareStatement("update user set  name=?, email=?, phone=?, password=? where id=?");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setLong(3, phone);
			ps.setString(4, password);
			ps.setInt(5, id);
			int row = ps.executeUpdate();
			PrintWriter pw = res.getWriter();
			pw.write("<html> <body> <h1> Updated Successfully </h1> </body> </html>");
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/instagram", "root", "root");
				 ps = con.prepareStatement("select * from user");

				ResultSet rs = ps.executeQuery();

				req.setAttribute("rs", rs);

				RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
				rd.include(req, res);

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
			
			
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
