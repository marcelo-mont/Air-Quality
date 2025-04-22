# Usar uma imagem base do Java
FROM openjdk:11-jre-slim

# Definir o diretório de trabalho no contêiner
WORKDIR /Air-Quality

# Copiar o arquivo JAR gerado para o contêiner
COPY target/*.jar app.jar

# Expor a porta que a aplicação usará
EXPOSE 8080

# Comando para executar a aplicação
CMD ["java", "-jar", "app.jar"]
