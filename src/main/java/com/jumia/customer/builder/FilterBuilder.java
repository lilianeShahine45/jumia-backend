package com.jumia.customer.builder;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FilterBuilder {

    private final String country;
    private final String state;
}
