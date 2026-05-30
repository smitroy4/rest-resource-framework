package com.smit.rrf.exception;

import com.smit.rrf.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public final class ExceptionUtils {

    private ExceptionUtils() {}

    public static ResponseEntity<ApiResponse<Void>>
    notFound(String message) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.failure(message));
    }
}