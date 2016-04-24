import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sikuli.basics.Debug;
import org.sikuli.basics.Settings;
import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import java.io.IOException;
import java.time.LocalDateTime;

public class TestLink {

	static {
		System.setProperty("log4j.configurationFile", "log-konfigurace.xml");
	}

	public static String screenshotName() {
		LocalDateTime l = LocalDateTime.now();
		return l.getYear() + "" + l.getMonthValue() + "" + l.getDayOfMonth() + "" + l.getHour() + "" + (l.getMinute()
				< 10 ? "0" + l.getMinute() : l.getMinute()) + "" + l.getSecond() + "";
	}

	public static void main(String[] args) {
		Logger logger = LogManager.getLogger();

		Settings.MoveMouseDelay = 0;
		Debug.setLogger(logger);
		Debug.setLoggerAll("info");

		Screen s = new Screen();
		try {
			Runtime.getRuntime().exec("cesta/k/TestLink/manager/tool");
			App application = new App("TestLink");
			application.focus();
			s.wait("png/goToApp.png", 5);
			s.click("png/goToApp.png");
			if (s.exists("png/startServers.png") != null) s.click("png/startServers.png");
			application = new App("Chrome");
			application.focus();
			s.wait("png/access.png", 50);
			s.click("png/access.png");
			if (s.exists("png/login.png") != null) {
				s.find("png/login.png").below(20).click();
				s.paste("login");
				s.click("png/login.png");
				s.find("png/pass.png").below(20).click();
				s.paste("password");
				s.type(Key.ENTER);
			}
		} catch (IOException | FindFailed e) {
			s.capture().save("errors", screenshotName());
			logger.error(e.getMessage());
		}

	}
}
