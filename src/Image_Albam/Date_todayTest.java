package Image_Albam;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Date_todayTest extends Date_today{
	Date_today datetest = new Date_today();
	@Test
	void testDate_today() {
		fail("まだ実装されていません");
	}

	@Test
	void testGetLocal_date() {
		//fail("まだ実装されていません");
		datetest.toString(datetest.getLocal_date());
	}

	@Test
	void testGetLocaltime() {
		fail("まだ実装されていません");
		datetest.toString(datetest.getLocaltime());
	}

	@Test
	void testGetDatetime() {
		//fail("まだ実装されていません");
		datetest.print(datetest.getDatetime().toString());
		System.out.println(datetest.getDatetime().toString());
		//datetest.toString();
		System.out.println(datetest.getDateTime().format(datetest.getFormat_date()));
	}

	@Test
	void testToday() {
		fail("まだ実装されていません");
	}

	@Test
	void testformat_day() {
		System.out.println(datetest.format_day());
	}

	@Test
	void testToString() {
		fail("まだ実装されていません");
	}
	@Override
	public String toString() {
		return datetest.getDatetime();
	}


}
