prohlizec = App("google-chrome")    #prohlizec je proměnná
prohlizec.open()    #otevře aplikaci definovanou výše
prohlizec.focus()    #vybere do popředí její okno
wait("obr1.png")    #čeká, dokud na obrazovce nenajde obrázek
paste("obr2.png", "http://oks.kiv.zcu.cz/Prevodnik")    #najde na obrazovce obrázek a vloží do něho text
type(Key.ENTER)    #simuluje stisk klávesy ENTER
click("obr3.png")    #najde na obrazovce obrázek a klikne na něj
wait("obr4.png")
paste("obr5.png", "1")
click(Pattern("obr6.png").targetOffset(-27,-18))
click("obr7.png")
click("obr4.png")
vystup = find("obr8.png").right(100).text()    #přečte text z části, která je vpravo od nalezeného obrázku 100px široká, do proměnné vystup
if vystup == "2.54":
    popup("Ok textově")    #pokud rozpoznaný text souhlasí se zadaným, otevře se vyskakovací okno
else:
    popError("Chyba")    #jinak se zobrazí chybové okno

if exists("obr9.png"):
    popup("Ok obrazově")    #pokud na obrazovce existuje obrázek, otevře se vyskakovací okno
else:
    popError("Chyba")    #jinak se zobrazí chybové okno
prohlizec.close()    #ukončí aplikace
