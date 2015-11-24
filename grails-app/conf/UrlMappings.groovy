class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

		"/"(controller:"index") // instead of linking the root to (view:"/index")
        "500"(view:'/error')
	}
}
