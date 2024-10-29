# Currency Exchange Application

This repository contains a Currency Exchange application built with a Java-based backend and an Angular frontend. The purpose of this application is to enable users to check current exchange rates for selected currencies and view past queries stored in the system.

## Project Structure

- **Backend:** Java (Spring), Gradle - Groovy, Java 17
- **Frontend:** Angular 17

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
  - [Backend Setup](#backend-setup)
  - [Frontend Setup](#frontend-setup)
- [Usage](#usage)
  - [Endpoints](#endpoints)
- [Frontend User Guide](#frontend-user-guide)
- [License](#license)

## Overview

The Java Backend serves as the core engine for handling currency exchange rate requests and managing historical data. It fetches exchange rates, processes user requests, and records them for future reference.

The Angular Frontend is a user interface where users can:
- Input a currency and a name to fetch the current exchange rate.
- View the result of the exchange rate and past requests they made.
- See an accessible history of requests showing who queried for which currency and the rate received at that time.

## Features

### Java Backend
- **Retrieve Current Exchange Rates:** The backend provides current exchange rates for supported currencies.
- **Track Exchange Requests:** Each request made for a currency exchange rate is logged, capturing the requested currency, user name, and timestamp.
- **API Endpoints:**
  - Fetch current exchange rate for a given currency.
  - Retrieve a list of all past exchange rate requests.

### Angular Frontend
- **User Input:** Allows users to select a currency and enter their name to check the current exchange rate.
- **Display Exchange Rates:** Shows the current exchange rate for the requested currency.
- **Request History:** Displays a history of all previous requests with information on currency, requester, request date, and exchange rate.

## Technologies Used

### Backend:
- Java 17
- Spring (for API development)
- RESTful APIs
- Database (MySQL 8)

### Frontend:
- Angular 17
- HTML, CSS, and TypeScript

## Setup and Installation

### Backend Setup

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/sduranowski1/nbp_api.git
   cd nbp_api/api

2. **Configure Database:** Update application.properties with database credentials.

3. **Run the Application:**

    ```bash
    ./gradlew bootRun
    
### Endpoints

 - POST /currencies/get-current-currency-value-command: Retrieves the exchange rate for a given currency.
 - GET /currencies/requests: Fetches stored requests for historical purposes.

### Frontend Setup
1. **Navigate to the Frontend Folder:**

    ```bash
    cd nbp_api/frontend

2. **Install Dependencies:**

    ```bash
    npm install

3. **Run the Application:**

    ```bash
    ng serve

4. **Access the Application: Open http://localhost:4200.**

## Usage

### Endpoints
1. **POST /currencies/get-current-currency-value-command**

- Description: Fetches the current exchange rate for the specified currency.
- Parameters: { "currency": "USD", "name": "John Doe" }
- Response:

    ```json
    {
      "currency": "USD",
      "rate": 4.22,
      "requesterName": "John Doe",
      "requestDate": "2024-10-28T10:00:00"
    }
    
2. **GET /currencies/requests**

- Description: Returns a list of all recorded currency exchange requests.
- Response:

     ```json
    [
      {
        "id": 1,
        "currency": "GBP",
        "requesterName": "Jan Kowalski",
        "rate": 5.2188,
        "requestDate": "2024-10-28T10:27:51"
      },
      {
        "id": 2,
        "currency": "USD",
        "requesterName": "John Doe",
        "rate": 4.0219,
        "requestDate": "2024-10-28T10:42:21"
      }
    ]
    
## Frontend User Guide
- Currency Input: Enter a currency code and a name to request the current exchange rate.
- Exchange Rate Display: Shows the exchange rate for the entered currency.
- Request History: Displays previous requests with currency, requester name, date, and rate.