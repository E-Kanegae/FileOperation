package txtfile.execute;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
*
* ファイルを一気に読み込んでOutOfMemoryが起きることの確認
*
**/
public class OutOfMemoryExec {

	public static void main(String[] args) {
		// 読み込む
		File f = new File("C:\\temp\\text.txt");
		byte[] b = new byte[(int) f.length()];
		FileInputStream in;
		try {
			in = new FileInputStream(f);
			in.read(b);
			System.out.println(new String(b));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
