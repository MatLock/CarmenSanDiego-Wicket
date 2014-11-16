package org.apache.wicket.CarmenSanDiegoWicket;

import Juego.Juego;
import Juego.JuegoAppModel;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
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
              Pais _paisModel = MapamundiView.this.paisAppModel.getPaisModel();
              MapamundiView.this.editarPais(_paisModel);
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
        Pais _pais = new Pais("Definir nombre");
        _modelObject.agregarPais(_pais);
      }
    };
    XButton _setOnClick = _xButton.setOnClick(_function);
    return this._wicketExtensionFactoryMethods.addChild(form, _setOnClick);
  }
  
  public MarkupContainer editarPais(final Pais pais) {
    MarkupContainer _xblockexpression = null;
    {
      PaisApplicationModel _paisApplicationModel = new PaisApplicationModel(pais);
      CompoundPropertyModel<PaisApplicationModel> _compoundPropertyModel = new CompoundPropertyModel<PaisApplicationModel>(_paisApplicationModel);
      Form<PaisApplicationModel> paisSeleccionadoForm = new Form<PaisApplicationModel>(
        "paisSeleccionadoForm", _compoundPropertyModel);
      this.editarNombre(paisSeleccionadoForm);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(this, paisSeleccionadoForm);
    }
    return _xblockexpression;
  }
  
  public MarkupContainer editarNombre(final Form<PaisApplicationModel> form) {
    TextField<Object> _textField = new TextField<Object>("paisModel.nombre");
    return this._wicketExtensionFactoryMethods.addChild(form, _textField);
  }
}
