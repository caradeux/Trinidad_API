package base;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAPIPage {
    private String baseUrl;
    private ExtentTest extentTest;

    public RestAPIPage(String baseUrl, ExtentTest extentTest) {
        this.baseUrl = baseUrl;
        this.extentTest = extentTest;
    }

    public Response sendGetRequest(String endpoint) {
        extentTest.log(Status.INFO, "Enviando GET a: " + endpoint);
        Response response = RestAssured.get(baseUrl + endpoint);
        extentTest.log(Status.INFO, "Respuesta: " + response.getBody().asString());
        return response;
    }

    public Response sendPostRequest(String endpoint, String requestBody) {
        extentTest.log(Status.INFO, "Enviando POST: " + endpoint);
        extentTest.log(Status.INFO, "Solicitud Body: " + requestBody);
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post(baseUrl + endpoint);
        extentTest.log(Status.INFO, "Respuesta: " + response.getBody().asString());
        return response;
    }

    public Response sendPutRequest(String endpoint, String requestBody) {
        extentTest.log(Status.INFO, "Enviando PUT: " + endpoint);
        extentTest.log(Status.INFO, "Solicitud Body: " + requestBody);
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .put(baseUrl + endpoint);
        extentTest.log(Status.INFO, "Respuesta: " + response.getBody().asString());
        return response;
    }

    public Response sendDeleteRequest(String endpoint) {
        extentTest.log(Status.INFO, "Enviando DELETE: " + endpoint);
        Response response = RestAssured.delete(baseUrl + endpoint);
        extentTest.log(Status.INFO, "Respuesta: " + response.getBody().asString());
        return response;
    }

    public void validarResponse(Response response, int expectedStatusCode) {
        int statusCode = response.getStatusCode();
        extentTest.log(Status.INFO, "Validando Codigo de Respuesta " + expectedStatusCode
                + ", Actual status code: " + statusCode);
        if (statusCode == expectedStatusCode) {
            extentTest.log(Status.PASS, "Validación de Respuesta Exitosa :"+statusCode);
        } else {
            extentTest.log(Status.FAIL, "Validación de Respuesta Erronea :"+statusCode);
        }
    }
}
