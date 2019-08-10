package Image_Albam;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public interface Request_exe<String> {
	public List<?> url = null;
	HttpGet httpget = new HttpGet();
	CloseableHttpClient httpclient = HttpClients.createDefault();
	public void request_get(String url);
	public  boolean request_download(String url);
	public default void Request_download() {
	}
	public default String htmlRequest() {
		return null;
	}

}
