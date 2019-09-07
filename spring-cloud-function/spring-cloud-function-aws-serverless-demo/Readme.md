# Spring Cloud Function using AWS Adapter example

## Exposed Function as API Endpoint using AWS API Gateway
`First.java` is exposed as function to the AWS Request Handler using `SpringBootRequestHandler`.
`APIGatewayProxyRequestEvent` is the input object and `APIGatewayProxyResponseEvent` is the response object.

### Command used:

https://sq94h7zkd6.execute-api.us-east-1.amazonaws.com/dev/getFirst
```