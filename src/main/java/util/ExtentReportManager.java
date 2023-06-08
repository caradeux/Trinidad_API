package util;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.restassured.response.Response;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import tech.grasshopper.reporter.ExtentPDFReporter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Base64;

public class ExtentReportManager {
    private static ExtentReports extentReports;

    public static void setupExtentReports() {

        ExtentReports extent = new ExtentReports();

        ExtentSparkReporter spark = new ExtentSparkReporter("src/Reporte/Spark.html");
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("src/Reporte/Reporte_Ejecucion.html");
        ExtentPDFReporter pdf = new ExtentPDFReporter("src/Reporte/Reporte_Ejecucion.pdf");
        extentReports = new ExtentReports();
        extentReports.setMediaResolverPath(new String[] { "images" });
        extentReports.attachReporter(htmlReporter);
        extentReports.attachReporter(pdf);
    }

    public static ExtentTest createTest(String testName) {

        return extentReports.createTest(testName);
    }

    public static void logPass(ExtentTest extentTest, String message) {

        extentTest.pass(message);

    }

    public static void logFail(ExtentTest extentTest, String message) {

        extentTest.fail(message);
    }

    public static void logSoapResponse(ExtentTest extentTest, Response response) {
        String responseBody = response.getBody().asString();

        Markup markup = MarkupHelper.createCodeBlock(responseBody);
        extentTest.info(markup);


    }



    public static void logScreenshot(ExtentTest extentTest, String imagePath) {
        extentTest.fail("Screenshot",
                MediaEntityBuilder.createScreenCaptureFromPath(imagePath).build());
    }

    public static void logBase64Screenshot(ExtentTest extentTest, String imagePath) {
        try {
            byte[] imageBytes = Files.readAllBytes(Path.of(imagePath));
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
            extentTest.fail("Base64 Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void flushReports() {

        extentReports.flush();
    }
}
