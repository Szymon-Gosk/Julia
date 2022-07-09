package gosk.szymon.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Stop implements DataModel {

    private int stopId;
    private String stopCode;
    private String stopName;
    private String stopShortname;
    private String stopDesc;
    private String subName;
    private String date;
    private int zoneId;
    private String zoneName;
    private int virtual;
    private int nonpassenger;
    private int depot;
    private int ticketZoneBorder;
    private int onDemand;
    private String activationDate;
    private double latitude;
    private double longitude;

}

