package tv.dyndns.kishibe.topcoder.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PanelSequence extends VerticalPanel implements ClickHandler {
	private final TextBox textBoxArithmeticFirstTerm = new FlipTextBox();
	private final TextBox textBoxArithmeticCommonDifference = new FlipTextBox();
	private final TextBox textBoxArithmeticElementCount = new FlipTextBox();
	private final Button buttonArithmetic = new Button("create", this);

	private final TextBox textBoxGeometricProgressionFirstTerm = new FlipTextBox();
	private final TextBox textBoxGeometricProgressionCommonRatio = new FlipTextBox();
	private final TextBox textBoxGeometricProgressionElementCount = new FlipTextBox();
	private final Button buttonGeometricProgression = new Button("create", this);

	private final TextBox textBoxArithmeticRandomFirstTerm = new FlipTextBox();
	private final TextBox textBoxArithmeticRandomCommonDifference = new FlipTextBox();
	private final TextBox textBoxArithmeticRandomElementCount = new FlipTextBox();
	private final Button buttonArithmeticRandom = new Button("create", this);

	private final TextBox textBoxPrimeProgressionMin = new FlipTextBox();
	private final TextBox textBoxPrimeProgressionMax = new FlipTextBox();
	private final TextBox textBoxPrimeProgressionElementCount = new FlipTextBox();
	private final Button buttonPrimeProgression = new Button("create", this);

	private final TextBox textBoxRandomMin = new FlipTextBox();
	private final TextBox textBoxRandomMax = new FlipTextBox();
	private final TextBox textBoxRandomElementCount = new FlipTextBox();
	private final Button buttonRandom = new Button("create", this);

	private final TextBox textBoxLetterTableLetters = new FlipTextBox();
	private final TextBox textBoxLetterTableWidth = new FlipTextBox();
	private final TextBox textBoxLetterTableHeight = new FlipTextBox();
	private final Button buttonLetterTable = new Button("create", this);

	private final TextBox textBoxCreatedText = new FlipTextBox();

	public PanelSequence() {
		add(new Label("等差数列"));
		{
			final HorizontalPanel panel = new HorizontalPanel();
			panel.add(new Label("初項"));
			panel.add(textBoxArithmeticFirstTerm);
			panel.add(new Label("公差"));
			panel.add(textBoxArithmeticCommonDifference);
			panel.add(new Label("要素数"));
			panel.add(textBoxArithmeticElementCount);
			panel.add(buttonArithmetic);
			add(panel);
		}

		add(new Label("等比数列"));
		{
			final HorizontalPanel panel = new HorizontalPanel();
			panel.add(new Label("初項"));
			panel.add(textBoxGeometricProgressionFirstTerm);
			panel.add(new Label("公比"));
			panel.add(textBoxGeometricProgressionCommonRatio);
			panel.add(new Label("要素数"));
			panel.add(textBoxGeometricProgressionElementCount);
			panel.add(buttonGeometricProgression);
			add(panel);
		}

		add(new Label("等差数列順番ランダム"));
		{
			final HorizontalPanel panel = new HorizontalPanel();
			panel.add(new Label("初項"));
			panel.add(textBoxArithmeticRandomFirstTerm);
			panel.add(new Label("公差"));
			panel.add(textBoxArithmeticRandomCommonDifference);
			panel.add(new Label("要素数"));
			panel.add(textBoxArithmeticRandomElementCount);
			panel.add(buttonArithmeticRandom);
			add(panel);
		}

		add(new Label("素数列(最小、最大のどちらかのみ入力)"));
		{
			final HorizontalPanel panel = new HorizontalPanel();
			panel.add(new Label("最小"));
			panel.add(textBoxPrimeProgressionMin);
			panel.add(new Label("最大"));
			panel.add(textBoxPrimeProgressionMax);
			panel.add(new Label("要素数"));
			panel.add(textBoxPrimeProgressionElementCount);
			panel.add(buttonPrimeProgression);
			add(panel);
		}

		add(new Label("ランダム"));
		{
			final HorizontalPanel panel = new HorizontalPanel();
			panel.add(new Label("最小"));
			panel.add(textBoxRandomMin);
			panel.add(new Label("最大"));
			panel.add(textBoxRandomMax);
			panel.add(new Label("要素数"));
			panel.add(textBoxRandomElementCount);
			panel.add(buttonRandom);
			add(panel);
		}

		add(new Label("ランダム文字列"));
		{
			final HorizontalPanel panel = new HorizontalPanel();
			panel.add(new Label("使用文字"));
			panel.add(textBoxLetterTableLetters);
			panel.add(new Label("幅"));
			panel.add(textBoxLetterTableWidth);
			panel.add(new Label("高さ"));
			panel.add(textBoxLetterTableHeight);
			panel.add(buttonLetterTable);
			add(panel);
		}

		add(new Label("created text"));
		textBoxCreatedText.setWidth("500px");
		add(textBoxCreatedText);
	}

	private void createArithmetic() {
		final int a = Integer.parseInt(textBoxArithmeticFirstTerm.getText());
		final int d = Integer.parseInt(textBoxArithmeticCommonDifference.getText());
		final int n = Integer.parseInt(textBoxArithmeticElementCount.getText());
		final StringBuilder sb = new StringBuilder();
		for (int x = a, i = 0; i < n; x += d, ++i) {
			sb.append(i == 0 ? "{" : ",").append(x);
		}
		sb.append("}");
		textBoxCreatedText.setText(sb.toString());
	}

	private void createGeometricProgression() {
		final int a = Integer.parseInt(textBoxGeometricProgressionFirstTerm.getText());
		final int r = Integer.parseInt(textBoxGeometricProgressionCommonRatio.getText());
		final int n = Integer.parseInt(textBoxGeometricProgressionElementCount.getText());
		final StringBuilder sb = new StringBuilder();
		for (int x = a, i = 0; i < n; x *= r, ++i) {
			sb.append(i == 0 ? "{" : ",").append(x);
		}
		sb.append("}");
		textBoxCreatedText.setText(sb.toString());
	}

	private void createArithmeticRandom() {
		final int a = Integer.parseInt(textBoxArithmeticRandomFirstTerm.getText());
		final int d = Integer.parseInt(textBoxArithmeticRandomCommonDifference.getText());
		final int n = Integer.parseInt(textBoxArithmeticRandomElementCount.getText());
		final int[] array = new int[n];
		for (int x = a, i = 0; i < n; x += d, ++i) {
			array[i] = x;
		}
		for (int i = 0; i < n; ++i) {
			final int j = Random.nextInt(n);
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			sb.append(i == 0 ? "{" : ",").append(array[i]);
		}
		sb.append("}");
		textBoxCreatedText.setText(sb.toString());
	}

	private void createPrimeProgression() {
		final int n = Integer.parseInt(textBoxPrimeProgressionElementCount.getText());
		final List<Integer> list = new ArrayList<Integer>();
		try {
			final int min = Integer.parseInt(textBoxPrimeProgressionMin.getText());
			int x = min;
			while (list.size() < n) {
				if (isPrime(x)) {
					list.add(x);
				}
				++x;
			}
		} catch (Exception e) {
			final int max = Integer.parseInt(textBoxPrimeProgressionMax.getText());
			int x = max;
			while (list.size() < n && x >= 2) {
				if (isPrime(x)) {
					list.add(x);
				}
				--x;
			}

			for (int i = 0; i < list.size() / 2; ++i) {
				final int a = list.get(i);
				list.set(i, list.get(list.size() - i - 1));
				list.set(list.size() - i - 1, a);
			}
		}

		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); ++i) {
			sb.append(i == 0 ? "{" : ",").append(list.get(i));
		}
		sb.append("}");
		textBoxCreatedText.setText(sb.toString());
	}

	private void createRandom() {
		final int min = Integer.parseInt(textBoxRandomMin.getText());
		final int max = Integer.parseInt(textBoxRandomMax.getText());
		final int n = Integer.parseInt(textBoxRandomElementCount.getText());
		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			final int x = Random.nextInt(max - min + 1) + min;
			sb.append(i == 0 ? "{" : ",").append(x);
		}
		sb.append("}");
		textBoxCreatedText.setText(sb.toString());
	}

	private void createLetterTable() {
		final String letters = textBoxLetterTableLetters.getText();
		final int width = Integer.parseInt(textBoxLetterTableWidth.getText());
		final int height = Integer.parseInt(textBoxLetterTableHeight.getText());
		final StringBuilder sb = new StringBuilder();
		for (int y = 0; y < height; ++y) {
			sb.append(y == 0 ? "{\"" : "\",\"");
			for (int x = 0; x < width; ++x) {
				final char c = letters.charAt(Random.nextInt(letters.length()));
				sb.append(c);
			}
		}
		sb.append("\"}");
		textBoxCreatedText.setText(sb.toString());
	}

	private boolean isPrime(int x) {
		if (x == 1) {
			return false;
		}

		final int upper = (int) Math.sqrt(x + 1) + 1;
		for (int i = 2; i <= upper && i < x; ++i) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void onClick(ClickEvent event) {
		final Object sender = event.getSource();
		if (sender == buttonArithmetic) {
			createArithmetic();
		} else if (sender == buttonGeometricProgression) {
			createGeometricProgression();
		} else if (sender == buttonArithmeticRandom) {
			createArithmeticRandom();
		} else if (sender == buttonPrimeProgression) {
			createPrimeProgression();
		} else if (sender == buttonRandom) {
			createRandom();
		} else if (sender == buttonLetterTable) {
			createLetterTable();
		}
	}
}
