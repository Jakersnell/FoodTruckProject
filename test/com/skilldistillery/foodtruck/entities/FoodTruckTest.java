package com.skilldistillery.foodtruck.entities;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class FoodTruckTest {
	private FoodTruck truck;

	@Before
	public void setUp() {
		truck = new FoodTruck("Pizza Palace", "Pizza", 5.0);
	}
	
	@After
	public void tearDown() {
		truck = null;
	}

	@Test
	public void test_getId_increments_correctly() {
		int id = truck.getId();
		FoodTruck anotherTruck = new FoodTruck("Burger Haven", "Burgers", 4.5);
		assertEquals(id + 1, anotherTruck.getId());
	}

	@Test
	public void test_getRating_returns_rating() {
		assertEquals(5.0, truck.getRating(), 0.01);
	}

	@Test
	public void test_setRating_updates_rating() {
		truck.setRating(4.5);
		assertEquals(4.5, truck.getRating(), 0.01);
	}

	@Test
	public void test_getName_returns_name() {
		assertEquals("Pizza Palace", truck.getName());
	}

	@Test
	public void test_setName_updates_name() {
		truck.setName("New Pizza Palace");
		assertEquals("New Pizza Palace", truck.getName());
	}

	@Test
	public void test_getFoodType_returns_foodType() {
		assertEquals("Pizza", truck.getFoodType());
	}

	@Test
	public void test_setFoodType_updates_foodType() {
		truck.setFoodType("Pasta");
		assertEquals("Pasta", truck.getFoodType());
	}
}
