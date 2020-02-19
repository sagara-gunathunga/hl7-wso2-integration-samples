/*
 *  Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package samples.hl7.hl7backend;

import ca.uhn.hl7v2.AcknowledgmentCode;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Application;
import ca.uhn.hl7v2.app.ApplicationException;
import ca.uhn.hl7v2.app.DefaultApplication;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.parser.PipeParser;

import java.io.IOException;
import java.util.Random;

public class SampleApp implements Application {

    public boolean canProcess(Message theIn) {
        return true;
    }


    /**
     * {@inheritDoc}
     */
    public Message processMessage(Message theIn) throws ApplicationException, HL7Exception {

        String encodedMessage = new PipeParser().encode(theIn);
        System.out.println("Received message:\n" + encodedMessage + "\n\n");

        Message retVal;
        try {

            Random randomno = new Random();
            boolean nextBoolean = randomno.nextBoolean();

            if (nextBoolean) {
                System.out.println("Generating ACK ...");
                retVal = theIn.generateACK();
            } else {
                System.out.println("Generating NCK ...");
                retVal = theIn.generateACK(AcknowledgmentCode.AE, new HL7Exception("Not Available"));
            }
            String res = new PipeParser().encode(retVal.get("MSH").getParent().getMessage());
            System.out.println("Response message:\n" + res + "\n\n");
        } catch (IOException e) {
            throw new HL7Exception(e);
        }
        return retVal;
    }

}
