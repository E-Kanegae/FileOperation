package txtfile.make;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.stream.Stream;

import org.apache.commons.lang3.RandomStringUtils;

public class TextFileMaker {

	public static void main(String[] args) {
		Iterable<String> lines = () -> Stream.
				generate(() -> RandomStringUtils.randomAlphanumeric(100))
				.limit(10000000)
				.iterator();
		try {
			FileOutputStream file = new FileOutputStream("C:\\temp\\text.txt");
			for(String s : lines){
				file.write(s.getBytes());
				file.write(10);
			}
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
