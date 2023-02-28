set dname="CN=localhost,OU=IT,O=KANAA,L=Moscow,C=RU,email=kanaa@email.com"
rem keytool -genkeypair -alias ssl -keyalg RSA -keysize 2048 -dname %dname% -validity 90 -keystore C:/keystore.jks -storepass passw0rd -keypass passw0rd -ext san:critical=dns:localhost,ip:127.0.0.1 -ext bc=ca:false
echo %dname%
