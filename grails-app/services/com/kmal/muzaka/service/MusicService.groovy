package com.kmal.muzaka.service

import java.util.ArrayList;
import java.util.HashMap;

import com.kmal.muzaka.dto.SongResultDTO;
import com.kmal.muzaka.engine.SearchEngine;

import grails.transaction.Transactional

@Transactional
class MusicService {
	
	SearchEngine searchEngine
  	
	def performSearch(String searchString){
		SearchEngine se = new SearchEngine();
		ArrayList<HashMap<String, String>> results = se.iterateThroughPage(searchString)
		ArrayList<SongResultDTO> songList = this.makeSongList(results)
		return songList
	}
	
	def makeSongList(ArrayList<HashMap<String, String>> mlist){
		SearchEngine se = new SearchEngine();
		
		ArrayList<SongResultDTO> songList = new ArrayList<SongResultDTO>();
	
		
		for (int i = 0; i<mlist.size();i++ ) {
			
			HashMap<String, String> tmpData = (HashMap<String, String>) mlist.get(i);
			Set<String> key = tmpData.keySet();
			Iterator<String> it = key.iterator();
			while (it.hasNext()) {
				String songName = (String)it.next();
				String songUrl = (String) tmpData.get(songName);
				
				//System.out.println("Key: "+songName +" & Data: "+songUrl);
				if(!songUrl.equalsIgnoreCase("#")){
					//saveMp3(songName, songUrl);
					SongResultDTO songDto  = new SongResultDTO(songName: songName,url:songUrl)						
					songList.add(songDto);
				}
				it.remove(); // avoids a ConcurrentModificationException
			}
			
		}
	

		return songList
	}
}
