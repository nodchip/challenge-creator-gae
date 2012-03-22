package tv.dyndns.kishibe.topcoder.client;

import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.ui.TextBox;

public class FlipTextBox extends TextBox implements FocusHandler {
	public FlipTextBox() {
		addFocusHandler(this);
	}

	@Override
	public void onFocus(FocusEvent event) {
		selectAll();
	}
}
