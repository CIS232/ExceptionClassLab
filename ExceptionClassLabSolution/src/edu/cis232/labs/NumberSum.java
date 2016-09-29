package edu.cis232.labs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NumberSum {

	public static void main(String[] args) {
		Scanner input = getFileUntilItExists();
		
		double sum = 0;
		while(input.hasNextLine()){
			sum += parseDoubleIfValid(input.nextLine());
		}
		
		System.out.printf("The sum of the numbers is %.2f%n", sum);
	}
	
	public static double parseDoubleIfValid(String str){
		double val = 0;
		
		try {
			val = Double.parseDouble(str);
		} catch (NumberFormatException e){
			System.out.printf("\"%s\" is not a valid double%n", str);
		}
		
		return val;
	}

	public static Scanner getFileUntilItExists(){
		Scanner keyboard = new Scanner(System.in);
		File file = null;
		Scanner input = null;
		
		while(input == null){
			System.out.println("Give me a valid filename");
			file = new File(keyboard.nextLine());
			try {
				input = new Scanner(file);
			} catch (FileNotFoundException e) {
				System.out.println("File not found!");
			}
		}
		
		System.out.println("Thanks for the file!");
		return input;
	}
}
