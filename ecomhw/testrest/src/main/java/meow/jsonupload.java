package meow;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement(name = "catmeow")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class jsonupload {
    private String title;
    private String src;
}
