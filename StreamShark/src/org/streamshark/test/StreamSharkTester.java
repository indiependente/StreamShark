package org.streamshark.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;


import org.streamshark.core.StreamSharkFinder;

public class StreamSharkTester {

	public static void main(String[] args) throws IOException {
		System.out.println("StreamShark Console Tester\nType !q to quit");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String toSearch = "";
		StreamSharkFinder ss = new StreamSharkFinder(3);
		
		while(!(toSearch=cmd(br,"Song, album or artist to search: ")).equalsIgnoreCase("!q")){
			if(!(toSearch.equals(""))){
				Iterator<Map<String, String>> it = ss.getResults(toSearch);
				if(!it.hasNext())
					System.out.println("Sorry.No results found.");
				while(it.hasNext()){
					Map<String,String> map = it.next();
					System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
					for(String k : map.keySet()){
						System.out.println(k+"\t\t"+map.get(k));
					}
					System.out.println("//////////////////////////");
				}
			}
			System.out.println("\nStreamShark Console Tester\nType !q to quit");
		}
		
	}

	private static String cmd(BufferedReader br, String s) throws IOException{
		System.out.println(s);
		return br.readLine();
	}
	
}
