package carsSystem.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandsDAO {

	private DateBaseManager conn;
	private ResultSet result;
	private int records;

	public synchronized List<String> getBrands() {
		String query = "select brand from car_brands";
		List<String> list = new ArrayList<String>();
		conn = new DateBaseManager();
		try {
			result = conn.Select(query);
			while (result.next()) {
				list.add(result.getString("brand"));
			}
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public synchronized List<ModelEntity> getBrandModels(String brand, int offset, int records) {
		String query = "SELECT car_id as ID,brand as Brand,model as Model, Price as Price, picture as Picture from cars c, car_brands cb where c.car_brand_id=cb.car_brand_id and cb.brand='"
				+ brand + "' limit " + offset + ", " + records;
		List<ModelEntity> list = new ArrayList<ModelEntity>();
		ModelEntity model = null;
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

			result = conn
					.Select("SELECT COUNT(*) FROM cars c, car_brands cb WHERE c.car_brand_id=cb.car_brand_id and cb.brand='"
							+ brand + "'");
			if (result.next())
				this.records = result.getInt(1);
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int getRecords() {
		return records;
	}
}
