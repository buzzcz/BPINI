chrome = App("google-chrome")
chrome.open()
chrome.focus()
wait("1445265477042.png")
paste("1445179646217.png", "http://oks.kiv.zcu.cz/Prevodnik")
type(Key.ENTER)
click("1445259423989.png")
wait("1445259454025.png")
paste("1445259475560.png", "1")
click(Pattern("1445259516792.png").targetOffset(-27,-18))
click("1445259547269.png")
click("1445259454025.png")
T = find("1445261615557.png").right(100).text().encode("utf-8")
if T == "2.54":
    popup("Ok textově")
else:
    popError("Chyba")

if exists("1445264707398.png"):
    popup("Ok obrazově")
else:
    popError("Chyba")
#chrome.close()
