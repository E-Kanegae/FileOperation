package log.execute;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import log.read.LogFileReader;
import log.util.FileValidateUtils;

/**
*
* logファイルを読み込んで必要な情報を出力するクラス<br>
* 引数は以下を想定している。
* 1:ファイルパス。もしくはディレクトリパス。ディレクトリの場合は直下に配備されたファイルを全て読み込む。[必須]
* 2:検索対象ファイルの正規表現[必須]
* 3:対象処理名：ログファイルで探索予定の処理名を記載する。[必須]
* 4:出力ファイルパス[任意]
*/
public class LogFileExec {

	private static final String OUTPUT_FILE_NAME = "";

	public static void main(String[] args) {

		String dir = args[0]; // ファイルパス
		String fileRegex = args[1]; // ファイル正規表現
		String processName = args[2]; //処理名
		String outputFilePath = args[3]; //出力ファイルパス

		if (dir.isEmpty() || fileRegex.isEmpty() || processName.isEmpty()){
			System.out.println("引数が足りません");
			System.exit(1);
		}

		// 対象ファイルリストを作成する。
		List<String> inputFileNameList = FileValidateUtils.getTargetFiles(
				FileValidateUtils.makeFileNameList(dir), fileRegex);

		try {
			if(outputFilePath.isEmpty()){
				outputFilePath = OUTPUT_FILE_NAME;
			}else{
				if(!FileValidateUtils.isValidFileName(outputFilePath)){
					outputFilePath = OUTPUT_FILE_NAME;
				}
			}

			FileOutputStream fo = new FileOutputStream(outputFilePath);
			OutputStreamWriter ow = new OutputStreamWriter(fo);
			BufferedWriter bw = new BufferedWriter(ow);

		// 読み込む
		LogFileReader reader = new LogFileReader();
		reader.read(inputFileNameList, bw);

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}

}
