package com.github.east196.xcode.model

import org.springframework.data.mongodb.repository.MongoRepository

interface EnumTypeRepository extends MongoRepository<EnumType, String> {
	
}