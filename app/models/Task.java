package models;

import java.util.List;
import javax.persistence.*;

import play.data.validation.*;
import play.db.jpa.*;


@Entity
@Table(name="employee")
public class Task{

	@Id
	@GeneratedValue
	@Column(name="Employee_id")
	public String id;
	
	@Constraints.Required
	@Column(name="FirstName")
	public String label;
	
	@OneToOne(mappedBy="task", cascade = CascadeType.ALL)
	public TaskDetail taskDetail;
	
	public static List<Task> all(){
		return JPA.em().createQuery("from Task").getResultList();
	}
	
	public static Task findTaskById(String id){
		return JPA.em().find(Task.class, id);
	}
	
	
	public void create(){
		//task.save();
		//this.id = id;
		JPA.em().persist(this);
	}
	
	public void delete(){
		//find.ref(id).delete();
		
		JPA.em().remove(this);
	}
	
}
