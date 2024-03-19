package com.crio.coderHack.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    @JsonIgnore
    private Integer score;
    @JsonIgnore
    private List<String> badges;
}
