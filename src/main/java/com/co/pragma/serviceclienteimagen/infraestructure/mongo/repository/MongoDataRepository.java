package com.co.pragma.serviceclienteimagen.infraestructure.mongo.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.co.pragma.serviceclienteimagen.infraestructure.mongo.entity.ClientImageEntity;

@Repository
public interface MongoDataRepository extends MongoRepository<ClientImageEntity, String>{

}
