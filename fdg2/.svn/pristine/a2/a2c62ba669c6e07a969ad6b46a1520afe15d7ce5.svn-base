@echo off

set "JAVA_OPTS=-Xms256m -Xmx1024m -XX:MaxNewSize=512m -XX:MaxMetaspaceSize=512m -Dundertow.port=888 -Dundertow.host=0.0.0.0"
set APP_BASE_PATH=%~dp0

set "JAVA_HOME=%APP_BASE_PATH%..\jre1.8"

set CP=%APP_BASE_PATH%config;%APP_BASE_PATH%lib\*
"%JAVA_HOME%\bin\java" -Xverify:none %JAVA_OPTS% -cp %CP% Boot >> "%APP_BASE_PATH%\fdp_api.log"
pause