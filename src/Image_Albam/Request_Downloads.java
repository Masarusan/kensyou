package Image_Albam;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

@SuppressWarnings("rawtypes")
public class Request_Downloads extends Albam_fileBean implements Request_exe {
	private List<String> url;

	public List<String> getUrl() {
		return url;
	}

	public void setUrl(List<String> url) {
		this.url = url;
	}

	public Request_Downloads(String url){
		super();
		this.setUrl(new ArrayList<String>());
		this.request_get(url);
	}

	protected void request_get(String url) {
		// TODO 自動生成されたメソッド・スタブ
		 try (final CloseableHttpClient client = HttpClients.createDefault();
	                final CloseableHttpResponse response = client.execute(new HttpGet(url))) {
			//System.out.println(new HttpGet(url).getURI());
			 HttpGet uri = new HttpGet(url);
			 URI uro = uri.getURI();
	            final int status = response.getStatusLine().getStatusCode();
	            if (status >= 200 && status < 300) {
	                final HttpEntity entity = response.getEntity();
	                Files.write(super.file_Create(uro), entity == null ? new byte[0] : EntityUtils.toByteArray(entity),
	                		StandardOpenOption.CREATE_NEW);
	            } else {
	                throw new ClientProtocolException("Unexpected response status: " + status);
	            }
		 }catch(IOException e) {
			 e.printStackTrace();
		 }
	}

	@Override
	public void request_get(Object url) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public boolean request_download(Object url) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}


}
