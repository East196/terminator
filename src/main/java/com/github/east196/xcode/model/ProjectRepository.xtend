package com.github.east196.xcode.model

import org.springframework.data.mongodb.repository.MongoRepository

interface ProjectRepository extends MongoRepository<Project, String> {
	
}