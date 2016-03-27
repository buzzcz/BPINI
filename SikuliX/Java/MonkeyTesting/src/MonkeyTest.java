import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sikuli.basics.Debug;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;

import javax.swing.*;
import java.util.Random;

/**
 * @author Jaroslav Klaus
 */
public class MonkeyTest {

	private static Logger logger;
	private static Screen s;
	private static App application;
	private static Region window;
	private static String title;

	static {
		System.setProperty("log4j.configurationFile", "log-konfigurace.xml");
	}

	@BeforeClass
	public static void setUpBeforeClass() throws FindFailed {
		logger = LogManager.getLogger();

		Settings.OcrTextSearch = true;
		Settings.OcrTextRead = true;
		Settings.MoveMouseDelay = 0;
		Debug.setLogger(logger);
		Debug.setLoggerAll("info");

		s = new Screen();
		if (System.getProperty("os.name").equals("Linux")) {
			new App("gnome-calculator").open();
			title = "png/title.png";
		} else {
			new App("C:\\Windows\\system32\\calc.exe").open();
			title = "png/winTitle.png";
		}
		new Screen().wait(title, 5);
		application = new App("Calculator");
		application.focus();
	}

	@AfterClass
	public static void tearDownAfterClass() {
		JOptionPane.showMessageDialog(null, "Test Suite dokončen");
	}

	private String randomString(Random gen) {
		String chars = "qwertzuioplkjhgfdsayxcvbnmQWERTZUIOPLKJHGFDSAYXCVBNM1234567890";
		String s = "";
		for (int i = 0; i < gen.nextInt(); i++) {
			s += chars.charAt(gen.nextInt(chars.length()));
		}
		return s;
	}

	@Test
	public void MonkeyTest01() throws FindFailed {
		Random gen = new Random();
		while (s.exists(title) != null) {
			window = App.focusedWindow();
			Location minCoord = window.getTopLeft();
			Location maxCoord = window.getBottomRight();
			int random = gen.nextInt(5);
			int x = gen.nextInt(maxCoord.getX()), y = gen.nextInt(maxCoord.getY());
			while (x < minCoord.getX()) x = gen.nextInt(maxCoord.getX());
			while (y < minCoord.getY()) y = gen.nextInt(maxCoord.getY());
			switch (random) {
				case 0: // Click
					window.click(new Location(x, y));
					break;
				case 1: // Double-click
					window.doubleClick(new Location(x, y));
					break;
				case 2: // Right click
					window.rightClick(new Location(x, y));
					break;
				case 3: // Paste
					if (gen.nextInt(2) == 1) window.click(new Location(x, y));
					String s = randomString(gen);
					window.paste(new Location(x, y), s);
					logger.info("PASTE \"" + s + "\" on [" + x + ", " + y + "]");
					break;
				case 4: // Type
					if (gen.nextInt(2) == 1) window.click(new Location(x, y));
					window.type(new Location(x, y), randomString(gen));
					break;
			}
		}
	}
}
