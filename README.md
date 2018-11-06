##SME TEST

Application to make web-scrapping based on REST services

- Ports:
    - 8080 -> Web port

- Build:

    You can choose to use the included maven distribution or use a local maven installation
    
    - Using embedded maven:
    
    1) Verify that docker is running: 
    
        ```docker ps``` or ```docker version```
    
    2) On the root of the project execute
    
        ```./mvnw clean package install dockerfile:build```
    
        This will create the image.
    
    3) Verify the image with 
    
        ```docker images```
        
        You should see ```hcastro/sme-test:latest``` in the list
        
    4) Mount container with
        
        ```docker run -d -p 8080:8080 -t hcastro/sme-test:latest```
        
        The parameter -p sets a local port to the container. Be sure to pick one available local port.
        
    5) Go to ```localhost:8080/sme/health``` to check if the application is running

- Paths:

    - Server path: ```BASE_URL/sme```
    - Health path: ```BASE_URL/sme/health```
    - Swagger UI: ```BASE_URL/sme/swagger-ui.html```
    - POST input: ```BASE_URL/sme/analyze/```
    - File input file: ```BASE_URL/sme/analyze/file```

For information about params and responses check the swagger-ui documentation.
    
