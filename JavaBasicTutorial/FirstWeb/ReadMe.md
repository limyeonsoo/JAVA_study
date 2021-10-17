JSP 문법 
 1. <%!  %>  : 선언문
    위치가 상관 없음.  선언 문이기 때문에.  변수, 메소드 선언
    { 선언 후,  service  try에서  out.write와  out.print로 표현 }
 
2. <%= %> : 표현식   응답, 화면, 웹브라우저에 표현함.

3. <%   %> : 스크립트릿
   모두 service 안에 선언되는 변수, 스크립트릿을 끊었다가 이어도 됨.  <% %>만 제거 후  html형식으로 servlet화
4. 주석  :  HTML, JAVA, JSP 모든 주석 사용 가능   deep :  JSV > JAVA > HTML
    * JSP 주석은 JSP기 때문에 servlet으로 안바뀜.  <%--   --%>  JSP페이지에서만 사용. 표시, 출력 안됨.
    * JAVA 주석은 실행이 안됨.  //  /**/   JSP-> JAVA로 바뀐 후, JAVA에서 실행될 때만 주석처리
    * HTML : 다 되지만, 브라우저에서 와서 인지 함.

JSP 내장 객체 : 
  JSP에서 servlet으로 JAVA로 바뀔 때  Service() 안에서 사용하는 이미 선언된 객체들.
   response, request, application, session, out, config, page, exception, pageContext ......
   ex)   StringBuffer url = request.getRequestURL();
          out.print("url : " + url.toString());
          // requset와 out을 선언하지 않고 사용 가능.  (JSP-> servlet 선언 되어있음)


--------------------------
Redirect   (302 + url)
 JSP 는  sendRedirect 메소드 이용   클라이언트 -> 서버  ->(redirect할 URL, + header + 302)  클라이언트 -> url request 
 즉, Client 가 server 로 request 를 2번 시도.

Forward   :  servlet1로 요청을 했는데 servlet1이 servlet2로 forward후  servlet2가 client로 response

Forward != Redirect 
 Redirect :  response와 request객체가 다름. 2번의 request, 2번의 response
 Forward :  request와 response가 하나.  request시 WAS가 만든 response 객체가 그대로 유지.

  URL 은 Front   response의 내용은  Next


Servlet 은  로직 good /  HTML bad
JSP는        로직 bad  /   HTML good
 =>  servlet과 JSP를 forwarding을 이용하여 구현

 * JSP 의 자바 코드를 줄이고 디자이너들도 편하게 사용 할 수 있도록 ?   EL,  JSTL 등.
 
 EL  :  ${ 변수 }   ${v1} + ${v2} + ${result}   // getAttribute 없이 변수를 가져올 수 있음.

