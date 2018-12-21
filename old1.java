package com.example.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;





@Repository
public class Iservice {

	@Autowired
	JdbcTemplate jdbt;

	public List<Items> getItems() {
		List<Items> items = jdbt.query("select * from item", (result, rowNum) -> new Items(result.getInt("id"),
				result.getString("name"), result.getString("category")));
		return items;

	}

	public List<Items> getItems(String id)
	{
	
		List<Items> searchResults = null;
		String query = "";
		query= "SELECT * FROM item where id='"+id+"'";
		searchResults=jdbt.query(query,new BeanPropertyRowMapper<Items>(Items.class));
		int i = 0;
		for (; i < searchResults.size();) 
		{
			Items e = new Items();
			e = (Items) searchResults.get(i);
				i++;
		
	}
		return searchResults;
}
	

	public int addItem(Items i) {
		int id = i.getId();
		String name = i.getName();
		String category = i.getCategory();
		String query = "INSERT INTO ITEM VALUES(?,?,?)";
		return jdbt.update(query, id, name, category);
	}

	public int updateItems(Items item, String id) {
		int result = 0;
		try {
			String sql = "UPDATE item SET name=?,category=? WHERE id = ? ";
			
			result = jdbt.update(sql, item.getName(), item.getCategory(), id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 System.out.println("result value====>"+result);
		return result;
		
	}

	public int deleteItems(String id) {
		int result = 0;
		try {
			String sql = "Delete from  item WHERE id = ? ";
			
			result = jdbt.update(sql, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("result value====>"+result);
		return result;
}
}