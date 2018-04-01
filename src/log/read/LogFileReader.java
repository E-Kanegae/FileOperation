package log.read;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import log.process.LogFileProcessor;

public class LogFileReader {

	public void read(List<String> fileNameList, BufferedWriter bw){

		LogFileProcessor processor = new LogFileProcessor();

		for(String fileName : fileNameList){
			File f = new File(fileName);

			FileInputStream fi = null;
			try {
				fi = new FileInputStream(f.getPath());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			InputStreamReader ir = new InputStreamReader(fi);
			BufferedReader br = new BufferedReader(ir);

				br.lines().forEach(line -> {
					processor.process(line, bw);
				});

				try {
					fi.close();
					ir.close();
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
