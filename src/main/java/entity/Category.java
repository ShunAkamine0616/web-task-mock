package entity;

public class Category {
	private Integer id;
	private String name;
	private Integer created_at;
	private Integer updated_at;
	
	public Category() {
		
	}
	
	public Category(Integer id, String name, Integer created_at) {
		this.id = id;
		this.name = name;
		this.created_at = created_at;
	}
	
	public Category(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Category(String name, Integer created_at) {
		this.name = name;
		this.created_at = created_at;
	}
	
	public Category(Integer id, String name, Integer created_at, Integer updated_at) {
		this.id = id;
		this.name = name;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Integer created_at) {
		this.created_at = created_at;
	}
	public void setUpdated_at(Integer updated_at) {
		this.updated_at = updated_at;
	}
	
}
