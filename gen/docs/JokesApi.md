# JokesApi

All URIs are relative to *https://api.chucknorris.io*

Method | HTTP request | Description
------------- | ------------- | -------------
[**jokesRandomGet**](JokesApi.md#jokesRandomGet) | **GET** /jokes/random | Get random Chuck joke


<a name="jokesRandomGet"></a>
# **jokesRandomGet**
> Joke jokesRandomGet()

Get random Chuck joke

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.JokesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.chucknorris.io");

    JokesApi apiInstance = new JokesApi(defaultClient);
    try {
      Joke result = apiInstance.jokesRandomGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling JokesApi#jokesRandomGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Joke**](Joke.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

