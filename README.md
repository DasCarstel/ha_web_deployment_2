# Kino-API

## Überblick
Dieses Projekt stellt eine REST-API für ein Kinomanagementsystem bereit. Es ermöglicht den Zugriff auf Daten zu Filmen, Gästen, Kinosälen, Tickets und Filmvorstellungen über standardisierte HTTP-Endpunkte im JSON-Format.

## Zweck
Das Projekt wurde im Rahmen einer Hochschulaufgabe entwickelt, um ein Java-Web-Projekt mit Spring Boot zu erstellen, das eine API für den Datenbankzugriff bereitstellt. Die Anforderung bestand darin, mindestens zwei Schnittstellen zu implementieren, die Daten aus der Datenbank im XML oder JSON-Format per GET oder POST ausgeben können.

## Technologien
- Java 21
- Spring Boot 3.4.4
- Spring Data JPA
- MySQL Connector
- Lombok
- Maven

## Datenmodell
Die API bietet Zugriff auf folgende Entitäten:
- **Film**: Filminformationen (Titel, Genre, Dauer)
- **Gast**: Besucherinformationen (Name, Email)
- **Saal**: Informationen zu Kinosälen (Parkettplätze, Logenplätze, Ausstattung)
- **Ticket**: Ticketinformationen (Vorstellung, Gast, Platztyp)
- **Vorstellung**: Informationen zu Filmvorführungen (Film, Vorführungszeit, Saal)

## API-Endpunkte
Für jede Entität werden folgende REST-Endpunkte bereitgestellt:

- **GET** `/api/{entity}` - Liste aller Einträge mit Paginierung
- **GET** `/api/{entity}/{id}` - Details zu einem bestimmten Eintrag
- **POST** `/api/{entity}` - Erstellt einen neuen Eintrag
- **PUT** `/api/{entity}` - Aktualisiert einen bestehenden Eintrag
- **DELETE** `/api/{entity}/{id}` - Löscht einen bestimmten Eintrag

Wobei `{entity}` für `film`, `gast`, `saal`, `ticket` oder `vorstellung` steht.

## Projektkonfiguration
Die Anwendung verbindet sich mit einer MySQL-Datenbank. Die Verbindungsdetails können in der `application.properties`-Datei konfiguriert werden:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/IhreDatenbank
spring.datasource.username=IhrBenutzername
spring.datasource.password=IhrPasswort
```

## Projektarchitektur
Das Projekt folgt einer sauberen, mehrschichtigen Architektur:
- **Controller**: Behandeln HTTP-Anfragen und -Antworten
- **Service**: Implementieren die Geschäftslogik
- **Repository**: Zugriff auf die Datenbank
- **Model**: Datenbankentitäten

Der generische Ansatz mit `GenericEntity`, `GenericRepository`, `GenericService` und `GenericController` reduziert Code-Redundanz erheblich.

## Installation und Start
1. Klonen Sie das Repository
2. Konfigurieren Sie die Datenbankverbindung in `application.properties`
3. Führen Sie `mvn clean install` aus
4. Starten Sie die Anwendung mit `mvn spring-boot:run`

Die API ist dann unter `http://localhost:8080/api/` erreichbar.