package tarefas.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Iterator;

public class JDBCUtils {
	private static String jdbcURL = "jdbc:mysql://localhost:3306/todo_management";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "root";

	public static Connection geConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void printSQLEXception(SQLException ex) {
		for (Throwable throwable : ex) {
			if (throwable instanceof SQLException) {
				throwable.printStackTrace();
				System.out.println("SQL State: " + ((SQLException) throwable)
						.getSQLState());
				System.out.println("Error Code: " + ((SQLException) throwable)
						.getSQLState());
				System.out.println("Message " + throwable.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();

				}
			}
		}
	}

	public static Date getSQLDate(LocalDate date) {
		return java.sql.Date.valueOf(date);
	}

	public static LocalDate gettUtilDate(Date sqlDate) {
		return sqlDate.toLocalDate();

	}

}