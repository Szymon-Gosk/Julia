package gosk.szymon.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopologyVersion implements DataModel {

    private int versionNumber;
    private String startDate;
    private String endDate;

}
