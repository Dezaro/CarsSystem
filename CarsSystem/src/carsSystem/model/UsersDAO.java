package carsSystem.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO {

	private DateBaseManager conn;
	private ResultSet result;
	private int records;

	public synchronized List<UserEntity> getUsers(int offset, int records) {
		String query = "select user_id as ID,user_name as Username,user_fname as Fname,user_lname as Lname,user_email as Email, user_password as Pass,user_role as Role from users limit "
				+ offset + ", " + records;
		List<UserEntity> list = new ArrayList<UserEntity>();
		UserEntity user = null;

		conn = new DateBaseManager();
		try {
			result = conn.Select(query);
			while (result.next()) {
				user = new UserEntity();
				user.setId(result.getInt("ID"));
				user.setUserName(result.getString("Username"));
				user.setFirstName(result.getString("Fname"));
				user.setLastName(result.getString("Lname"));
				user.setEmail(result.getString("Email"));
				user.setPassword(result.getString("Pass"));
				user.setRole(result.getString("Role"));
				list.add(user);
			}
			result.close();

			result = conn.Select("SELECT COUNT(*) FROM users");
			if (result.next())
				this.records = result.getInt(1);
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public synchronized void insertUser(UserEntity user) {
		String query = "insert into users(user_name,user_fname,user_lname,user_email,user_password,user_role) values('"
				+ user.getUserName() + "', '" + user.getFirstName() + "','" + user.getLastName() + "', '"
				+ user.getEmail() + "', '" + user.getPassword() + "', '" + user.getRole() + "')";
		conn = new DateBaseManager();
		conn.Insert(query);
	}

	public synchronized void updateUser(UserEntity user) {
		String query = "update users set user_name='" + user.getUserName() + "', user_fname='" + user.getFirstName()
				+ "',user_lname='" + user.getLastName() + "',user_email='" + user.getEmail() + "',user_password='"
				+ user.getPassword() + "',user_role='" + user.getRole() + "' where user_id= " + user.getId() + "";
		conn = new DateBaseManager();
		conn.Update(query);
	}

	public synchronized UserEntity loadUser(int id) {
		String query = "select user_name as Username,user_fname as Fname,user_lname as Lname,user_email as Email, user_password as Pass,user_role as Role from users where user_id = "
				+ id;
		UserEntity user = new UserEntity();
		conn = new DateBaseManager();
		try {
			result = conn.Select(query);
			if (result.next()) {
				user = new UserEntity();
				user.setId(id);
				user.setUserName(result.getString("Username"));
				user.setFirstName(result.getString("Fname"));
				user.setLastName(result.getString("Lname"));
				user.setEmail(result.getString("Email"));
				user.setPassword(result.getString("Pass"));
				user.setRole(result.getString("Role"));
			}
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public synchronized void deleteUser(int id) {
		String query = "delete from users where user_id = " + id;
		conn = new DateBaseManager();
		conn.Delete(query);
	}

	public int getRecords() {
		return records;
	}

}
