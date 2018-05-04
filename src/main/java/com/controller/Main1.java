package com.controller;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Main1 {

	private static boolean isCalled = false;

	public static void main(String[] args) {
		ArrayDeque<String> arrayDeque = new ArrayDeque<>();
		String[] arr = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
				"q", "r", "s" };
		arrayDeque.addAll(Arrays.asList(arr));
		String currentElement = null;
		while (!arrayDeque.isEmpty()) {
			currentElement = arrayDeque.pop();
			if (!process(currentElement)) {
				arrayDeque.add(currentElement);
			}
		}
	}

	private static boolean process(String currentElement) {
		System.out.println("Processing: " + currentElement);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (currentElement.equalsIgnoreCase("h")) {
			if (!isCalled) {
				isCalled = true;
				System.out.println("Processing failed: " + currentElement);
				return false;
			}
		}
		return true;
	}
}
