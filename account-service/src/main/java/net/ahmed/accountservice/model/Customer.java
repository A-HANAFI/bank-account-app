package net.ahmed.accountservice.model;

import lombok.*;

@Getter
@Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Customer {
    private Long id;
    private String FirstName;
    private String LastName;
    private String email;
}
