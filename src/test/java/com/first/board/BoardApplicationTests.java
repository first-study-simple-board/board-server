package com.first.board;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.first.board.config.ModelMapperConfig;

@SpringBootTest(classes = {BoardApplication.class, ModelMapperConfig.class})
@ActiveProfiles("test")
class BoardApplicationTests {

    @Test
    void contextLoads() {
    }
}
