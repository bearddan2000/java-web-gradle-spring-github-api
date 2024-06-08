package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Importing required classes
import java.io.*;
import java.utils.*;

public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	private List<String> readSQLFile() throws IOException
	{
		String PWD = System.getenv("PWD");
		// Now calling Files.readString() method to
		// read the file
		String fileName = PWD + "/src/main/resources/download.csv";
		// Now calling Files.readString() method to
		// read the file
		String str = new String(
			java.nio.file.Files.readAllBytes(
			java.nio.file.Paths.get(fileName)), java.nio.charset.StandardCharsets.UTF_8);

		return Arrays.asList(str.split("\n"));;
	}

	public static void main(String[] args) {
		List fileContent;
/*
		org.hibernate.Session session = HibernateUtils.getSessionFactory().openSession();

		for (int i=1;i<rounded;i++) {
			FetchAPI t = new FetchAPI(i, session);
			t.run();
		}
		HibernateUtils.shutdown();
*/
	}
}
