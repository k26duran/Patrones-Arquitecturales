package edu.escuelaing.arem.DAO;

import java.sql.SQLException;
import java.util.*;

import org.springframework.stereotype.Service;

import edu.escuelaing.arem.entites.Task;

@Service
public interface TaskDAO{
    public List<Task> findAll() throws SQLException ;  
    public void insertTask(Task t) throws SQLException;
}