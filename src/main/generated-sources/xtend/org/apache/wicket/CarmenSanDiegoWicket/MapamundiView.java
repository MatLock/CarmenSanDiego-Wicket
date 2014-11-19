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
import org.uqbar.wicket.xtend.XForm;
import org.uqbar.wicket.xtend.XListView;
import pais.Caracteristica;
import pais.Lugar;
import pais.Pais;
import persona.Villano;

@SuppressWarnings("all")
public class MapamundiView extends WebPage {
  @Extension
  private WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new WicketExtensionFactoryMethods();
  
  private JuegoAppModel juegoAppModel;
  
  private Form<JuegoAppModel> paisSeleccionadoForm;
  
  private Form<JuegoAppModel> villanoSeleccionadoForm;
  
  public MapamundiView() {
    JuegoAppModel _juegoAppModel = new JuegoAppModel();
    this.juegoAppModel = _juegoAppModel;
    Juego _juego = this.juegoAppModel.getJuego();
    CompoundPropertyModel<Juego> _compoundPropertyModel = new CompoundPropertyModel<Juego>(_juego);
    final XForm<Juego> paisesForm = new XForm<Juego>("paisesJuegoForm", _compoundPropertyModel);
    this.mostrarListaPaises(paisesForm);
    this.nuevoPaisForm(paisesForm);
    this._wicketExtensionFactoryMethods.addChild(this, paisesForm);
    CompoundPropertyModel<JuegoAppModel> _compoundPropertyModel_1 = new CompoundPropertyModel<JuegoAppModel>(this.juegoAppModel);
    Form<JuegoAppModel> _form = new Form<JuegoAppModel>("paisSeleccionadoForm", _compoundPropertyModel_1);
    this.paisSeleccionadoForm = _form;
    this.editarNombrePais(this.paisSeleccionadoForm);
    this.editarCaracteristicaPais(this.paisSeleccionadoForm);
    this.editarConexionesPais(this.paisSeleccionadoForm);
    this.editarLugaresPais(this.paisSeleccionadoForm);
    this._wicketExtensionFactoryMethods.addChild(this, this.paisSeleccionadoForm);
    Juego _juego_1 = this.juegoAppModel.getJuego();
    CompoundPropertyModel<Juego> _compoundPropertyModel_2 = new CompoundPropertyModel<Juego>(_juego_1);
    final Form<Juego> villanosForm = new Form<Juego>("villanosJuegoForm", _compoundPropertyModel_2);
    this.mostrarListaVillanos(villanosForm);
    this.nuevoVillanoForm(villanosForm);
    this._wicketExtensionFactoryMethods.addChild(this, villanosForm);
    CompoundPropertyModel<JuegoAppModel> _compoundPropertyModel_3 = new CompoundPropertyModel<JuegoAppModel>(this.juegoAppModel);
    Form<JuegoAppModel> _form_1 = new Form<JuegoAppModel>("villanoSeleccionadoForm", _compoundPropertyModel_3);
    this.villanoSeleccionadoForm = _form_1;
    this.mostrarNombreVillano(this.villanoSeleccionadoForm);
    this.editarSeña(this.villanoSeleccionadoForm);
    this.editarHobbie(this.villanoSeleccionadoForm);
    this._wicketExtensionFactoryMethods.addChild(this, this.villanoSeleccionadoForm);
  }
  
