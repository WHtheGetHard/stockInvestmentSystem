package test;

import java.io.IOException;
import java.net.MalformedURLException;

import flayer.SearchWebPage;

public class TestSearchWebPage {
	public static void main(String[] args) {
		SearchWebPage searchWebPage = new SearchWebPage();
		String url = "";

		String result = null;
		try {
			result = searchWebPage.search(url);
		} catch (MalformedURLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		System.out.println(result);
	}
}
