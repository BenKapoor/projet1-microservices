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
 - hystrix
    - dans la main @EnableHystrixDashboard
    - dans application.properties server.port = 9999
    - dépendance hystrix dashboard
    - dans application.properties des microservice à monitorer :
        - management.endpoints.web.exposure.include=hystrix.stream
        - hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=2000
        - @EnableHystrix dans le main
        - http://localhost:8888/actuator/hystrix.stream permet de check si ça fonctionne dans le microservcie gateway par exemple (port 8888)
    - http://localhost:9999/hystrix => ajouter l’adresse du service monitoré ex: http://localhost:8888/actuator/hystrix.stream



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
