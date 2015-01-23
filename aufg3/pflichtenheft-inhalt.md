
# Dokumentenstatus

Das vorliegende Dokument befindet sich aktuell im Aufbau. Für die meisten Bereichen sind Stichpunkte als grobe Übersicht über den Inalt eingetragen. Einige Bereiche sind bereits ausformuliert.

Stellen die Erweiterung bedürfen sind mit „(...)“ (ohne Anführungszeichen) gekennzeichnet.

# Zielbestimmung

Durch den Umzug der Fakultät und aller ihrer Lehrstühle ist das Problem der Verwaltung der Lehrstuhleigenen Bibliothek aufgekommen. Diese werden derzeit zumeist durch die Sekretärinnen, aber auch durch Mitarbeiter verwaltet, wobei   mit den Jahren der Überblick verloren geht. Deshalb soll ein neues rechnergestütztes System entworfen werden, dass bei der Verwaltung der Bibliotheksmedien helfen kann.

## Musskriterien

### /MK010/ Nutzerverwaltung

Nutzer müssen erstellt, verändert, gelöscht und deren Daten abgerufen werden können.

### /MK020/ Nutzerrechteverwaltung

Rechtegruppen müssen erstellt, verändert, gelöscht und deren Daten abgerufen werden können.
Nutzern müssen Rechtegruppen zugewiesen werden können.

### /MK030/ Ausleihe

Die Ausleihe von Büchern müssen ins System eingetragen und ausgetragen werden können.
Die Ausleihzeit muss verändert werden können.
- Ausleihe und Rückgabe, Veränderung von Ausleihdaten

### /MK040/ Mediensuche

Der Mediendatenbestand muss nach passenden Metadaten oder passendem Inhalt durchsucht werden können.

## Wunschkriterien

### /WK010/ Rückgabewarnung

Der Ausleiher soll gewarnt werden, wenn die Ausleihe seiner Medien zuende geht.

### /WK020/ Präsenzbestand

In den Bestand, den das System verwaltet, können auch Präsenzbestandsexemplare eingebracht werden.

## Abgrenzungskriterien

### /AK010/ Peripheriegeräte

Das System hat keine Schnittstellen für andere Peripheriegeräte als Maus und Tastatur.


# Produkteinsatz

Das System wird auf allen Rechnern am Lehrstuhl zur Vefügung stehen und somit den Zugriff auf den Bibliotheksbestand vielen zugänglich machen. Das System wird durch entsprechende Administratoren verwaltet werden.

## Anwendungsbereich

Das System ist im Verwaltungsbereich von Mediatheken und Bibliotheken einsetzbar. Es unterstützt die Datenhaltung betreffs Medien und Ausleihen. Es bildet dazu Vorgänge, wie z.B. "ausleihen", ab. 

## Zielgruppe

Der Nutzer des System sind die Angestellten der Fakultätsbibliothek. Sie sind mit den Abläufen in einer Bibliothek vertraut.

## Betriebsbedingungen


# Produktumgebung

Das System wird mit Hilfe eines Web-Servers über HTTP/HTML im Intranet der Fakultät zur Verfügung gestellt. Auf den zugreifenden Rechnern muss dazu neben einem Betriebssystem ein passender Browser installiert sein.

## Software

### Server
- Ubuntu
- Apache Webserver mit PHP-CGI
- PHP 5.4

### Anwender

- HTML5/CSS3-fähiger Web-Browser mit Javascript-Unterstützung

## Hardware

- Rechner mit Internetzugriff

## Orgware

- Softwarehandbuch

## Produktschnittstellen

- für alle Nutzer HTML-Nutzerschnittstelle


# Produktfunktionen

## Medienverwaltung

Dieser Bereich /PF010/–/PF040/ ist abgeleitet aus /LF10/ (Lastenheft).

### /PF010/ Medium anlegen

Mittels der Formularmaske /PO010/ müssen Administratoren und Medienverwalter alle Mediendaten zu einem neuen Medium eingeben können. Der Medientyp ist über ein Auswahlmenü festlegbar. Nach Abschicken des Formulars legt das System das neue Medium an und speichert die Mediendaten persistent.

### /PF020/ Medium verändern

