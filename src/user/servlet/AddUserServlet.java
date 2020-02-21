package user.servlet;

import user.dao.UserDao;
import user.entity.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("GBK");
        response.setContentType("text/html;charset = GBK");
        String username = request.getParameter("username");
        String userpass = request.getParameter("userpass");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        PrintWriter out = response.getWriter();
        ServletContext ctx = this.getServletContext();
        String server = ctx.getInitParameter("server");
        String dbname = ctx.getInitParameter("dbname");
        String dbuser = ctx.getInitParameter("dbuser");
        String dbpwd = ctx.getInitParameter("dbpwd");
        User user = new User();
        user.setUsername(username);
        user.setUserpass(userpass);
        user.setName(name);
        user.setSex(sex);
        user.setAge(age);

        //user.setRole(Integer.parseInt(role));
        UserDao dao = new UserDao();
        dao.getConn(server, dbname, dbuser, dbpwd);
        if(dao.addUser(user)){
            out.print("注册成功！&nbsp<a href=\"index.jsp\">点击登陆</a>");
        }
        else{
            out.print("注册失败！&nbsp<a href=\"reg.jsp\">重新注册</a>");
        }


    }

}
