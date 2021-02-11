package org.rolofge.application.backend.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.rolofge.application.backend.entity.User;

@Data
@AllArgsConstructor
public class UserDto {
    private String id;
    private String firstName;
    private String lastName;
    private String email;

    public static UserDto of(User entity) {
        return new UserDto(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getEmail());
    }
}
