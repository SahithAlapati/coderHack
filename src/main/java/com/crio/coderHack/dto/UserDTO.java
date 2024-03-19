package com.crio.coderHack.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    private String id;
    private String userName;
    private Integer score;
    private List<String> badges;
}
