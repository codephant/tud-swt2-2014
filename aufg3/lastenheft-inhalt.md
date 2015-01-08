
# Zielbestimmung

Durch den Umzug der Fakultät und aller ihrer Lehrstühle ist das Problem der Verwaltung der Lehrstuhleigenen Bibliothek aufgekommen. Diese werden derzeit zumeist durch die Sekretärinnen, aber auch durch Mitarbeiter verwaltet, wobei mit den Jahren der Überblick verloren geht. Deshalb soll ein neues rechnergestütztes System entworfen werden, dass bei der Verwaltung der Bibliotheksmedien helfen kann.

# Produkteinsatz

Das System wird auf allen Rechnern am Lehrstuhl zur Vefügung stehen und somit den Zugriff auf den Bibliotheksbestand vielen zugänglich machen. Das System wird durch entsprechende Administratoren verwaltet werden.

# Produktübersicht

Durch das System können eine Vielzahl von Nutzern Informationen zu verschiedenartigen Medien abrufen. Diese Medieninformationen werden durch entsprechende Speicher gehalten und können verändert werden.

Das System besitzt eine Nutzerverwaltung. Neben den Nutzerdaten werden auch die dazugehörigen Nutzerrechte in Form von Rechtegruppen verwaltet.

# Produktfunktionen

## /LF10/

Die Informationen zu Medien wie Büchern, DVDs, CDs, Zeitschriften und mehr müssen durch die Administratoren angelegt, gelöscht und verändert werden können.

## /LF20/

Das System muss Nutzer verwalten können. Die entsprechenden Nutzerdaten müssen angelegt, verändert und gelöscht werden können.  

## /LF30/
Gruppen und deren Rechte anlegen, ändern und löschen

## /LF40/
Nutzer können Medien entleihen

## /LF50/
Ausleiher werden gewarnt und gemahnt

## /LF60/
Das System besitzt eine Monitoring Komponente, die den Status jedes Mediums ausgeben kann

## /LF70/
Ausleihen können verlängert werden

## /LF80/
Das System bietet eine Suche über den ganzen Katalog an mittels Meta- und Inhaltsdaten

## /LF90/
Medien können zurückgegeben werden
  
# Produktdaten

## /LD10/ Nutzer
  * Gruppen
  * Vorname
  * Nachname
  * Geburtstag
    * Tag
	* Monat
	* Jahr
  * Adresse
    * Land
	* Postleitzahl
	* Ort
	* Straße
	* Hausnummer
	* Adresszusatz
	
## /LD20/ Gruppen
  * Name
  * Rechte
	
## /LD30/ Medien
  * International standardisierte Nummer
  * Medientyp
  * Titel
  * Autor
    * Vorname
	* Nachname
  * Verleger
    * Name
	* Adresse
      * Land
	  * Postleitzahl
	  * Ort
	  * Straße
	  * Hausnummer
	  * Adresszusatz
  * Auflage
  * Erscheinungsdatum
    * Tag
	* Monat
	* Jahr
  * Status
  * Medienrechte
	
## /LD40/ Ausleihe
  * Nutzer
  * Medium
  * Ausleihbeginn
    * Tag
	* Monat
	* Jahr
  * Ausleihende
	* Tag
	* Monat
	* Jahr
	
## /LD50/ Vorbestellung
  * Nutzer
  * Medium
  * Zeitstempel
	* Uhrzeit
	* Tag
	* Monat
	* Jahr
	
## /LD60/ Warnung
  * Nutzer
  * Medium
  * Inhalt
  
## /LD70/ Bestand
  * Medium
  * Stückzahl
	
# Produktleistungen

Das User Interface muss leicht zugänglich und verständlich sein. Außerdem ist es wichtig, dass die Software von allen Rechnern des Lehrstuls 
aus erreicht werden kann. Die Antwortszeiten bei den Suchanfragen dürfen nicht länger als 5 Sekunden dauern.
  
# Qualitätsanforderungen
  * Funktionalität: Wichtig
    Es ist wichtig, dass die Software ihre Funktionen in vollen Umfang erfüllt.
  * Zuverlässigkeit: Sehr wichtig
    Es ist sehr wichtig, dass die Software bei der Benutzung nicht abstürzt und keine Fehler bei der Benutzung auftreten.
  * Benutzbarkeit: Wichtig
    Es ist wichtig, dass sich die Software leicht bedienen lässt. Das heißt, wichtige Funktionen sollen in wenigen Klicks erreichbar und gut findbar sein.
	Des Weiteren soll die Anwendung nicht lange für die Reaktion auf Nutzereingaben brauchen.
  * Effizienz: Nicht Relevant
    Es ist nicht relevant wie groß das fertige Software Paket ist. Auch die Geschwindigkeit steht nicht an erster Stelle. Allerdings sollte die Performance
	nicht ganz ignoriert werden.
  * Änderbarkeit: Normal
    Es sollte darauf geachtet werden, dass sich Teile der Software leicht ändern lassen. Hier liegt allerdings nicht der Hauptfocus.
  * Übertragbarkeit: Nicht Relevant
    Es ist nicht wichtig, dass die Software auch auf anderen Systemen eingesetzt werden kann.