Mittels Formular /PO020/ können Administratoren und Medienverwalter im System erfasste Mediendaten verändern. Die neuen Mediendaten werden im System gespeichert und stehen bei nächsten Abruf bereit.

### /PF030/ Medium löschen

Mittels der Medienansicht /PO030/ können Administratorern und Medienverwalter ein Medium aus dem Bestand löschen.

### /PF040/ Medium ansehen

Mittels der Medienansicht /PO030/ kann jeder Nutzer die Medieninformationen zu einem bestimmten Medium ansehen.


## Nutzerverwaltung

Dieser Bereich /PF050/–/PF0X0/ leitet sich aus /LF20/ und /LF30/ (Lastenheft) ab.

### /PF050/ Nutzer anlegen

Mittels der Formularmaske /PO040/ muss ein Administrator alle Nutzerdaten zu einem neuen Nutzer eingeben können. Nach Abschicken des Formulars legt das System den neuen Nutzer an und speichert die Nutzerdaten persistent.

### /PF060/ Nutzer verändern

Mittels der Formularmaske /PO050/ kann ein Administrator alle Nutzerdaten verändern. Nach Abschicken des Formulars werden die veränderten Nutzerdaten persistent gespeichert und stehen beim nächsten Abruf bereit.

### /PF070/ Nutzer löschen

Mittels der Nutzeransicht /PO060/ kann ein Administrator einen Nutzer aus dem System löschen.

### /PF080/ Nutzer ansehen

Mittels der Nutzeransicht /PO060/ kann ein Nutzer seine eigenen Daten ansehen. Mittels der Nutzeransicht /PO60/ kann ein Administrator die Nutzerdaten eines vom Administrator gewählten Nutzers ansehen.

### /PF080/ Rechtegruppe anlegen

Mittels der Formularmaske /PO070/ kann ein Administrator alle Daten einer Nutzerrechtegruppe eingeben. Nach Abschicken des Formulars legt das System die neue Rechtegruppe an und speichert die Gruppendaten persistent.

### /PF090/ Rechtegruppe verändern 

Mittels der Formularmaske /PO080/ kann ein Administrator die Daten einer Nutzerrechtegruppe verändern. Nachdem der Administrator das Formular abschickt, speichert das System die neuen Rechtegruppendaten. Das System wendet die geänderten Rechtedaten nach dem Speichern an.

### /PF100/ Rechtegruppe löschen

Mittels der Rechtegruppenübersicht /PO090/ kann ein Administrator eine Rechtegruppe löschen. Nach dem Löschen berücksichtigt das System für keinen Nutzer die mit der Grupper verknüpften Rechte. Die ausgezeichnete Systemadministratorgruppe kann nicht gelöscht werden.


## Ausleihe

Dieser Bereich leitet sich aus /LF40/–/LF70/ (Lastenheft) ab.

### /PF110/ Medium ausleihen

Mittels Formularmaske /PO090/ können Medienverwalter eine Ausleihe und deren Daten eintragen. Wenn nicht angegeben, berechnet das System automatisch anhand der Rechte des Ausleihers und des Medientyps die Ausleihdauer.

### /PF120/ Medium zurückgeben

Mittels Formularmaske /PO100/ können Medienverwalter zurückgegebene Medien eintragen und die dazugehörige Ausleihe abschließen.

### /PF130/ Ausleihe verlängern

Medienverwalter können mittels Formularmaske /PO110/ die Dauer einer bestimmten Ausleihe verlängern.


## Suche

### /PF140/
Das System bietet eine Suche über den ganzen Katalog an mittels Meta- und Inhaltsdaten

### /PF150/

- bei Rückgabe von Medium schließt Medienverwalter Ausleihe ab
  
# Produktdaten

![Systemklassen](klassen.pdf)

## /PD010/ Nutzer

