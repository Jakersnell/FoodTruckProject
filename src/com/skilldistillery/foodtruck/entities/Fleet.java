package com.skilldistillery.foodtruck.entities;

public class Fleet {
	private int memberCount = 0;
	private int maxTrucks;
	private FoodTruck[] members;

	public Fleet(int maxTrucks) {
		this.maxTrucks = maxTrucks;
		this.members = new FoodTruck[maxTrucks];
	}

	public int getMemberCount() {
		return this.memberCount;
	}
	
	
	public int getMaxTrucks() {
		return this.maxTrucks;
	}

	public boolean addFoodTruck(FoodTruck truck) {
		if (memberCount != maxTrucks) {
			members[memberCount++] = truck;
			return true;
		} else {
			return false;
		}
	}
	
	private FoodTruck[] getTrucks() {
		FoodTruck[] trucks = new FoodTruck[memberCount];
		for (int i =0; i<memberCount; i++) {
			trucks[i] = members[i];
		}
		return trucks;
	}

	public void displayAllTrucks() {
		for (FoodTruck truck: getTrucks()) {
			System.out.println(truck);
		}
	}

	public void displayHighestRatedTruck() {
		if (memberCount != 0) {
			FoodTruck highestRated = members[0];
			for (FoodTruck currentTruck : getTrucks()) {
				if (currentTruck.getRating() > highestRated.getRating()) {
					highestRated = currentTruck;
				}
			}
			System.out.println(highestRated);
		}
	}

	public void displayAverageRating() {
		double scores = 0.0;
		for (FoodTruck truck : getTrucks()) {
			scores += truck.getRating();
		}
		System.out.println(scores/memberCount);
	}
}
