# COVID-19 India REST API

We are using Indian Govt. official website (https://www.mygov.in/covid-19/) to load the data. In Every hour in
UTC timezone, App has scheduler which will refresh the data from the source.

We are using web-scraping (https://en.wikipedia.org/wiki/Web_scraping) technique to get the required information
from the website.

## Development and Deployment

For local development and deployment. Please follow [HELP.md](HELP.md).

> Note: As of now, app provides information for India.

## Supported country and state  
Supported [location](LOCATION.md). 

### 1. Get the latest stats for country
> /api/covid/countries-stats/{countryCode}
```bash
curl -v https://rout.dev/api/covid/countries-stats?countryCode=IN
``` 


### 2. Get the historical stats for country
> /api/covid/countries-stats?countryCode=IN 
```bash
curl -v https://rout.dev/api/covid/countries-stats?countryCode=IN
```

### 3. Get the latest stats for state
> /api/covid/states-stats/{stateCode}
```bash
curl -v https://rout.dev/api/covid/states-stats/DL
```

### 4. Get the historical stats for state
> /api/covid/states-stats?stateCode=DL
```bash
curl -v https://rout.dev/api/covid/states-stats?stateCode=DL
```

### 5. Get the historical stats for country's states
> /api/covid/states-stats?countryCode=IN
```bash
curl -v https://rout.dev/api/covid/states-stats?countryCode=IN
```