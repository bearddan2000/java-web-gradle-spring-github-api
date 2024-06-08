package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class Helper {

	static Logger logger = LoggerFactory.getLogger(Helper.class);

	public  static String getRepoResponse(String url){
		try
		{
				URL obj = new URL(url);
				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				// optional default is GET
				con.setRequestMethod("GET");
				//add request header
				con.setRequestProperty("User-Agent", "Mozilla/5.0");
				int responseCode = con.getResponseCode();
				logger.debug("\nSending 'GET' request to URL : " + url);
				logger.debug("Response Code : " + responseCode);
				BufferedReader in = new BufferedReader(
								new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				return response.toString();
		}

		catch(Exception e)
		{
			logger.error("api response corrupted");
		}
		return null;
	}
	public static int getRepoCount(String url)
	{
		String res = getRepoResponse(url);
		if(res != null){
			JSONObject json = new JSONObject(res);
			return (Integer)json.get("public_repos");
		}
		else
			logger.warn("getRepoCount return 0");
		return 0;
	}
}
