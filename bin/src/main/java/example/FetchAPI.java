package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import java.util.HashMap;

import example.model.*;

// Task class to be executed (Step 1)
public class FetchAPI implements Runnable
{
	private int page;
	private HashMap<String, String> map;
	private static final Logger logger = LoggerFactory.getLogger(FetchAPI.class);

	public FetchAPI(int page, HashMap<String, String> map)
	{
		this.page = page;
		this.map = map;
	}

	private void parseClassification(String[] name)
	{
		logger.info("call to parseClassification function");
		for (String s : name) {
				if (!map.containsKey(s)) {
					map.put(s, s);
				}
		}
	}

	private void parseApi(String res)
	{
		Gson gson = new Gson();
		GitRepoPlain[] repo = gson.fromJson(res, GitRepoPlain[].class);
		for (GitRepoPlain x : repo) {
			String[] name = x.getName().split("-");
			try {
				String lang = name[0];
				String platform = name[1];
				if(lang.equals("dev"))
				{
					x.setIsDev(1);
					lang = name[1];
					platform = name[2];
				}
				else if (lang.equals("docker")) {
					logger.info(x.toString());
				}
				parseClassification(name);
				x.setLang(lang);
				x.setPlatform(platform);
//				logger.info(x.toString());
			}
			catch (ArrayIndexOutOfBoundsException e) {
				logger.warn("access of out of bounds index for: " + x.getName());
			}
		}
	}

	// Prints task name and sleeps for 1s
	// This Whole process is repeated 5 times
	public void run()
	{
		String url = "https://api.github.com/users/bearddan2000/repos?per_page=100&page="+page;
		String res = example.Helper.getRepoResponse(url);
		if (res != null) {
			parseApi(res);
		}
		else {
			logger.warn("api malformed");
		}
	}
}
