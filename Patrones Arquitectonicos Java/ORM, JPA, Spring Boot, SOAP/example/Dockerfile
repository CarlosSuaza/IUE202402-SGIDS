FROM sapmachine:22-jdk-headless-ubuntu

COPY target/*.jar app-soap.jar
EXPOSE 8080
CMD ["java","-jar","app-soap.jar"]