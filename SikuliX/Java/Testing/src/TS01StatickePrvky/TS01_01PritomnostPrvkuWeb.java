package TS01StatickePrvky;

import org.junit.Test;
import org.sikuli.script.FindFailed;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author Jaroslav Klaus
 */
public class TS01_01PritomnostPrvkuWeb extends SupportWeb {
	@Test
	public void TC01_01_01LabelVstup() {
		if (run) {
			try {
				assertTrue("Label vstup neexistuje", s.exists(pngs + "labely/vstupLabel.png") != null);
			} catch (AssertionError e) {
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
	public void TC01_01_02VstupniTextovePole() {
		if (run) {
			try {
				assertTrue("Vstupní textové pole neexistuje", s.find(pngs + "labely/vstupLabel.png").right().grow(0,
						20).exists(pngs + "textovaPole/vstupniTextovePole.png") != null);
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
	public void TC01_01_03VstupniVyberovySeznam() {
		if (run) {
			try {
				assertTrue("Vstupní výběrový seznam neexistuje", s.find(pngs + "labely/vstupLabel.png").grow(0, 20)
						.right().exists(pngs + "vyberoveSeznamy/vstupniVyberovySeznam.png") != null);
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
	public void TC01_01_04LabelVystup() {
		if (run) {
			try {
				assertTrue("Label výstup neexistuje", s.exists(pngs + "labely/vystupLabel.png") != null);
			} catch (AssertionError e) {
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
	public void TC01_01_05VystupniTextovePole() {
		if (run) {
			try {
				assertTrue("Výstupní textové pole neexistuje", s.find(pngs + "labely/vystupLabel.png").right().grow(0,
						20).exists(pngs + "textovaPole/vystupniTextovePole.png") != null);
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
	public void TC01_01_06VystupniVyberovySeznam() {
		if (run) {
			try {
				assertTrue("Výstupní výběrový seznam neexistuje", s.find(pngs + "labely/vystupLabel.png").grow(0, 20)
						.right().exists(pngs + "vyberoveSeznamy/vystupniVyberovySeznam.png") != null);
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
	public void TC01_01_07TlacitkoPreved() {
		if (run) {
			try {
				assertTrue("Tlačítko převeď neexistuje", s.exists(pngs + "tlacitka/tlacitkoPreved.png") != null);
			} catch (AssertionError e) {
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
	public void TC01_01_08TlacitkoVymaz() {
		if (run) {
			try {
				assertTrue("Tlačítko vymaž neexistuje", s.exists(pngs + "tlacitka/tlacitkoVymaz.png") != null);
			} catch (AssertionError e) {
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