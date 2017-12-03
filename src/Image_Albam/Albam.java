package Image_Albam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Document;

public interface Albam {
	public static final String REGEX = "(https?|ftp)(:\\\\/\\\\/[-_.!~*\\\\'()a-zA-Z0-9;\\\\/?:\\\\@&=+\\\\$,%#]+)";
	public static final Document document = null;
	public default String getRegex() {
		return Albam.REGEX;
	}

	public default void check(Pattern p, String target) {
		Matcher m = p.matcher(target);

		if(m.find()) {

		}else {

		}
	}
	public Document scraper(String url);


}
