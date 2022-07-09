package gosk.szymon.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Agency implements DataModel {

    private int agencyId;
    private String agencyName;
    private String agencyUrl;
    private String agencyTimezone;
    private String agencyLang;
    private String agencyEmail;

    @ToString.Exclude
    private Set<TopologyVersion> topologyVersions;

}
