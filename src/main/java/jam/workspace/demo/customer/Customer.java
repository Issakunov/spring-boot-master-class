package jam.workspace.demo.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table
@NoArgsConstructor
@ToString
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Customer {
    @Id
    @JsonProperty(value = "customerId")
    private Long id;
    @NotBlank(message = "Name mustn't be blank")
    private String name;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @Email
    private String email;


    public Customer(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }
}
