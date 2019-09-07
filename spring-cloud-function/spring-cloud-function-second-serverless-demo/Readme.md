# Spring Cloud Function using AWS Adapter example

## Exposed Function as API Endpoint using AWS API Gateway
`First.java` is exposed as function to the AWS Request Handler using `SpringBootRequestHandler`.
`APIGatewayProxyRequestEvent` is the input object and `APIGatewayProxyResponseEvent` is the response object.

### Command used:

curl -X POST -H 'Content-Type: application/json' https://ix1y5b2j3l.execute-api.us-east-1.amazonaws.com/dev/upperCase -d '
{
"greetings": "hello world"
}'
```