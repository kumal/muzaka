package com.kmal.muzaka.engine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SearchEngine {

	public static void main(String[] args) throws IOException {

	
		
		
		String searchString = "Elinel";
		
		SearchEngine.iterateThroughPage(searchString);
		
	}
	
	public static HashMap<String, String> putResultsToHashMap(String songName, String songUrl){
		   
        HashMap<String, String> mMap = new HashMap<String, String>();      
        mMap.put(songName,songUrl);      
        
        return mMap;
    }

	
	public static ArrayList<HashMap<String, String>> iterateThroughPage(String searchString) throws IOException{
		String url = "";
		//System.setProperty("http.proxyHost", "proxy.muc");
	//	System.setProperty("http.proxyPort", "8080");
		if(searchString.startsWith("http://www.zbavitu.me")){
			url = searchString; 
		}else{
			url = "http://www.zbavitu.me/mp3/?search="+searchString;
		
		}
		//String url = "http://get-tune.net/?a=music&q="+searchString;
		String provider = "http://www.zbavitu.me/mp3/";
		//String provider = "";
        Document document;
        FileLoader fl = new FileLoader();
        
		document = Jsoup.connect(url).timeout(0).get();
		
		print("Fetching %s...", url);


		/***TODO: LOGIK erweitern evtl. in andere Methode packen und fuer Multiple-Host-Indexing vorbereiten
		 * 
		 * 
		 * 
		 */
		
		Elements songs = document.select("#frame .name a");
		//Elements songs = document.select(".track");
		
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();		
		
        for (Element song : songs) {
        	        	
        	//Elements songss = song.getElementsByClass("playlist-name");
        	
        	//String songUrl = provider+song.attr("data-mp3");
        	String songUrl = provider+song.attr("href");      	
        	
        	String songName = song.text().toString();
        	list.add(putResultsToHashMap(songName, songUrl)); 

        }
        
        
       return list;
        
		
	}
	
	private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }


}
