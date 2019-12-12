package openhouse.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Data
@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("sex")
    private Byte sex;
    @JsonProperty("department")
    private String department;
}
