package lt.viko.eif.vvasylieva.soap.soapdemo.WebService;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * This class configures the Hospital web service by setting up the HospitalService, message dispatcher servlet,
 * default WSDL 1.1 definition, and XSD schema.
 */
@EnableWs
@Configuration
@ComponentScan(basePackages = "lt.viko.eif.vvasylieva.soap.soapdemo.WebService")
public class WebServiceConfig extends WsConfigurerAdapter {

	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet() {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(servlet, "/ws/*");
	}

	@Bean(name = "account")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema accountSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("AccountPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://eif.viko.lt/vvasylieva/springsoap/gen");
		wsdl11Definition.setSchema(accountSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema accountSchema() {
		return new SimpleXsdSchema(new ClassPathResource("account.xsd"));
	}
}