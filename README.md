# MCP Order Server (Spring Boot + Spring AI + Ollama local)

## Prérequis
- Java 17
- Maven
- Ollama installé et modèle `mistral` disponible localement (ex: `ollama pull mistral`)

## Lancer Ollama (si pas déjà)
```bash
ollama run mistral
```

## Lancer l'application
```bash
mvn spring-boot:run
```

## Tester l'exemple
```bash
curl -X POST http://localhost:8080/api/chat/ask -H "Content-Type: text/plain" -d "Donne-moi les détails de la commande ORD-1001"
```

Notes:
- Les annotations `@Tool` et `@ToolParam` peuvent varier selon la version de Spring AI. Adapte les imports si nécessaire.
- Ajuste `pom.xml` si Maven Central propose une autre version de `spring-ai`.
