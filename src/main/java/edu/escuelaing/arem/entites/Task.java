package edu.escuelaing.arem.entites;


public class Task{
	
	public String author;
	public int priority;
    public String description;

    public Task(){}

	public Task(String author, int priority, String description) {
		super();
		this.author = author;
		this.priority = priority;
		this.description = description;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public int getPriority() {
		return priority;
	}


	public void setPriority(int priority) {
		this.priority = priority;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

    
}


