/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.st10447558_prog5121_poe_part1_safwaanwadee.java;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 *
 * @author Safwaan
 */
public class ST10447558_PROG5121_POE_Part1_SafwaanWadee {
    //Store user credentials
    private static String registeredUsername;
    private static String registeredPassword;
    private static String firstName;
    private static String lastName;
    
    //Constructor
    private static class Login {

        public Login() {
        }

        private String registerUser() {
            return "Registration successful.";
        }
        
        private String returnLoginStatus() {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        }
    }
    
    //Method for user registration
    public static void registerUser(Scanner scanner){
        boolean validInput = false;
        
        //Username input and validation
        while (!validInput){
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            if (checkUserName(username)){
                registeredUsername = username;
                System.out.println("Username successfully captured");
                validInput = true;
            }else{
                System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.");
            }
        }
        
        validInput = false;
        
        //Password input and validation
        while (!validInput){
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            if (checkPasswordComplexity(password)){
                registeredPassword = password;
                System.out.println("Password successfully captured.");
                validInput = true;
            }else{
                System.out.println("Password is not correctly formatted, please ensure that the password contains atleast 8 characters, a capital letter, a number, and a special character.");
            }
        }
        
        //First name and last name input
        System.out.print("Enter your first name: ");
        firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        lastName = scanner.nextLine();
        
        System.out.println("Registration successful.");
    }
    
    //Method for user login
    public static void loginUser(Scanner scanner){
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        
        if (username.equals(registeredUsername)&& password.equals(registeredPassword)){
            System.out.println("Welcome " + firstName + ", " + lastName + " it is great to see you again.");
        }else{
            System.out.println("Username or password incorrect, please try again.");
        }
    }
    
    //Validate username based on the conditions
    public static boolean checkUserName(String username){
        //Username must contain an underscore and be no more than 5 characters
        return username.contains("_")&&username.length()<=5;
    }
    
    //Validate password based on the conditions
     public static boolean checkPasswordComplexity(String password){
         //Password must be atleast 8 characters long, contain a capital letter, a number, and a special character
         if (password.length()<8){
             return false;
         }
         
         Pattern capitalLetter = Pattern.compile("[A-Z]");
         Pattern number = Pattern.compile("[0-9]");
         Pattern specialChar = Pattern.compile("[^a-zA-Z0-9]");
         
         Matcher hasCapital = capitalLetter.matcher(password);
         Matcher hasNumber = number.matcher(password);
         Matcher hasSpecial = specialChar.matcher(password);
         
         return hasCapital.find() && hasNumber.find() && hasSpecial.find();
     }
     
     //Main method to demonstrate functionality
    public static void main(String[] args) {
        Login loginSystem = new Login();
        
        //Register user
        System.out.println("=== User Registration ===");
        String registrationMessage = loginSystem.registerUser();
        System.out.println(registrationMessage);
                
        //Login status
        System.out.println("=== User Login ===");
        String loginMessage = loginSystem.returnLoginStatus();
        System.out.println(loginMessage);
    }
}
