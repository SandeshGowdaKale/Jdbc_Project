package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.SignUpDAO;
import com.ty.dto.SignUp;

public class GetSignUpController {
	public static void main(String[] args) {
		SignUp s = new SignUp();
		SignUpDAO dao = new SignUpDAO();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Email:");
		String email = scanner.next();
		s.setEmail(email);

		SignUp result = dao.getSignUp(email);
		System.out.println(result);

	}
}
