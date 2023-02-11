package tarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import tarefas.model.User;
import tarefas.utils.JDBCUtils;

public class UserDao {
	public int registerEmployee(User employee) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO users" + " (first_name, last_name, username, password) VALUES"
				+ "(?, ?, ?, ?);";

		int result = 0;

		try (Connection connection = JDBCUtils.geConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
			
			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setString(3, employee.getUsername());
			preparedStatement.setString(4, employee.getPassword());
			
			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			JDBCUtils.printSQLEXception(e);
		}
		
		return result;
	}
}
