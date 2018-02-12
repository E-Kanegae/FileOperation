package txtfile.execute;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/**
*
* ディレクトリ内の全ファイルを読み込んで、一つのファイルに書き込むクラス<br>
* 入出力ともにStream処理を行う。
*
*/
public class LineStreamMultiInputFilesExec {

	public static void main(String[] args) {

		try {
			FileOutputStream fo = new FileOutputStream("C:\\temp\\output\\output.txt");
			OutputStreamWriter ow = new OutputStreamWriter(fo);
			BufferedWriter bw = new BufferedWriter(ow);

		// 読み込む
		File dir = new File("C:\\temp\\input");
		File[] files = dir.listFiles();

		// 1ファイルづつ処理
		for(File f : files){
			FileInputStream fi = null;
			try {
				fi = new FileInputStream(f.getPath());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			InputStreamReader ir = new InputStreamReader(fi);
			BufferedReader br = new BufferedReader(ir);


				br.lines().forEach(line -> {
					try {
						bw.write(line + "\\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
				});

				fi.close();
				ir.close();
				br.close();
		}

			bw.close();
			ow.close();
			fo.close();

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
