package com.iska.jvmcon

import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import javax.annotation.PostConstruct

@Component
class DataLoader(private val talkRepository: TalkRepository) {

    @PostConstruct
    fun loadData() {
        talkRepository.deleteAll().thenMany(
                Flux.just("The fallacies of Doom",
                        "Exploring Java 9 Modularization",
                        "Kotlin 102 - Beyond the basics")
                        .map { Talk(title = it) }
                        .flatMap { talkRepository.save(it) })
                .subscribe { println(it) }
    }
}


