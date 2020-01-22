# Mediation from REST/JSON to HL7/LLMP and back.  [WIP Sample] 


A frontend application send a JSON message over HTTP transport and WSO2 EI convert the 
message into a HL7 format and send to a HL7 backend application over MLLP protocol. 
Once the backend application acknowledged, WSO2 EI again convert HL7  acknowledgment 
into JSON format and return to the frontend over HTTP. 

## Prerequisites

* Build and run the sample backends and integration flows as described  [here.]
(https://github.com/sagara-gunathunga/hl7-wso2-integration-samples/blob/master/hl7-integration-sample/README.md#how-to-build)



## How to Test



* Make a RESTfull call 


```

curl http://localhost:8290/health/hello 
```


* The HTTP client should show the following JSON response. 

```

{
   "message" : {
      "ACK" : {
         "MSA" : {
            "MSA.2" : 3101,
            "MSA.1" : "AA"
         },
         "MSH" : {
            "MSH.11" : {
               "PT.1" : "T"
            },
            "MSH.9" : {
               "MSG.1" : "ACK",
               "MSG.2" : "A01"
            },
            "MSH.10" : 4956,
            "MSH.2" : "^~\\&",
            "MSH.1" : "|",
            "MSH.12" : {
               "VID.1" : 2.4
            },
            "MSH.7" : {
               "TS.1" : "20200123100606.997+1300"
            }
         }
      }
   }
}


```

 


