package com.springcloud.roomservices.resource.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    @JsonProperty("error")
    private boolean isError;

    @JsonProperty("message")
    private String message;
}
