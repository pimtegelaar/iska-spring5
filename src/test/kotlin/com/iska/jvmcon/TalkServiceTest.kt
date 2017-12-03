package com.iska.jvmcon

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import reactor.test.StepVerifier
import java.time.Duration

@RunWith(SpringRunner::class)
@SpringBootTest
class TalkServiceTest {

    @Autowired lateinit var talkService: TalkService

    @Test
    fun getRatingsForTalkTake10() {
        val talkId: String = talkService.getAllTalks().blockFirst()!!.id!!
        StepVerifier.withVirtualTime {
            talkService.getRatingsForTalk(talkId)
                    .take(10)
                    .collectList()
        }
                .thenAwait(Duration.ofHours(10))
                .consumeNextWith { list -> Assert.assertTrue(list.size == 10) }
                .verifyComplete()
    }

}