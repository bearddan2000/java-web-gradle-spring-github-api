package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static int roundToNearesttHundred(final int raw){return (((int)raw/100) % 100)+1;}

	public static void main(String[] args) {
		int raw = Helper.getRepoCount("https://api.github.com/users/bearddan2000");
		int rounded = roundToNearesttHundred(raw);
		logger.debug(String.format("raw=%d, rounded=%d", raw, rounded));

		org.hibernate.Session session = HibernateUtils.getSessionFactory().openSession();

		for (int i=1;i<rounded;i++) {
			FetchAPI t = new FetchAPI(i, session);
			t.run();
		}
		HibernateUtils.shutdown();
	}
}
