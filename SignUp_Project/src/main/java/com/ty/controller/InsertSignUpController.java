package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.SignUpDAO;
import com.ty.dto.SignUp;

public class InsertSignUpController {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SignUpDAO dao = new SignUpDAO();
		SignUp s = new SignUp();
		System.out.println("Enter the FirstName");
		String firstname = scanner.next();
		s.setFirstName(firstname);

		System.out.println("Enter the Last name:");
		String lastname = scanner.next();
		s.setLastName(lastname);

		System.out.println("Enter the Email:");
		String email = scanner.next();
		s.setEmail(email);
		
		System.out.println("Enter the Password");
		String password = scanner.next();
		s.setPassword(password);
		
		System.out.println("Enter the Phone no:");
		Long phone = scanner.nextLong();
		s.setPhone(phone);
		
		System.out.println("Enter the DOB:");
		String dob = scanner.next();
		s.setDob(dob);
		
		System.out.println("Enter Your Gender:");
		String gender = scanner.next();
		s.setGender(gender);
		
		String result=dao.insertSignUp(s);
		System.out.println(result);
	}

}
