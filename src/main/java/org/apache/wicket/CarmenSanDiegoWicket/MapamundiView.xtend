package org.apache.wicket.CarmenSanDiegoWicket

import org.apache.wicket.markup.html.WebPage
import Juego.Juego
import pais.PaisApplicationModel
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.apache.wicket.model.CompoundPropertyModel
import org.apache.wicket.markup.html.form.Form
import org.uqbar.wicket.xtend.XListView
import Juego.JuegoAppModel
import org.apache.wicket.markup.html.basic.Label
import org.uqbar.wicket.xtend.XButton
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.markup.html.form.DropDownChoice

class MapamundiView extends WebPage{
		extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
		var Juego juego;
		var JuegoAppModel juegoAppModel;
		var PaisApplicationModel paisAppModel;
		
		new() {
		this.juego = new Juego
		this.paisAppModel = new PaisApplicationModel(juego.conexiones.get(0))
		val Form<Juego> paisesForm = new Form<Juego>("paisesJuegoForm", new CompoundPropertyModel<Juego>(this.juego))
		this.mostrarListaPaises(paisesForm)
		this.nuevoPaisForm(paisesForm)		
		this.addChild(paisesForm)
//-----------------------------------------------------------------------------//
		val Form<PaisApplicationModel> paisForm = new Form<PaisApplicationModel>("paisSeleccionadoForm", new CompoundPropertyModel<PaisApplicationModel>(this.paisAppModel))
		this.mostrarNombrePais(paisForm)
		this.mostrarCarateristicasPaisForm(paisForm)
		this.verConexionesPais(paisForm)
		this.verLugaresPais(paisForm)		
		this.addChild(paisForm)
		
		}
	
	
	def mostrarListaPaises(Form<Juego> form) {
		val listView = new XListView("conexiones")
		listView.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new Label("nombre"))
			
			item.addChild(new XButton("eliminar")
				.onClick = [| 
					
					juegoAppModel.paisSeleccionado = item.modelObject
					juegoAppModel.eliminarPais()
				]
			)
		]
		parent.addChild(listView)
	}
	
	def nuevo(){
		responsePage = new NuevoPaisView(this) 
		
	}
	def nuevoPaisForm(Form<Juego> form) {
		form.addChild(new XButton("nuevo").onClick = [| nuevo() ]	)
	}
	
	def mostrarNombrePais(Form<PaisApplicationModel> form) {
		form.addChild(new Label("paisElegido.nombre"))
	}
	
	def mostrarCarateristicasPaisForm(Form<PaisApplicationModel> form) {
		val listView = new XListView("paisElegido.caracteristicas")
		form.addChild(listView)
		
		form.addChild(new TextField<String>("caracteristicaAAgregar"))
		//falta boton agregar, que agregue lo que se ponga en el textfield.	
	}
	
	def verConexionesPais(Form<PaisApplicationModel> form) {
		val listView = new XListView("pais.conexiones")
		listView.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new Label("nombre"))
			item.addChild(new XButton("eliminar")
				.onClick = [| 
					paisAppModel.paisElegido = item.modelObject
					paisAppModel.eliminarConexion
				]
			)
		]
		parent.addChild(listView)
		
		parent.addChild(new DropDownChoice<Juego>("conexiones") => [
			choices = loadableModel([| Juego.home.allInstances ])
			choiceRenderer = choiceRenderer([Juego j| j.conexiones ])
		])
		
		//falta boton agregar al selector
	}
	def verLugaresPais(Form<PaisApplicationModel> form) {
			val listView = new XListView("pais.lugares")
		listView.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new XButton("eliminar")
				.onClick = [| 
					paisAppModel.paisElegido = item.modelObject
					paisAppModel.eliminarLugar
				]
			)
		]
		parent.addChild(listView)
		
		parent.addChild(new DropDownChoice<Juego>("lugares") => [
			choices = loadableModel([| Juego.home.allInstances ])
			choiceRenderer = choiceRenderer([Juego j| j.lugares ])
		])
	}
	
}

	
