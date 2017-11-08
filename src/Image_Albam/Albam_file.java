package Image_Albam;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Albam_file {

	//ファイル読み込み
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
