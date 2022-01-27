package com.ewallet.assistant.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import software.crldev.elrondspringbootstarterreactive.api.model.AccountOnNetwork;
import software.crldev.elrondspringbootstarterreactive.api.model.AddressBalance;
import software.crldev.elrondspringbootstarterreactive.api.model.AddressNonce;
import software.crldev.elrondspringbootstarterreactive.api.model.AddressStorageValue;
import software.crldev.elrondspringbootstarterreactive.api.model.TransactionForAddress;
import software.crldev.elrondspringbootstarterreactive.interactor.account.ErdAccountInteractor;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import static software.crldev.elrondspringbootstarterreactive.domain.account.Address.fromBech32;

@Component
@RestController
@RequestMapping("/account")
public class AccountController {

    private final ErdAccountInteractor accountInteractor;

    @Autowired
    public AccountController(ErdAccountInteractor accountInteractor) {
        this.accountInteractor = accountInteractor;
    }

    @GetMapping("/info/{address}")
    public Mono<AccountOnNetwork> getAccountInfo(@PathVariable String address) {
        return accountInteractor.getAccountInfo(fromBech32(address));
    }

    @GetMapping("/balance/{address}")
    public Mono<AddressBalance> getAccountBalance(@PathVariable String address) {
        return accountInteractor.getBalance(fromBech32(address));
    }

    @GetMapping("/nonce/{address}")
    public Mono<AddressNonce> getAccountNonce(@PathVariable String address) {
        return accountInteractor.getNonce(fromBech32(address));
    }

    @GetMapping("/username/{address}")
    public Mono<String> getAccountUsername(@PathVariable String address) {
        return accountInteractor.getAccountInfo(fromBech32(address))
                .map(AccountOnNetwork::getUsername);
    }

    @GetMapping("/reward/{address}")
    public Mono<BigInteger> getAccountReward(@PathVariable String address) {
        return accountInteractor.getAccountInfo(fromBech32(address))
                .map(AccountOnNetwork::getDeveloperReward);
    }

    @GetMapping("/transactions/{address}")
    public Mono<List<TransactionForAddress>> getAccountTransactions(@PathVariable String address) {
        return accountInteractor.getTransactions(fromBech32(address));
    }

    @GetMapping("/transactions/count/{address}")
    public Mono<Integer> getAccountTransactionsCount(@PathVariable String address) {
        return accountInteractor.getTransactions(fromBech32(address))
                .map(List::size);
    }

    @GetMapping("/storage/{address}")
    public Mono<Map<String, String>> getAccountStorage(@PathVariable String address) {
        return accountInteractor.getStorage(fromBech32(address));
    }

    @GetMapping("/storage/{address}/key/{key}")
    public Mono<AddressStorageValue> getAccountStorageValue(@PathVariable String address, @PathVariable String key) {
        return accountInteractor.getStorageValue(fromBech32(address), key);
    }
}
