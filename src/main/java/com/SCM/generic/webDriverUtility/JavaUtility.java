package com.SCM.generic.webDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random random = new Random();
		int randomInt = random.nextInt(5000);
		return randomInt;
	}

	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	public String getSystemDateddMMyyyy() {
		Date dateobj = new Date();
		String date = sdf.format(dateobj);
		return date;
	}

	public String getRequiredDateYYYYMMDD(int days) {
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String endDate = sdf.format(cal.getTime());
		return endDate;
	}

	private  final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	// Generate a random string of a given length
	public String getRandomString(int length) {
		StringBuilder builder = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			int index = random.nextInt(ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(index));
		}

		return builder.toString();
	}
}
