package com.iska.jvmcon

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/talks")
class TalkController(private val talkService: TalkService) {

    @GetMapping
    fun getTalks(): Flux<Talk> = talkService.getAllTalks()

    @GetMapping("/{id}")
    fun getTalk(@PathVariable id: String): Mono<Talk> = talkService.getTalkById(id)

    @GetMapping(value = "/{id}/ratings", produces = arrayOf(MediaType.TEXT_EVENT_STREAM_VALUE))
    fun getRatings(@PathVariable id: String): Flux<Rating> = talkService.getRatingsForTalk(id)
}