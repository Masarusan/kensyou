package Image_Albam;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.apache.http.client.methods.CloseableHttpResponse;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Albam_Scraper implements Albam{

	private Document document;
	private String htmltext;
	final private String REGEX = "(https?|ftp)(:\\/\\/[-_.!~*\\'()a-zA-Z0-9;\\/?:\\@&=+\\$,%#]+)";

	//http_Pattern
	public String getRegex() {
		return this.REGEX;
	}

	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	Albam_Scraper(String url){
		this.document = null;
		//this.scraper(url);
		Pattern p1 = Pattern.compile(this.REGEX);
		this.check(p1, url);
	}
	Albam_Scraper(){

	}
	@Override
	 public void check(Pattern p, String target){
		    Matcher m = p.matcher(target);
		    System.out.print(target + "はhttp(s)は");

		    if (m.find()){
		      System.out.println("マッチします");
		      this.scraper(target);
		    }else{
		      System.out.println("マッチしません");
		    }
		  }


	//htmlファイルまるごとスクレイピング
	public Document scraper(String url){
		try {
			this.document = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return this.document;

	}
	String document_parser(Document document) {
		System.out.println("パーサー");
		Document doc = Jsoup.parse(document.toString());
		Element content = doc.getElementById("content");
		Elements str = content.getElementsByClass("pict");
		List<String> urls = new ArrayList<String>();
		String image_path= "";
		int i = 0;
		for(Element e: str) {
			i++;
			image_path = e.attr("src");
			urls.add(image_path);
			System.out.printf("%d:%s\n",i,e);
			String http_url = "http";
			if(!(e.toString().contains("http"))) {
				System.out.println("補完します");
				String url = urls.get(i);
				urls.set(i,http_url + urls.get(i));
				urls.forEach(o -> {
				System.out.println(o);
				});
			}
		}
		return document.toString();
	}

}
