package org.apache.wicket.CarmenSanDiegoWicket

import org.apache.wicket.protocol.http.WebApplication
import org.uqbar.commons.utils.ApplicationContext
import Juego.Juego

class MapamundiApplication extends WebApplication {
	
	override getHomePage() {
		MapamundiView
	}
	
}