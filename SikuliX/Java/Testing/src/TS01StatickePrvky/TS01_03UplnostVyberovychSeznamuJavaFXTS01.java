package TS01StatickePrvky;

import org.junit.Test;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author Jaroslav Klaus
 */
public class TS01_03UplnostVyberovychSeznamuJavaFXTS01 extends SupportJavaFX {

	@Test
	public void TC01_03_01VstupniVyberovySeznam() {
		if (run) {
			try {
				s.find(pngs + "vstupLabel.png").right().grow(0, 20).click(pngs + "vstupniVyberovySeznam.png");
				assertTrue("Vstupní výběrový seznam není úplný", s.exists(pngs + "uplnyVstupniVyberovySeznam.png") !=
						null);
				s.type(Key.ESC);
			} catch (FindFailed | AssertionError e) {
				s.capture().save("errors", screenshotName());
				logger.error(e.getMessage());
				s.type(Key.ESC);
				fail(e.getMessage());
			}
		} else {
			logger.error("Setup failed");
			fail("Setup failed");
		}
	}

	@Test
	public void TC01_03_02VystupniVyberovySeznam() {
		if (run) {
			try {
				s.find(pngs + "vystupLabel.png").right().grow(0, 20).click(pngs + "vystupniVyberovySeznam.png");
				assertTrue("Výstupní výběrový seznam není úplný", s.exists(pngs + "uplnyVystupniVyberovySeznam.png")
						!= null);
				s.type(Key.ESC);
			} catch (FindFailed | AssertionError e) {
				s.capture().save("errors", screenshotName());
				logger.error(e.getMessage());
				s.type(Key.ESC);
				fail(e.getMessage());
			}
		} else {
			logger.error("Setup failed");
			fail("Setup failed");
		}
	}
}
