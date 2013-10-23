/*
CISC 3150 - Spring 2013
Mark A. Tyler II - Revised And Ready
*/

import java.util.*;
import java.io.*;

public class CreditCards {
	long number;
	String tmp;
	private String value; 
	private double balance; 
	private Person cardHolder;
	
	CreditCards(){
		number = 0;
		balance = 0;
		
	}
	
	CreditCards(String value, double balance, Person cardHolder){
		this.tmp = value;
		this.number = Long.valueOf(value);
		this.balance = balance;
		this.cardHolder = cardHolder;
	}
	
	public String toString(){
		return("Credit Card Number: " + number + " Balance: " + balance  + " IsValid? " + isValid(number) + " Card Type: " + cardType(tmp));
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public static void main(String [] args) {
		// To receive input from command prompt
		Scanner input = new Scanner(System.in);
		//prompt the user to enter card number.
		System.out.println("Please enter a credit card number: ");
		//get each digit as a long	
		long number = input.nextLong();
		//show the user the card number
		String s = String.valueOf(number);
		System.out.println("The credit card number you entered is: " + number);
		
		//begin to check card validity. if isValid - return true else return false
		if (isValid(number)) {
			System.out.println("The credit card number " + number + " is VALID");
			System.out.println("Card Type: " + cardType(s));
		}
			else{
				System.out.println("The credit card number is NOT VALID");		
			}
		int total = calcTotal(sumAndDoubleOfEvenPlace(number),sumOfOddPlace(number));
		int div = total / 10;
		int mod = total % 10;
		
		System.out.println("1. The Sum and Double of Even Places: " + sumAndDoubleOfEvenPlace(number));
		System.out.println("2. The Sum Of Odd Places: " + sumOfOddPlace(number));
		System.out.println("Total: " + total);
		System.out.println("Div: " + div);
		System.out.println("Mod: " + mod);
		
		if(MOD10(total)){
		//if((sumAndDoubleOfEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0){
			System.out.println("Works!");
		}else{
			System.out.println("Invalid!");
		}
	}
	public static int calcTotal(int a, int b){
		int t;
		t = a + b;
		return t;
	}
	//checks the validity of the card number
	//starting with size check
	//if the prefix matcehs a valid card type
	//LUHN's algorithm - MOD10 Algorithm
	public static boolean isValid(long number) {
		if(getSize(number) >=13 && getSize(number) <=16 ) {
			return true;
		}else{
			return false;
			//(sumAndDoubleOfEvenPlace(number) + sumOfOddPlace(number)) % 10 == 1
		}          
	}
	//card type function
	public static String cardType(String s){
		if(s.startsWith("4")){
			return "Visa";
		}else if(s.startsWith("5")){
			return "Master";
		}else if(s.startsWith("6")){
			return "Discover";
		}else if(s.startsWith("37")){
			return "American-Express";
		}else{
			return "In-valid Card";
		}
	}

	// Extract a digit from the long
	public static int separateDigit(long number, int position){
		
		String x = Long.toString(number);
		//extract digit at a given position
		int temp = x.charAt(position)-'0';
		return temp;
	} 
	/*
	You can convert a long to a String and use String methods 
	OR 
	You can use modulus with division.
	*/
	/** Get the result from Steps 1 and 2*/ 
	public static int sumAndDoubleOfEvenPlace(long number) {
		int total = 0;
		//Allows us to use the string length value
		String s = String.valueOf(number);
		for( int i = 1; i < s.length(); i+=2){
			//multiply by two each digit that's extracted from 
			//the even places in the card 'number'.
			//pass value through getAsOneDigit function to convert 
			//digit to single digit of it exceeds 9
			total += getAsOneDigit(2 *separateDigit(number, i));
		}
		return total;
	}
 		
	// Return this number if it's <=9 as a single digit, else return 
	//the sum of the two digits.  
	public static int getAsOneDigit(int number){
		if(number > 9){
			return (number % 10) + (number / 10);
		}
		return number;
	}
 
	// Return sum of odd place digits in number, Step 3 */ 
	public static int sumOfOddPlace(long number) {
	int total = 0;
	String s = String.valueOf(number);
	
	//For Loop iterate through the string
	for( int i = 0; i < s.length(); i+=2){
		//sum up each digit that is separated from the long
		total += separateDigit(number, i);
	}
	return total;
	
	/*	
	//Algorithm that was initially tested but gave bad results.	
		int sum = 0;
        int remainder;
        //number = number % 10;
        while (number % 10 != 0 || number / 10 != 0) {
            remainder = (int) (number % 10);
            //double remainder
            //remainder = remainder * 2;
            //add up everybody
            sum = sum + getAsOneDigit(remainder);
            //extract already combined digit
            number /= 100;
        }
        return sum;
     */
	}

	// Extract each individual digit from card 'number'
	public static int getDigit(int number) {
	         return number % 10 + (number / 10);
	    
	} 
	//Checks if total is divisible by 10
	public static boolean MOD10(int t){
		//String s = String.valueOf(number);
		//for(int i = 0; i < s.length() ; i++){
			if(t % 10 == 0){
				return true;
			}
			else{
				return false;
			}
	}
	public static int getSize(long p) {	    
	    int num = 0;
	    String s = Long.toString(p);
	    num = s.length();
	    return num;
	}
	    
	// Return the first k number of digits from number. If the number
	// of digits in number is less than k, return number.
	//

}
