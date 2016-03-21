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
				s.find(pngs + "vstupLabel.png").right().grow(0, 20).paste(pngs + "vstupniTextovePole.png", "vstup");
				s.find(pngs + "vstupLabel.png").right().grow(0, 20).find(pngs + "editovatelnostVstupnihoPole.png");
				assertTrue("Vstupní textové pole není editovatelné", s.find(pngs + "vstupLabel.png").right().grow(0,
						20).exists(pngs + "vstupVstup.png") != null);
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
				s.find(pngs + "vystupLabel.png").right().grow(0, 20).paste(pngs + "vystupniTextovePole.png", "vstup");
				assertTrue("Výstupní textové pole je editovatelné", s.find(pngs + "vystupLabel.png").right().grow(0,
						20).exists(pngs + "vystupniTextovePole.png") != null);
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
