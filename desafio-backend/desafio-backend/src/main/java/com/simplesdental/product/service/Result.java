package com.simplesdental.product.service;

import java.util.ArrayList;
import java.util.List;

import io.micrometer.common.lang.Nullable;
import lombok.Data;

@Data
public class Result<T> {
    @Nullable
    private T data;
    private List<String> errors = new ArrayList<>();
    public boolean isSuccess() {
        return errors.size() == 0;
    }
}
