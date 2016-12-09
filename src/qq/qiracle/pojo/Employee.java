package qq.qiracle.pojo;

public class Employee {
	public String id;
	public String name;
	public String age;
	public String sex;
	public String position;
	public String jobdate;
	public String salary;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String id, String name, String age, String sex, String position, String jobdate, String salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.position = position;
		this.jobdate = jobdate;
		this.salary = salary;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getJobdate() {
		return jobdate;
	}
	public void setJobdate(String jobdate) {
		this.jobdate = jobdate;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	

}
