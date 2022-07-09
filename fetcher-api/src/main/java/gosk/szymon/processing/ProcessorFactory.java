package gosk.szymon.processing;

import gosk.szymon.fetching.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProcessorFactory {

    /**
     * Returns processor specific for given data source.
     * @param dataSource source of data
     * @return processor specific for data source.
     */
    public @NotNull Processor getProcessor(@NotNull DataSource dataSource) {
        return switch (dataSource) {
            case AGENCY -> new AgencyProcessor();
            case STOP -> new StopProcessor();
        };
    }

}
