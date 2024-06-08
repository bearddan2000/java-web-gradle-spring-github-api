package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import org.hibernate.Session;

import example.dto.Portal;
import example.entity.PortalEntity;

// Task class to be executed (Step 1)
public class FetchAPI
{
	private int page;

	Session session = null;

	Portal dto = new Portal();

	Logger logger = LoggerFactory.getLogger(FetchAPI.class);

	public FetchAPI(int page, Session s)
	{
		this.page = page;
		session = s;
	}

	private void parseApi(String res)
	{
		Gson gson = new Gson();
		PortalEntity[] repo = gson.fromJson(res, PortalEntity[].class);
		for (PortalEntity x : repo) {
			String[] name = x.getName().split("-");
			if (name.length >= 2) {
				try {
					dto.insert(x, session);
				} catch(Exception e) {}
			}
		}
	}

	public void run()
	{
		String url = "https://api.github.com/users/bearddan2000/repos?per_page=100&page="+page;
		String res = Helper.getRepoResponse(url);
		if (res != null) {
			parseApi(res);
		}
		else {
			logger.warn("api malformed");
		}
	}
}
