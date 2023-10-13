package com.skilldistillery.foodtruck.entities;

public class Fleet {
	private int memberCount;
	private int max_trucks;
	private FoodTruck[] members;
	
	public Fleet() {
		members = new FoodTruck[max_trucks];
	}
	
	public boolean addFoodTruck(FoodTruck truck) {
		if (memberCount != max_trucks) {
			members[memberCount++] = truck;
			return true;
		} else {
			return false;
		}
	}
}
