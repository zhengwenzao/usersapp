package user.servlet;

import user.dao.BaseDao;
import user.entity.User;

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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Servlet implementation class QueryUserServlet
 */
@WebServlet("/QueryUserServlet")
public class QueryUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryUserServlet() {
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
		ServletContext ctx = request.getServletContext();
		String server = ctx.getInitParameter("server");
		String dbname = ctx.getInitParameter("dbname");
		String dbuser = ctx.getInitParameter("dbuser");
		String dbpwd = ctx.getInitParameter("dbpwd");		
		BaseDao db = new BaseDao();
		db.getConn(server, dbname, dbuser, dbpwd);
		String sql;
		String [] param = null;
		if (username!=null && !"".equals(username)){
			sql = "SELECT * FROM user WHERE username = ?";
			param = new String[]{username};
		}else {
			sql = "SELECT * FROM user";
		}
		ResultSet rs = db.executeQuery(sql,param);
		try {
			if(rs != null ){
				List<User> list =  new ArrayList<>();
				while (rs.next()) {
					//循环用有参构造方法直接给airInfo对象赋值
					User user = new User(rs.getString("username"),
							rs.getString("userpass"),
							rs.getString("name"),
							rs.getString("sex"),
							rs.getString("age")

					);
					//循环把airInfo对象添加到航班集合里面
					list.add(user);
				}
				request.setAttribute("list", list);
				request.getRequestDispatcher("/users.jsp").forward(request,response);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void init()throws ServletException {
		
	}

}
