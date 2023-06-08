@echo off
echo # Configuración de la API >> src\main\resources\config.properties
echo api.baseurl=http://example.com/api >> src\main\resources\config.properties
echo api.username=admin >> src\main\resources\config.properties
echo api.password=secretpassword >> src\main\resources\config.properties
echo. >> src\main\resources\config.properties
echo # Configuración de Extent Reports >> src\main\resources\config.properties
echo extentreport.filename=ExtentReport.html >> src\main\resources\config.properties
echo. >> src\main\resources\config.properties
echo # Otras configuraciones >> src\main\resources\config.properties
echo timeout.seconds=10 >> src\main\resources\config.properties

echo Creación del archivo config.properties completa!
