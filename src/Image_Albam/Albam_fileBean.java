package Image_Albam;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.imageio.ImageIO;

public class Albam_fileBean {
	private BufferedImage image;
	private Image Image_Read;

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
	//ファイル書き込み
	//ファイル作成
	//ファイル名入力
	//ファイル・ディレクトリ作成
	//ファイル、ディレクトリ判定
	public Path file_System(String directory) {
		Path path = Paths.get(directory);
		try {
			Files.createDirectory(path);
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
