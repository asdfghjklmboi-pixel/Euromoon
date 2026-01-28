#PROJECT 
korte uitleg over mijn trein applicatie en welke klassen
ik heb geïmplementeerd. De applicatie laat toe om passagiers te registreren, reizen aan te
maken, treinen toe te wijzen en tickets te verkopen met controle op capaciteit en reisklasse.
#Personen
De abstracte klasse Person vormt de basisklasse waarmee we alle personen in het systeem
kunnen beschrijven met algemene persoonsgegevens. De Passenger klasse is een
extensie van de Person klasse en stelt een persoon voor die tickets kan kopen. Employee is
ook een extensie van de Person klasse, maar is zelf ook een abstracte klasse voor het
beschrijven van personeelsleden en vormt de basis voor specifieke rollen. Driver, Steward
en LuggageStaff zijn extensies van de Employee klasse met specifieke rollen zoals het
besturen van de trein, behandelen van bagage, etc.
#Trein & reis
De klasse Trip wordt gebruikt om een treinrit te definiëren met een vertrekstation,
aankomststation en een tijdstip voor vertrek. De klasse Trein stelt een trein voor die bestaat
uit een locomotief, wagons en verkochte tickets. Met deze klasse kunnen wij ook de
capaciteit controleren. De abstracte klasse Locomotive bepaalt de maximale capaciteit en
het maximum aantal wagons dat een trein heeft. De klassen Type A en Type B zijn
extensies van de klasse Locomotive met een verschillend maximum aantal wagons. De
wagon klasse stelt een deel van een trein voor.
#Tickets
De klasse Ticket verbindt een passagier met een specifieke reis en een specifieke
reisklasse die wordt gedefinieerd door de enum Travel Class.
#Main
De klasse Menu bevat de overkoepelende Main-methode en voorziet een consolemenu
waarmee alle functionaliteiten van de applicatie gebruikt kunnen worden.
#Referenties
- W3Schools
https://www.w3schools.com/java/
- Stack Overflow
https://stackoverflow.com/questions
- Coding with John (YouTube)
https://www.youtube.com/@CodingWithJohn
- Cursusmateriaal en hoorcolleges
