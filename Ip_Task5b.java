package ind_pro_final;

import java.sql.Connection; 
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
 
public class Ip_Task5b{ 
 
    // Database credentials 
    final static String HOSTNAME = "komm0004-sql-server.database.windows.net"; 
    final static String DBNAME = "cs-dsa-4513-sql-db"; 
    final static String USERNAME = "komm0004"; 
    final static String PASSWORD = "xacwej-fohto7-cysFyf"; 
 
    // Database connection string 
    final static String URL = 
String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", 
            HOSTNAME, DBNAME, USERNAME, PASSWORD);
    
    // User input prompt// 
    final static String PROMPT =  
            "\nPlease select one of the options below: \n" + 
            "1) Inserting the Employee details(e_name,e_address,salary,type and  correspondig details; \n" + 
            "2) Inserting the products details(id,date_produce,time,person_produce,person_tested,date,type_of_product and corresponding details; \n" + 
            "3) Inserting the customer details(name,address and id ); \n" +  
            "4) Inserting the account details(acc_number, date, cost, type and id); \n"+
            "5) Inserting the complaint details(c_id, date, description, treatment and id); \n"+
            "6) Inserting the accident details(accident_number, acci_date, work_day_loss, id and type of acci); \n"+
            "7) Retrieve the date produced and time spent to produce a particular product (id); \n"+
            "8) Retrieve all products made by a particular worker(worker_name); \n"+
            "9) Retrieve the total number of errors a particular quality controller made (qc_name); \n"+
            "10) Retrieve the total costs of the products in the product3 category which were repaired at the request of a particular quality controller (qc_name); \n"+
            "11) Retrieve all customers (in name order) who purchased all products of a particular color (color); \n"+
            "12) Retrieve all employees whose salary is above a particular salary (salary); \n"+
            "13)  Retrieve the total number of workdays lost due to accidents in repairing the products which got complaints; \n"+
            "14) Retrieve the average cost of all products made in a particular year (year); \n"+
            "15) Delete all accidents whose dates are in some range (date1 and date2); \n"+
            "16) Import: enter new employees from a data file; \n"+
            "17) Export: Retrieve all customers (in name order) who purchased all products of a particular color and output them to a data file; \n"+
            "18) Exit....!!";
 
    public static void main(String[] args) throws SQLException { 
    	
    	System.out.println("Welcome to application!"); 
        final Scanner sc = new Scanner(System.in); // Scanner is used to collect the user input 
        String option = ""; // Initialize user option selection as nothing 
        while (!option.equals("16")) { // As user for options until option 4 is selected 
            System.out.println(PROMPT); // Print the available options 
            option = sc.next(); // Read in the user option selection 
            		
        switch (option) { // Switch between different options 
            case "1":
            	System.out.println("Please enter Employee name:"); 
            	sc.nextLine();
                String e_name= sc.nextLine(); // Read in the user input of employee name 

                System.out.println("Please enter employee address:"); 
                String e_address = sc.nextLine(); // Read in user input of faculty name 
                
                System.out.println("Please enter employee salary:"); 
                Float salary= sc.nextFloat(); // Read in user input of faculty name 

                System.out.println("Please enter employee category:"); 
                sc.nextLine();
                String type= sc.nextLine(); // Read in the employee category
                 
                System.out.println("Please enter produce_per_day:");
                //sc.nextLine();
                int produce_per_day= sc.nextInt(); // Read in the employee Produce(if type is worker)
                
                System.out.println("Please enter type of product:");
                sc.nextLine();
                String type_of_product = sc.nextLine(); // Read in the type of product(if type is quality_controller)
                
                System.out.println("Please enter position of employee");
                String position= sc.nextLine(); // Read in the position of employee(if type is technical_staff)
                
                System.out.println("Please enter 1st degree of employee");
                String degree1= sc.nextLine(); // Read in the 1st degree of the employee(if type is technical_staff)
                
                
                System.out.println("Please enter 2nd degree of employee");
                String degree2= sc.nextLine(); // Read in the 2nd degree of the employee(if type is technical_staff)
                
                System.out.println("Please enter 3rd degree of employee");
                String degree3= sc.nextLine(); // Read in the 3rd degree of the employee(if type is technical_staff)
                
                
            	System.out.println("Connecting to the database..."); 
            	// Get a database connection and prepare a query statement 
            	try (final Connection connection = DriverManager.getConnection(URL)) { 
            		try (final PreparedStatement statement = connection.prepareStatement("EXEC query1 @e_name = ?, @e_address = ?, @salary = ?, @type=?, @produce_per_day=?, @type_of_product=?,@position=?,@degree1=?,@degree2=?,@degree3=?;")) { 
            		// Setting the storage procedure input parameter values 
            	    
	                statement.setString(1,e_name ); 
	                statement.setString(2, e_address); 
	                statement.setFloat(3, salary);  
	                statement.setString(4,type);
	                statement.setInt(5, produce_per_day);
	                statement.setString(6, type_of_product);
	                statement.setString(7, position);
	                statement.setString(8,degree1);
	                statement.setString(9, degree2);
	                statement.setString(10, degree3);
 
                    System.out.println("Dispatching the query..."); 
                    // Actually execute the populated query 
                    final int rows_inserted = statement.executeUpdate(); 
                    System.out.println(String.format("Successfully inserted...")); 
            	} 
	
            } 
            	catch(SQLException Error) {
            		System.out.println("Error executed");
            	}
            	
            break;
            
            
            case "2":
            	System.out.println("Please enter Product id:"); 
            	sc.nextLine(); 
                int id= sc.nextInt(); // Read in the user input of product id 
                System.out.println("Please enter Product produced date:"); 
                sc.nextLine(); 
                String date_of_produce = sc.nextLine(); // Read in user input of produced date
                
                System.out.println("Please enter time taken to make product:"); 
                int time_spent = sc.nextInt(); // Read in user input of produced date
                
                System.out.println("Please enter Person produced:"); 
                sc.nextLine(); 
                String person_produce = sc.nextLine(); // Read in user input of person produce
                
                System.out.println("Please enter Person tested:"); 
                String person_tested= sc.nextLine(); // Read in user input of  person tested
                
                System.out.println("Please enter Person repair:"); 
                String person_repair= sc.nextLine(); // Read in user input of person repair
                
                System.out.println("Please enter Repair date:"); 
                String date_of_record= sc.nextLine(); // Read in user input of repaired date
                
                System.out.println("Please enter type of product:"); 
                String product_type= sc.nextLine(); // Read in user input of type_of_product
                
                System.out.println("Please enter size:"); 
                String size= sc.nextLine(); // Read in user input of type_of_product
                
                System.out.println("Please enter Software:"); 
                String software= sc.nextLine(); // Read in user input of type_of_product

                System.out.println("Please enter Color:"); 
                String color= sc.nextLine(); // Read in user input of color
                	
                System.out.println("Please enter weight:"); 
                float weight= sc.nextFloat(); // Read in user input of weight
                
            	System.out.println("Connecting to the database..."); 
            	// Get a database connection and prepare a query statement 
            	try (final Connection connection = DriverManager.getConnection(URL)) { 
            		try (final PreparedStatement statement = connection.prepareStatement("EXEC query2 @id= ?, @date_of_produce= ?, @time_spent= ?,@person_produce=?,@person_tested=?,@person_repair=?,@date_record=?,@type_of_product=?,@size=?,@software=?,@color=?,@weight=?;")) { 
            		// Setting the storage procedure input parameter values 
            	    
	                statement.setInt(1,id); 
	                statement.setString(2, date_of_produce); 
	                statement.setInt(3, time_spent); 
	                statement.setString(4, person_produce);
	                statement.setString(5, person_tested);
	                statement.setString(6, person_repair);
	                statement.setString(7, date_of_record);
	                statement.setString(8, product_type);
	                statement.setString(9, size);
	                statement.setString(10, software);
	                statement.setString(11, color);
	                statement.setFloat(12, weight);
 
                    
                    System.out.println("Dispatching the query..."); 
                    // Actually execute the populated query 
                    final int rows_inserted = statement.executeUpdate(); 
                    System.out.println(String.format("Successfully inserted..."));    
            	}		
            }
            	catch(SQLException Error) {
            		System.out.println("Error executed");
            	}    
            break;
            
            
            case "3":
            	System.out.println("Please enter Customer Name:"); 
            	sc.nextLine(); 
                String cust_name= sc.nextLine(); // Read in the customer name
                
                System.out.println("Please enter Customer Address:"); 
                String cust_address= sc.nextLine(); // Read in the customer address
                

                System.out.println("Please enter product id:"); 
                int p_id= sc.nextInt(); // Read in the product id
                
            	System.out.println("Connecting to the database..."); 
            	// Get a database connection and prepare a query statement 
            	try (final Connection connection = DriverManager.getConnection(URL)) { 
            		try (final PreparedStatement statement = connection.prepareStatement("EXEC query3 @name=?,@address=?,@p_id=?;")) { 
            		
 
            			statement.setString(1, cust_name);
    	                statement.setString(2, cust_address);
    	                statement.setInt(3, p_id);
     
                        
                        System.out.println("Dispatching the query..."); 
                        // Actually execute the populated query 
                        final int rows_inserted = statement.executeUpdate(); 
                        System.out.println(String.format("Successfully inserted..."));     
                	}     		
                } 
             	catch(SQLException Error) {
            		System.out.println("Error executed");
            	}
            break;
            
            
            case "4":
	            System.out.println("Please enter Account number"); 
	        	sc.nextLine(); 
	            int acc_number= sc.nextInt(); // Read in the account number 
	            
	            System.out.println("Please enter date established:"); 
	            sc.nextLine();
	            String date_esta= sc.nextLine(); // Read in the date_established
	            

	            System.out.println("Please enter cost of product:"); 
	            Float product_cost= sc.nextFloat(); // Read in the cost of product
	            
	            System.out.println("Please enter account type:"); 
	            sc.nextLine();
	            String acc_type= sc.nextLine(); // Read in the account type
	            
	            
	            System.out.println("Please enter product id:"); 
	            int a_id= sc.nextInt(); // Read in the product id 
	            
	            System.out.println("Connecting to the database..."); 
            	// Get a database connection and prepare a query statement 
            	try (final Connection connection = DriverManager.getConnection(URL)) { 
            		try (final PreparedStatement statement = connection.prepareStatement("EXEC query4 @acc_number=?,@date_est=?,@cost_p_product=?,@acc_type=?,@id=?;")) { 
            		
 
            			statement.setInt(1, acc_number);
    	                statement.setString(2, date_esta);
    	                statement.setFloat(3, product_cost);
    	                statement.setString(4, acc_type);
    	                statement.setInt(5, a_id);
     
                        
                        System.out.println("Dispatching the query..."); 
                        // Actually execute the populated query 
                        final int rows_inserted = statement.executeUpdate(); 
                        System.out.println(String.format("Successfully inserted..."));     
            		}	
            	}
            	catch(SQLException Error) {
            		System.out.println("Error executed");
            	}
            break;
            
            
            
            
            
            case "5":
	            System.out.println("Please enter Complaint id"); 
	        	sc.nextLine(); 
	            int c_id= sc.nextInt(); // Read in the complaint id
	            
	            System.out.println("Please enter date of complaint:"); 
	        	sc.nextLine(); 
	            String date_comp= sc.nextLine(); // Read in the date of complaint
	            

	            System.out.println("Please enter complaint description:"); 
	            String c_description= sc.nextLine(); // Read in the complaint description
	            
	            System.out.println("Please enter complaint treatment:"); 
	            String treat= sc.nextLine(); // Read in the account type
	            
	            
	            System.out.println("Please enter product id:"); 
	            int c_p_id= sc.nextInt(); // Read in the product id 
	            

	            System.out.println("Please enter person_repaired:"); 
	            sc.nextLine();
	            String person_repaired_comp= sc.nextLine(); // Read in the person repaired
	            
	            System.out.println("Please enter recorded date:"); 
	            String date_repaired_comp= sc.nextLine(); // Read in the repaired date
	            
	            System.out.println("Connecting to the database..."); 
            	// Get a database connection and prepare a query statement 
            	try (final Connection connection = DriverManager.getConnection(URL)) { 
            		try (final PreparedStatement statement = connection.prepareStatement("EXEC query5 @c_id=?, @date_of_complaint=?,@c_description=?,@treatment =?,@id=?,@tech_name=?,@date_record=?;")) { 
            		
 
            			statement.setInt(1, c_id);
    	                statement.setString(2, date_comp);
    	                statement.setString(3, c_description);
    	                statement.setString(4, treat);
    	                statement.setInt(5, c_p_id);
    	                statement.setString(6, person_repaired_comp);
    	                statement.setString(7, date_repaired_comp);
    	                
     
                        
                        System.out.println("Dispatching the query..."); 
                        // Actually execute the populated query 
                        final int rows_inserted = statement.executeUpdate(); 
                        System.out.println(String.format("Successfully inserted..."));     
            		}	
            	}
            	catch(SQLException Error) {
            		System.out.println("Error executed");
            	}
            break;
            
            
            case"6":
            	System.out.println("Please enter Accident number"); 
	        	sc.nextLine(); 
	            int acci_no= sc.nextInt(); // Read in the complaint id
	            
	            System.out.println("Please enter date of accident:"); 
	            sc.nextLine();
	            String date_accident= sc.nextLine(); // Read in the date of complaint
	            

	            System.out.println("Please enter work day loss:"); 
	            int work_day_loss= sc.nextInt(); // Read in the complaint description
	            
	            System.out.println("Please enter  product id:"); 
	            int ac_id= sc.nextInt(); // Read in the account type
	            
	            
	            System.out.println("Please enter person met with an accident:"); 
	            sc.nextLine();
	            String type_acci= sc.nextLine(); // Read in the person name
	            
	            System.out.println("Connecting to the database..."); 
            	// Get a database connection and prepare a query statement 
            	try (final Connection connection = DriverManager.getConnection(URL)) { 
            		try (final PreparedStatement statement = connection.prepareStatement("EXEC query6 @accident_number=?,@acci_date=?,@work_day_loss=?,@id=?,@acci_name=?;")) { 
            		
 
            			statement.setInt(1, acci_no);
    	                statement.setString(2, date_accident);
    	                statement.setInt(3, work_day_loss);
    	                statement.setInt(4, ac_id);
    	                statement.setString(5,type_acci);
                          
                        System.out.println("Dispatching the query..."); 
                        // Actually execute the populated query 
                        final int rows_inserted = statement.executeUpdate(); 
                        System.out.println(String.format("Successfully inserted..."));     
            		}	
            	}
            	catch(SQLException Error) {
            		System.out.println("Error executed");
            	}
            break;
	        
            case"7":
            	System.out.println("Please enter Product id"); 
	        	sc.nextLine(); 
	            int product_id= sc.nextInt(); // Read in the product id
	            
            	System.out.println("Connecting to the database..."); 
            	// Get a database connection and prepare a query statement 
            	try (final Connection connection = DriverManager.getConnection(URL)) { 
            		try (final PreparedStatement statement = connection.prepareStatement("EXEC query7 @id=?;")) { 
            		
            		statement.setInt(1, product_id);
            		
                    // Call the stored procedure 
                    ResultSet resultSet = statement.executeQuery(); 
 
                    System.out.println("Results of the Query7:"); 
                    System.out.println(" Date _of_produce | Time_spent "); 
                    // Unpack the tuples returned by the database and print them out to the user
                    while (resultSet.next()) { 
                        System.out.println(String.format("%s  |  %s ", 
                            resultSet.getString(1), 
                            resultSet.getString(2))); 
                    
                    }
                    }    		
            	}
            	catch(SQLException Error) {
            		System.out.println("Error executed");
            	}
            break;
            
            case"8":
            	System.out.println("Please enter Worker Name"); 
	        	sc.nextLine(); 
	            String worker_name= sc.nextLine(); // Read in the worker name
	            
            	System.out.println("Connecting to the database..."); 
            	// Get a database connection and prepare a query statement 
            	try (final Connection connection = DriverManager.getConnection(URL)) { 
            		try (final PreparedStatement statement = connection.prepareStatement("EXEC query8 @worker_name=?;")) { 
            		
            		statement.setString(1, worker_name);
                		
            			
                    // Call the stored procedure 
                    ResultSet resultSet = statement.executeQuery(); 
 
                    System.out.println("Results of the Query8:"); 
                    System.out.println(" Id | Date _of_produce | Time_spent "); 
                    // Unpack the tuples returned by the database and print them out to the user
                    while (resultSet.next()) { 
                        System.out.println(String.format("%s | %s | %s ", 
                            resultSet.getString(1), 
                            resultSet.getString(2),
                            resultSet.getString(3))); 
                    
                    }
                    }
            		
            	}
            	catch(SQLException Error) {
            		System.out.println("Error executed");
            	}
            break;
            
            case"9":
            	System.out.println("Please enter Quality controller Name"); 
	        	sc.nextLine(); 
	            String qc_name= sc.nextLine(); // Read in the quality controller name
	            
            	System.out.println("Connecting to the database..."); 
            	// Get a database connection and prepare a query statement 
            	try (final Connection connection = DriverManager.getConnection(URL)) { 
            		try (final PreparedStatement statement = connection.prepareStatement("EXEC query9 @qc_name=?;")) { 
            			
            		statement.setString(1,qc_name);
                	
                    // Call the stored procedure 
                    ResultSet resultSet = statement.executeQuery(); 
 
                    System.out.println("Results of the Query9:"); 
                    System.out.println(" Total number of errors a particular quality controller made "); 
                    // Unpack the tuples returned by the database and print them out to the user
                    while (resultSet.next()) { 
                        System.out.println(String.format("%s  ", 
                            resultSet.getString(1))); 
                    
                    }
                    }
                		
            	}
            	catch(SQLException Error) {
            		System.out.println("Error executed");
            	}
            break;
            
            
            
            case"10":
            	System.out.println("Please enter Quality controller Name"); 
	        	sc.nextLine(); 
	            String name_qc= sc.nextLine(); // Read in the Quality controller name
	            
            	System.out.println("Connecting to the database..."); 
            	// Get a database connection and prepare a query statement 
            	try (final Connection connection = DriverManager.getConnection(URL)) { 
            		try (final PreparedStatement statement = connection.prepareStatement("EXEC query10 @qc_name=?;")) { 
            		
            		statement.setString(1,name_qc);
 
                    // Call the stored procedure 
                    ResultSet resultSet = statement.executeQuery(); 
 
                    System.out.println("Results of the Query10:"); 
                    System.out.println(" Total  product costs "); 
                    // Unpack the tuples returned by the database and print them out to the user
                    while (resultSet.next()) { 
                        System.out.println(String.format("%s  ", 
                            resultSet.getString(1))); 
                    
                    }
                    }
            	}
            	catch(SQLException Error) {
            		System.out.println("Error executed");
            	}
            break;
             

            case"11":
            	System.out.println("Please enter Color"); 
	        	sc.nextLine(); 
	            String color_ent= sc.nextLine(); // Read in the color
	            
            	System.out.println("Connecting to the database..."); 
            	// Get a database connection and prepare a query statement 
            	try (final Connection connection = DriverManager.getConnection(URL)) { 
            		try (final PreparedStatement statement = connection.prepareStatement("EXEC query11 @color=?;")) { 
            		
            		statement.setString(1,color_ent);
            		
                    // Call the stored procedure 
                    ResultSet resultSet = statement.executeQuery(); 
 
                    System.out.println("Results of the Query11:"); 
                    System.out.println("all customers"); 
                    // Unpack the tuples returned by the database and print them out to the user
                    while (resultSet.next()) { 
                        System.out.println(String.format("%s  ", 
                            resultSet.getString(1))); 
                    
                    }
            		}
                		
            	}
             	catch(SQLException Error) {
            		System.out.println("Error executed");
            	}
            break;
            
           
            case"12":
            	System.out.println("Please enter Salary"); 
	        	sc.nextLine(); 
	            Float salary_ent= sc.nextFloat(); // Read in the salary 
	            
            	System.out.println("Connecting to the database..."); 
            	// Get a database connection and prepare a query statement 
            	try (final Connection connection = DriverManager.getConnection(URL)) { 
            		try (final PreparedStatement statement = connection.prepareStatement("EXEC query12 @salary=?;")) { 
            		
            		statement.setFloat(1,salary_ent);
            		
                    // Call the stored procedure 
                    ResultSet resultSet = statement.executeQuery(); 
 
                    System.out.println("Results of the Query12:"); 
                    System.out.println(" all customers"); 
                    System.out.println(" Employee Name | Employee address | salary "); 
                    // Unpack the tuples returned by the database and print them out to the user
                    while (resultSet.next()) { 
                        System.out.println(String.format("%s | %s | %s", 
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3))); 
                    
                    }
                    }
                		
            	}
            	catch(SQLException Error) {
            		System.out.println("Error executed");
            	}
            break;
            
            case"13": 
	            
            	System.out.println("Connecting to the database..."); 
            	// Get a database connection and prepare a query statement 
            	try (final Connection connection = DriverManager.getConnection(URL)) { 
            		try (final PreparedStatement statement = connection.prepareStatement("EXEC query13;")) { 
            		
 
                    // Call the stored procedure 
                    ResultSet resultSet = statement.executeQuery(); 
 
                    System.out.println("Results of the Query13:"); 
                    System.out.println("the total number of workdays lost"); 
                    // Unpack the tuples returned by the database and print them out to the user
                    while (resultSet.next()) { 
                        System.out.println(String.format("%s ", 
                            resultSet.getString(1))); 
                    
                    }
                    }	
            	}
             	catch(SQLException Error) {
            		System.out.println("Error executed");
            	}
            break;
            
			case"14":
				
				System.out.println("Please enter Year"); 
	        	sc.nextLine(); 
	            int year= sc.nextInt(); // Read in the year
	            
				System.out.println("Connecting to the database..."); 
            	// Get a database connection and prepare a query statement 
            	try (final Connection connection = DriverManager.getConnection(URL)) { 
            		try (final PreparedStatement statement = connection.prepareStatement("EXEC query14 @year=?;")) { 
            		
            		statement.setInt(1,year);
            		
                    // Call the stored procedure 
                    ResultSet resultSet = statement.executeQuery(); 
 
                    System.out.println("Results of the Query14:"); 
                    System.out.println(" Average cost of all products made in a particular year"); 
                    // Unpack the tuples returned by the database and print them out to the user
                    while (resultSet.next()) { 
                        System.out.println(String.format("%s ", 
                            resultSet.getString(1))); 
                    }
                    }	
            	}
            	catch(SQLException Error) {
            		System.out.println("Error executed");
            	}
            break;
            
            
            
            
			case"15":
				
				System.out.println("Please enter Date1"); 
	        	sc.nextLine(); 
	            String date1= sc.nextLine(); // Read in the date1
	            
	            System.out.println("Please enter Date2"); 
	            String date2= sc.nextLine(); // Read in the date2
				
	            System.out.println("Connecting to the database..."); 
            	// Get a database connection and prepare a query statement 
            	try (final Connection connection = DriverManager.getConnection(URL)) { 
            		try (final PreparedStatement statement = connection.prepareStatement("EXEC query15 @date1=?, @date2=?;")) { 
            		
            		statement.setString(1,date1);
            		statement.setString(2,date2);
            		
            		System.out.println("Dispatching the query..."); 
                    // Actually execute the populated query 
                    final int rows_inserted = statement.executeUpdate(); 
                    System.out.println(String.format("Successfully removed the incidents..."));     
            		}
                		
            	}
              	catch(SQLException Error) {
            		System.out.println("Error executed");
            	}
            break;

            	
            case "18": // Do nothing, the while loop will terminate upon the next iteration 
                System.out.println("Exiting! Good-bye!"); 
                break; 
            default: // Unrecognized option, re-prompt the user for the correct one 
                System.out.println(String.format( 
                    "Unrecognized option: %s\n" +  
                    "Please try again!",  
                    option)); 
            break;   
            
        } 
      }
    sc.close(); // Close the scanner before exiting the application 
    }
}
