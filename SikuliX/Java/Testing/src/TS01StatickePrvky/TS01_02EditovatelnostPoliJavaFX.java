package TS01StatickePrvky;

import org.junit.Test;
import org.sikuli.script.FindFailed;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author Jaroslav Klaus
 */
public class TS01_02EditovatelnostPoliJavaFX extends SupportJavaFX {
	@Test
	public void TC01_02_01VstupniTextovePole() {
		if (run) {
			try {
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).paste(pngs +
						"textovaPole/vstupniTextovePole.png", "vstup");
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"textovaPole/editovatelnostVstupnihoPole.png");
				assertTrue("Vstupní textové pole není editovatelné", s.find(pngs + "labely/vstupLabel.png").right()
						.grow(0, 20).exists(pngs + "textovaPole/editovatelnostVstupnihoPole.png") != null);
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
	public void TC01_02_02VystupniTextovePole() {
		if (run) {
			try {
				s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).paste(pngs +
						"textovaPole/vystupniTextovePole.png", "vstup");
				assertTrue("Výstupní textové pole je editovatelné", s.find(pngs + "labely/vystupLabel.png").right()
						.grow(0, 20).exists(pngs + "textovaPole/vystupniTextovePole.png") != null);
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