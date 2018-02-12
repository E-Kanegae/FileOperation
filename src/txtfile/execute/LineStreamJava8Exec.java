package txtfile.execute;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
*
* {@link txtfile.execute.OutOfMemoryExec}だとOutOfMemoryになるファイル読み込み処理が<br>
* Streamで一行づつ読み込むと正常に処理が行われることの確認<br>
* Streamを使って処理を行うクラス<br>
*
*/
public class LineStreamJava8Exec {

	public static void main(String[] args) {
		// 読み込む
		FileInputStream fi = null;
		try {
			fi = new FileInputStream("C:\\temp\\text.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		InputStreamReader ir = new InputStreamReader(fi);
		BufferedReader br = new BufferedReader(ir);


		//書き込む
		try {
			FileOutputStream fo = new FileOutputStream("C:\\temp\\output.txt");
			OutputStreamWriter ow = new OutputStreamWriter(fo);
			BufferedWriter bw = new BufferedWriter(ow);

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
