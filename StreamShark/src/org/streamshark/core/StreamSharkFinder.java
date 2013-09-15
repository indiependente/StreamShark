package org.streamshark.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.threadox.tinysong.api.SearchBot;
import com.threadox.tinysong.api.Song;



public class StreamSharkFinder {
	private static final String tinykey = "9b184eb52faed2726aa190207b6904b5";
	private SearchBot bot = null;
	private int defaultLimit = 5;
	private int currentLimit;
	
	public StreamSharkFinder(){
		bot = new SearchBot(tinykey, defaultLimit);
		currentLimit = defaultLimit;
	}
	
	public StreamSharkFinder(int limit){
		bot = new SearchBot(tinykey, limit);
		currentLimit = limit;
	}
	
	public Map<String,String> imFeelingLucky(String toSearch){
			return (mapper(bot.search(toSearch),currentLimit)).next();
	}
	
	public Iterator<Map<String,String>> getResults(String toSearch){
		return mapper(bot.search(toSearch), currentLimit);
	}
	
	private Iterator<Map<String, String>> mapper(Song[] songs, int limit){
		ArrayList<Map<String, String>> maps = new ArrayList();
		int i = 0;
		for(Song s : songs){
			maps.add(new HashMap<String, String>());
			maps.get(i).put("albumID", s.albumID);
			maps.get(i).put("albumName", s.albumName);
			maps.get(i).put("artistID", s.artistID);
			maps.get(i).put("artistName", s.artistName);
			maps.get(i).put("songID", s.songID);
			maps.get(i).put("songName", s.songName);
			maps.get(i).put("url", s.url);
			i++;
		}
		
		return maps.iterator();
	}
}
