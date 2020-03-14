package com.example.springwebfluxlinkshortener;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class LinkController {


    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/link")
    Mono<CreateLinkResponse> create(@RequestBody CreateLinkRequest request) {
        return linkService.shortenLink(request.getLink())
                .map(CreateLinkResponse::new);
    }

    static class CreateLinkRequest {
        private String link;
        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }

    static class CreateLinkResponse {
        public String getShortenedLink() {
            return shortenedLink;
        }

        public CreateLinkResponse(String shortenedLink) {
            this.shortenedLink = shortenedLink;
        }

        private String shortenedLink;
    }
}
