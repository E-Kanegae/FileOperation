package log.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ファイル読み込みの際のチェック処理などのutilクラス
 *
 */
public class FileValidateUtils {

	/**
	 *
	 * @param dirName ディレクトリパスもしくはファイルパス
	 * @return ファイルリスト
	 */
	public static List<String> makeFileNameList(String dirName){

		File inputDir = new File(dirName);
		List<String> fileList = new ArrayList<String>();
		if(inputDir.isDirectory()){
			return Arrays.asList(inputDir.list());
		}else{
			fileList.add(dirName);
			return fileList;
		}
	}

	/**
	 * 正規表現に合致する名称のみリストに残し、returnする。<br>
	 * @param files
	 * @param regex
	 * @return
	 */
	public static List<String> getTargetFiles(List<String> files, String regex){
		List<String> returnList = new ArrayList<String>();
		for(String file : files){
	        Pattern p = Pattern.compile(regex);
	        Matcher m = p.matcher(file);
	        if(m.find()){
	        	returnList.add(file);
	        }
		}
		return returnList;
	}

	/**
	 * ファイルパスの妥当性を確認する
	 * @param fileName
	 * @return rue/false
	 */
	public static boolean isValidFileName(String fileName){
		// 未実装
		return true;
	}

}
