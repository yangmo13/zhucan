@echo off

set "JAVA_OPTS=-Xms128m -Xmx256m -XX:MaxNewSize=256m -XX:MaxMetaspaceSize=256m -Dundertow.port=8777 -Dundertow.host=0.0.0.0"
set APP_BASE_PATH=%~dp0

set "JAVA_HOME=%APP_BASE_PATH%..\jre1.8"

set CP=%APP_BASE_PATH%config;%APP_BASE_PATH%lib\*
"%JAVA_HOME%\bin\java" -Xverify:none %JAVA_OPTS% -cp %CP% Boot >> "%APP_BASE_PATH%\fdp_api.log"
pause