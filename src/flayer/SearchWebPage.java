package flayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class SearchWebPage {
	public String search(String url) throws MalformedURLException, IOException {
		String webArticle = "";

		URLConnection conn = new URL(url).openConnection();
		InputStream inputStream = conn.getInputStream();
		InputStreamReader inputStreamReader
			= new InputStreamReader(inputStream, "utf-8");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		String line = null;
		StringBuilder concatLine = new StringBuilder();

		while ((line = bufferedReader.readLine()) != null) {
			concatLine.append(line+"\n");
		}

		webArticle = concatLine.toString();

		return webArticle;
	}
}
