package com.github.east196.xcode.model

import org.springframework.data.mongodb.repository.MongoRepository
import java.util.List

interface RecordRepository extends MongoRepository<Record, String> {
	
	def  List<Record> findByProjectId(String projectId)
	
}