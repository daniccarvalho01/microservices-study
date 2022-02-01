package com.microservicesstudy.store.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StoreRequest {

    private String name;

    public StoreRequest(String name, LocalDate dateCreate, LocalDate dateUpdate) {
        this.name = name;

    }

}
