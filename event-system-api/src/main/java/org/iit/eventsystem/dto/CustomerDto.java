package org.iit.eventsystem.dto;

import lombok.Data;

@Data
public class CustomerDto {
    private String username;
    private String email;
    private String password;
    private Long mobileNo;
    private Boolean isPremium;


    public Boolean getIs_premium() {
        return isPremium;
    }
}
