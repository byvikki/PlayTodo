package models;

import java.util.List;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import play.data.validation.*;
import play.db.jpa.*;


@Entity
@Table(name= "employeedetail")
public class TaskDetail {
	
	@Id
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="task"))
	@Column(name="Employee_id")
	private String employeeid;
	
	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String city;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Task task;
	
	
	public static TaskDetail findTaskDetailById(String id){
		return JPA.em().find(TaskDetail.class, id);
	}
	
	public void save(){
		if(this.task.id == null){
			this.task = null;
		}
		else{
			this.task = Task.findTaskById(task.id);
		}
		JPA.em().persist(this);
	}
	
	//Getters And Setters Method

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
	

}
