package org.apache.wicket.CarmenSanDiegoWicket;

import org.apache.wicket.CarmenSanDiegoWicket.MapamundiView;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.TextField;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;
import org.uqbar.wicket.xtend.XButton;

@SuppressWarnings("all")
public class NuevoPaisView extends WebPage {
  @Extension
  private WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new WicketExtensionFactoryMethods();
  
  private final MapamundiView mainPage;
  
  public NuevoPaisView(final MapamundiView mainPage) {
    this.mainPage = mainPage;
    TextField<Object> _textField = new TextField<Object>("nombreNuevo");
    this._wicketExtensionFactoryMethods.addChild(this, _textField);
    XButton _xButton = new XButton("cancelar");
    final Procedure1<XButton> _function = new Procedure1<XButton>() {
      public void apply(final XButton it) {
        final Procedure0 _function = new Procedure0() {
          public void apply() {
            NuevoPaisView.this.volver();
          }
        };
        it.setOnClick(_function);
      }
    };
    XButton _doubleArrow = ObjectExtensions.<XButton>operator_doubleArrow(_xButton, _function);
    this._wicketExtensionFactoryMethods.addChild(this, _doubleArrow);
  }
  
  public void volver() {
    this.setResponsePage(this.mainPage);
  }
}
