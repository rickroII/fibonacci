/* 

   name:  Fibonacci.java
   author: rickroll
   date: 10/22/16
   description: Fibonacci sequence printed

*/

import java.util.Scanner;

//Fibonacci Class
public class Fibonacci{
	
	//Fibonacci Class Fields
	
	//userInput field, get's input from the user to calcuate the fibonacci sequence to the nth number
	private static int userInput;
	
	//Fibonacci Class Methods
    //main method with default parameters
	public static void main(String[] args) throws ArrayIndexOutOfBoundsException{
		//calls the getUserInput method that gets an integer value from the user
		//value of user's input used to determine length of fibonacci sequence generated
		getUserInput();
		
		//separate variables used to store userInput
		//"i" variable used for index in arrays
		int i = userInput;
		
		//"stopsign" variable used for displaying relevant data to user
		//used in output loop as length of fibonacci values to output  
		int stopsign = userInput;

		//"flag" variable used for flagging if explainOutput method needs to be run
		boolean flag = false;
		
		//create two new array object's
		//"fibonacci" array object stores the numbers of the fibonacci sequence
		long[] fibonacci = new long[i];
		//"grfibonacci" array object stores the ratio of the fibonacci sequence
		long[] grfibonacci = new long[i];
		
		//error trap if user's input is invalid
		try{
			
			//array initalizers for "fibonacci" array
			fibonacci[0]=1;
			fibonacci[1]=1;
			
			//computes the data values for fibonacci sequence
			//stops computation if user's input exceeds the limits of primitive types
			for(i=2; i < userInput; i++){
				fibonacci[i] = fibonacci[i-1]+fibonacci[i-2];
				grfibonacci[i]=(fibonacci[i]/fibonacci[i-1]);
				//if the golden ratio value is not within bounds of reason (i.e. 1.6)
				if (grfibonacci[i] != 1 && grfibonacci[i] != 2){
				//set output loop end to index's current value
				stopsign = i;
				//end current loop by setting current userInput to the index
				i = userInput;
				//set flag variable to true
				flag=true;
				}
			}
			//start output sequence with explaination for user
			System.out.println("Line # : Fibonacci #");

			//outputs the relevant data values for fibonacci sequence
			//starting at 0, go until the end of relevant domain
			for(i=0; i < stopsign; i++){
				System.out.println(i+": "+fibonacci[i]);
			}
			
			//if "flag" variable value was true, execute explainOutput method
			if(flag==true){
				explainOutput(i);
			}
		}
		catch(ArrayIndexOutOfBoundsException e){
			if(userInput==0){
				//start output sequence with explaination for user
				System.out.println("Line # : Fibonacci #");
			} else if(userInput==1) {
				//start output sequence with explaination for user
				System.out.println("Line # : Fibonacci #");
				System.out.println("0: 1");			
			} else {
				System.out.println("Invalid Input. The Number of Fibonacci Sequence number's you want displayed must be > or = to 0");
			}
		}

	}
	
	//get users input method
	public static int getUserInput(){
		//getting the user's input from the system
		
		System.out.println("How many values of the Fibonacci sequence would you like to display?");
		Scanner setUserInput = new Scanner(System.in);
		
		while (!setUserInput.hasNextInt()) {
	    	//tell user to enter in an integer value, and give them a chance to do so. Repeat as many times as nessacary until they do.	
			System.out.println("Enter an integer, please!");
			setUserInput.nextLine();
		}
		
		userInput = setUserInput.nextInt();
		
		//sends userInput value to "main" method
		return userInput;
	}
	
	//method to explain truncated output to the user
	public static int explainOutput(int i){
		System.out.println("\n-----------------------------------------------------------------");
		System.out.println("User's input exceeds bounds of data type capacity at value: "+ i);
		System.out.println("This basically means that the number of the fibonacci sequence");
		System.out.println("you've entered exceeds the limits of the java language's capacity");
		System.out.println("-----------------------------------------------------------------");
		return i;
	}
}
