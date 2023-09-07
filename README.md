# Vollapi
This api just was created for purpose of study, it's a simple api that can be used to create, read, update and delete doctors through a rest architecture.

## Run Locally

- Clone the project

```bash
  git clone git@github.com:MaxC0d3/voll-api.git
```

If you don't have a ssh key, can use **http method**.

```bash
  git clone https://github.com/MaxC0d3/voll-api.git
```


- Go to the project directory

```bash
  cd voll-api
```

Install dependencies. Make sure you've maven installed

```bash
  mvn package 
```

Start the server 😁


## Usage

I am currently using Postman for http requests. U can install this software on the page: [postman](https://www.postman.com/)

Once you have installed postman or anything else software for request http, you may continue.


- [Get all doctors](#Get-all-doctors)
- [Get a doctor by id](#Get-a-doctor-by-id)
- [Create a doctor](#Create-a-doctor)
- [Update a doctor data](#Update-a-doctor-data)

#### Get all doctors

You've to request a GET method to this URL

```bash
  http://localhost:8080/medico
```

Currently this url accepts query params, those params are:

- sort=conditionToSort
- offset
- size
- totalPages
- totalElements

This is an example of the use of query parameters for the url get:

```bash
  http://localhost:8080/medico?size=2&sort=name
```

#### Get a doctor by id

```bash
  http://localhost:8080/medico/ID
```


#### Create a doctor

First of all, this is the json to create a doctor

```json
{
    "name": "Erick Cardenas",
    "email": "Erick.Cardenas@voll.med",
    "document": "615342",
    "telephone": "345123435",
    "specialty": "CARDIOLOGIST",
    "dataDirection": {
        "state": "State 2",
        "city": "City 2",
        "number": 2,
        "complement": "b",
        "street": "Cl 13 45"
    } 
}
```

#### Update a doctor data

You must pass the id of the doctor u wanna update through the json, and the data you're gonna change. *U can only change the values: email, telephone, address.*

```json
  {
  "id": 1,
  "email": "email@voll.med",
  "telephone": "345123435",
  "dataDirection": {
    "state": "New state",
    "city": "City",
    "number": 132,
    "complement": "b2",
    "street": "Cl 13 45 # 11"
  }
}
```

## Tech Stack

I used the following technologies: java, spring boot, flywaydb, mysql, lombok, hibernate
