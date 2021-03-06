package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;




@WebServlet(name="ResponseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //Content-Type : application/json
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");


        //29 ~ 31줄 코드를 json으로 변경해야된다.
        HelloData helloData =new HelloData();
        helloData.setUsername("kim");
        helloData.setAge(20);

        //{"username": "kim", "age":20}
        String result = objectMapper.writeValueAsString(helloData); //objectMapper.writeValueAsString()를 사용하면 객체로 값을 써서  문자로 변경
        response.getWriter().write(result);
    }
}
