
CLEANFILES=lh-inhalt.html lh-inhalt.tex *.log *.aux *.out
PURGEFILES=$(CLEANFILES) Lastenheft.pdf

lh-inhalt.html : Lastenheft.txt
	theme -t lh-inhalt.theme -o lh-inhalt.html Lastenheft.txt

Lastenheft.pdf : lh-inhalt.tex Lastenheft.tex
	xelatex Lastenheft.tex

%.tex : %.html
	xsltproc -v -o $@ xhtml2tex.xslt $<

%.pdf : %.tex
	xelatex $<

clean :
	rm -f $(CLEANFILES)

purge :
	rm -f $(PURGEFILES)
