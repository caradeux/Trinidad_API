package com.example.tests;

import base.RestAPIPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import util.ExtentReportManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.System.getProperty;


public class APITests {
    private static final String SOAP_REQUEST_FILE_1 = "src/test/resources/Request_PortalCESMobile.xml";
    private static final String SOAP_REQUEST_FILE_2 = "src/test/resources/Servicio_Registro_Pago.xml";
    private static final String SOAP_REQUEST_FILE_3 = "src/test/resources/Servicio_Obtener_Deuda.xml";
    private static final String SOAP_REQUEST_FILE_4 = "src/test/resources/Servicio_EVA_Online.xml";
    private static final String SCREENSHOT_DIR ="src/test/capturas" ;

    private static ExtentTest extentTest;
    private static RestAPIPage restAPIPage;


    @BeforeClass
    public static void setup() {
        ExtentReportManager.setupExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");


    }

    @AfterClass
    public static void teardown() {

        ExtentReportManager.flushReports();

    }

    @Test
    public void test_ConsultaCuotaReq() {
        extentTest = ExtentReportManager.createTest("Servicio Consulta Cuota\n");
        String baseUrl = ConfigurationManager.getApiEndPoint();
        restAPIPage = new RestAPIPage(baseUrl, extentTest);


        String endpoint = ConfigurationManager.getApiNissanAdjudicación();
        String requestBody = getResourceAsString("ConsultaCuotaReq.json");


        // Realiza una solicitud POST y valida la respuesta
        Response response = restAPIPage.sendPostRequest(endpoint, requestBody);
        restAPIPage.validarResponse(response, 200);

        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();
        if (statusCode == 200) {
            ExtentReportManager.logPass(extentTest, "Codigo de Respuesta : " + statusCode);
            ExtentReportManager.logPass(extentTest, "Respuesta Correcta : " + responseBody);
        }
        else
        {
            ExtentReportManager.logFail(extentTest, "Codigo de Respuesta : " + statusCode);
            ExtentReportManager.logFail(extentTest, "Error en Respuesta : " + responseBody);
            extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath("img.png").build());
            extentTest.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());


        }

        ExtentReportManager.logSoapResponse(extentTest, response);
    }


    @Test
    public void test_NissanAdjudicacion() {
        extentTest = ExtentReportManager.createTest("Servicio Nissan Adjudicacion\n");
        String baseUrl = ConfigurationManager.getApiEndPoint();
        restAPIPage = new RestAPIPage(baseUrl, extentTest);


        String endpoint = ConfigurationManager.getApiNissanAdjudicación();
        String requestBody = getResourceAsString("NissanAdjudicacion.json");


        // Realiza una solicitud POST y valida la respuesta
        Response response = restAPIPage.sendPostRequest(endpoint, requestBody);
        restAPIPage.validarResponse(response, 200);

        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();
        if (statusCode == 200) {
            ExtentReportManager.logPass(extentTest, "Codigo de Respuesta : " + statusCode);
            ExtentReportManager.logPass(extentTest, "Respuesta Correcta : " + responseBody);
        }
        else
        {
            ExtentReportManager.logFail(extentTest, "Codigo de Respuesta : " + statusCode);
            ExtentReportManager.logFail(extentTest, "Error en Respuesta : " + responseBody);
            extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath("img.png").build());
            extentTest.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
        }

        ExtentReportManager.logSoapResponse(extentTest, response);
    }


    @Test
    public void test_ServicioSpider() {
        extentTest = ExtentReportManager.createTest("Servicio Spider\n");
        String baseUrl = ConfigurationManager.getApiEndPoint();
        restAPIPage = new RestAPIPage(baseUrl, extentTest);


        String endpoint = ConfigurationManager.getApiSpider();
        String requestBody = getResourceAsString("ServicioSpider.json");


        // Realiza una solicitud POST y valida la respuesta
        Response response = restAPIPage.sendPostRequest(endpoint, requestBody);
        restAPIPage.validarResponse(response, 200);

        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();
        if (statusCode == 200) {
            ExtentReportManager.logPass(extentTest, "Codigo de Respuesta : " + statusCode);
            ExtentReportManager.logPass(extentTest, "Respuesta Correcta : " + responseBody);
        }
        else
        {
            ExtentReportManager.logFail(extentTest, "Codigo de Respuesta : " + statusCode);
            ExtentReportManager.logFail(extentTest, "Error en Respuesta : " + responseBody);
            extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath("img.png").build());
            extentTest.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
        }

        ExtentReportManager.logSoapResponse(extentTest, response);
    }

    @Test
    public void test_ServicioPortalCES() {
        extentTest = ExtentReportManager.createTest("Servicio  Portal CES\n");
        String baseUrl = ConfigurationManager.getApiEndPoint();
        restAPIPage = new RestAPIPage(baseUrl, extentTest);


        String endpoint = ConfigurationManager.getApiPortalCES();
        String requestBody = getResourceAsString("PortalCES.json");


        // Realiza una solicitud POST y valida la respuesta
        Response response = restAPIPage.sendPostRequest(endpoint, requestBody);
        restAPIPage.validarResponse(response, 200);

        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();
        if (statusCode == 200) {
            ExtentReportManager.logPass(extentTest, "Codigo de Respuesta : " + statusCode);
            ExtentReportManager.logPass(extentTest, "Respuesta Correcta: " + responseBody);
        }
        else
        {
            ExtentReportManager.logFail(extentTest, "Codigo de Respuesta : " + statusCode);
            ExtentReportManager.logFail(extentTest, "Error en Respuesta: " + responseBody);
            extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath("img.png").build());
            extentTest.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
        }

        ExtentReportManager.logSoapResponse(extentTest, response);
    }


    @Test
    public void test_EvaOnline() throws IOException {
        extentTest = ExtentReportManager.createTest("Evaluacion Online\n");


        String soapRequest = new String(Files.readAllBytes(Path.of(SOAP_REQUEST_FILE_4)));


        String baseUrl = ConfigurationManager.getBaseUrl4();
        Response response = sendSOAPRequest(baseUrl, soapRequest);

        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();

        if (statusCode == 200) {
            ExtentReportManager.logPass(extentTest, "SOAP Codigo de Respuesta : " + statusCode);
            ExtentReportManager.logPass(extentTest, "SOAP request Correcto. Respuesta: " + responseBody);
        } else {
            ExtentReportManager.logFail(extentTest, "SOAP Codigo de Respuesta : " + statusCode);
            ExtentReportManager.logFail(extentTest, "SOAP request Error. Respuesta: " + responseBody);
            extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath("img.png").build());
            extentTest.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
        }

        ExtentReportManager.logSoapResponse(extentTest, response);
    }

    @Test
    public void test_PortalCESMobile() throws IOException {
        String soapRequest = new String(Files.readAllBytes(Path.of(SOAP_REQUEST_FILE_1)));
        extentTest = ExtentReportManager.createTest("Portal CES Mobile\n");

        String baseUrl = ConfigurationManager.getBaseUrl1();
        Response response = sendSOAPRequest(baseUrl, soapRequest);

        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();

        if (statusCode == 200) {
            ExtentReportManager.logPass(extentTest, "SOAP Codigo de Respuesta : " + statusCode);
            ExtentReportManager.logPass(extentTest, "SOAP request Correcto. Respuesta: " + responseBody);



        } else {
            ExtentReportManager.logFail(extentTest, "SOAP Codigo de Respuesta : " + statusCode);
            ExtentReportManager.logFail(extentTest, "SOAP request Error. Respuesta: " + responseBody);
            extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath("img.png").build());
            extentTest.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());


        }

        ExtentReportManager.logSoapResponse(extentTest, response);



    }

    @Test
    public void test_RegistroPago() throws IOException {
        String soapRequest = new String(Files.readAllBytes(Path.of(SOAP_REQUEST_FILE_2)));
        extentTest = ExtentReportManager.createTest("Servicio Registro Pago\n");

        String baseUrl = ConfigurationManager.getBaseUrl2();
        Response response = sendSOAPRequest(baseUrl, soapRequest);

        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();

        if (statusCode == 200) {
            ExtentReportManager.logPass(extentTest, "SOAP Codigo de Respuesta : " + statusCode);
            ExtentReportManager.logPass(extentTest, "SOAP request Correcto. Respuesta: " + responseBody);



        } else {
            ExtentReportManager.logFail(extentTest, "SOAP Codigo de Respuesta : " + statusCode);
            ExtentReportManager.logFail(extentTest, "SOAP request Error. Respuesta: " + responseBody);
            extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath("img.png").build());
            extentTest.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());


        }

        ExtentReportManager.logSoapResponse(extentTest, response);



    }

    @Test
    public void test_Servicio_Obtener_Deuda() throws IOException {
        String soapRequest = new String(Files.readAllBytes(Path.of(SOAP_REQUEST_FILE_3)));
        extentTest = ExtentReportManager.createTest("Servicio Obtener Deuda\n");

        String baseUrl = ConfigurationManager.getBaseUrl1();
        Response response = sendSOAPRequest(baseUrl, soapRequest);

        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();

        if (statusCode == 200) {
            ExtentReportManager.logPass(extentTest, "SOAP Codigo de Respuesta : " + statusCode);
            ExtentReportManager.logPass(extentTest, "SOAP request Correcto. Respuesta: " + responseBody);



        } else {
            ExtentReportManager.logFail(extentTest, "SOAP Codigo de Respuesta : " + statusCode);
            ExtentReportManager.logFail(extentTest, "SOAP request Error. Respuesta: " + responseBody);
            extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath("img.png").build());
            extentTest.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());


        }

        ExtentReportManager.logSoapResponse(extentTest, response);



    }

    private Response sendSOAPRequest(String baseUrl, String soapRequest) {
        return RestAssured.given()
                .baseUri(baseUrl)
                .contentType("text/xml")
                .body(soapRequest)
                .post("/endpoint");
    }

    private static String getResourceAsString(String resourceName) {
        try {
            return new String(Files.readAllBytes(Paths.get("src/test/resources/" + resourceName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String takeScreenshot(String screenshotName) throws IOException {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String screenshotPath = SCREENSHOT_DIR + screenshotName + "_" + timestamp + ".png";

        // Toma la captura de pantalla y guarda la imagen en la ubicación especificada
        // Puedes utilizar la biblioteca o método que prefieras para tomar la captura de pantalla

        // Por ejemplo, usando Selenium WebDriver:
        // WebDriver driver = new ChromeDriver();
        // File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Files.copy(screenshotFile.toPath(), Path.of(screenshotPath), StandardCopyOption.REPLACE_EXISTING);

        // Se copia una imagen de ejemplo para mostrar el funcionamiento
        //Files.copy(Path.of("src/test/resources/sample-screenshot.png"), Path.of(screenshotPath), StandardCopyOption.REPLACE_EXISTING);

        return screenshotPath;
    }
}
