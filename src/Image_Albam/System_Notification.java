package Image_Albam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;

//OsaScript
public class System_Notification<Notification> implements Serializable{
	private String Sys_not;

	System_Notification(String string){
		this.Sys_not  = string;
		this.Notification_Scrape(this.Sys_not);
	}

	public String getSys_not() {
		return Sys_not;
	}

	public void setSys_not(String sys_not) {
		this.Sys_not = sys_not;
	}

	void Notification_Scrape(String string) {
		String test = string;
		System.out.println(test.toString());
		String command = "display notification \""+ test.toString()  +"\" with title \"Scrape\" sound name \"Purr\"";
	try
	{
		Runtime runtime = Runtime.getRuntime();
		String[] Command = {"osascript", "-e", command};
		Process p = runtime.exec(Command);
		InputStream is = p.getInputStream();
		BufferedReader br
	    = new BufferedReader(
	    new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = br.readLine()) != null) {
			sb.append("\n"+line);
		}
	System.out.println(sb.toString());
	System.out.println(command);
		br.close();

	}catch(IOException e) {
		System.out.println(e.getMessage());
	}
	}
}