  public MarkupContainer mostrarListaPaises(final XForm<Juego> form) {
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
              MapamundiView.this.juegoAppModel.setPaisSeleccionado(_modelObject);
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
  
  public MarkupContainer editarNombrePais(final Form<JuegoAppModel> form) {
    TextField<String> _textField = new TextField<String>("paisSeleccionado.nombre");
    return this._wicketExtensionFactoryMethods.addChild(form, _textField);
  }
  
  public MarkupContainer editarCaracteristicaPais(final Form<JuegoAppModel> form) {
    MarkupContainer _xblockexpression = null;
    {
      final XListView<Object> listView = new XListView<Object>("paisSeleccionado.caract");
      final Procedure1<ListItem<Object>> _function = new Procedure1<ListItem<Object>>() {
        public void apply(final ListItem<Object> item) {
          Object _modelObject = item.getModelObject();
          CompoundPropertyModel<Object> _asCompoundModel = MapamundiView.this._wicketExtensionFactoryMethods.<Object>asCompoundModel(_modelObject);
          item.setModel(_asCompoundModel);
          Label _label = new Label("descripcion");
          MapamundiView.this._wicketExtensionFactoryMethods.addChild(item, _label);
        }
      };
      listView.setPopulateItem(_function);
      this._wicketExtensionFactoryMethods.addChild(form, listView);
      final TextField<String> texto = new TextField<String>("valor");
      this._wicketExtensionFactoryMethods.addChild(form, texto);
      XButton _xButton = new XButton("agregarCaract");
      final Procedure0 _function_1 = new Procedure0() {
        public void apply() {
          MapamundiView.this.juegoAppModel.agregarCaract();
        }
      };
      XButton _setOnClick = _xButton.setOnClick(_function_1);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(form, _setOnClick);
    }
    return _xblockexpression;
  }
  
  public MarkupContainer editarConexionesPais(final Form<JuegoAppModel> form) {
    MarkupContainer _xblockexpression = null;
    {
      final XListView<Pais> listView = new XListView<Pais>("paisSeleccionado.conexiones");
      final Procedure1<ListItem<Pais>> _function = new Procedure1<ListItem<Pais>>() {
        public void apply(final ListItem<Pais> item) {
          Pais _modelObject = item.getModelObject();
          CompoundPropertyModel<Pais> _asCompoundModel = MapamundiView.this._wicketExtensionFactoryMethods.<Pais>asCompoundModel(_modelObject);
          item.setModel(_asCompoundModel);
          Label _label = new Label("nombre");
          MapamundiView.this._wicketExtensionFactoryMethods.addChild(item, _label);
          XButton _xButton = new XButton("eliminarConexion");
          final Procedure0 _function = new Procedure0() {
            public void apply() {
              Pais _modelObject = item.getModelObject();
              MapamundiView.this.juegoAppModel.setPaisElegido(_modelObject);
              MapamundiView.this.juegoAppModel.eliminarConexion();
            }
          };
          XButton _setOnClick = _xButton.setOnClick(_function);
          MapamundiView.this._wicketExtensionFactoryMethods.addChild(item, _setOnClick);
        }
      };
      listView.setPopulateItem(_function);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(form, listView);
    }
    return _xblockexpression;
  }
  
  public MarkupContainer editarLugaresPais(final Form<JuegoAppModel> form) {
    MarkupContainer _xblockexpression = null;
    {
      final XListView<Lugar> listView = new XListView<Lugar>("paisSeleccionado.lugares");
      final Procedure1<ListItem<Lugar>> _function = new Procedure1<ListItem<Lugar>>() {
        public void apply(final ListItem<Lugar> item) {
          Lugar _modelObject = item.getModelObject();
          CompoundPropertyModel<Lugar> _asCompoundModel = MapamundiView.this._wicketExtensionFactoryMethods.<Lugar>asCompoundModel(_modelObject);
          item.setModel(_asCompoundModel);
          Label _label = new Label("nombre");
          MapamundiView.this._wicketExtensionFactoryMethods.addChild(item, _label);
          XButton _xButton = new XButton("eliminarLugar");
          final Procedure0 _function = new Procedure0() {
            public void apply() {
              Lugar _modelObject = item.getModelObject();
              MapamundiView.this.juegoAppModel.setLugarElegido(_modelObject);
              Pais _paisSeleccionado = MapamundiView.this.juegoAppModel.getPaisSeleccionado();
              MapamundiView.this.juegoAppModel.setPaisSeleccionado(_paisSeleccionado);
              MapamundiView.this.juegoAppModel.eliminarLugar();
            }
          };
          XButton _setOnClick = _xButton.setOnClick(_function);
          MapamundiView.this._wicketExtensionFactoryMethods.addChild(item, _setOnClick);
        }
      };
      listView.setPopulateItem(_function);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(form, listView);
    }
    return _xblockexpression;
  }
  
  public MarkupContainer nuevoPaisForm(final XForm<Juego> form) {
    XButton _xButton = new XButton("nuevo");
    final Procedure0 _function = new Procedure0() {
      public void apply() {
        Juego _juego = MapamundiView.this.juegoAppModel.getJuego();
        Pais _pais = new Pais("*Definir nombre*");
        _juego.agregarPais(_pais);
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
              Villano _modelObject = item.getModelObject();
              MapamundiView.this.juegoAppModel.setVillanoSeleccionado(_modelObject);
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
  
  public MarkupContainer mostrarNombreVillano(final Form<JuegoAppModel> form) {
    TextField<String> _textField = new TextField<String>("villanoSeleccionado.nombre");
    return this._wicketExtensionFactoryMethods.addChild(form, _textField);
  }
  
  public MarkupContainer editarSeña(final Form<JuegoAppModel> form) {
    MarkupContainer _xblockexpression = null;
    {
      final XListView<Caracteristica> listView = new XListView<Caracteristica>("villanoSeleccionado.senias");
      final Procedure1<ListItem<Caracteristica>> _function = new Procedure1<ListItem<Caracteristica>>() {
        public void apply(final ListItem<Caracteristica> item) {
          Caracteristica _modelObject = item.getModelObject();
          CompoundPropertyModel<Caracteristica> _asCompoundModel = MapamundiView.this._wicketExtensionFactoryMethods.<Caracteristica>asCompoundModel(_modelObject);
          item.setModel(_asCompoundModel);
          Label _label = new Label("descripcion");
          MapamundiView.this._wicketExtensionFactoryMethods.addChild(item, _label);
          XButton _xButton = new XButton("eliminarSenia");
          final Procedure0 _function = new Procedure0() {
            public void apply() {
              Caracteristica _modelObject = item.getModelObject();
              MapamundiView.this.juegoAppModel.setSeñaSeleccionada(_modelObject);
              MapamundiView.this.juegoAppModel.eliminarSeña();
            }
          };
          XButton _setOnClick = _xButton.setOnClick(_function);
          MapamundiView.this._wicketExtensionFactoryMethods.addChild(item, _setOnClick);
        }
      };
      listView.setPopulateItem(_function);
      this._wicketExtensionFactoryMethods.addChild(form, listView);
      final TextField<String> texto = new TextField<String>("valor");
      this._wicketExtensionFactoryMethods.addChild(form, texto);
      XButton _xButton = new XButton("agregarSenia");
      final Procedure0 _function_1 = new Procedure0() {
        public void apply() {
          MapamundiView.this.juegoAppModel.agregarSenia();
        }
      };
      XButton _setOnClick = _xButton.setOnClick(_function_1);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(form, _setOnClick);
    }
    return _xblockexpression;
  }
  
  public MarkupContainer editarHobbie(final Form<JuegoAppModel> form) {
    MarkupContainer _xblockexpression = null;
    {
      final XListView<Caracteristica> listView = new XListView<Caracteristica>("villanoSeleccionado.hobbie");
      final Procedure1<ListItem<Caracteristica>> _function = new Procedure1<ListItem<Caracteristica>>() {
        public void apply(final ListItem<Caracteristica> item) {
          Caracteristica _modelObject = item.getModelObject();
          CompoundPropertyModel<Caracteristica> _asCompoundModel = MapamundiView.this._wicketExtensionFactoryMethods.<Caracteristica>asCompoundModel(_modelObject);
          item.setModel(_asCompoundModel);
          Label _label = new Label("descripcion");
          MapamundiView.this._wicketExtensionFactoryMethods.addChild(item, _label);
          XButton _xButton = new XButton("eliminarHobbie");
          final Procedure0 _function = new Procedure0() {
            public void apply() {
              Caracteristica _modelObject = item.getModelObject();
              MapamundiView.this.juegoAppModel.setHobbieSeleccionado(_modelObject);
              MapamundiView.this.juegoAppModel.eliminarHobbie();
            }
          };
          XButton _setOnClick = _xButton.setOnClick(_function);
          MapamundiView.this._wicketExtensionFactoryMethods.addChild(item, _setOnClick);
        }
      };
      listView.setPopulateItem(_function);
      this._wicketExtensionFactoryMethods.addChild(form, listView);
      final TextField<String> texto = new TextField<String>("valorA");
      this._wicketExtensionFactoryMethods.addChild(form, texto);
      XButton _xButton = new XButton("agregarHobbie");
      final Procedure0 _function_1 = new Procedure0() {
        public void apply() {
          MapamundiView.this.juegoAppModel.agregarHobbie();
        }
      };
      XButton _setOnClick = _xButton.setOnClick(_function_1);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(form, _setOnClick);
    }
    return _xblockexpression;
  }
}
