package Assignment.util;


import Assignment.config.Constant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Assignment.config.Constant.PHONE_LENGTH;
import static Assignment.config.Constant.PHONE_REGEX;

public class Common implements Constant {
	public static boolean isValidPhoneNumber(String phoneNumber) {
		if(isNullOrEmpty(phoneNumber) || phoneNumber.length() != PHONE_LENGTH || !phoneNumber.matches(PHONE_REGEX)) {
			return false;
		};
		return true;
	}

	public static boolean isValidEmail(String email) {
		if (isNullOrEmpty(email)) {
			return false;
		}
		Pattern pattern = Pattern.compile(EMAIL_REGEX);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public static boolean isNullOrEmpty(String str) {
		if (str == null || str.isEmpty()) {
			return true;
		}
		return false;
	}
}
