package B6R5EduardoGuerrero.B6R5EduardoGuerrero.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SoapConfig {
    @Bean
    public XsdSchema surchargeSchema() {
        return new SimpleXsdSchema(new ClassPathResource("surcharge.xsd"));
    }

    @Bean(name = "surcharge")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema surchargeSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("SurchargePort");
        definition.setTargetNamespace("http://www.javacodegeeks.org/webservices/soap/surcharge/generated");
        definition.setLocationUri("/ws");
        definition.setSchema(surchargeSchema);
        return definition;
    }

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
    }

}