Ein Nutzer des Systems ist eine Person, die mit dem System mittelbar oder unmittelbar interagiert. Diese Nutzer können im Bezug auf das System unterschiedliche Ziele haben. Die Nutzer verwenden das System um ihre Ziele zu erreichen.

  * ID: Eine laufende Zahl, die den Nutzer eindeutig identifiziert.
  * Gruppen: Eine Menge von Verweisen auf Rechtegruppen, die deutlich machen zu welche Rechte der Nutzer hat.
  * Vorname: Eine Zeichenkette, die den Rufnamen des Nutzers darstellt.
  * Nachname: Eine Zeichenkette
  * Geburtstag: Eine Datumsangabe, bestehend aus Tag, Monat und Jahr nach dem Gregorianischen Kalender.
  * Adresse: Eine Internationale Adresse, bestehend aus
    * Land: Eine Zeichenkette, die den Namen eines anerkannten Landes darstellt.
    * Postleitzahl: Eine Zeichenkette, die nur aus Ziffern besteht und einen postalischen Distrikt im Land der Adresse darstellt.
    * Ort: Eine Zeichenkette, die den Namen einer Ortschaft im Land der Adresse darstellt.
    * Straße: Eine Zeichenkette.
    * Hausnummer: Eine Ganzzahl.
    * Adresszusatz: Eine beliebige Zeichenkette.

## /PD020/ Gruppen

Eine Nutzerrechtegruppe ist eine Sammlung von Rechten, die einem Nutzer gewährt werden können, indem ihm die Gruppe zugeordnet wird.

  * ID: Eine laufende Zahl, die die Gruppe eindeutig identifiziert
  * Name: Eine Zeichenkette, die der Gruppe eine repräsentative, für Menschen verständliche Bezeihnung gibt.
  * Rechte: (...);

## /PD030/ Medium

Ein Medium ist ein audiovisuelles Schöpferwerk. Es ist in Media-/Bibliotheken potentiell ausleihbar. Es ist nicht die konkrete Instanz, sondern die Sammlung seiner Metadaten.

  * ID: Eine Ganzzahl; laufende Nummer, die das Medium eindeutig im Bestand der Media-/Bibliothek identifiziert.
  * ISNTyp: Eine Zeichenkette, die den Typ der Internationalen Standard Nummer beschreibt.
  * ISN: Eine Zeichenkette von Ziffern, die das Medium im Sinne seines ISNTypes eindeutig identifiziert.
  * Medientyp: Eine Zeichenkette, die deutlich macht, um was für eine Art Medium (Buch, Magazin, AudioCD, DVD o.A.) es sich handelt.
  * Titel: Eine Zeichenkette, der Name des Werkes.
  * Urheber: Eine Zeichenkette, der Name einer Person, die sich als Schöpfer des Werkes verantwortlich zeichnet.
  * Herausgeber: Eine Zeichenkette, der Name des Vertreibers des Mediums.
  * Revision: Eine Zahl, die die Produktionsserie des Mediums darstellt.
  * Erscheinungsdatum: Eine Datum nach dem Gregorianischen Kalender bestehend aus Jahr, Monat und Tag.
  * Status: (...).

## /PD040/ Ausleihe

Eine Ausleihe ist der Zustand, der entsteht wenn eine Instanz eines Mediums zum Konsum an einen Nutzer ausgegeben wird. Er endet, wenn dieser Nutzer das Medium zurück an die Bibliothek gibt.

  * ID: Eine Ganzzahl; laufende Nummer, die die Ausleihe eindeutig identifiziert.
  * Nutzer: Ein Verweis auf den Nutzer, der das Medium ausgeliehen hat.
  * Medium: Ein Verweis auf das Medium, das ausgeliehen wurde.
  * Ausleihbeginn: Eine Datumsangabe nach dem Gregorianischen Kalender, bestehend aus Jahr, Monat und Tag; der Tag der Ausleihe und Beginn der Ausleihfrist.
  * Ausleihende: Eine Datumsangabe nach dem Gregorianischen Kalender, bestehend aus Jahr, Monat und Tag; der Tag an dem das Medium spätestens zurückgegeben werden muss.

## /PD050/ Vorbestellung

Eine Vorbestellung beschreibt, den Wunsch eines Nutzers ein bestimmtes Medium auszuleihen. Das Medium ist aber aktuell in der Bibliothek nicht ausleihbar vorhanden.

  * ID: Eine Ganzzahl; laufende Nummer, die die Vorbestellung eindeutig identifiziert.
  * Nutzer: Ein Verweis auf den Nutzer, der das Medium ausleihen möchte.
  * Medium: Ein Verweis auf das Medium, das ausgeliehen werden soll und aktuell nicht im Bestand ist.
  * Zeitstempel: Bestehend aus
    * Datum: Bestehend aus Jahr, Monat und Tag.
    * Zeit: Bestehend aus Stunde, Minute und Sekunde.

