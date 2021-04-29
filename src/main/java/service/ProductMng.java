package service;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import DAO.ProductRepository;
import DTO.Product;
import exception.DuplicateProductException;

/**
 * Servlet implementation class ProductMng
 */
@WebServlet("/productMng")
public class ProductMng extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductMng() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String filename = "";
		String realFolder = "C:\\Users\\ITPS\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\WebMarket\\images";
		int maxSize = 10 * 1024 * 1024;  //파일의 최대업로드 용량
		String encType = "UTF-8"; // 데이터가 어떻게 인코딩이되어있는지에 대하여
		
		MultipartRequest multi = new MultipartRequest(request, realFolder,maxSize, encType, new DefaultFileRenamePolicy());
		
		String productId = multi.getParameter("productId");
		String name = multi.getParameter("name");
		String unitPrice = multi.getParameter("unitPrice");
		String description = multi.getParameter("description");
		String manufacturer = multi.getParameter("manufacturer");
		String category =  multi.getParameter("category");
		String unitsInStock = multi.getParameter("unitsInStock");
		String condition = multi.getContentType("condition");
		
		Enumeration<String> files = multi.getFileNames();
		String fileName = files.nextElement();
		fileName = multi.getFilesystemName(fileName); //서버에 저장되어있는 파일이름가져오기
		
		Product product = new Product(productId, name,unitPrice, description, manufacturer, category, unitsInStock, condition, fileName);
		
		ProductRepository pr = ProductRepository.getInstance();
		try {
			// 상품 정보 저장
			pr.addProduct(product);
				
			response.sendRedirect("/WebMarket/error/products.jsp?active=addProduct");
	//		dis.forward(request, response); //사용자가 URL에 변화를 못느끼고 원하는 요청을 수행하게함.
			// 상품 코드가 중복되지 않아서 성공적으로 상품 정보를 저장했다면
			// 상품 목록 페이지로 이동
		} catch(DuplicateProductException e) {
			// 상품코드가 중복됐다면
			// 상품 코드 중복 페이지로 이동
			response.sendRedirect("/WebMarket/error/duplicate.jsp?active=addProduct");
		}
	
		
	}

}
