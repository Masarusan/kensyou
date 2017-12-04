package Image_Albam;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

class Albam_fileTest implements Albam{
	private static String str = "";
	Albam_fileBean albamfile = new Albam_fileBean();

	@Test
	void testFile_System() {
		//String str = "/image/";
		fail("まだ実装されていません");

		//assertEquals("パスが存在しません", albamfile.file_System(str));
	}
	@SuppressWarnings("unlikely-arg-type")
	@Test
	void testimage_read() {
		//equals(albamfile.file_System("/image"));
	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	void testAlbam_Scraper() {
		Albam_Scraper albamscraper = new Albam_Scraper("http://eropasture.com/archives/52211167.html");//"http://example.com"
		albamscraper.document_parser(albamscraper.getDocument());
		equals(albamscraper);
	}

	@Test
	void testTemporarily_file() {
		fail("まだ実装されていません");
	}

	@Test
	void testGetClass() {
		fail("まだ実装されていません");
	}

	@Test
	void testToString() {
		fail("まだ実装されていません");
	}
	@Override
	public Document scraper(String url) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
