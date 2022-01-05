package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet  extends HttpServlet {

    //Ctrl +  O   select Method to Override/implement
    // service 메소드 실행
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);


        String username = request.getParameter("username"); //request.getParameter()로 쿼리파라미터 조회 가능하다
        System.out.println("username = " + username);

        response.setContentType("text/plain");  //header   Content-Type
        response.setCharacterEncoding("UTF-8"); //header   Content-Type
        response.getWriter().write("hello " + username);
    }
}

