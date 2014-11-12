package org.apache.wicket.CarmenSanDiegoWicket;

import Juego.Juego;
import Juego.JuegoAppModel;
import java.util.List;
import org.apache.wicket.CarmenSanDiegoWicket.NuevoPaisView;
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
  
  private Juego juego;
  
  private JuegoAppModel juegoAppModel;
  
  private PaisApplicationModel paisAppModel;
  
  public MapamundiView() {
    Juego _juego = new Juego();
    this.juego = _juego;
    List<Pais> _conexiones = this.juego.getConexiones();
    Pais _get = _conexiones.get(0);
    PaisApplicationModel _paisApplicationModel = new PaisApplicationModel(_get);
    this.paisAppModel = _paisApplicationModel;
    CompoundPropertyModel<Juego> _compoundPropertyModel = new CompoundPropertyModel<Juego>(this.juego);
    final Form<Juego> paisesForm = new Form<Juego>("paisesJuegoForm", _compoundPropertyModel);
    this.mostrarListaPaises(paisesForm);
    this.nuevoPaisForm(paisesForm);
    this._wicketExtensionFactoryMethods.addChild(this, paisesForm);
    CompoundPropertyModel<PaisApplicationModel> _compoundPropertyModel_1 = new CompoundPropertyModel<PaisApplicationModel>(this.paisAppModel);
    final Form<PaisApplicationModel> paisForm = new Form<PaisApplicationModel>("paisSeleccionadoForm", _compoundPropertyModel_1);
    this.mostrarNombrePais(paisForm);
    this.mostrarCarateristicasPaisForm(paisForm);
    this.verConexionesPais(paisForm);
    this.verLugaresPais(paisForm);
    this._wicketExtensionFactoryMethods.addChild(this, paisForm);
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
        }
      };
      listView.setPopulateItem(_function);
      MarkupContainer _parent = this.getParent();
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(_parent, listView);
    }
    return _xblockexpression;
  }
  
  public void nuevo() {
    NuevoPaisView _nuevoPaisView = new NuevoPaisView(this);
    this.setResponsePage(_nuevoPaisView);
  }
  
  public MarkupContainer nuevoPaisForm(final Form<Juego> form) {
    XButton _xButton = new XButton("nuevo");
    final Procedure0 _function = new Procedure0() {
      public void apply() {
        MapamundiView.this.nuevo();
      }
    };
    XButton _setOnClick = _xButton.setOnClick(_function);
    return this._wicketExtensionFactoryMethods.addChild(form, _setOnClick);
  }
  
  public MarkupContainer mostrarNombrePais(final Form<PaisApplicationModel> form) {
    Label _label = new Label("paisElegido.nombre");
    return this._wicketExtensionFactoryMethods.addChild(form, _label);
  }
  
  public MarkupContainer mostrarCarateristicasPaisForm(final Form<PaisApplicationModel> form) {
    MarkupContainer _xblockexpression = null;
    {
      final XListView<Object> listView = new XListView<Object>("paisElegido.caracteristicas");
      this._wicketExtensionFactoryMethods.addChild(form, listView);
      TextField<String> _textField = new TextField<String>("caracteristicaAAgregar");
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(form, _textField);
    }
    return _xblockexpression;
  }
  
  public MarkupContainer verConexionesPais(final Form<PaisApplicationModel> form) {
    throw new Error("Unresolved compilation problems:"
      + "\nBounds mismatch: The type argument <Juego> is not a valid substitute for the bounded type parameter <T extends Entity> of the method home(Class<T>)");
  }
  
  public MarkupContainer verLugaresPais(final Form<PaisApplicationModel> form) {
    throw new Error("Unresolved compilation problems:"
      + "\nBounds mismatch: The type argument <Juego> is not a valid substitute for the bounded type parameter <T extends Entity> of the method home(Class<T>)");
  }
}
