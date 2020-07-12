# Servlet

Servlet ?  동적으로 응답 결과를 만들어 내는 것. (요청이 들어왔을 때)
 Servlet, package, JSP, Interface   >   java class + css, html, img  >  java web application   >   WAS

 cf) middle ware (WAS)  or  Framework 등을 사용할 때는 rule을 잘 지켜 도움을 받아야함.
     ex) java web app 에서의 web.xml (배포기술자 중요(3.0이상에서는 annotation 대체)),  lib 디렉토리 => jar file,  classes 디렉토리 => java package, classes ....

**웹 페이지를 구성하는 HTML을 JSP로 표현,  복잡한 로직을 서블릿으로 구현.**

response.setContentType("text/html;charset=utf-8");   //응답을 보낼 서식 설정.
PrintWriter out = response.getWriter();                    //response.getWrite(); 를 호출하면 PrintWriter( java.io) 객체 반환.  
 
servlet의 생명주기 :  실습 :  init, destroy, service + 생성자 확인.
  생성자 -> init  -> service    /   새로고침시 service  /  코드 수정시 메모리 상의 객체 변경을 위해 destory
==>  WAS는 서블릿 요청 받으면  메모리에 있는지 확인  =>  init() or service() 실행
        WAS가 종료되거나, WA가 갱신 되면 destroy() 실행

service() :  HttpServlet의 템플릿메서드패턴으로 존재 : doGET / doPOST 등 호출.
