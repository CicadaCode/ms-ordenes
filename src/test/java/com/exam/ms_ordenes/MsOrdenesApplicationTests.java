package com.exam.ms_ordenes;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
		"spring.cloud.vault.enabled=false",
		"spring.cloud.config.enabled=false",
		"eureka.client.enabled=false"
})
class MsOrdenesApplicationTests {

	@Test
	void contextLoads() {
		Assertions.assertTrue(true);
	}
}
