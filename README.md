# projet1-microservices
Projet réalisé la semaine du 15/06 Formateur Eddy java microservice (gateway+ eureka + metiers )

Dependance des micros services :
- services métiers
    - spring boot dev tools
    - spring boot actuator
    - spring data jpa
    - mysql server
    - eureka discovery client
    - spring web
- gateway
    - spring boot actuator
    - hystrix [maintenance]
    - erekar discovery client
    - gateway
- eureka
    - eureka server

Méthodologie :
services métiers:
- créer un micro service inventory-service
- configurer le fichier application.properties
- domaine créer une classe Produit (id, name, price, description)
- service : addProduit(Produit p), List<Produit> findAll(), Produit getProduit(Long id)
- écrire le controller correspondant
- configurer le microservice et le déployer dans le microservice annuaire
- au niveau du microservice getway, rajouter le chemin vers ce nouveau micro service
- tester depuis le client qu'on peut bien atteindre le micro service
