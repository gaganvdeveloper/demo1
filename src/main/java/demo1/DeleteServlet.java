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

import com.mysql.cj.protocol.SocksProxySocketFactory;
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String sid = req.getParameter("id");
		int id = Integer.parseInt(sid);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/instagram","root","root");
			PreparedStatement ps = con.prepareStatement("delete from user where id=?");
			ps.setInt(1, id);
			int row = ps.executeUpdate();
			if(row==1) {
				PrintWriter pw = res.getWriter();
				pw.write("<html><body><h1>Deleted Successfully...</h1></body></html>");
				
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

			}
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
