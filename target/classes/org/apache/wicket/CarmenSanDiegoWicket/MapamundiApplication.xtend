package org.apache.wicket.CarmenSanDiegoWicket

import org.apache.wicket.protocol.http.WebApplication
import org.uqbar.commons.utils.ApplicationContext
import Juego.Juego

class MapamundiApplication extends WebApplication {
	
//	override protected init() {
//		super.init()
//		ApplicationContext.instance.configureSingleton(Juego, new Juego)
//	
//		} 
	
	override getHomePage() {
		MapamundiView
	}
	
}