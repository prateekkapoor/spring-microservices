# Spring Cloud Function demo

## Exposed Functions as Endpoints
- *Supplier* - `/supply` - returns an output

```
curl -H 'Content-Type: text/plain' http://localhost:5000/supplier
```

- *Consumer* - `/consume` - expects an input

```
curl -H 'Content-Type: text/plain' http://localhost:5000/consumer -d 'First Demo'
```

- *Function* - `/function` - expects an input and output
```
curl  -H 'Content-Type: text/plain' http://localhost:5000/upperCase -d 'Hello cloud function'
```

- *Function* - `/first` - expects an input and output
```                                                                                        
curl -H 'Content-Type: text/plain' http://localhost:5000/first -d 'First Cloud function'

```