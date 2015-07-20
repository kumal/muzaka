package muzaka

import com.kmal.muzaka.service.MusicService;

class SearchController {

	
	MusicService musicService
	
    def index() { }
	
	def search(){
		
		println "Parameter: ${params}"
		def searchString = params.searchString
		
		def songList = musicService.performSearch(searchString)
	
	
		println "Found entries: ${songList.size} ${songList}" 
		
		render (view:'result', model: [songList: songList])
	}
	
	def oauth2callback(){
		
	}
}
