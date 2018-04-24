package kg.iceknight.sumologicdemo.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kg.iceknight.sumologicdemo.config.SumologicProperties;
import kg.iceknight.sumologicdemo.model.LogDTO;
import kg.iceknight.sumologicdemo.service.LoggingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Slf4j
@Service
public class SumoLogicLoggingService implements LoggingService {

    private final SumologicProperties sumologicProperties;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public SumoLogicLoggingService(SumologicProperties sumologicProperties) {
        this.sumologicProperties = sumologicProperties;
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();

    }

    @Async()
    @Override
    public void log() {
        String endpoint = sumologicProperties.getEndpoint();
        LogDTO logDTO = new LogDTO();
        logDTO.setProjectName("BEKS TEST");
        logDTO.setUser("admin");
        logDTO.setDetail(UUID.randomUUID().toString());
        String s;
        try {
            s = objectMapper.writeValueAsString(logDTO);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return;
        }
        log.info(s);
//        ResponseEntity<Object> objectResponseEntity = restTemplate.postForEntity(endpoint, s, Object.class);

    }
}
