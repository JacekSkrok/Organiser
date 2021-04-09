# DefaultApi

All URIs are relative to *http://orgap.pl*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMeetings**](DefaultApi.md#getMeetings) | **GET** /user/{id}/meeting | Getting meetings list.
[**getSingleMeeting**](DefaultApi.md#getSingleMeeting) | **GET** /user/{id}/meeting/{meeting_id} | Getting single meeting
[**postAuthenticate**](DefaultApi.md#postAuthenticate) | **POST** /authenticate | Authenticate user
[**postMeeting**](DefaultApi.md#postMeeting) | **POST** /user/{id}/meeting | Add meeting.
[**postUser**](DefaultApi.md#postUser) | **POST** /user | Register user


<a name="getMeetings"></a>
# **getMeetings**
> List&lt;MeetingList&gt; getMeetings(id, limit, offset, search)

Getting meetings list.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
Integer id = 56; // Integer | User id
Integer limit = 56; // Integer | Number of records to return
Integer offset = 56; // Integer | Initial index of records to return
String search = "search_example"; // String | Phrase to search
try {
    List<MeetingList> result = apiInstance.getMeetings(id, limit, offset, search);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getMeetings");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| User id |
 **limit** | **Integer**| Number of records to return |
 **offset** | **Integer**| Initial index of records to return |
 **search** | **String**| Phrase to search | [optional]

### Return type

[**List&lt;MeetingList&gt;**](MeetingList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getSingleMeeting"></a>
# **getSingleMeeting**
> Meeting getSingleMeeting(id, meetingId)

Getting single meeting

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
Integer id = 56; // Integer | User id
Integer meetingId = 56; // Integer | Id of a single meeting
try {
    Meeting result = apiInstance.getSingleMeeting(id, meetingId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getSingleMeeting");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| User id |
 **meetingId** | **Integer**| Id of a single meeting |

### Return type

[**Meeting**](Meeting.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postAuthenticate"></a>
# **postAuthenticate**
> User postAuthenticate(body)

Authenticate user

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
AuthenticationRequest body = new AuthenticationRequest(); // AuthenticationRequest | Credentials data.
try {
    User result = apiInstance.postAuthenticate(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#postAuthenticate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**AuthenticationRequest**](AuthenticationRequest.md)| Credentials data. |

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postMeeting"></a>
# **postMeeting**
> Meeting postMeeting(id, body)

Add meeting.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
Integer id = 56; // Integer | User id
Meeting body = new Meeting(); // Meeting | New meeting data
try {
    Meeting result = apiInstance.postMeeting(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#postMeeting");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| User id |
 **body** | [**Meeting**](Meeting.md)| New meeting data |

### Return type

[**Meeting**](Meeting.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postUser"></a>
# **postUser**
> User postUser(body)

Register user

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
RegisterUserRequest body = new RegisterUserRequest(); // RegisterUserRequest | New user data
try {
    User result = apiInstance.postUser(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#postUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**RegisterUserRequest**](RegisterUserRequest.md)| New user data |

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

