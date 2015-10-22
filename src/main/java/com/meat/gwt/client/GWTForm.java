package com.meat.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class GWTForm implements EntryPoint {

	@Override
	public void onModuleLoad() {
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogPanel");
	    dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
	    dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
	    RootPanel.get("formContainer").add(dialogVPanel);
	}

}
