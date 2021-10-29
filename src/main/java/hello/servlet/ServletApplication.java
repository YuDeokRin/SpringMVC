package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


//@ServletComponentScan : Spring이 자동으로 현재 패키지를 포함해서 하위패키지까지
// 다 검색해서 서블릿을 찾아서 자동으로 서블릿 등록 해서 실행하게 해준다.
@ServletComponentScan //서블릿 자동 등록
@SpringBootApplication
public class ServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}

}
