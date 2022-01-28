package com.ewallet.assistant.api;

import com.ewallet.assistant.client.domain.Provider;
import com.ewallet.assistant.service.ProviderService;
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
@RequestMapping("/providers")
public class ProvidersController {
    private final ProviderService providerService;

    @Autowired
    public ProvidersController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping("/")
    public Mono<List<Provider>> getAllProviders() {
        return providerService.getAllProviders();
    }

    @GetMapping("/{address}")
    public Mono<Provider> getProvider(@PathVariable String address) {
        return providerService.getProvider(address);
    }
}
