package com.example.springwebfluxlinkshortener;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class LinkServiceTest {
    private LinkService linkService = new LinkService("http://some-domain.com");

    @Test
    public void shortensLink()  {
        StepVerifier.create(linkService.shortenLink("http://spring.io"))
                .expectNextMatches(result->result!=null && result.length()>0
                && result.startsWith("http://some-domain.com"))
                .expectComplete()
                .verify();
    }

}