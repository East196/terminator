package com.github.east196.xcode.model

import org.springframework.data.mongodb.repository.MongoRepository
import java.util.List

interface FieldRepository extends MongoRepository<Field, String> {
	
	def List<Field> findByRecordId(String recordId)
	
}