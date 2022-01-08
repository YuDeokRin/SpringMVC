<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%
    //request, response 사용 가능하다. 그냥 쓸 수 있다.
    MemberRepository memberRepository = MemberRepository.getInstance();

    System.out.println("MemberSaveServlet.service");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age")); // request.getParameter()의 결과 값을 항상 문자이다. 그래서  int 로 바꿔준다

    Member member = new Member(username, age);
    memberRepository.save(member);

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <il>id=<%=member.getId()%></il>
    <il>username=<%=member.getUsername()%></il>
    <il>age=<%=member.getAge()%></il>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
