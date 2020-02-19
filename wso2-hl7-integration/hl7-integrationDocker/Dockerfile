FROM wso2/micro-integrator:latest
COPY target/CompositeApps/*.car /home/wso2carbon/wso2mi/repository/deployment/server/carbonapps/
COPY conf/internal-apis.xml /home/wso2carbon/wso2mi/conf/internal-apis.xml
COPY conf/deployment.toml /home/wso2carbon/wso2mi/conf/deployment.toml
COPY target/lib/*.jar /home/wso2carbon/wso2mi/lib/
COPY lib/*.jar /home/wso2carbon/wso2mi/lib/
ENV HL7_BE_URL=hl7://host.docker.internal:9989
