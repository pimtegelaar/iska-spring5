package com.iska.jvmcon

import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface TalkRepository: ReactiveMongoRepository<Talk, String>