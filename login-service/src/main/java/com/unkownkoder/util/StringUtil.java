package com.unkownkoder.util;

public class StringUtil {
	public static boolean isEmpty(String input) {
		return input == null || input.trim() == "";
	}

	public static boolean startsWith(String input, String pattern) {
		return input.startsWith(pattern);
	}

	public static boolean isNotEmpty(String input) {
		return !isEmpty(input);
	}
}
