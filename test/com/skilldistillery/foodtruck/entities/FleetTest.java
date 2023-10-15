package com.skilldistillery.foodtruck.entities;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;



public class FleetTest {
	private Fleet fleet;

	@Before
	public void setUp(){
		fleet = new Fleet(5);
	}
	
	@After
	public void tearDown() {
		fleet = null;
	}

	@Test
	public void test_addFoodTruck_adds_truck_to_fleet() {
		FoodTruck truck = new FoodTruck("Truck1", "Pizza", 4.0);
		assertTrue(fleet.addFoodTruck(truck));
		assertEquals(1, fleet.getMemberCount());
	}

	@Test
	public void test_addFoodTruck_does_not_add_when_full() {
		for (int i = 0; i < 5; i++) {
			FoodTruck truck = new FoodTruck("Truck" + i, "Pizza", 4.0);
			fleet.addFoodTruck(truck);
		}
		FoodTruck anotherTruck = new FoodTruck("AnotherTruck", "Burger", 5.0);
		assertFalse(fleet.addFoodTruck(anotherTruck));
		assertEquals(5, fleet.getMemberCount());
	}

	@Test
	public void test_getMaxTrucks_returns_max_trucks() {
		assertEquals(5, fleet.getMaxTrucks());
	}

	@Test
	public void test_getMemberCount_returns_correct_count() {
		FoodTruck truck = new FoodTruck("Truck1", "Pizza", 4.0);
		fleet.addFoodTruck(truck);
		assertEquals(1, fleet.getMemberCount());
	}

	@Test
	public void test_getMemberCount_returns_zero_for_empty_fleet() {
		assertEquals(0, fleet.getMemberCount());
	}
}
