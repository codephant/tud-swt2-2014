J2WSDL	= "org.apache.axis.wsdl.Java2WSDL"
CP		= lib/*:bin
DIFF	= git diff --no-index
LOC		= http://www.example.org/de/tu-dresden/inf/swt/2/ws2014/regtest
NS		= $(LOC)/ns

all : diff/Test.diff

diff/%.diff : old/%.wsdl new/%.wsdl
	$(DIFF) old/$(*F).wsdl new/$(*F)_impl.wsdl > $@ 

old/%.wsdl : bin/%.class
	java -cp old/$(CP) $(J2WSDL) -o $@ -l $(LOC)/$* -n $(NS) $*

new/%.wsdl : bin/%.class
	java -cp new/$(CP) $(J2WSDL) -o $@ -l $(LOC)/$* -n $(NS) $*

bin/%.class : src/%.java
	javac -d bin $<

purge :
	rm -fr bin/*.class old/*.wsdl new/*.wsdl
	rm -fr diff/*.diff
