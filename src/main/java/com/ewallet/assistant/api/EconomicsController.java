package com.ewallet.assistant.api;

import com.ewallet.assistant.client.domain.Economics;
import com.ewallet.assistant.client.domain.MexPair;
import com.ewallet.assistant.client.model.GetMexPairResponse;
import com.ewallet.assistant.service.EconomicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RestController
@RequestMapping("/economics")
public class EconomicsController {
    private final EconomicsService economicsService;

    @Autowired
    public EconomicsController(EconomicsService economicsService) {
        this.economicsService = economicsService;
    }

    @GetMapping("/{token}")
    public Mono<Economics> getEconomics(@PathVariable String token) {
        return economicsService.getEconomics(token);
    }

    @GetMapping("/mex-pairs")
    public Mono<List<MexPair>> getMexPairs() {
        return economicsService.getMexPairs();
    }
}
