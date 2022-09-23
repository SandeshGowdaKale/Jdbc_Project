package com.ty.controller;

import java.util.List;
import java.util.Scanner;

import com.ty.dao.SignUpDAO;
import com.ty.dto.SignUp;

public class GetAllSignUpController {
	public static void main(String[] args) {
		SignUp signUp= new SignUp();
		SignUpDAO dao = new SignUpDAO();
		Scanner scanner = new Scanner(System.in);
		
		List<SignUp> list=dao.getAllSignUp();
		System.out.println(list);
	
	}
}
