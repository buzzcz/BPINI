prohlizec = App("google-chrome")
prohlizec.open()    #otevře aplikaci definovanou výše
prohlizec.focus()    #vybere do popředí její okno
wait("1445265477042.png")    #čeká, dokud na obrazovce nenajde obrázek
paste("1445179646217.png", "http://oks.kiv.zcu.cz/Prevodnik")    #najde na obrazovce obrázek a vloží do něho text
type(Key.ENTER)    #simuluje stisk klávesy ENTER
click("1445259423989.png")    #najde na obrazovce obrázek a klikne na něj
wait("1445259454025.png")
paste("1445259475560.png", "1")
click(Pattern("1445259516792.png").targetOffset(-27,-18))
click("1445259547269.png")
click("1445259454025.png")
vystup = find("1445261615557.png").right(100).text()    #přečte text z části, která je 100px vpravo od nalezeného obrázku
if vystup == "2.54":
    popup("Ok textově")    #pokud rozpoznaný text souhlasí se zadaným, otevře se vyskakovací okno
else:
    popError("Chyba")    #jinak se zobrazí chybové okno

if exists("1445264707398.png"):
    popup("Ok obrazově")    #pokud na obrazovce existuje obrázek, otevře se vyskakovací okno
else:
    popError("Chyba")    #jinak se zobrazí chybové okno
prohlizec.close()    #ukončí aplikace
