package edu.escuelaing.arem.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import edu.escuelaing.arem.entites.Task;


@Component
public class TaskDAOImpl implements TaskDAO {


	@Autowired
	private DataSource dataSource;

    public List<Task> findAll() throws SQLException {
       String query = "SELECT * FROM prueba;";
		List<Task> tasks = new ArrayList<Task>();
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Task task = new Task();
				task.setAuthor(rs.getString("author"));
				task.setDescription(rs.getString("description"));
				task.setPriority(rs.getInt("priority"));
				
				tasks.add(task);
			}
			connection.close();
			return tasks;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
    }

	@Override
	public void insertTask(Task t) throws SQLException {
		 String query = "INSERT INTO prueba VALUES ('"+t.getAuthor()+
	                "','"+t.getDescription()+"',"+t.getPriority()+");";
	        Connection connection = null;
	        System.out.println(query);
	        try {
	            connection = dataSource.getConnection();
	            Statement stmt = connection.createStatement();
	            stmt.execute(query);
	            connection.close();
	            
	        } catch (SQLException e) {
	            System.err.println("Error trying to create task ["+ t.getDescription() +"], Exception: " + e.getMessage());
	        } 
	}
		
}



