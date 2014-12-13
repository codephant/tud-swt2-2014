
CLEANFILES=aux/*
PURGEFILES=$(CLEANFILES) Lastenheft.pdf

%.tex : %.html
	xsltproc -v -o $@ scripts/xhtml2tex.xslt $<

aux/lh-inhalt.html : Lastenheft.txt
	theme -t lh/lh-inhalt.theme -o aux/lh-inhalt.html Lastenheft.txt

Lastenheft.pdf : aux/lh-inhalt.tex lh/Lastenheft.tex
	xelatex lh/Lastenheft.tex
	mv *.aux *.log *.out aux/ # cleaning up the latex mess

clean :
	rm -f $(CLEANFILES)

purge :
	rm -f $(PURGEFILES)
