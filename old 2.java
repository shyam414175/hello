package com.example.crud;

public class Items {
	
		  private int id;
		  private String name;
		  private String category;
		  public Items() {
				super();
		  }	
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public Items(int id, String name, String category) {
			super();
			this.id = id;
			this.name = name;
			this.category = category;
		}
	}