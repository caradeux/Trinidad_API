@echo off

REM Crear las carpetas del proyecto
mkdir src
mkdir src\main
mkdir src\main\java
mkdir src\main\java\com
mkdir src\main\java\com\example
mkdir src\main\java\com\example\api
mkdir src\main\resources
mkdir src\test
mkdir src\test\java
mkdir src\test\java\com
mkdir src\test\java\com\example
mkdir src\test\java\com\example\tests
mkdir src\test\resources
mkdir test-output

REM Crear los archivos necesarios
echo package com.example.api; > src\main\java\com\example\api\SOAPClient.java
echo. > src\main\resources\config.properties
echo package com.example.api; > src\main\java\com\example\api\ExtentReportManager.java
echo package com.example.tests; > src\test\java\com\example\tests\APITests.java
echo. > src\test\resources\soap-request.xml

REM Agregar el contenido de los archivos
echo import io.restassured.RestAssured; >> src\main\java\com\example\api\SOAPClient.java
echo import io.restassured.response.Response; >> src\main\java\com\example\api\SOAPClient.java
echo. >> src\main\java\com\example\api\SOAPClient.java
echo public class SOAPClient { >> src\main\java\com\example\api\SOAPClient.java
echo     private static final String SOAP_ENDPOINT = "/soap/endpoint"; >> src\main\java\com\example\api\SOAPClient.java
echo. >> src\main\java\com\example\api\SOAPClient.java
echo     public static Response sendSOAPRequest(String soapRequest) { >> src\main\java\com\example\api\SOAPClient.java
echo         return RestAssured.given() >> src\main\java\com\example\api\SOAPClient.java
echo                 .contentType("text/xml") >> src\main\java\com\example\api\SOAPClient.java
echo                 .body(soapRequest) >> src\main\java\com\example\api\SOAPClient.java
echo                 .post(SOAP_ENDPOINT); >> src\main\java\com\example\api\SOAPClient.java
echo     } >> src\main\java\com\example\api\SOAPClient.java

echo import com.aventstack.extentreports.ExtentReports; >> src\main\java\com\example\api\ExtentReportManager.java
echo import com.aventstack.extentreports.ExtentTest; >> src\main\java\com\example\api\ExtentReportManager.java
echo import com.aventstack.extentreports.reporter.ExtentHtmlReporter; >> src\main\java\com\example\api\ExtentReportManager.java
echo. >> src\main\java\com\example\api\ExtentReportManager.java
echo public class ExtentReportManager { >> src\main\java\com\example\api\ExtentReportManager.java
echo     private static ExtentReports extent; >> src\main\java\com\example\api\ExtentReportManager.java
echo     private static ExtentTest test; >> src\main\java\com\example\api\ExtentReportManager.java
echo. >> src\main\java\com\example\api\ExtentReportManager.java
echo     public static void setupExtentReports() { >> src\main\java\com\example\api\ExtentReportManager.java
echo         ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/ExtentReport.html"); >> src\main\java\com\example\api\ExtentReportManager.java
echo         extent = new ExtentReports(); >> src\main\java\com\example\api\ExtentReportManager.java
echo         extent.attachReporter(htmlReporter); >> src\main\java\com\example\api\ExtentReportManager.java
echo     } >> src\main\java\com\example\api\ExtentReportManager.java
echo. >> src\main\java\com\example\api\ExtentReportManager.java
echo     public static void createTest(String testName) { >> src\main\java\com\example\api\ExtentReportManager.java
echo         test = extent.createTest(testName); >> src\main\java\com\example\api\ExtentReportManager.java
echo     } >> src\main\java\com\example\api\ExtentReportManager.java
echo. >> src\main\java\com\example\api\ExtentReportManager.java
echo     public static void logInfo(String message) { >> src\main\java\com\example\api\ExtentReportManager.java
echo         test.info(message); >> src\main\java\com\example\api\ExtentReportManager.java
echo     } >> src\main\java\com\example\api\ExtentReportManager.java
echo. >> src\main\java\com\example\api\ExtentReportManager.java
echo     public static void logPass(String message) { >> src\main\java\com\example\api\ExtentReportManager.java
echo         test.pass(message); >> src\main\java\com\example\api\ExtentReportManager.java
echo     } >> src\main\java\com\example\api\ExtentReportManager.java
echo. >> src\main\java\com\example\api\ExtentReportManager.java
echo     public static void logFail(String message) { >> src\main\java\com\example\api\ExtentReportManager.java
echo         test.fail(message); >> src\main\java\com\example\api\ExtentReportManager.java
echo     } >> src\main\java\com\example\api\ExtentReportManager.java
echo. >> src\main\java\com\example\api\ExtentReportManager.java
echo     public static void flushReports() { >> src\main\java\com\example\api\ExtentReportManager.java
echo         extent.flush(); >> src\main\java\com\example\api\ExtentReportManager.java
echo     } >> src\main\java\com\example\api\ExtentReportManager.java

echo package com.example.tests; > src\test\java\com\example\tests\APITests.java
echo. > src\test\resources\soap-request.xml

echo import util.ExtentReportManager; >> src\test\java\com\example\tests\APITests.java
echo import base.SOAPClient; >> src\test\java\com\example\tests\APITests.java
echo import io.restassured.response.Response; >> src\test\java\com\example\tests\APITests.java
echo import org.junit.AfterClass; >> src\test\java\com\example\tests\APITests.java
echo import org.junit.BeforeClass; >> src\test\java\com\example\tests\APITests.java
echo import org.junit.Test; >> src\test\java\com\example\tests\APITests.java
echo. >> src\test\java\com\example\tests\APITests.java
echo import java.io.IOException; >> src\test\java\com\example\tests\APITests.java
echo import java.nio.file.Files; >> src\test\java\com\example\tests\APITests.java
echo import java.nio.file.Paths; >> src\test\java\com\example\tests\APITests.java
echo. >> src\test\java\com\example\tests\APITests.java
echo public class APITests { >> src\test\java\com\example\tests\APITests.java
echo     private static final String SOAP_REQUEST_FILE = "src/test/resources/soap-request.xml"; >> src\test\java\com\example\tests\APITests.java
echo. >> src\test\java\com\example\tests\APITests.java
echo     @BeforeClass >> src\test\java\com\example\tests\APITests.java
echo     public static void setup() { >> src\test\java\com\example\tests\APITests.java
echo         ExtentReportManager.setupExtentReports(); >> src\test\java\com\example\tests\APITests.java
echo     } >> src\test\java\com\example\tests\APITests.java
echo. >> src\test\java\com\example\tests\APITests.java
echo     @AfterClass >> src\test\java\com\example\tests\APITests.java
echo     public static void teardown() { >> src\test\java\com\example\tests\APITests.java
echo         ExtentReportManager.flushReports(); >> src\test\java\com\example\tests\APITests.java
echo     } >> src\test\java\com\example\tests\APITests.java
echo. >> src\test\java\com\example\tests\APITests.java
echo     @Test >> src\test\java\com\example\tests\APITests.java
echo     public void testSOAPRequest() throws IOException { >> src\test\java\com\example\tests\APITests.java
echo         String soapRequest = new String(Files.readAllBytes(Paths.get(SOAP_REQUEST_FILE))); >> src\test\java\com\example\tests\APITests.java
echo         ExtentReportManager.createTest("Test SOAP Request"); >> src\test\java\com\example\tests\APITests.java
echo. >> src\test\java\com\example\tests\APITests.java
echo         Response response = SOAPClient.sendSOAPRequest(soapRequest); >> src\test\java\com\example\tests\APITests.java
echo. >> src\test\java\com\example\tests\APITests.java
echo         int statusCode = response.getStatusCode(); >> src\test\java\com\example\tests\APITests.java
echo         String responseBody = response.getBody().asString(); >> src\test\java\com\example\tests\APITests.java
echo. >> src\test\java\com\example\tests\APITests.java
echo         if (statusCode == 200) { >> src\test\java\com\example\tests\APITests.java
echo             ExtentReportManager.logPass("SOAP request successful. Response: " + responseBody); >> src\test\java\com\example\tests\APITests.java
echo         } else { >> src\test\java\com\example\tests\APITests.java
echo             ExtentReportManager.logFail("SOAP request failed. Response: " + responseBody); >> src\test\java\com\example\tests\APITests.java
echo         } >> src\test\java\com\example\tests\APITests.java
echo     } >> src\test\java\com\example\tests\APITests.java
echo } >> src\test\java\com\example\tests\APITests.java

echo <?xml version="1.0" encoding="UTF-8"?> > src\test\resources\soap-request.xml
echo <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:web="http://www.example.com/"> >> src\test\resources\soap-request.xml
echo     <soapenv:Header/> >> src\test\resources\soap-request.xml
echo     <soapenv:Body> >> src\test\resources\soap-request.xml
echo         <web:Request> >> src\test\resources\soap-request.xml
echo             <web:Param1>Value1</web:Param1> >> src\test\resources\soap-request.xml
echo             <web:Param2>Value2</web:Param2> >> src\test\resources\soap-request.xml
echo         </web:Request> >> src\test\resources\soap-request.xml
echo     </soapenv:Body> >> src\test\resources\soap-request.xml
echo </soapenv:Envelope> >> src\test\resources\soap-request.xml

echo Creación de archivos completa!
