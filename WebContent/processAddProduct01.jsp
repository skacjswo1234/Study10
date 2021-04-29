<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String productId = request.getParameter("productId");
	String name = request.getParameter("name");
	
	String unitPrice = request.getParameter("productId");
	int unitPrice_i = Integer.parseInt(unitPrice);
	String description = request.getParameter("description");
	String manufacturer = request.getParameter("manufacturer");
	String category = request.getParameter("category");
	String unitsInStock = request.getParameter("unitsInStock");
	int unitsInStock_i = Integer.parseInt(unitsInStock);
	String condition = request.getParameter("condition");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
			try{
				 if(productId.length()==0)       throw new IllegalArgumentException("상품 코드 공란");
				 else if(productId.length() != 5)  throw new IllegalArgumentException("상품 코드 부적절");
				 else if(name.length()==0)        throw new IllegalArgumentException("상품명 공란");
				 else if(name.length() > 255)		throw new IllegalArgumentException("상품명 부적절");
			 	 else if(unitPrice.length()==0)   throw new IllegalArgumentException("가격 공란 ");
				else if(unitPrice_i < 0 || unitPrice_i > 10000000)   throw new IllegalArgumentException("가격 공란 ");
				 
			 	 else if(unitsInStock.length()==0)  throw new IllegalArgumentException("재고 수");
			 	 else if(unitsInStock_i < 0)  throw new IllegalArgumentException("재고 부적절");
				 else{
%>
				<p>productId = <%=productId %></p>
				<p>name = <%=name %></p>
				<p>unitPrice = <%=unitPrice %></p>
				<p>unitsInStock = <%=unitsInStock %></p>
	<% 
				 }
			} catch(IllegalArgumentException e){
				 //상품의 정보를 올바르게 입력하기 않을 경우
				 // 1.상품의 정보를 입력하지않았다.
				 // 2.상품 코드는 5자여야합니다.
				 // 3.상품명은 255자 이하여야합니다.
				 // 4.가격은 0원 이상 1천만원 이하여야만합니다.
				 // 5.재고수는 0개 이상이어야합니다.
				 
				 out.println("<p>상품 정보가 올바르지 않습니다.</p><a href=\"./addProduct.jsp\">되돌아가기</a></p>");	 
			}
%>	
</body>
</html>