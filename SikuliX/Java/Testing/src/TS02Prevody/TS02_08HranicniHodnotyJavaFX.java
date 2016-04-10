package TS02Prevody;

import org.junit.Test;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author Jaroslav Klaus
 */
public class TS02_08HranicniHodnotyJavaFX extends SupportJavaFX {
	@Test
	public void TC02_08_01Nula() {
		if (run) {
			try {
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("0");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupM.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupM.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 0, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right(200)
						.grow(0, 10).exists(pngs + "vystupy/vystup0.png") != null);
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
	public void TC02_08_02MaxDouble() {
		if (run) {
			try {
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("1.7e308");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupM.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupM.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: Infinity, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right
						(200).grow(0, 10).exists(pngs + "vystupy/vystupInf.png") != null);
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