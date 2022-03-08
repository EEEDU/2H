package B6R5EduardoGuerrero.B6R5EduardoGuerrero.endpoint;

import org.javacodegeeks.webservices.soap.surcharge.generated.SurchargeRequest;
import org.javacodegeeks.webservices.soap.surcharge.generated.SurchargeResponse;
import org.javacodegeeks.webservices.soap.surcharge.service.SurchargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SurchargeEndpoint {

    @Autowired
    SurchargeService service;

    @PayloadRoot(namespace = "http://www.javacodegeeks.org/webservices/soap/surcharge/generated", localPart = "SurchargeRequest")
    @ResponsePayload
    public SurchargeResponse processCourseDetailsRequest(@RequestPayload SurchargeRequest request) {

        SurchargeResponse response = new SurchargeResponse();

        int surcharge = service.calculateSurcharge(request.getOrder());
        response.setSurcharge(surcharge);

        return response;
    }

}