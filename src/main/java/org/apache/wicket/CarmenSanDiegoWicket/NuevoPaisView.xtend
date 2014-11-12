package org.apache.wicket.CarmenSanDiegoWicket

import org.apache.wicket.markup.html.WebPage
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.apache.wicket.markup.html.form.TextField
import org.uqbar.wicket.xtend.XButton

class NuevoPaisView extends WebPage {
		extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
		private final MapamundiView mainPage
		
	new(MapamundiView mainPage){
		this.mainPage = mainPage		
		this.addChild(new TextField("nombreNuevo"))
		this.addChild(new XButton("cancelar")=> [
			onClick = [| volver ]
		])
		
	}
	
	
	def volver() {
		responsePage = mainPage
	}
}