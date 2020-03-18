# Convert simple JSON message in to HL7 FHIR format and deliver to a destination




A frontend application send a JSON message over HTTP transport and WSO2 EI convert the 
message into a HL7 FHIR format and send to a backend application over HTTP protocol. 


## Prerequisites

* Build and run the sample backends and integration flows as described  [here.](https://github.com/sagara-gunathunga/hl7-wso2-integration-samples/blob/master/README.md#how-to-build)




## How to Test



* Make a RESTfull call 


1. Add a patient 
```shell
curl -XPOST -H "Content-type: application/json" -d '{"id":"123", "givenname":"John", "familyname":"Doe", "gender":"M", "dob":"30-06-1989","active":"Active"}' http://localhost:8290/FIHR/Patient
```

2. get a specific patient 
```shell
curl http://localhost:8290/FIHR/Patient/173



* The HTTP client should show the following JSON response. 

```

{
                    "resourceType": "Patient",  "id" : "811",  "meta" : {    "versionId" : "1.0"},
                    "identifier": [
                      {  "use": "usual",      "label": "MRN",
                         "system": "http://www.goodhealth.org/identifiers/mrn",
                         "value": "123456"    }
                                 ],
                      "name": [
                           {  "family": [""],
                               "given": [""],
                                "suffix": [""]
                            }  ],
                       "gender": {"text": ""},
                       "birthDate": "",
                       "active": ''}


```

 


