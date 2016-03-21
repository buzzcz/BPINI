package TS02Prevody;

import org.junit.Test;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author Jaroslav Klaus
 */
public class TS02_01HappyDayScenarioJavaFX extends SupportJavaFX {

	@Test
	public void TC02_01_01PrevodPalceNaMm() {
		if (run) {
			try {
				s.find(pngs + "vstupLabel.png").right().grow(0, 20).click(pngs + "vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "vstupLabel.png").right().grow(0, 20).find(pngs +
						"vstupniVyberovySeznam" +
						".png");
				hledani.click();
				hledani.below().click(pngs + "vstupIn.png");
				hledani = s.find(pngs + "vystupLabel.png").right().grow(0, 20).find(pngs + "vystupniVyberovySeznam" +
						".png");
				hledani.click();
				hledani.below().click(pngs + "vystupMm.png");
				s.click(pngs + "tlacitkoPreved.png");
				s.wait(pngs + "tlacitkoPreved.png", 5);

				Region oblast = s.find(pngs + "vystupLabel.png").right(150).grow(0, 20);
				double vystup = Double.parseDouble(oblast.text());
				assertEquals("Očekávano: " + 25.4 + ", zjištěno: " + vystup, 25.4, vystup, 0.001);
			} catch (FindFailed | AssertionError e) {
				s.capture().save("errors", screenshotName());
				logger.error(e.getMessage());
				fail(e.getMessage());
			}
		} else {
			logger.error("Setup failed");
			fail("Setup failed");
		}
	}

	@Test
	public void TC02_01_02PrevodMetruNaYard() {
		if (run) {
			try {
				s.find(pngs + "vstupLabel.png").right().grow(0, 20).click(pngs + "vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "vstupLabel.png").right().grow(0, 20).find(pngs +
						"vstupniVyberovySeznam" +
						".png");
				hledani.click();
				hledani.below().click(pngs + "vstupM.png");
				hledani = s.find(pngs + "vystupLabel.png").right().grow(0, 20).find(pngs + "vystupniVyberovySeznam" +
						".png");
				hledani.click();
				hledani.below().click(pngs + "vystupYd.png");
				s.click(pngs + "tlacitkoPreved.png");
				s.wait(pngs + "tlacitkoPreved.png", 5);

				Region oblast = s.find(pngs + "vystupLabel.png").right(200).grow(0, 20);
				double vystup = Double.parseDouble(oblast.text());
				assertEquals("Očekávano: " + 1.0936132983377078 + ", zjištěno: " + vystup, 1.0936132983377078, vystup,
						0.00000000000000001);
			} catch (FindFailed | AssertionError e) {
				s.capture().save("errors", screenshotName());
				logger.error(e.getMessage());
				fail(e.getMessage());
			}
		} else {
			logger.error("Setup failed");
			fail("Setup failed");
		}
	}
}
