CLEANFILES=*.out *.aux *.log lastenheft-inhalt.tex
PURGEFILES=Lastenheft.pdf

lastenheft.tex: lastenheft-inhalt.tex

%.tex: %.md
	pandoc -f markdown -t latex -o $@ $<

%.pdf: %.tex
	xelatex $^

clean :
	rm -f $(CLEANFILES)

purge : clean
	rm -f $(PURGEFILES)
