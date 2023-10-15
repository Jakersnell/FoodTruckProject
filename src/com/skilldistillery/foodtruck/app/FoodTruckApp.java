package com.skilldistillery.foodtruck.app;

import com.skilldistillery.foodtruck.entities.Fleet;
import com.skilldistillery.foodtruck.entities.FoodTruck;
import java.util.Scanner;

public class FoodTruckApp {
	private Scanner input;

	public static void main(String[] args) {
		FoodTruckApp fta = new FoodTruckApp();
		fta.run();

	}

	public void run() {
		input = new Scanner(System.in);
		Fleet fleet = new Fleet(5);
		inputLoop(fleet);
		menuLoop(fleet);

		input.close();
	}

	public void inputLoop(Fleet fleet) {
		System.out.println("Welcome to foodtruck app:\nlet's get started!\n");

		FoodTruck inputTruck;
		String userInput;
		for (int i = 0; i < fleet.getMaxTrucks(); i++) {

			inputTruck = new FoodTruck();
			System.out.print("Type 'quit' to exit this menu.\nWhat is the name of your food-truck?\n>>>");
			userInput = input.nextLine();
			if (userInput.toLowerCase().equals("quit")) {
				break;
			}
			inputTruck.setName(userInput);

			System.out.print("What type of food does your truck sell?\n>>>");
			inputTruck.setFoodType(input.nextLine());

			System.out.print("What is the rating of your foodtruck? 0 to 5 stars.\n>>>");
			double rating = input.nextDouble();
			
			if (rating < 0) {
				System.out.println("rating cannot be negative. defaulting to 0.");
				rating = 0;
			} else if (rating > 5) {
				System.out.println("rating cannot be over 5. defaulting to 5.");
				rating = 5;
			}
			
			inputTruck.setRating(rating);
			input.nextLine();
			
			fleet.addFoodTruck(inputTruck);
			
			if (i == fleet.getMaxTrucks() - 1) {
				System.out.println();
				System.out.println("You are out of room in your fleet!");
			}

		}

	}

	public void menuLoop(Fleet fleet) {
		System.out.println();
		if (fleet.getMemberCount() == 0) {
			System.out.println("Your have no trucks in your fleet!");
			return;
		} else {

			int userSelection = 0;
			do {
				System.out.print("What would you like to do? Please choose an option:"
						+ "\n\n1) List all existing food trucks." + "\n2) See the average rating of food trucks."
						+ "\n3) Display the highest-rated food truck." + "\n4) Quit the program.\n\n>>>");
				userSelection = input.nextInt();
				switch (userSelection) {
				case 1:
					fleet.displayAllTrucks();
					break;
				case 2:
					fleet.displayAverageRating();
					break;
				case 3:
					fleet.displayHighestRatedTruck();
					break;
				case 4:
					break;
				default:
					System.out.println(userSelection + " is not an option!");
				}
				System.out.println();
			} while (userSelection != 4);
		}
		System.out.println("Goodbye!");
	}

}
