# next_ubs

## List the UBSs closest to a given point

This project presents an REST API that lists the UBSs closest to a chosen coordinate.

## Running the project

-After importing the project, change the <b>application.properties</b> file to connect to your MySQL database:
```bash
spring.datasource.url=your_connection_url
```

-Run the NextubsApplication class in the <b>br.com.nextubs</b> package to create Ubs Table.

-Import [UBSs csv file](https://dados.gov.br/dataset/unidades-basicas-de-saude-ubs) to UBS table (It is recommended to use Workbench Table Wizard)

-Finally the API is ready to use

## Documentation

The documentation was built using Swagger. To access the complete documentation of models and endpoints just access:
```bash
http://base_url_application/swagger-ui.html
```

## Run Tests

To run the application tests, just go to NextubsApplicationTests class in the <b>src/test/java</b> and run using JUnit
