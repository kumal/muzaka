package muzaka

import com.kmal.muzaka.service.MusicService;

class IndexController {
	
	MusicService musicService

    def index(Integer max) { 
		
		params.max = Math.min(max ?: 10, 100)
		
		def searchString = """&dir=%20%20%20%20%20%20%20%20%20%20%20%20%20%20HITET%20DHE%20ALBUMET%20E%20FUNDIT%20[%20NE%20Zbavitu.Net%202015%20]"""
						
		def songList = musicService.performTopTitles(searchString)
		def songList2;
		
		songList.each {
			
		//	println "URL IST:" + songList.url;
			
			
			
		}
		
	
		println "Found entries: ${songList.size} ${songList}"
		//User.list(params)
		
	//	songList(params)
		//songList(params)
		// Model available to the view
		[songList: songList.drop(params.int('offset')?:0).take(params.int('max')?:10),songNameCount: songList.size]
		
		}
}
