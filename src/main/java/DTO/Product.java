package DTO;

import java.io.Serializable;

// dto - 데이터를 저장하거나 저장된 데이터를 받아오는 클래스
// dao - dto를 사용해서 데이터베이스에 데이터를 저장하거나 추가하거나 수정하는 등의 역할 클래스
public class Product implements Serializable {
	
	private static final long serialVersionUID = -7786326574566890394L;

	private String productId;    		// 상품 아이디
	private String name;  				// 상품명
	private int unitPrice;				// 상품가격
	private String descrption;			// 상품 설명
	private String manufacturer;	// 제조사
	private String category;			// 분류
	private long unitsInStock;		//재고 수
	private String condition;			// 신상품 or 중고품 or 재생품
	private String ImagePath;
	
	
	
	public Product(String productId, String name, int unitPrice) {
		setProductId(productId);
		setName(name);
		setUnitPrice(unitPrice);
	}
	public Product(String productId, String name, String unitPrice, String description, String manufacturer, String category, String unitsInStock, String condition, String ImagePath) {
	
		this.productId =productId;
		this.name = name;
		this.unitPrice = Integer.parseInt(unitPrice);
		this.descrption = description;
		this.manufacturer = manufacturer;
		this.category = category;
		this.unitsInStock = Integer.parseInt(unitsInStock);
		this.condition = condition;
		this.ImagePath = ImagePath;
	}
	
	public String getImagePath() {
		return ImagePath;
	}
	public void setImagePath(String imagePath) {
		ImagePath = imagePath;
	}
	private int unitPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getDescrption() {
		return descrption;
	}
	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public long getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	
}
