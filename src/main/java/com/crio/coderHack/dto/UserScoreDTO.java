package com.crio.coderHack.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class UserScoreDTO {
    @JsonProperty("id")
    @NonNull
    private String id;
    @JsonProperty("score")
    @NonNull
    @Min(value = 0,message = "Score must be equal or greater than zero")
    @Max(value=100,message="Score must be equal or lesser than hundred ")
    private Integer score;
}
