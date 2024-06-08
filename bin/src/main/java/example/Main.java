package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static int roundToNearesttHundred(final int raw){return (((int)raw/100) % 100)+1;}

	public static void main(String[] args) {
		int raw = Helper.getRepoCount("https://api.github.com/users/bearddan2000");
		int rounded = roundToNearesttHundred(raw);
		logger.info(String.format("raw=%d, rounded=%d", raw, rounded));

		final int MAX_T = 3;
		ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
 		HashMap<String, String> map = new HashMap<>();

		for (int i=1;i<rounded+1;i++) {
			Runnable t = new FetchAPI(i, map);
			pool.execute(t);
		}
		pool.shutdown();
		for (String key : map.keySet())
			logger.info(key);
	}
}
