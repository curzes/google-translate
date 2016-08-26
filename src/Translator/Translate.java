package Translator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;


public class Translate extends HTMLDecoder {
	
	private static String phrase;
	private static String to;
	private static String from = "auto"; //sv
	private static String[] result = new String[4];
	
	public static String[] translate(String phrase, String to, String from){
		Translate.phrase = phrase;
		Translate.to = to;
		Translate.from = from;
		getTranslation();
		return result;
	}
	
	public static String[] translate(String phrase, String to){
		Translate.phrase = phrase;
		Translate.to = to;
		getTranslation();
		return result;
	}
	
	private static void getTranslation(){
		
		result[0] = from;
		result[1] = to;
		result[2] = phrase;
		
		try {
			phrase = URLEncoder.encode(phrase, "UTF-8");
			to = URLEncoder.encode(to, "UTF-8");
			from = URLEncoder.encode(from, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		try {
			String url = "https://translate.google.com/m?hl=" + to + "&sl=" + from + "&q=" + phrase;
			URLConnection connection = new URL(url).openConnection();
			connection.setRequestProperty("Accept-Charset", "UTF-8");
	        connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:40.0) Gecko/20100101 Firefox/40.1");

	        BufferedReader in = new BufferedReader( new InputStreamReader(connection.getInputStream(), "UTF-8") );
	        String page = decode(in.readLine());
	        result[3] = page.substring(page.indexOf("class=\"t0\"") + ("class=\"t0\">").length()).split("</div>")[0];
	        in.close();
	        
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}