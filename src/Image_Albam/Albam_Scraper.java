package Image_Albam;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class Albam_Scraper {

	private Document document;

	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	Albam_Scraper(String url){
		this.document = null;
		this.scraper(url);

	}
	//パース
	String scraper(String url){
		try {
			this.document = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return url;
	}

}
