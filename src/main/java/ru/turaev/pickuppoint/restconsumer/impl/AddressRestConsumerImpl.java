package ru.turaev.pickuppoint.restconsumer.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.turaev.pickuppoint.restconsumer.AddressRestConsumer;

@Service
@RequiredArgsConstructor
public class AddressRestConsumerImpl implements AddressRestConsumer {
    private final WebClient.Builder webClientBuilder;

    @Value("${microservice.address.name}")
    private String addressServiceName;

    @Override
    public boolean isAddressExist(long id) {
        String path = "http://" + addressServiceName +"/api/v1/addresses/exist/";
        return webClientBuilder.build()
                .get()
                .uri(path + id)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }
}
