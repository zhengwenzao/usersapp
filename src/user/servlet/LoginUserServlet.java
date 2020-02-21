package user.servlet;

import user.dao.BaseDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class LoginUserServlet
 */
@WebServlet("/LoginUserServlet")
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUserServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset = GBK");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String userpass = request.getParameter("userpass");
		ServletContext ctx = request.getServletContext();
		String server = ctx.getInitParameter("server");
		String dbname = ctx.getInitParameter("dbname");
		String dbuser = ctx.getInitParameter("dbuser");
		String dbpwd = ctx.getInitParameter("dbpwd");		
		BaseDao db = new BaseDao();
		db.getConn(server, dbname, dbuser, dbpwd);
		String sql = "SELECT * FROM user WHERE username = ? AND userpass = ?";
		ResultSet rs = db.executeQuery(sql,new String[]{username,userpass});
		try {
			if(rs != null && rs.next()){
				HttpSession session = request.getSession();
				session.setAttribute("username",username);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String logtime = sdf.format(new Date()); 
				session.setAttribute("logtime",logtime);
				Cookie cookie = new Cookie("username",username);
				cookie.setMaxAge(60*60*24*30);
				response.addCookie(cookie);
				RequestDispatcher dispatcher = request.getRequestDispatcher("MainServlet");
				dispatcher.forward(request,response);
			}else{
				out.print("登录失败");
				out.print("<br><a href = 'index.jsp'>重新登陆</a>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void init()throws ServletException {
		
	}

}
