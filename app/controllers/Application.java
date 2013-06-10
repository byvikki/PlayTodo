package controllers;

import models.Task;
//import models.TaskDetail;
import play.*;
import play.data.Form;
import play.mvc.*;
import play.db.jpa.*;
import views.html.*;


public class Application extends Controller {
	
	private static Form<Task> taskForm = Form.form(Task.class);
	
	//private static Form<TaskDetail> taskDetail = Form.form(TaskDetail.class);
  
	@Transactional
    public static Result index() {
    	
    	//Form<Task> taskForm = Form.form(Task.class);


    	return ok(index.render(Task.all(),  taskForm));

    }
    
    public static Result tasks(){
    	return TODO;
    }


    @Transactional
    public static Result newTask(){    	
    	
    	Form<Task> filledTask = taskForm.bindFromRequest();    	
    	if(filledTask.hasErrors()){

    		return badRequest(views.html.index.render(Task.all(),  filledTask));
    	}
    	else{
    		//Task.create(filledForm.get());
    		
    		filledTask.get().taskDetail.setTask(filledTask.get());
    		filledTask.get().create();
    		
    		return redirect(routes.Application.index());
    	}

    }
    
    @Transactional
    public static Result deleteTask(String id){
    	//Task.delete(id);
    	
    	Task.findTaskById(id).delete();
    	return redirect(routes.Application.index());
    }
  
}
