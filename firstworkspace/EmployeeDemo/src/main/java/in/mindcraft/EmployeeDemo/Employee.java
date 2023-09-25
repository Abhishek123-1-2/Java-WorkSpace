package in.mindcraft.EmployeeDemo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Employee {
	@Id
	private int empid;
	private String name;
	@OneToMany
	private List<Adress> list = new ArrayList<Adress>();
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Adress> getList() {
		return list;
	}
	public void setList(List<Adress> list) {
		this.list = list;
	}
	

}
