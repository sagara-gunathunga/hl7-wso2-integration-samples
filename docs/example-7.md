# Convert HL7 2.3 message format in to HL7 2.4 format and deliver to a destination.


A frontend application send a HL7 2.3 message and WSO2 EI convert the 
message into a HL7 2.4 format and send to a HL7 backend application over MLLP protocol. 
Once the backend application acknowledged, WSO2 EI again convert HL7 2.4 acknowledgment 
back into HL7 2.3 format and return to the frontend. 

## Prerequisites

* Build and run the sample backends and integration flows as described  [here.](https://github.com/sagara-gunathunga/hl7-wso2-integration-samples/blob/master/README.md#how-to-build)




## How to Test



* Start HAPI TestPanel and create a new connection for port 9595 and send a HL7 2.3 message.



* In case if you have used receiving connection in the HAPI TestPanel, you should able to see the received message in the HAPI TestPanel in HL7 2.4 format; otherwise, if you have used provided test backend, you should able to see received messages in the server console

