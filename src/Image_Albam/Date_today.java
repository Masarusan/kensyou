package Image_Albam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

//ファイルの日時等
public class Date_today {
	private LocalDate dateDay = null;
	private LocalTime time = null;
	private LocalDateTime dateTime = null;
	private DateTimeFormatter format_date = null;

	public DateTimeFormatter getFormat_date() {
		return format_date;
	}

	public void setFormat_date(DateTimeFormatter format_date) {
		this.format_date = format_date;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	//コンストラクタ
	public Date_today() {
		this.dateDay = LocalDate.now();
		this.time = LocalTime.now();
		this.dateTime = LocalDateTime.now();
		this.setFormat_date(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

	}

	//String型で日付取得
	public String getLocal_date() {
		return this.dateDay.toString();
	}

	//String型で時刻取得
	public String getLocaltime() {
		return this.time.toString();
	}

	//String型で日時取得
	public String getDatetime() {
		String format = this.dateTime.getYear() +  this.dateTime.getMonth().toString();
		return format;
	}
	//formatdate表示
	public String format_day() {
		return this.format_day();
	}

	//年を取得
	public int getDateyear() {
		return this.dateTime.getYear();
	}

	//標準出力
	public void print(String str) {
		System.out.println(str);
	}
	//文字列型に変換
	public String toString(String date) {
		return date;

	}

}
