# COVID-19 India REST API

We are using Indian Govt. official website (https://www.mygov.in/covid-19/) to load the data. In Every hour in
UTC timezone, App has scheduler which will refresh the data from the source.

We are using web-scraping (https://en.wikipedia.org/wiki/Web_scraping) technique to get the required information
from the website.

## Deployment strategy

We are bit lazy, so we are using docker to wrap our application. Please refer [maven.yml](.github/workflows/maven.yml).


## As of now, we are providing few endpoints :

### 1. Get country stats 