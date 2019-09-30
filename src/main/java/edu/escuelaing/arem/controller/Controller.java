package edu.escuelaing.arem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.arem.DAO.TaskDAO;
import edu.escuelaing.arem.entites.Task;;

@RestController
@RequestMapping("/api")
public class Controller {

	@Autowired
	TaskDAO taskDAO;
	
	@RequestMapping(value="/tasks",method = RequestMethod.GET)
	public ResponseEntity<?> listAllTasks(){
	    try {
	        return new ResponseEntity<>(taskDAO.findAll(),HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        return new ResponseEntity<>("Algo salio mal",HttpStatus.NOT_FOUND);
	    }
    }
	@PostMapping("/tasks")
    public ResponseEntity<?> createTask(@RequestBody Task task) {
        try {
        	taskDAO.insertTask(task);
            return new ResponseEntity<>(task, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("No se pudo crear la tarea", HttpStatus.FORBIDDEN);
        }
    }
}