package org.iit.eventsystem.dto;

import lombok.Data;

@Data
public class VendorDTO {
    private String username;
    private String email;
    private String password;
    private Long mobileNo;
    private Boolean isAdmin;

    public Boolean getIsAdmin() {
        return isAdmin;
    }
}

