package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.SignUpDAO;
import com.ty.dto.SignUp;

public class VaildationEmail_Password {
	public static void main(String[] args) {
		SignUp signUp = new SignUp();
		SignUpDAO dao = new SignUpDAO();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Email:");
		String email = scanner.next();
		signUp.setEmail(email);
		
		System.out.println("Enter the Password:");
		String password = scanner.next();
		signUp.setPassword(password);
		
		SignUp result=dao.getSignUpByEmailAndPassword(email, password);
		System.out.println(result);
		
		
	}
}
