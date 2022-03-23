package B6R5EduardoGuerrero.B6R5EduardoGuerrero.service;

import org.javacodegeeks.webservices.soap.surcharge.generated.SurchargeRequest.Order;
import org.springframework.stereotype.Component;

@Component
public class SurchargeService {

    public int calculateSurcharge(Order order) {

        int surcharge = 15;
        if (order.getCustomer().getAddress().getCountry().equals("US"))
            surcharge = 10;

        if (order.getPaymentMethod().equals("CC"))
            surcharge += 3;

        if (order.getValue() > 1000)
            surcharge -= 1;

        return surcharge;
    }
}