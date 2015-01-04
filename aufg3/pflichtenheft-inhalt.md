
# Dokumentenstatus

Das vorliegende Dokument befindet sich aktuell im Aufbau. Für die meisten Bereichen sind Stichpunkte als grobe Übersicht über den Inalt eingetragen. Einige Bereiche sind bereits ausformuliert.

# Zielbestimmung

Durch den Umzug der Fakultät und aller ihrer Lehrstühle ist das Problem der Verwaltung der Lehrstuhleigenen Bibliothek aufgekommen. Diese werden derzeit zumeist durch die Sekretärinnen, aber auch durch Mitarbeiter verwaltet, wobei   mit den Jahren der Überblick verloren geht. Deshalb soll ein neues rechnergestütztes System entworfen werden, dass bei der Verwaltung der Bibliotheksmedien helfen kann.

## Musskriterien

- Nutzerverwaltung mit CRUD-Zugriff
- Medienverwaltung mit CRUD-Zugriff
- Nutzerrechteverwaltung via Nutzerrechtegruppen mit CRUD-Zugriff für Rechtegruppen
- Ausleihe und Rückgabe, Veränderung von Ausleihdaten
- Katalog von jedem Rechner aus durchsuchbar

## Wunschkriterien

- Wenn Ausleihfrist fast abgelaufen, Ausleiher bekommt Nachricht zugesandt

## Abgrenzungskriterien

- Keine Schnittstelle für andere Peripheriegeräte als Maus und Tastatur


# Produkteinsatz

Das System wird auf allen Rechnern am Lehrstuhl zur Vefügung stehen und somit den Zugriff auf den Bibliotheksbestand vielen zugänglich machen. Das System wird durch entsprechende Administratoren verwaltet werden.

## Anwendungsbereich

## Zielgruppe

## Betriebsbedingungen


# Produktumgebung

- Client/Server-Model mit Auslieferung via HTTP/HTML

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

## /PD010/ Nutzer
  * Gruppen
  * Vorname
  * Nachname
  * Geburtstag
  * Adresse
	
## /PD020/ Gruppen
  * Name
  * Rechte
	
## /PD030/ Medien
  * International standardisierte Nummer
  * Medientyp
  * Titel
  * Autor
  * Verleger
  * Auflage
  * Erscheinungsdatum
  * Status
  * Medienrechte
	
## /PD040/ Ausleihe
  * Nutzer
  * Medium
  * Ausleihbeginn
  * Ausleihende
	
## /PD050/ Vorbestellung
  * Nutzer
  * Medium
  * Zeitstempel
	
## /PD60/ Warnung
  * Nutzer
  * Medium
  * Inhalt
  
## /PD70/ Bestand
  * Medium
  * Stückzahl

# Produktleistungen

## /PL10/
Einfach zugängliches User Interface

## /PL20/
Erreichbarkeit von allen Rechnern des Lehrstuhls

## /PL30/
Antwortszeiten bei Suchanfragen dürfen nicht mehr als 5 Sekunden betragen

# Benutzeroberfläche

(Die Benutzeroberflächen-Vorschauen sind ausgelassen, obwohl referenziert.)
  
# Qualitätszielbestimmung
  * Funktionalität: Wichtig
  * Zuverlässigkeit: Sehr wichtig
  * Benutzbarkeit: Wichtig
  * Effizienz: Nicht Relevant
  * Änderbarkeit: Normal
  * Übertragbarkeit: Nicht Relevant

# Globale Testszenarien/Akzeptanztestfälle

- Kompletter Ablauf einer Ausleihe mit Verlängerung
- Neuanschaffung eines Medium
. Eintragung eines neuen Medienverwalters

# Glossar/Ontologie
