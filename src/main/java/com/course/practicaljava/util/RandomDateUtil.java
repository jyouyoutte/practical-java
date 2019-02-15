package com.course.practicaljava.util;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDateUtil {
	
	private static final long MIN_DAY = LocalDate.of(2010, Month.JANUARY, 1).toEpochDay();
	private static final long MAX_DAY = LocalDate.now().toEpochDay();

	public static LocalDate generateRandomLocalDate() {
		long ramdomDay = MIN_DAY + ThreadLocalRandom.current().nextLong(MAX_DAY - MIN_DAY);
		return LocalDate.ofEpochDay(ramdomDay);
	}
	
	public static Date generateRandomDate() {
		var randomLocalDate = generateRandomLocalDate();
		return Date.from(randomLocalDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

}
