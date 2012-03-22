package tv.dyndns.kishibe.topcoder.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;

public class ChallengeCreatorGae implements EntryPoint {
	@Override
	public void onModuleLoad() {
		final TabPanel tabPanel = new TabPanel();
		tabPanel.add(new PanelSequence(), "数列");
		tabPanel.selectTab(0);
		RootPanel.get().add(tabPanel);
	}
}
