package carsSystem.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelsDAO {
	private DateBaseManager conn;
	private ResultSet result;
	private int records;

	public synchronized List<ModelEntity> getNews() {
		String query = "SELECT car_id as ID,brand as Brand,model as Model, Price as Price, picture as Picture from cars c, car_brands cb where c.car_brand_id=cb.car_brand_id order by car_id desc limit 3";
		List<ModelEntity> list = new ArrayList<ModelEntity>();
		ModelEntity model;
		conn = new DateBaseManager();
		try {
			result = conn.Select(query);
			while (result.next()) {
				model = new ModelEntity();
				model.setId(result.getInt("ID"));
				model.setBrand(result.getString("Brand"));
				model.setModel(result.getString("Model"));
				model.setPrice(result.getDouble("Price"));
				model.setPicture(result.getString("Picture"));
				list.add(model);
			}
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public synchronized List<ModelEntity> getModels(int offset, int records) {
		String query = "select c.car_brand_id as Brand_id, picture as Pic, car_id as Id,brand as Brand, model as Model,seria as Seria, price as Price,info as Info, registration_date as Reg_date from cars c,car_brands cb where c.car_brand_id=cb.car_brand_id order by 3 limit "
				+ offset + ", " + records;
		List<ModelEntity> list = new ArrayList<ModelEntity>();
		ModelEntity model = null;
		conn = new DateBaseManager();
		try {
			result = conn.Select(query);
			while (result.next()) {
				model = new ModelEntity();
				model.setBrand_id(result.getInt("Brand_id"));
				model.setPicture(result.getString("Pic"));
				model.setId(result.getInt("Id"));
				model.setBrand(result.getString("Brand"));
				model.setModel(result.getString("Model"));
				model.setSeria(result.getString("Seria"));
				model.setPrice(result.getDouble("Price"));
				model.setInfo(result.getString("Info"));
				model.setData(result.getString("Reg_date"));
				list.add(model);
			}
			result.close();

			result = conn.Select("SELECT COUNT(*) FROM cars");
			if (result.next())
				this.records = result.getInt(1);
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public synchronized ModelEntity getModelInfo(int id) {
		String query = "select car_id as id,brand as Brand,model as Model,seria as seria,price as Price, info as Info,DATE_FORMAT(registration_date,'%d.%m.%Y ã.') AS dat,picture as Picture "
				+ "from cars c,car_brands cb where c.car_brand_id=cb.car_brand_id and car_id=" + id;
		ModelEntity model = new ModelEntity();
		conn = new DateBaseManager();
		try {
			result = conn.Select(query);
			if (result.next()) {
				model.setId(result.getInt("id"));
				model.setBrand(result.getString("Brand"));
				model.setModel(result.getString("Model"));
				model.setSeria(result.getString("seria"));
				model.setPrice(result.getDouble("Price"));
				model.setInfo(result.getString("Info"));
				model.setData(result.getString("dat"));
				model.setPicture(result.getString("Picture"));
			}
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}

	public synchronized void insertModel(ModelEntity model) {
		String query;
		int brand_id = 1;
		conn = new DateBaseManager();

		query = "select car_brand_id as id from car_brands where brand = '" + model.getBrand() + "'";
		try {
			result = conn.Select(query);
			if (result.next())
				brand_id = result.getInt("id");
			result.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		query = "insert into cars(car_brand_id,model,seria,price,info,picture,registration_date) values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement pst = ConnectionManager.getInstance().preparedStatement(query);
			pst.setInt(1, brand_id);
			pst.setString(2, model.getModel());
			pst.setString(3, model.getSeria());
			pst.setDouble(4, model.getPrice());
			pst.setString(5, model.getInfo());
			pst.setString(6, model.getPicture());
			pst.setString(7, model.getData());
			pst.executeUpdate();
			ConnectionManager.getInstance().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public synchronized ModelEntity loadModel(int id) {
		String query = "SELECT brand as Brand,picture as Pic, model as Model,seria as Seria,price as Price, info as Info,registration_date as Reg_date from cars c,car_brands cb where c.car_brand_id=cb.car_brand_id and car_id= "
				+ id;
		ModelEntity model = new ModelEntity();
		conn = new DateBaseManager();
		try {
			result = conn.Select(query);
			if (result.next()) {
				model.setId(id);
				model.setBrand(result.getString("Brand"));
				model.setPicture(result.getString("Pic"));
				model.setModel(result.getString("Model"));
				model.setSeria(result.getString("Seria"));
				model.setPrice(result.getDouble("Price"));
				model.setInfo(result.getString("Info"));
				model.setData(result.getString("Reg_date"));

			}
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}

	public synchronized void updateModel(ModelEntity model) {
		String query = "update cars set model='" + model.getModel() + "',seria='" + model.getSeria() + "',price='"
				+ model.getPrice() + "',info='" + model.getInfo() + "' ,registration_date='" + model.getData()
				+ "' where car_id=" + model.getId() + " and car_brand_id=" + model.getBrand_id();
		conn = new DateBaseManager();
		conn.Update(query);
	}

	public synchronized void deleteModel(int id) {
		String query = "delete from cars where car_id = " + id;
		conn = new DateBaseManager();
		conn.Delete(query);
	}

	public int getRecords() {
		return records;
	}
}
