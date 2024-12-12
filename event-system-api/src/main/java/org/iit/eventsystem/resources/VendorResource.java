package org.iit.eventsystem.resources;

import lombok.Data;

@Data
public class VendorResource {
    private String username;
    private String email;
    private String password;
    private Long mobileNo;
    private Boolean isAdmin;

    public Boolean getIsAdmin() {
        return isAdmin;
    }
}

