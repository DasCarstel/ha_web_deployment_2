# Kino-API

## Überblick

![Screenshot](/ha_web_deployment_2_screen.png)

Dieses Projekt stellt eine REST-API für ein Kinomanagementsystem bereit. Es ermöglicht den Zugriff auf Daten zu Filmen, Gästen, Kinosälen, Tickets und Filmvorstellungen über standardisierte HTTP-Endpunkte im JSON-Format.

## Zweck
Das Projekt wurde im Rahmen einer Hochschulaufgabe entwickelt, um ein Java-Web-Projekt mit Spring Boot zu erstellen, das eine API für den Datenbankzugriff bereitstellt. Die Anforderung bestand darin, mindestens zwei Schnittstellen zu implementieren, die Daten aus der Datenbank im XML oder JSON-Format per GET oder POST ausgeben können.

## **HINWEIS FÜR DEN PROFESSOR**: 
- Bei der Verwendung von NetBeans kann folgende Warnung auftreten:
   "Can't initialize javac processor due to (most likely) a class loader problem: java.lang.NoClassDefFoundError: Could not initialize class lombok.javac.Javac"
- Diese Warnung ist ein bekanntes Problem zwischen NetBeans und Lombok und tritt nach der Migration von IntelliJ auf
- Der Code ist trotz dieser Warnung voll funktions- und ausführbar
- Es handelt sich um eine Kompatibilitätsproblematik zwischen dem NetBeans Java-Compiler und Lombok-Annotationsverarbeitung

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

## Projektstruktur
```
ha_web_deployment_2/
├── pom.xml                              # Maven-Konfiguration
├── src/
│   ├── main/
│   │   ├── java/com/example/ha_web_deployment_2/
│   │   │   ├── HaWebDeployment2Application.java     # Hauptklasse
│   │   │   ├── ServletInitializer.java              # Servlet-Konfiguration
│   │   │   ├── controller/                          # REST-API Controller
│   │   │   │   ├── FilmController.java
│   │   │   │   ├── GastController.java
│   │   │   │   ├── GenericController.java           # Generischer Controller
│   │   │   │   ├── SaalController.java
│   │   │   │   ├── TicketController.java
│   │   │   │   └── VorstellungController.java
│   │   │   ├── models/                              # Entitätsklassen
│   │   │   │   ├── Film.java
│   │   │   │   ├── Gast.java
│   │   │   │   ├── GenericEntity.java               # Interface für Entitäten
│   │   │   │   ├── Saal.java
│   │   │   │   ├── Ticket.java
│   │   │   │   └── Vorstellung.java
│   │   │   ├── repository/                          # Datenzugriffs-Layer
│   │   │   │   ├── FilmRepository.java
│   │   │   │   ├── GastRepository.java
│   │   │   │   ├── GenericRepository.java           # Generisches Repository
│   │   │   │   ├── SaalRepository.java
│   │   │   │   ├── TicketRepository.java
│   │   │   │   └── VorstellungRepository.java
│   │   │   └── services/                            # Service-Layer
│   │   │       └── GenericService.java              # Generischer Service
│   │   └── resources/
│   │       └── application.properties               # Anwendungskonfiguration
│   └── test/
│       └── java/com/example/ha_web_deployment_2/
│           └── HaWebDeployment2ApplicationTests.java # Test-Klasse
└── .idea/                                # IDE-Konfiguration
```

## Installation und Start
1. Klonen Sie das Repository
2. Konfigurieren Sie die Datenbankverbindung in `application.properties`
3. Führen Sie `mvn clean install` aus
4. Starten Sie die Anwendung mit `mvn spring-boot:run`

Die API ist dann unter `http://localhost:8080/api/` erreichbar.

## Wichtige Konfigurationsschritte für Apache NetBeans

Um das Projekt in Apache NetBeans korrekt als Spring Boot-Anwendung auszuführen, befolgen Sie die folgenden Schritte:

1. **Maven Build und Clean durchführen:**
   - Rechtsklick auf das Projekt
   - Wählen Sie "Clean and Build" oder führen Sie Maven-Goals `clean install` aus

2. **JDK 21 konfigurieren:**
   - Rechtsklick auf das Projekt
   - Wählen Sie "Properties" (Eigenschaften)
   - Gehen Sie zu "Build" > "Compile"
   - Stellen Sie sicher, dass JDK 21 als Java-Plattform ausgewählt ist

3. **Hauptklasse konfigurieren:**
   - Rechtsklick auf das Projekt
   - Wählen Sie "Properties" (Eigenschaften)
   - Gehen Sie zu "Run"
   - Setzen Sie als Main Class: `com.example.ha_web_deployment_2.HaWebDeployment2Application`