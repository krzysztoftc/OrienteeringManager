package pl.edu.controller.competitor.form;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

/**
 * Created by bartosz on 29.05.16.
 */
@XmlRootElement
public class CompetitorOptionsList {
    @JsonProperty
    @Getter @Setter
    private Long competitor;

    @JsonProperty
    @Getter @Setter
    private Long[] nights;

    @JsonProperty
    @Getter @Setter
    private Long[] caterings;
}
