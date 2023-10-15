package com.skilldistillery.foodtruck.entities;

public class FoodTruck {
	private static int globalTruckCount = 0;
	private int id;
	private double rating;
	private String name;
	private String foodType;

	public FoodTruck(String name, String foodType, double rating) {
		this();
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
	}
	
	public FoodTruck() {
		this.id = ++ globalTruckCount;
	}

	public int getId() {
		return id;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	@Override
	public String toString() {
		return "FoodTruck [id=" + id + ", rating=" + rating + ", name=" + name + ", foodType=" + foodType + "]";
	}

}
