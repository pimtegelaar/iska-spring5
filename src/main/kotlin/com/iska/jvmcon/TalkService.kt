package com.iska.jvmcon

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class TalkService(private val talkRepository: TalkRepository) {

    fun getAllTalks(): Flux<Talk> = talkRepository.findAll()

    fun getTalkById(id: String): Mono<Talk> = talkRepository.findById(id)
}

