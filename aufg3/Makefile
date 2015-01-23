CLEANFILES=*.out *.aux *.log *heft-inhalt.tex

lastenheft.tex: lastenheft-inhalt.tex

pflichtenheft.tex: pflichtenheft-inhalt.tex sa-usecases.pdf

%heft.purge : clean
	rm -f $*heft.pdf

%.tex: %.md
	pandoc -f markdown -t latex -o $@ $<

%.pdf: %.tex
	xelatex $^

clean :
	rm -f $(CLEANFILES)
