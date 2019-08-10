package Image_Albam;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class System_NotificationTest<Notification> {

	private System_Notification<Notification> sno;

	@Test
	<testSystem_Notification> void testSystem_Notification() {
		sno = new System_Notification<Notification>("test");
		System.out.println(sno.getSys_not());
		equals(sno);
	}

	@Test
	void testNotification_Scrape() {
		fail("まだ実装されていません");

	}

}
