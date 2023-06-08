package base;
import io.restassured.RestAssured; 
import io.restassured.response.Response; 
 
public class SOAPClient { 
    private static final String SOAP_ENDPOINT = "/soap/endpoint"; 
 
    public static Response sendSOAPRequest(String soapRequest, String request) {
        return RestAssured.given() 
                .contentType("text/xml") 
                .body(soapRequest) 
                .post(SOAP_ENDPOINT); 
    }
}
