package org.apache.wicket.CarmenSanDiegoWicket;

import Juego.Juego;
import Juego.JuegoAppModel;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.model.CompoundPropertyModel;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;
import org.uqbar.wicket.xtend.XButton;
import org.uqbar.wicket.xtend.XListView;
import pais.Pais;
import pais.PaisApplicationModel;
import persona.Villano;

@SuppressWarnings("all")
public class MapamundiView extends WebPage {
  @Extension
  private WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new WicketExtensionFactoryMethods();
  
  private JuegoAppModel juegoAppModel;
  
  private PaisApplicationModel paisAppModel;
  
  public MapamundiView() {
    JuegoAppModel _juegoAppModel = new JuegoAppModel();
    this.juegoAppModel = _juegoAppModel;
    Juego _juego = this.juegoAppModel.getJuego();
    CompoundPropertyModel<Juego> _compoundPropertyModel = new CompoundPropertyModel<Juego>(_juego);
    final Form<Juego> paisesForm = new Form<Juego>("paisesJuegoForm", _compoundPropertyModel);
    this.mostrarListaPaises(paisesForm);
    this.nuevoPaisForm(paisesForm);
    this._wicketExtensionFactoryMethods.addChild(this, paisesForm);
    Juego _juego_1 = this.juegoAppModel.getJuego();
    CompoundPropertyModel<Juego> _compoundPropertyModel_1 = new CompoundPropertyModel<Juego>(_juego_1);
    final Form<Juego> villanosForm = new Form<Juego>("villanosJuegoForm", _compoundPropertyModel_1);
    this.mostrarListaVillanos(villanosForm);
    this.nuevoVillanoForm(villanosForm);
    this._wicketExtensionFactoryMethods.addChild(this, villanosForm);
  }
  
  public MarkupContainer mostrarListaPaises(final Form<Juego> form) {
    MarkupContainer _xblockexpression = null;
    {
      final XListView<Pais> listView = new XListView<Pais>("conexiones");
      final Procedure1<ListItem<Pais>> _function = new Procedure1<ListItem<Pais>>() {
        public void apply(final ListItem<Pais> item) {
          Pais _modelObject = item.getModelObject();
          CompoundPropertyModel<Pais> _asCompoundModel = MapamundiView.this._wicketExtensionFactoryMethods.<Pais>asCompoundModel(_modelObject);
          item.setModel(_asCompoundModel);
          Label _label = new Label("nombre");
          MapamundiView.this._wicketExtensionFactoryMethods.addChild(item, _label);
          XButton _xButton = new XButton("eliminar");
          final Procedure0 _function = new Procedure0() {
            public void apply() {
              Pais _modelObject = item.getModelObject();
              MapamundiView.this.juegoAppModel.setPaisSeleccionado(_modelObject);
              MapamundiView.this.juegoAppModel.eliminarPais();
            }
          };
          XButton _setOnClick = _xButton.setOnClick(_function);
          MapamundiView.this._wicketExtensionFactoryMethods.addChild(item, _setOnClick);
          XButton _xButton_1 = new XButton("editar");
          final Procedure0 _function_1 = new Procedure0() {
            public void apply() {
              Pais _modelObject = item.getModelObject();
              MapamundiView.this.paisAppModel.setPaisModel(_modelObject);
            }
          };
          XButton _setOnClick_1 = _xButton_1.setOnClick(_function_1);
          MapamundiView.this._wicketExtensionFactoryMethods.addChild(item, _setOnClick_1);
        }
      };
      listView.setPopulateItem(_function);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(form, listView);
    }
    return _xblockexpression;
  }
  
  public MarkupContainer nuevoPaisForm(final Form<Juego> form) {
    XButton _xButton = new XButton("nuevo");
    final Procedure0 _function = new Procedure0() {
      public void apply() {
        Juego _modelObject = form.getModelObject();
        Pais _pais = new Pais("*Definir nombre*");
        _modelObject.agregarPais(_pais);
      }
    };
    XButton _setOnClick = _xButton.setOnClick(_function);
    return this._wicketExtensionFactoryMethods.addChild(form, _setOnClick);
  }
  
  public MarkupContainer mostrarListaVillanos(final Form<Juego> form) {
    MarkupContainer _xblockexpression = null;
    {
      final XListView<Villano> listView = new XListView<Villano>("villanos");
      final Procedure1<ListItem<Villano>> _function = new Procedure1<ListItem<Villano>>() {
        public void apply(final ListItem<Villano> item) {
          Villano _modelObject = item.getModelObject();
          CompoundPropertyModel<Villano> _asCompoundModel = MapamundiView.this._wicketExtensionFactoryMethods.<Villano>asCompoundModel(_modelObject);
          item.setModel(_asCompoundModel);
          Label _label = new Label("nombre");
          MapamundiView.this._wicketExtensionFactoryMethods.addChild(item, _label);
          XButton _xButton = new XButton("eliminar");
          final Procedure0 _function = new Procedure0() {
            public void apply() {
              Villano _modelObject = item.getModelObject();
              MapamundiView.this.juegoAppModel.setVillanoSeleccionado(_modelObject);
              MapamundiView.this.juegoAppModel.eliminarVillano();
            }
          };
          XButton _setOnClick = _xButton.setOnClick(_function);
          MapamundiView.this._wicketExtensionFactoryMethods.addChild(item, _setOnClick);
          XButton _xButton_1 = new XButton("editar");
          final Procedure0 _function_1 = new Procedure0() {
            public void apply() {
            }
          };
          XButton _setOnClick_1 = _xButton_1.setOnClick(_function_1);
          MapamundiView.this._wicketExtensionFactoryMethods.addChild(item, _setOnClick_1);
        }
      };
      listView.setPopulateItem(_function);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(form, listView);
    }
    return _xblockexpression;
  }
  
  public MarkupContainer nuevoVillanoForm(final Form<Juego> form) {
    XButton _xButton = new XButton("nuevo");
    final Procedure0 _function = new Procedure0() {
      public void apply() {
        Juego _modelObject = form.getModelObject();
        Villano _villano = new Villano("*Definir nombre*");
        _modelObject.agregarVillano(_villano);
      }
    };
    XButton _setOnClick = _xButton.setOnClick(_function);
    return this._wicketExtensionFactoryMethods.addChild(form, _setOnClick);
  }
}
