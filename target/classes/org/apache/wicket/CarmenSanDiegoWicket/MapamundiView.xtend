package org.apache.wicket.CarmenSanDiegoWicket

import Juego.Juego
import Juego.JuegoAppModel
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.uqbar.wicket.xtend.XButton
import org.uqbar.wicket.xtend.XListView
import pais.Pais
import pais.PaisApplicationModel
import org.apache.wicket.markup.html.form.TextField

class MapamundiView extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	var JuegoAppModel juegoAppModel;
	var PaisApplicationModel paisAppModel;

	new() {
		this.juegoAppModel = new JuegoAppModel
		val Form<Juego> paisesForm = new Form<Juego>("paisesJuegoForm",
			new CompoundPropertyModel<Juego>(this.juegoAppModel.juego))
		this.mostrarListaPaises(paisesForm)
		this.nuevoPaisForm(paisesForm)
		this.addChild(paisesForm)

	//<--------------------------------------------------------------------------------------------->
	//		val Form<PaisApplicationModel> paisSeleccionadoForm = new Form<PaisApplicationModel>("paisSeleccionadoForm",
	//		this.paisAppModel.asCompoundModel)
	//		this.editarNombre(paisSeleccionadoForm)
	//		this.editarCaracteristicas(paisSeleccionadoForm)
	//		this.editarConexiones(paisSeleccionadoForm)
	//		this.editarLugares(paisSeleccionadoForm)
	//		this.aceptar()
	}

	def mostrarListaPaises(Form<Juego> form) {
		val listView = new XListView("conexiones")
		listView.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new Label("nombre"))
			item.addChild(
				new XButton("eliminar").onClick = [ |
					juegoAppModel.paisSeleccionado = item.modelObject
					juegoAppModel.eliminarPais()
				]
			)
			item.addChild(
				new XButton("editar").onClick = [ |
					paisAppModel.paisModel = item.modelObject
					this.editarPais(paisAppModel.paisModel)
				])
		]
		form.addChild(listView)
	}

	def nuevoPaisForm(Form<Juego> form) {
		form.addChild(new XButton("nuevo").onClick = [|form.modelObject.agregarPais(new Pais("Definir nombre"))])
	}
	
	def editarPais(Pais pais) {
		var Form<PaisApplicationModel> paisSeleccionadoForm = new Form<PaisApplicationModel>(
			"paisSeleccionadoForm",	new CompoundPropertyModel<PaisApplicationModel>(new PaisApplicationModel(pais)))
		this.editarNombre(paisSeleccionadoForm)
		this.addChild(paisSeleccionadoForm)
	}
	
	def editarNombre(Form<PaisApplicationModel> form) {
		form.addChild(new TextField("paisModel.nombre"))
	}



//	def mostrarCarateristicasPaisForm(Form<PaisApplicationModel> form) {
//		val listView = new XListView("paisElegido.caracteristicas")
//		form.addChild(listView)
//		
//		form.addChild(new TextField<String>("caracteristicaAAgregar"))
//falta boton agregar, que agregue lo que se ponga en el textfield.	
//	}
//	def verConexionesPais(Form<PaisApplicationModel> form) {
//		val listView = new XListView("paisModel.conexiones")
//		listView.populateItem = [ item |
//			item.model = item.modelObject.asCompoundModel
//			item.addChild(new Label("nombre"))
//			item.addChild(new XButton("eliminar")
//				.onClick = [| 
//					paisAppModel.paisElegido = item.modelObject
//					paisAppModel.eliminarConexion
//				]
//			)
//		]
//		form.addChild(listView)
//		
//		form.addChild(new DropDownChoice<Juego>("conexiones") => [
//			choices = loadableModel([| Juego.home.allInstances ])
//			choiceRenderer = choiceRenderer([Juego j| j.conexiones ])
//		])
//falta boton agregar al selector
//	}
//	def verLugaresPais(Form<PaisApplicationModel> form) {
//			val listView = new XListView("pais.lugares")
//		listView.populateItem = [ item |
//			item.model = item.modelObject.asCompoundModel
//			item.addChild(new XButton("eliminar")
//				.onClick = [| 
//					paisAppModel.paisElegido = item.modelObject
//					paisAppModel.eliminarLugar
//				]
//			)
//		]
//		form.addChild(listView)
//		
//		form.addChild(new DropDownChoice<Juego>("lugares") => [
//			choices = loadableModel([| Juego.home.allInstances ])
//			choiceRenderer = choiceRenderer([Juego j| j.lugares ])
//		])
//	}
}
