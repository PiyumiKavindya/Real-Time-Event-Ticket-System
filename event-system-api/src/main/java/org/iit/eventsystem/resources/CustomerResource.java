package org.iit.eventsystem.resources;

import lombok.Data;

@Data
public class CustomerResource {
    private String username;
    private String email;
    private String password;
    private Long mobileNo;
    private Boolean isPremium;


    public Boolean getIs_premium() {
        return isPremium;
    }
}
