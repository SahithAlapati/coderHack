package com.crio.coderHack.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @JsonProperty("id")
    @NonNull
    private String id;
    @NonNull
    @JsonProperty("userName")
    private String userName;
    @Min(value = 0,message = "Score must be equal or greater than zero")
    @Max(value=100,message="Score must be equal or lesser than hundred ")
    @JsonProperty("score")
    private Integer score=0;
    @JsonProperty("badge")
    private List<String> badges=new ArrayList<>();
}