## /PD60/ Warnung

Warnungen sind Nachrichten. Sie informieren den Nutzer darüber, dass eine ihm zugeordnete Ausleihe im Begriff ist auszulaufen.

  * Nutzer: Ein Verweis auf den Nutzer, der die Warnung erhalten soll.
  * Medium: Ein Verweis auf das Medium, dessen Ausleihfrist zuende geht.
  * Inhalt: Eine Zeichenkette, die eine zusätzliche Erklärung zur Warnung liefert.

## /PD70/ Bestand

Ein Bestand ist ein Konglomerat von vielen Instanzen von Medien. Ein Bestand ist fest mit einer gegebenen Bibliothek verbunden.

  * Medium: Ein Verweis auf das Medium, das in den Bestand aufgenommen ist.
  * Stückzahl: Eine Ganzzahl, die die Menge der zum Bestand gehörigen Exemplare angibt.
  * Präsenz: Eine Ganzzahl, die angibt wieviele der Exemplare zum Präsenzbestand gehören. Dieses Zahl muss kleiner gleich der Stückzahl sein.

# Produktleistungen

## /PL10/ Einfach verständliche Oberfläche

Die Benutzeroberfläche muss leicht verständlich sein und sollte nicht mehr als zwei Stunden zur Einarbeitung benötigen.

## /PL20/

Die Software muss von allen Computern im Fakultätsintranet aus erreichbar sein. Computer außerhalb dieses Netzwerks dürfen keinen Zugriff auf den Bibliotheksbestand haben.

## /PL30/

Antwortszeiten bei Suchanfragen dürfen vom Absenden der Anfrage bis zur Darstellung erster Suchergebnisse nicht mehr als 5 Sekunden betragen.

# Benutzeroberfläche

(...)
(Die Benutzeroberflächen-Vorschauen sind ausgelassen, obwohl referenziert.)

# Qualitätszielbestimmung
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

# Globale Testszenarien/Akzeptanztestfälle

Das System wird in Produktionsumgebung durch Angestellte der Biobliothek unter Aufsicht von Testern getestet. Dabei werden alle durch die Abbildung „Anwendungsfälle“ beschriebenen Tätigkeiten durch die Testenden ausgeführt.

![Anwendungsfälle](sa-usecases.pdf)

# Glossar/Ontologie

\begin{verbatim}
Bestand :: {Medium}^n. // Datenstruktur aller Medien

Medium ::= Mediumdaten 
		+ Status
		+ Medienrechte
		+ Stückzahl.

Mediumdaten ::= Medientyp
		+ Titel
		+ Autor 
		+ (Verlag) 
		+ (Auflage) 
		+ Erscheinungsdatum 
		+ Id.

Medientyp ::= Datenträger
		| Zeitschrift
		| Broschüre
		| Buch.

Datenträger ::= CD
		| DVD.

Status ::= [verfügbar
		| ausgeliehen]
		+ vorbestellt.

Suchdaten ::= 1 { [ Inhaltausschnitt
		| Medientyp 
		| Titel
		| Author 
		| Verlag 
		| Auflage 
		| Erscheinungsdatum
		| Id ] } n.

Id ::= ISBN
		| ISSN
		| ISMN.

Warnung ::= Id 
		+ Nutzer 
		+ Medium 
		+ Inhalt.

Nutzer ::= Nutzerdaten 
		+ Gruppe.

Nutzerdaten ::= Vorname 
		+ Nachname 
		+ Geburtsdatum 
		+ Adresse
		+ Nutzername 
		+ Kennwort. 

Gruppe ::= Name 
		+ Rechte. 

Rechte ::= Ausleihe
		+ Datenpflege
		+ Administration. 

Medienrechte ::= Ausliehbar
		+ (MaxAusleihdauer).

Ausleihe ::= Nutzer
		+ Medium
		+ Ausleihbeginn
		+ Ausleihende.

Vorbestellung ::= Nutzer
		+ Medium
		+ Zeitstempel. 
\end{verbatim}
