# RestChallenge
Simple json Rest webservice biult with jersey  that accepts Json as input and return JSON as the response
The webservice Implemets the following methods

1. PUT
2. POST
3. GET

## SETUP

This  is  a maven  project that  can be complied with Netbeans and run From Glassfish 4.1 or APACHE-TOMCAT

### Usage

| URL                                             | METHOD  | DATA  |
| ----------------------------------------------- |:-------:| -----:|
| http://localhost:8080/api/apiv1/customer/create| POST|{"cusomer_limit":50000.0,"customer_account_no":"001123547889Z","customer_name":"Lewis"} |
| http://localhost:8080/api/apiv1/customer/edit| PUT|{"cusomer_limit":50000.0,"customer_account_no":"001123547889Z","customer_name":"Lewis"} |
| http://localhost:8080/api/apiv1/customer/list |GET|{"cusomer_limit":50000.0,"customer_account_no":"001123547889Z","customer_id":"DAC789","customer_name":"Lewis Munene"}  |



### Authorization 
Use basic Authorization 

password :1234
username :lewis


