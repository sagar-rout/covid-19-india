# COVID-19 India REST API

We are using Indian Govt. official website (https://www.mygov.in/covid-19/) to load the data. In Every hour in
UTC timezone, App has scheduler which will refresh the data from the source.

We are using web-scraping (https://en.wikipedia.org/wiki/Web_scraping) technique to get the required information
from the website.

## As of now, we are providing few endpoints :

### 1. Register yourself and get access token

POST /users 

> Request Body
```json
{
  "emailId" : "john@doe.com",
  "purpose" : "data analytics"
}
```  

> Response
```json
 {
   "id" : "47422e0a-b219-4521-829c-7d9e81c2cfb7",
   "emailId" : "john@doe.com",
   "accessToken" : "X5SJ4VRNaSRObmn1dd",
   "purpose" : "data analytics"
 }
 ```

### 2. Use access token to get your information

GET /users?emailId=john@doe.com

> Response
```json
 {
   "id" : "47422e0a-b219-4521-829c-7d9e81c2cfb7",
   "emailId" : "john@doe.com",
   "accessToken" : "X5SJ4VRNaSRObmn1dd",
   "purpose" : "data analytics"
 }
```