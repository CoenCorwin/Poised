import java.sql.*;
import java.util.Scanner;

public class PoisedManager {
	public static void main(String[] args) {

		try {
			//				Connect to the database
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/poisepms?useSSL=false",
					"otheruser",
					"swordfish"
					);

			// Create a direct line to the database for running our queries
			Statement statement = connection.createStatement();
			ResultSet results;
			int rowsAffected;


			//				create user input
			Scanner input = new Scanner(System.in);


			//		Display menu to user
			System.out.println("Selection from menu:" 
					+ "\n1 Create a new Project:"
					+ "\n2 Change the due date of the project:" 
					+ "\n3 Change the total number of the fee:"
					+ "\n4 Update contractors contact details:"
					+ "\n5 View completed tasks:"
					+ "\n6 View uncompleted tasks:"
					+ "\n7 Finalise Project:" 
					+ "\n8 Past due data:"
					+ "\n9 Search project:"
					+ "\n10 Contact detail of the architect:"
					+ "\n11 Contact detail of the customer:"
					+ "\n12 Contact detail of the contractor:"
					+ "\n13 Exit Program:");



			while(true) {

				String userChoice = input.nextLine();

				//			if user choice 1 add new project
				if (userChoice.equals("1")) {

					//				declare variable 
					int typedProjectNumber = 0;

					while(true) {
						try {

							//				create new project number
							System.out.println("Enter Project Number:");
							typedProjectNumber = input.nextInt();
							input.nextLine();
							break;

						}

						catch (Exception e) {
							System.out.println("Enter the correct format");
							input.next();
						}
					}

					//				create new project name
					System.out.println("Enter Project Name:");
					String typedProjectName = input.nextLine();


					//				enter building type
					System.out.println("Enter building type:");
					String typedBuildingType = input.nextLine();

					//				enter physical address
					System.out.println("Enter project physical address:");
					String typedProjectAddress = input.nextLine();

					//				Erf number	
					int typedErfNumber = 0;

					while(true) {
						try {
							//						enter Erf number
							System.out.println("Enter Erf Number:");
							typedErfNumber = input.nextInt();
							input.nextLine();
							break;
						}

						catch (Exception e) {
							System.out.println("Enter the correct format");
							input.next();
						}
					}

					//				enter total fee
					Double typedTotalFee = 0.0;

					while(true) {

						try {
							System.out.println("Enter project total fee (number only):");
							typedTotalFee = input.nextDouble();
							input.nextLine();
							break;
						}

						catch (Exception e) {
							System.out.println("Enter the correct format");
							input.next();
						}
					}

					//				enter the amount paid by customer
					Double typedTotalPaid = 0.0;

					while(true) {

						try {
							System.out.println("Enter amount paid by customer (number only):");
							typedTotalPaid = input.nextDouble();
							input.nextLine();
							break;
						}

						catch (Exception e) {
							System.out.println("Enter the correct format");
							input.next();
						}
					}


					//				enter project deadline 
					System.out.println("Enter due date for example 2020-09-10:");
					String typedProjectDeadline = input.nextLine();



					//				set project completed to no				
					String projectCompleted = "No";
					Date defaultDate = null;

					/*
					 * get Architect input
					 */
					//				architect name
					System.out.println("Enter Architect name:");
					String architectName = input.nextLine();

					//				architect surname
					System.out.println("Enter Architect surname:");
					String architectSurname = input.nextLine();

					//				enter Architect phone number
					int architectPhoneNumber = 0;

					while(true) {
						try {

							System.out.println("Enter Architect phone number");
							architectPhoneNumber = input.nextInt();
							input.nextLine();
							break;
						}

						catch (Exception e) {
							System.out.println("Enter the correct format");
							input.next();
						}
					}

					//				enter Architect email address
					System.out.println("Enter Architect email address:");
					String architectEmail = input.nextLine();


					//				enter Architect address
					System.out.println("Enter Architect address:");
					String architectAddress = input.nextLine();

					/*
					 * get Customer input 
					 */	
					//				customer name
					System.out.println("Enter Customer name:");
					String customerName = input.nextLine();

					//				customer surname
					System.out.println("Enter Customer surname:");
					String customerSurname = input.nextLine();

					//				enter customer phone number
					int customerPhoneNumber = 0;

					while(true) {

						try {
							System.out.println("Enter Customer phone number");
							customerPhoneNumber = input.nextInt();
							input.nextLine();
							break;
						}

						catch (Exception e) {
							System.out.println("Enter the correct format");
							input.next();
						}
					}

					//				enter customer email address
					System.out.println("Enter Customer email address:");
					String customerEmail = input.nextLine();


					//				enter customer address
					System.out.println("Enter Customer address:");
					String customerAddress = input.nextLine();

					/*
					 * get Contractor input
					 */
					//				contractor name
					System.out.println("Enter Contractor name:");
					String contractorName = input.nextLine();

					//				customer surname
					System.out.println("Enter Contractor surname:");
					String contractorSurname = input.nextLine();

					//				enter contractor  number
					int contractorNumber = 0;

					while(true) {

						try {
							System.out.println("Enter Contractor number:");
							contractorNumber = input.nextInt();
							input.nextLine();
							break;
						}

						catch (Exception e) {
							System.out.println("Enter the correct format");
							input.next();
						}
					}

					//				enter contractor email address
					System.out.println("Enter Contractor email address:");
					String contractorEmail = input.nextLine();


					//				enter contractor address
					System.out.println("Enter Contractor address:");
					String contractorAddress = input.nextLine();




					results = statement.executeQuery("SELECT * FROM projects WHERE proj_num='"+typedProjectNumber+"' OR proj_name='"+typedProjectName+"'");

					if(results.next()) {
						System.out.println("The project number or the project name already exists");
					}

					else {
						/*
						 * Add to project to the projects database
						 */
						rowsAffected = statement.executeUpdate(
								"INSERT INTO projects VALUES ("+typedProjectNumber+",'"+typedProjectName+"','"+typedBuildingType+"',"
										+"'"+typedProjectAddress+"',"+typedErfNumber+","+typedTotalFee+","+typedTotalPaid+","+
										"'"+typedProjectDeadline+"',"+"'"+projectCompleted+"',"+defaultDate+",'"+architectName+"','"+customerName+"','"+contractorName+"')"
								);

						/*
						 * Add architect to the architect database
						 */
						rowsAffected = statement.executeUpdate(
								"INSERT INTO architect VALUES ("+typedProjectNumber+",'"+architectName+"','"+architectSurname+"',"
										+architectPhoneNumber+",'"+architectEmail+"','"+architectAddress+"')"
								);

						/*
						 * Add customer to the customer database
						 */
						rowsAffected = statement.executeUpdate(
								"INSERT INTO customer VALUES ("+typedProjectNumber+",'"+customerName+"','"+customerSurname+"',"
										+customerPhoneNumber+",'"+customerEmail+"','"+customerAddress+"')"
								);

						/*
						 * Add contractor to the contractor
						 */
						rowsAffected = statement.executeUpdate(
								"INSERT INTO contractor VALUES ("+typedProjectNumber+",'"+contractorName+"','"+contractorSurname+"',"
										+contractorNumber+",'"+contractorEmail+"','"+contractorAddress+"')"
								);


						results = statement.executeQuery("SELECT * FROM projects WHERE proj_num='"+typedProjectNumber+"'");

						while(results.next()) {
							System.out.println(
									results.getInt("proj_num") + ", "
											+ results.getString("proj_name") + ", "
											+ results.getString("building_type") + ", "  
											+ results.getString("phys_address") + ", "
											+ results.getInt("erf_num") +", "	
											+ results.getFloat("total_fee")+ ", "
											+ results.getFloat("amount_paid")+ ", "
											+ results.getString("deadline") + ", "
											+ results.getString("proj_completed") + ", "
											+ results.getDate("date_completed") + ", "
											+ results.getString("arch_name") + ", "
											+ results.getString("cust_name") + ", "  
											+ results.getString("cont_name")

									);
						}

						System.out.println("\nNew project has been created!");


					}

				}

				//			if user choice 2 change due date
				else if (userChoice.equals("2")) {
					int deadlineIndex = 0;

					//				Ask the user which project to change the due date
					System.out.println("Please enter project you want to edit by index:");
					deadlineIndex= input.nextInt();
					input.nextLine();

					results = statement.executeQuery("SELECT * FROM projects WHERE proj_num='"+deadlineIndex+"'");

					//				check if index is in the database
					if (results.next()) {

						//				change the due date
						System.out.println("Enter new project deadline date for example 2020-09-10");
						String newDeadline = input.nextLine();

						rowsAffected = statement.executeUpdate(
								"UPDATE projects SET deadline='"+newDeadline+"' WHERE proj_num="+deadlineIndex+""
								);


						results = statement.executeQuery("SELECT * FROM projects WHERE proj_num='"+deadlineIndex+"'");

						while(results.next()) {
							System.out.println(
									results.getInt("proj_num") + ", "
											+ results.getString("proj_name") + ", "
											+ results.getString("building_type") + ", "  
											+ results.getString("phys_address") + ", "
											+ results.getInt("erf_num") +", "	
											+ results.getFloat("total_fee")+ ", "
											+ results.getFloat("amount_paid")+ ", "
											+ results.getString("deadline") + ", "
											+ results.getString("proj_completed") + ", "
											+ results.getDate("date_completed") + ", "
											+ results.getString("arch_name") + ", "
											+ results.getString("cust_name") + ", "  
											+ results.getString("cont_name")

									);
						}

						System.out.println("\nUpdate the deadline of the project");
					}

					//				if not in the database 
					else {
						//					display this message
						System.out.println("Error: This project number "+deadlineIndex+" does not exists");
						System.out.println();
					}
				}

				//			if user choice 3 change fee paid
				else if (userChoice.equals("3")) {
					int feePaidIndex = 0;


					//				Ask the user which project to change the fee paid
					System.out.println("Please enter project you want to edit by index:");
					feePaidIndex = input.nextInt();
					input.nextLine();

					results = statement.executeQuery("SELECT * FROM projects WHERE proj_num='"+feePaidIndex+"'");

					//				check if index is in the database
					if (results.next()) {
						//				change the fee paid
						Double newFeePaid = 0.0;

						System.out.println("Enter new fee paid by the customer");
						newFeePaid = input.nextDouble();
						input.nextLine();

						rowsAffected = statement.executeUpdate(
								"UPDATE projects SET total_fee='"+newFeePaid+"' WHERE proj_num="+feePaidIndex+""
								);

						results = statement.executeQuery("SELECT * FROM projects WHERE proj_num='"+feePaidIndex+"'");

						while(results.next()) {
							System.out.println(
									results.getInt("proj_num") + ", "
											+ results.getString("proj_name") + ", "
											+ results.getString("building_type") + ", "  
											+ results.getString("phys_address") + ", "
											+ results.getInt("erf_num") +", "	
											+ results.getFloat("total_fee")+ ", "
											+ results.getFloat("amount_paid")+ ", "
											+ results.getString("deadline") + ", "
											+ results.getString("proj_completed") + ", "
											+ results.getDate("date_completed") + ", "
											+ results.getString("arch_name") + ", "
											+ results.getString("cust_name") + ", "  
											+ results.getString("cont_name")

									);
						}

						System.out.println("\nUpdate the total fee of the project");

					}

					//				if not in the database 
					else {
						//					display this message
						System.out.println("Error: This project number "+feePaidIndex+" does not exists");
						System.out.println();
					}
				}


				//			if user choice 4 Update contractors contact details
				else if (userChoice.equals("4")) {

					//				Ask the user which project to edit contractors
					int contractorsIndex = 0;


					System.out.println("Please enter project you want to edit by index:");
					contractorsIndex = input.nextInt();

					results = statement.executeQuery("SELECT * FROM contractor WHERE proj_num='"+contractorsIndex+"'");

					//				check if index is in the database
					if (results.next()) {

						//				update contractors details
						//				change telephone number
						int newPhoneNumber = 0;

						System.out.println("Enter new contractors phone number:");
						newPhoneNumber = input.nextInt();
						input.nextLine();



						//				change email address
						System.out.println("Enter new contractors email address:");
						String newEmailAddress = input.nextLine();


						rowsAffected = statement.executeUpdate(
								"UPDATE contractor SET cont_tel='"+newPhoneNumber+"', cont_email='"+newEmailAddress+"' WHERE proj_num="+contractorsIndex+""
								);

						results = statement.executeQuery("SELECT * FROM contractor WHERE proj_num="+contractorsIndex+"");

						while(results.next()) {
							System.out.println(
									results.getInt("proj_num") + ", "
											+ results.getString("cont_name") +", "
											+ results.getString("cont_surname") +", "
											+ results.getInt("cont_tel") + ", "
											+ results.getString("cont_email") +", "
											+ results.getString("cont_address")
									);
						}

						System.out.println("\nUpdate the contractor details");
					}

					//				if not in the database 
					else {
						//					display this message
						System.out.println("Error: This project number "+contractorsIndex+" does not exists");
						System.out.println();
					}
				}


				/*
				 * user choice 5 view all completed task
				 */

				else if (userChoice.equals("5")) {
					/*
					 * Loop through table to print completed project
					 */

					results = statement.executeQuery("SELECT * FROM projects WHERE proj_completed='Yes'");

					while(results.next()) {
						System.out.println(
								results.getInt("proj_num") + ", "
										+ results.getString("proj_name") + ", "
										+ results.getString("building_type") + ", "  
										+ results.getString("phys_address") + ", "
										+ results.getInt("erf_num") +", "	
										+ results.getFloat("total_fee")+ ", "
										+ results.getFloat("amount_paid")+ ", "
										+ results.getString("deadline") + ", "
										+ results.getString("proj_completed") + ", "
										+ results.getDate("date_completed") + ", "
										+ results.getString("arch_name") + ", "
										+ results.getString("cust_name") + ", "  
										+ results.getString("cont_name")

								);
					}

				}

				/*
				 * user choice 6 view all completed task
				 */

				else if (userChoice.equals("6")) {
					/*
					 * Loop through table to print uncompleted project
					 */
					results = statement.executeQuery("SELECT * FROM projects WHERE proj_completed='No'");

					while(results.next()) {
						System.out.println(
								results.getInt("proj_num") + ", "
										+ results.getString("proj_name") + ", "
										+ results.getString("building_type") + ", "  
										+ results.getString("phys_address") + ", "
										+ results.getInt("erf_num") +", "	
										+ results.getFloat("total_fee")+ ", "
										+ results.getFloat("amount_paid")+ ", "
										+ results.getString("deadline") + ", "
										+ results.getString("proj_completed") + ", "
										+ results.getDate("date_completed") + ", "
										+ results.getString("arch_name") + ", "
										+ results.getString("cust_name") + ", "  
										+ results.getString("cont_name")

								);
					}
				}




				else if (userChoice.equals("7")) {
					//				ask user which project they want to edit
					int finalisedIndex = 0;

					System.out.println("Please enter project you want to edit by index:");
					finalisedIndex = input.nextInt();
					input.nextLine();

					results = statement.executeQuery("SELECT * FROM projects WHERE proj_num='"+finalisedIndex+"'");

					if (results.next()) {

						//				defined difference and calc difference
						Double Difference = 0.0;
						Difference = (double) (results.getFloat("amount_paid") - results.getFloat("total_fee"));

						if (Difference == 0) {

							//					Display message to user

							System.out.println("No invoice is needed marking project as completed");


							rowsAffected = statement.executeUpdate(
									"UPDATE projects SET proj_completed='Yes', date_completed=NOW() WHERE proj_num='"+finalisedIndex+"'"
									);

							rowsAffected = statement.executeUpdate(
									"UPDATE projects SET proj_completed='Yes' WHERE proj_num='"+finalisedIndex+"'"
									);
							System.out.println();
						}

						//				owe money display this
						else if (Difference != 0) {
							System.out.println("Invoice generated");
							System.out.println("The project number: "+results.getInt("proj_num") + "\nThe customer name: "+ results.getString("cust_name"));
							System.out.println("Your amount owed is R" + Difference);


						}

						else {

						}
					}

					else {
						System.out.println("Error not project is created");
					}


				}

				/*
				 * check if the project is overdue
				 */
				else if(userChoice.equals("8")) {

					results = statement.executeQuery("SELECT * FROM projects WHERE deadline BETWEEN deadline AND NOW()");


					while(results.next()) {

						System.out.println(
								results.getInt("proj_num") + ", "
										+ results.getString("proj_name") + ", "
										+ results.getString("building_type") + ", "  
										+ results.getString("phys_address") + ", "
										+ results.getInt("erf_num") +", "	
										+ results.getFloat("total_fee")+ ", "
										+ results.getFloat("amount_paid")+ ", "
										+ results.getString("deadline") + ", "
										+ results.getString("proj_completed") + ", "
										+ results.getDate("date_completed") + ", "
										+ results.getString("arch_name") + ", "
										+ results.getString("cust_name") + ", "  
										+ results.getString("cont_name")

								);
					}

				}

				/*
				 * search for the projects
				 */
				else if(userChoice.equals("9")) {


					/*
					 * if the user search by
					 * number or
					 * name
					 */
					System.out.println("Search project by "
							+ "\n1 Number"
							+ "\n2. Name"
							+ "\n3. Return main menu");
					String option = input.nextLine();

					if (option.equals("1")) {
						System.out.println("Enter number of the project");
						int proj_num = input.nextInt();
						input.nextLine();


						results = statement.executeQuery("SELECT * FROM projects WHERE proj_num="+proj_num+"");

						if(results.next()) {
							System.out.println(
									results.getInt("proj_num") + ", "
											+ results.getString("proj_name") + ", "
											+ results.getString("building_type") + ", "  
											+ results.getString("phys_address") + ", "
											+ results.getInt("erf_num") +", "	
											+ results.getFloat("total_fee")+ ", "
											+ results.getFloat("amount_paid")+ ", "
											+ results.getString("deadline") + ", "
											+ results.getString("proj_completed") + ", "
											+ results.getDate("date_completed") + ", "
											+ results.getString("arch_name") + ", "
											+ results.getString("cust_name") + ", "  
											+ results.getString("cont_name")

									);
						}

						else {
							System.out.println("Error: This project number "+proj_num+" does not exists");
						}
					}

					else if (option.equals("2")) {
						System.out.println("Enter name of the project");
						String proj_name = input.nextLine();


						results = statement.executeQuery("SELECT * FROM projects WHERE proj_name='"+proj_name+"'");

						if(results.next()) {
							System.out.println(
									results.getInt("proj_num") + ", "
											+ results.getString("proj_name") + ", "
											+ results.getString("building_type") + ", "  
											+ results.getString("phys_address") + ", "
											+ results.getInt("erf_num") +", "	
											+ results.getFloat("total_fee")+ ", "
											+ results.getFloat("amount_paid")+ ", "
											+ results.getString("deadline") + ", "
											+ results.getString("proj_completed") + ", "
											+ results.getDate("date_completed") + ", "
											+ results.getString("arch_name") + ", "
											+ results.getString("cust_name") + ", "  
											+ results.getString("cont_name")

									);
						}

						else {
							System.out.println("Error: This project name "+proj_name+" does not exists");
						}
					}
					else {
						System.out.println("Not update is make");
					}

				}
				
				
				else if (userChoice.equals("10")) {
					System.out.println("Enter name of the architect");
					String arch_name = input.nextLine();


					results = statement.executeQuery("SELECT * FROM architect WHERE arch_name='"+arch_name+"'");

					if(results.next()) {
						System.out.println(
								results.getInt("proj_num") + ", "
										+ results.getString("arch_name") +", "
										+ results.getString("arch_surname") +", "
										+ results.getInt("arch_tel") + ", "
										+ results.getString("arch_email") +", "
										+ results.getString("arch_address")
								);
					}

					else {
						System.out.println("Error: This architect name "+arch_name+" does not exists");
					}

				}
				
				else if (userChoice.equals("11")) {
					System.out.println("Enter name of the customer");
					String cust_name = input.nextLine();


					results = statement.executeQuery("SELECT * FROM customer WHERE cust_name='"+cust_name+"'");

					if(results.next()) {
						System.out.println(
								results.getInt("proj_num") + ", "
										+ results.getString("cust_name") +", "
										+ results.getString("cust_surname") +", "
										+ results.getInt("cust_tel") + ", "
										+ results.getString("cust_email") +", "
										+ results.getString("cust_address")
								);
					}
				}
				
				else if (userChoice.equals("12")) {
					System.out.println("Enter name of the contractor");
					String cont_name = input.nextLine();


					results = statement.executeQuery("SELECT * FROM contractor WHERE cont_name='"+cont_name+"'");

					if(results.next()) {
						System.out.println(
								results.getInt("proj_num") + ", "
										+ results.getString("cont_name") +", "
										+ results.getString("cont_surname") +", "
										+ results.getInt("cont_tel") + ", "
										+ results.getString("cont_email") +", "
										+ results.getString("cont_address")
								);
					}
				}

				//			if user choice 10 exit
				else if (userChoice.equals("13")) {
					System.out.println("GoodBye!!!");
					break;
				}

				else {
					System.out.println("Please selection one of the options");
				}

			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
