package ips2023pl21.main;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Main21913 {

	public static void main(String[] args) {
		Timestamp a = Timestamp.valueOf("2023-10-13 01:31:00");
		System.out.println(a);
		Timestamp b = Timestamp.valueOf(LocalDateTime.now());
		System.out.println(b);
		LocalDateTime l = LocalDateTime.of(2023, 01, 01, 21, 10);
		System.out.println(l.toString());
		
		System.out.println(l.getChronology());
		
		System.out.println(l.getYear());
		System.out.println(l.getMonthValue());
		System.out.println(l.getDayOfMonth());
		System.out.println(l.getHour());
		System.out.println(l.getMinute());
	}

}
