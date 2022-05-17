package presentation;

import java.util.Scanner;

import exception.OverDraftException;
import exception.SystemException;
import model.AccountDetailsPojo;
import model.UsersPojo;
import service.AccountDetailsService;
import service.AccountDetailsServiceImpl;
import service.UsersService;
import service.UsersServiceImpl;

public class BankAccountManagmentSystem {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		UsersService usersService = new UsersServiceImpl();
		AccountDetailsService accountDetailsService = new AccountDetailsServiceImpl();

		char proceed = 'y';

		while (proceed == 'y') {
			System.out.println("*******************************");
			System.out.println("BANK ACCOUNT MANAGMENT SYSTEM");
			System.out.println("*******************************");
			System.out.println("1. Create new user");
			System.out.println("2. Login as existing user");
			System.out.println("3. Exit");
			System.out.println("*******************************");
			System.out.println("Please enter an option:");
			int option = scan.nextInt();
			System.out.println("*******************************");
			switch (option) {
			case 1:
				UsersPojo newUsersPojo = new UsersPojo();
				AccountDetailsPojo newAccountDetailsPojo = new AccountDetailsPojo();
				System.out.println("Please enter desired username: ");
				scan.nextLine();
				newUsersPojo.setUsername(scan.nextLine());
				System.out.println("Please enter desired password: ");
				newUsersPojo.setPassword(scan.nextLine());
				UsersPojo usersPojo = null;
				try {
					usersPojo = usersService.addUser(newUsersPojo, newAccountDetailsPojo);
				} catch (SystemException e) {
					System.out.println(e.getMessage());
					break;
				}
				System.out.println("*******************************");
				System.out.println("New user registered! \nUser ID is: " + usersPojo.getUserId());
				System.out.println("*******************************");
				// System.out.println("Do you want to continue?");
				// proceed = scan.next().charAt(0);
				break;
			case 2:
				UsersPojo userLoginPojo = new UsersPojo();
				AccountDetailsPojo currentUserAccountDetailsPojo = new AccountDetailsPojo();
				System.out.println("Enter your username: ");
				scan.nextLine();
				userLoginPojo.setUsername(scan.nextLine());
				System.out.println("Enter you password: ");
				userLoginPojo.setPassword(scan.nextLine());
				UsersPojo returnedLoginUserPojo = null;
				try {
					returnedLoginUserPojo = usersService.loginUser(userLoginPojo);
				} catch (SystemException e) {
					System.out.println("*******************************");
					System.out.println("Sorry. An error occured please try again later");
					e.printStackTrace();
					System.out.println("*******************************");
					break;
				}

				int currentUserId = returnedLoginUserPojo.getUserId();

				if (currentUserId == 0) {
					System.out.println("Username or password entered incorrectly, please try again");
					break;
				} else {
					currentUserAccountDetailsPojo.setUserId(currentUserId);
					System.out.println("Login succesful!!");
					System.out.println("The current users ID is " + currentUserAccountDetailsPojo.getUserId());

					char innerProceed = 'y';
					while (innerProceed == 'y') {

						System.out.println("*******************************");
						System.out.println("**USER MENU**");
						System.out.println("*******************************");
						System.out.println("1. View Account Balance");
						System.out.println("2. Deposit");
						System.out.println("3. Withdraw");
						System.out.println("*******************************");
						System.out.println("Please enter an option: ");
						int action = scan.nextInt();
						System.out.println("*******************************");

						switch (action) {
						case 1:
							try {
								currentUserAccountDetailsPojo = accountDetailsService.getAUserAccount(currentUserId);
							} catch (SystemException e) {
								e.printStackTrace();
							}
							System.out.println("Your account balance is: $" + currentUserAccountDetailsPojo.getFunds());
							break;
						case 2:
							System.out.println("Enter the ammount you would like to deposit: ");
							double ammountToDeposit = scan.nextDouble();
							double newDepositAccountBalance = currentUserAccountDetailsPojo.getFunds()
									+ ammountToDeposit;
							currentUserAccountDetailsPojo.setFunds(newDepositAccountBalance);
							try {
								accountDetailsService.depositFunds(currentUserAccountDetailsPojo);
							} catch (SystemException e) {
								System.out.println(e.getMessage());
								break;
							}
							System.out.println(
									"Your new account balance is: $" + currentUserAccountDetailsPojo.getFunds());
							break;
						case 3:
							System.out.println("Enter the ammount you would like to withdraw: ");
							double ammountToWithdraw = scan.nextDouble();
							double newWithdrawnAccountBalance = currentUserAccountDetailsPojo.getFunds()
									- ammountToWithdraw;
							currentUserAccountDetailsPojo.setFunds(newWithdrawnAccountBalance);
							try {
								accountDetailsService.withdrawFunds(currentUserAccountDetailsPojo);
							} catch (SystemException | OverDraftException e) {
								System.out.println(e.getMessage());
								break;
							}
							System.out.println(
									"Your new account balance is: $" + currentUserAccountDetailsPojo.getFunds());
						}
						System.out.println("Do you want to continue?(y/n)");
						innerProceed = scan.next().charAt(0);
					}
				}
			case 3:
				System.out.println("*******************************");
				System.out.println("THANK YOU FOR USING BANK ACCOUNT MANAGMENT SYSTEM!! HAVE A GREAT DAY!!");
				System.out.println("*******************************");
				System.exit(0);
			default:

			}
			System.out.println("Do you want to continue?");
			proceed = scan.next().charAt(0);
		}
		System.out.println("*******************************");
		System.out.println("THANK YOU FOR USING BANK ACCOUNT MANAGMENT SYSTEM!! HAVE A GREAT DAY!!");
		System.out.println("*******************************");
		System.exit(0);
	}
}
