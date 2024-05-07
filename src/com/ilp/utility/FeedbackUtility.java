package com.ilp.utility;

import java.util.Scanner;

import com.ilp.service.FeedbackService;
import com.ilp.service.FeedbackServiceImpl;

import com.ilp.service.ProgramService;
import com.ilp.service.ProgramServiceImpl;

import com.ilp.service.TrainerService;
import com.ilp.service.TrainerServiceImpl;
public class FeedbackUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String mainMenuOption = "y";
		do {
		System.out.println("What do you want to do? 1. Insert 2. Read Feedbacks");
		int choice = scanner.nextInt();
		if(choice == 1) { 
			System.out.println("1.Program 2. Trainer 3.Feedback");
			int option = scanner.nextInt();
			switch(option)
			{
			case 1 :
				ProgramService programService = new ProgramServiceImpl();
				programService.insertProgram();
				break;
			case 2 :
				TrainerService trainerService = new TrainerServiceImpl();
				trainerService.insertTrainers();
				break;
			case 3 :
				FeedbackService feedbackService2 = new FeedbackServiceImpl();
				feedbackService2.insertFeedbacks();
				break;
			}
		}
		else if(choice == 2)
		{
			System.out.println("1. Employee Based 2. Trainer Based");
			int option = scanner.nextInt();
			switch(option)
			{
			case 1:
				FeedbackService feedbackService1 = new FeedbackServiceImpl();
				feedbackService1.getAllFeedbacksOfEmployee();
				break;
			case 2:
				FeedbackService feedbackService2 = new FeedbackServiceImpl();
				feedbackService2.getAllFeedbacksOfTrainers();
				break;
			}
		}
		scanner.nextLine();
		System.out.println("Go to main menu? y or n");
		mainMenuOption = scanner.nextLine();
		}while(mainMenuOption.equals("y"));
		
		

	}

}
