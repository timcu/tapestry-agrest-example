# tapestry-agrest-example
Proof of concept for integrating tapestry, cayenne, tapestry-resteasy, agrest

To run application

    mvn jetty:run

## Example URLs

- http://localhost:8089/tapestry-agrest-example/  # Tapestry demo home page
- http://localhost:8089/tapestry-agrest-example/about  # Display data from database in Tapestry web page
- http://localhost:8089/tapestry-agrest-example/rest/mydomainobject  # REST results using tapestry-resteasy
- http://localhost:8089/tapestry-agrest-example/rest/category  # REST results using tapestry-resteasy and cayenne, 
- http://localhost:8089/tapestry-agrest-example/rest/book  # REST results using tapestry-resteasy and cayenne and agrest  # TODO fixme

## References

- Agrest example based on https://github.com/agrestio/agrest-bookstore-example
- tapestry-resteasy issue https://github.com/tynamo/tapestry-resteasy/issues/19
