package kg.iceknight.sumologicdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogDTO {
    private String projectName;

    private String user;

    private String detail;
}
