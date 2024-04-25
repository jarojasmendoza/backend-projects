package com.backend.repository;

import com.backend.model.Mensaje;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MensajeRepository extends ReactiveMongoRepository<Mensaje, String>
{
}
