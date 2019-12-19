package data.object;

public class User {
	
	private String email;
	private String password;
	private String sex;
	private String firstname;
	private String day;
	private String month;
	private String year;
	public User(String email, String password, String sex, String firstname,
			String day, String month, String year) {
		super();
		this.email = email;
		this.password = password;
		this.sex = sex;
		this.firstname = firstname;
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
