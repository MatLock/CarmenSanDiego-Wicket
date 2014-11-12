package org.apache.wicket.CarmenSanDiegoWicket;

import org.apache.wicket.CarmenSanDiegoWicket.MapamundiView;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

@SuppressWarnings("all")
public class MapamundiApplication extends WebApplication {
  public Class<? extends Page> getHomePage() {
    return MapamundiView.class;
  }
}
