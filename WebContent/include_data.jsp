<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	int  gugudan =Integer.parseInt(request.getParameter("gugudan"));
  
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>5단 구구단 출력</title>
</head>
<body>
	<%
			for(int i =1; i<=9; i++){
	%>
		<p><%=gugudan%> * <%=i%> = <%=gugudan * i%></p>
	<%
				
			}
		%>
</body>
</html>