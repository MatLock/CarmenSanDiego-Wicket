package org.apache.wicket.CarmenSanDiegoWicket

import Juego.Juego
import Juego.JuegoAppModel
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.model.CompoundPropertyModel
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.uqbar.wicket.xtend.XButton
import org.uqbar.wicket.xtend.XForm
import org.uqbar.wicket.xtend.XListView
import pais.Pais
import persona.Villano

class MapamundiView extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	var JuegoAppModel juegoAppModel;
	var Form<JuegoAppModel> paisSeleccionadoForm 
	var Form<JuegoAppModel> villanoSeleccionadoForm 
	

	new() {
		
		this.juegoAppModel = new JuegoAppModel
		//LISTADO DE PAISES
		val paisesForm = new XForm<Juego>("paisesJuegoForm", new CompoundPropertyModel<Juego>(this.juegoAppModel.juego))
		this.mostrarListaPaises(paisesForm)
		this.nuevoPaisForm(paisesForm)
		this.addChild(paisesForm)
		
        paisSeleccionadoForm = new Form<JuegoAppModel>("paisSeleccionadoForm", new CompoundPropertyModel<JuegoAppModel>(this.juegoAppModel))
	
		// PESTAÑA DE MAPAMUNDI
		this.editarNombrePais(this.paisSeleccionadoForm)
		this.editarCaracteristicaPais(this.paisSeleccionadoForm)
		this.editarConexionesPais(this.paisSeleccionadoForm)
		this.editarLugaresPais(this.paisSeleccionadoForm)
		this.addChild(paisSeleccionadoForm)
		
		//LISTADO DE VILLANOS
		val Form<Juego> villanosForm = new Form<Juego>("villanosJuegoForm", new CompoundPropertyModel<Juego>(this.juegoAppModel.juego))
		this.mostrarListaVillanos(villanosForm)
		this.nuevoVillanoForm(villanosForm)
		this.addChild(villanosForm)

        villanoSeleccionadoForm = new Form<JuegoAppModel>("villanoSeleccionadoForm", new CompoundPropertyModel<JuegoAppModel>(this.juegoAppModel))
		
		// PESTAÑA DE EXPEDIENTE
		this.mostrarNombreVillano(this.villanoSeleccionadoForm)
		this.editarSeña(this.villanoSeleccionadoForm)
		this.editarHobbie(this.villanoSeleccionadoForm)
		this.addChild(villanoSeleccionadoForm)
	}
	
	def mostrarListaPaises(XForm<Juego> form) {
		val listView = new XListView("conexiones")
		listView.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new Label("nombre"))
			item.addChild(new XButton("eliminar").onClick = [ |
				juegoAppModel.paisSeleccionado = item.modelObject
				juegoAppModel.eliminarPais()
			]		)
			item.addChild(new XButton("editar").onClick = [ |
				juegoAppModel.paisSeleccionado = item.modelObject
			])

		]
		form.addChild(listView)
	}
	
	def editarNombrePais(Form<JuegoAppModel> form) {
		form.addChild(new TextField<String>("paisSeleccionado.nombre"))
		}

	def editarCaracteristicaPais(Form<JuegoAppModel> form){
		val listView = new XListView("paisSeleccionado.caract")
		listView.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new Label("descripcion"))			
		]
		form.addChild(listView)
		
		//Casillero y boton para agregar caracteristicas.
//		
//
//		val TextField<String> texto = new TextField<String>("valorAAgregar")
//		val Caracteristica valor = new Caracteristica(texto.toString)
//		form.addChild(new XButton("agregarCaract").onClick = [ |
//				juegoAppModel.caracteristicaAAgregar = valor
//				juegoAppModel.agregarCaract
//			]	)
//		form.addChild(texto)
		
	}
	
	def editarConexionesPais(Form<JuegoAppModel> form) {
		val listView = new XListView("paisSeleccionado.conexiones")
		listView.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new Label("nombre"))
			item.addChild(new XButton("eliminarConexion").onClick = [ |
				juegoAppModel.paisElegido = item.modelObject
				juegoAppModel.eliminarConexion
			]		)			
		]
		form.addChild(listView)			
	}
	
//	def selectorConexion(Form<JuegoAppModel> form){
//		form.addChild(new DropDownChoice<Juego>("conexionesJuego") => [
//			choices = loadableModel([| Juego.home.allInstances ])
//			choiceRenderer = choiceRenderer([Juego j| j.conexiones ])
//		])
//	}
	
	def editarLugaresPais(Form<JuegoAppModel> form) {
		val listView = new XListView("paisSeleccionado.lugares")
		listView.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new Label("nombre"))
			item.addChild(new XButton("eliminarLugar").onClick = [ |
				juegoAppModel.lugarElegido = item.modelObject
				juegoAppModel.paisSeleccionado = this.juegoAppModel.paisSeleccionado
				juegoAppModel.eliminarLugar
			]		)			
		]
		form.addChild(listView)			
	}
	
	def nuevoPaisForm(XForm<Juego> form) {
		form.addChild(new XButton("nuevo").onClick = [|this.juegoAppModel.juego.agregarPais(new Pais("*Definir nombre*"))])
	}
	
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	def mostrarListaVillanos(Form<Juego> form) {
		val listView = new XListView("villanos")
		listView.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new Label("nombre"))
			item.addChild(
				new XButton("eliminar").onClick = [ |
					juegoAppModel.villanoSeleccionado = item.modelObject
					juegoAppModel.eliminarVillano()
				]
			)
			item.addChild(
				new XButton("editar").onClick = [ |
					
					juegoAppModel.villanoSeleccionado = item.modelObject
				])
		]
		form.addChild(listView)
	}
	
	def nuevoVillanoForm(Form<Juego> form) {
			form.addChild(new XButton("nuevo").onClick = [|form.modelObject.agregarVillano(new Villano("*Definir nombre*"))])
	}
	

	def mostrarNombreVillano(Form<JuegoAppModel> form) {
		form.addChild(new TextField<String>("villanoSeleccionado.nombre"))
		
	}
	
	def editarSeña(Form<JuegoAppModel> form) {
		val listView = new XListView("villanoSeleccionado.senias")
			listView.populateItem = [ item |
				item.model = item.modelObject.asCompoundModel
				item.addChild(new Label("descripcion"))
				item.addChild(new XButton("eliminarSenia").onClick = [ |
					juegoAppModel.señaSeleccionada = item.modelObject
					juegoAppModel.eliminarSeña()
			]		)			
		]
			form.addChild(listView)		
	}
	
	def editarHobbie(Form<JuegoAppModel> form) {
		val listView = new XListView("villanoSeleccionado.hobbie")
			listView.populateItem = [ item |
				item.model = item.modelObject.asCompoundModel
				item.addChild(new Label("descripcion"))
				item.addChild(new XButton("eliminarHobbie").onClick = [ |
					juegoAppModel.hobbieSeleccionado = item.modelObject
					juegoAppModel.eliminarHobbie
			]		)			
		]
			form.addChild(listView)		
	}

}
