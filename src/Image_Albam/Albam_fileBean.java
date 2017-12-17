package Image_Albam;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.imageio.ImageIO;

public class Albam_fileBean extends Date_today{
	private BufferedImage image;
	private Image Image_Read;
	private Path path;
	private Path directoryPath;

	public Path getPath() {
		return path;
	}
	public void setPath(Path path) {
		this.path = path;
	}
	public Path getDirectoryPath() {
		return directoryPath;
	}
	public void setDirectoryPath(Path directoryPath) {
		this.directoryPath = directoryPath;
	}
	public BufferedImage getImage() {
		return image;
	}
	public BufferedImage setImage(BufferedImage image) {
		return this.image = image;
	}
	public Image getImage_Read() {
		return Image_Read;
	}
	public void setImage_Read(Image image_Read) {
		Image_Read = image_Read;
	}

	//コンストラクタ
	public Albam_fileBean() {
		//super.toString();
		this.directoryPath = Paths.get("");
		this.path = Paths.get("");
		//this.file_System();
	}

	//ファイル読み込み
	public Path file_read(Path path) {
		try(InputStream is = Files.newInputStream(path, StandardOpenOption.CREATE)) {
			for(int ch;(ch = is.read())!= -1;) {
				System.out.println(ch);
			}
		}
		catch(IOException ex) {
			System.err.println(ex);
		}
		return path;

	}
	//inputstream変換
	public BufferedImage image_read(BufferedImage image) {
		// 対象となるBufferedImage
		//BufferedImage image;
		// 一度byte配列へ変換
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			image = ImageIO.read(new File("image.jpg"));
			ImageIO.write( image, ".jpg", baos );
		byte[] imageInByte = baos.toByteArray();
		// byte配列をInputStreamに変換
		InputStream in = new ByteArrayInputStream(imageInByte);

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return this.setImage(image);

	}
	//画像読み込み
	public BufferedImage image_reader(BufferedImage readImage, Path path) {
		try {
		  readImage = ImageIO.read(path.toFile());
		} catch (Exception e) {
		  e.printStackTrace();
		  readImage = null;
		}
		return this.setImage(readImage);

	}

	//ディレクトリ作成(現在時刻日時で)
	protected Path file_System() {
		this.directoryPath = Paths.get(this.Currentdirectory() +  "/"+ this.DirectoriesName2());
		try {
			Files.createDirectory(this.directoryPath);
		}
		catch(NoSuchFileException e) {
			System.out.println("ディレクトリが存在しません");
			System.out.println(e.getMessage());
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		return path;
	}

	//ディレクトを作成しその中にファイル作成
	protected Path file_Create(URI uri) {
		this.file_System();
		this.path = Paths.get(uri.getPath()).getFileName();
		Path filename =this.directoryPath.resolve(this.path);
		System.out.println(this.getPath());
		return filename;

	}

	//日付日時でファイル：ディレクトリ名前作成
	protected String DirectoriesName() {
		String directoryname = new Date_today().getDatetime();
		return directoryname;

	}

	//日付日時でファイル：ディレクトリ名前作成
	protected String DirectoriesName2() {
		String directoryname = new Date_today().getDateTime().format(this.getFormat_date());
		return directoryname;

	}

	//カレントディレクトリ取得
	public Path Currentdirectory() {
		return this.path.toAbsolutePath();
	}

	public String relativePath() throws IOException {
		return this.path.toRealPath(LinkOption.NOFOLLOW_LINKS).toString();
	}

	//String型の絶対パス
	public String current() {
		String path = new File(".").getAbsoluteFile().getParent();
		return path;
	}

	//複数ディレクトリ作成
	public Path directories(Path path) {
		try {
			Files.createDirectories(path);
		}
		catch(IOException ex) {
			System.err.println(ex);
		}
		return null;

	}
	//一時ファイル,画像
	public Path Temporarily_file(Path path, String tmpname) {
		try {
			Path tempPath = Files.createTempFile(path, tmpname, ".tmp");
			System.out.println(tempPath);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		return path;

	}

}
