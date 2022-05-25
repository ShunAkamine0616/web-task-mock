package entity;

public class User {
	private int userId;
    private String loginId;
    private String password;
    private String name;
    private int role;
    private int createddate;
    private int creayedtime;
    
    public User() {
    }
    
    public User(String loginId, String password) {
    	this.loginId = loginId;
    	this.password = password;
    }
    
    public User(int userId, String loginId, String password) {
        this.userId = userId;
        this.loginId = loginId;
        this.password = password;
    }
    
    public User(String loginId, String password, String name, int role) {
        this.loginId = loginId;
        this.name = name;
        this.password = password;
        this.role = role;
    }
//    public User(ResultSet rs) {
//		this.userId = rs;
//	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getCreateddate() {
		return createddate;
	}

	public void setCreateddate(int createddate) {
		this.createddate = createddate;
	}

	public int getCreayedtime() {
		return creayedtime;
	}

	public void setCreayedtime(int creayedtime) {
		this.creayedtime = creayedtime;
	}

}