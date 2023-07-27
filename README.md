# Basic Customer API

#### This API is intended to use in my OpenTelemetry POC project.

The Customer API will return the following JSON:

```json
{
    "name": "John",
    "lastName": "Doe",
    "walmartID": "12345asda"
}
```

depending on the customerID sent by the query param.

The request can be made like this:

```bash
curl --request GET \
--url 'http://localhost:8080/api/customer?walmartID=12345asda'
```