package com.backend.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.backend.repository")
public class MongoConfig extends AbstractReactiveMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "apiChat"; // Nombre de tu base de datos MongoDB
    }

    @Override
    public MongoClient reactiveMongoClient() {
        // Configura y devuelve el cliente de MongoDB
        // Aquí puedes personalizar la configuración del cliente MongoDB si es necesario
        return MongoClients.create("mongodb+srv://jarojasm:qNC8VSu9v0y8QdaE@apibackend.sdxanc8.mongodb.net/?retryWrites=true&w=majority&appName=apiBackend");
    }
}