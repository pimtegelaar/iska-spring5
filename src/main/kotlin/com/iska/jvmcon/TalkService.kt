package com.iska.jvmcon

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.SynchronousSink
import java.time.Duration
import java.util.*

@Service
class TalkService(private val talkRepository: TalkRepository) {

    fun getAllTalks(): Flux<Talk> = talkRepository.findAll()

    fun getTalkById(id: String): Mono<Talk> = talkRepository.findById(id)

    fun getRatingsForTalk(id: String): Flux<Rating> =
            Flux.generate<Rating> { sink: SynchronousSink<Rating> ->
                sink.next(Rating(id, (Math.random() * 10).toInt() + 1, Date()))
            }.delayElements(Duration.ofSeconds(1))
}

