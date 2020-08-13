@echo off
cd %~dp0
cd fdp
call mvn clean install
cd ..
cd fdp-model
call mvn clean install
cd ..
cd fdp-api
call mvn clean package
cd ..
pause