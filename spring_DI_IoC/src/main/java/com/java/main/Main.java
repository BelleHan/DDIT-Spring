package com.java.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/spring/context/application-context.xml");

		Calculator cal = ctx.getBean("calc",Calculator.class); //new Calculator();
		
		int result = 0;
		do {
			System.out.println("계산 항목을 선택하세요.");
			System.out.println("[1]더하기\t[2]빼기\t[3]곱하기\t[4]나누기");
			System.out.print("선택 번호 : __");

			Scanner scann = new Scanner(System.in);
			try {
				int menu = Integer.parseInt(scann.nextLine());

				System.out.println("두 정수를 띄어쓰기로 입력하세요.");
				try {
					int a = scann.nextInt();
					int b = scann.nextInt();
					scann.nextLine();

					switch (menu) {
					case 1:
						result = cal.sum(a, b);
						break;
					case 2:
						result = cal.minus(a, b);
						break;
					case 3:
						result = cal.multi(a, b);
						break;
					case 4:
						result = cal.divide(a, b);
						break;
					default:
						continue;
					}
				} catch (NumberFormatException | InputMismatchException e) {
					System.out.println("정수 입력이 올바르지 않습니다.\n처음부터 다시시작합니다.");
					System.out.println("아무키나 입력하세요.");
					scann.nextLine();
					continue;
				}

			} catch (NumberFormatException e) {
				System.out.println("선택이 올바르지 않습니다.\n\n\n\n");
				System.out.println("아무키나 입력하세요.");
				scann.nextLine();
				continue;
			}

			System.out.println("결과 : " + result);
			System.out.println("\n\n\n");

		} while (true);

	}

}
