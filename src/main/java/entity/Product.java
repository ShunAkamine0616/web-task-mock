package entity;

import java.sql.Timestamp;

public class Product {
	private Integer id;
	private Integer product_id;
	private Integer category_id;
	//	private String category_name;
	private Category category; // 追加
	private String name;
	private Integer price;
	private String image_path;
	private String description;
//	private SimpleDateFormat create_at;
//	private SimpleDateFormat update_at;
//	private String create_at;
//	private String update_at;
	private Timestamp create_at;
	private Timestamp update_at;
	
	public Product() {

	}

	public Product(String name, Integer price) {
		this.name = name;
		this.price = price;
	}

	public Product(Integer product_id, String name, Integer price) {
		this.product_id = product_id;
		this.name = name;
		this.price = price;
	}

	public Product(Integer product_id, Integer category_id, 
			String name, Integer price,  String description, Timestamp create_at) {
		this.product_id = product_id;
		this.category_id = category_id;
//		this.category = new Category(category_id, category_name);
		this.name = name;
		this.price = price;
		this.description = description;
		this.create_at = create_at;
	}
	
	public Product(Integer product_id, Integer category_id, 
			String name, Integer price,  String description, Timestamp create_at, Timestamp update_at) {
		this.product_id = product_id;
		this.category_id = category_id;
//		this.category = new Category(category_id, category_name);
		this.name = name;
		this.price = price;
		this.description = description;
		this.create_at = create_at;
		this.update_at = update_at;
	}
	
	public Product(Integer id, Integer product_id, Integer category_id, 
			String name, Integer price,  String description, Timestamp create_at) {
		this.id = id;
		this.product_id = product_id;
		this.category_id = category_id;
//		this.category = new Category(category_id, category_name);
		this.name = name;
		this.price = price;
		this.description = description;
		this.create_at = create_at;
	}
	
	public Product(Integer id, Integer product_id, Integer category_id, 
			String name, Integer price,  String description, Timestamp create_at, Timestamp update_at) {
		this.id = id;
		this.product_id = product_id;
		this.category_id = category_id;
//		this.category = new Category(category_id, category_name);
		this.name = name;
		this.price = price;
		this.description = description;
		this.create_at = create_at;
		this.update_at = update_at;
	}
	

	public Product(Integer product_id, Integer category_id, String category_name,
			String name, Integer price,  String description) {
		this.product_id = product_id;
		this.category_id = category_id;
		this.category = new Category(category_id, category_name);
		this.name = name;
		this.price = price;
		this.description = description;
	}
	
	public Product(Integer id, Integer product_id, Integer category_id, String category_name,
			String name, Integer price,  String description, Timestamp create_at, Timestamp update_at) {
		this.id = id;
		this.product_id = product_id;
		this.category_id = category_id;
		this.category = new Category(category_id, category_name);
		this.name = name;
		this.price = price;
		this.description = description;
		this.create_at = create_at;
		this.update_at = update_at;
	}

	//	
	//	public String getCategory_name() {
	//		return category_name;
	//	}
	//
	//	public void setCategory_name(String category_name) {
	//		this.category_name = category_name;
	//	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public String getC_name() {
		return name;
	}

	public void setC_name(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Timestamp create_at) {
		this.create_at = create_at;
	}

	public Timestamp getUpdate_at() {
		return update_at;
	}
	
	public void setUpdate_at(Timestamp update_at) {
		this.update_at = update_at;
	}
}
