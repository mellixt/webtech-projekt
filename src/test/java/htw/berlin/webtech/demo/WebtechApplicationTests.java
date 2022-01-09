package htw.berlin.webtech.demo;

import htw.berlin.webtech.persistence.PollEntity;
import htw.berlin.webtech.persistence.PollRepository;
import htw.berlin.webtech.web.api.Poll;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import htw.berlin.webtech.service.PollService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class WebtechApplicationTests {

	@Test
	@DisplayName("should test if poll  creation was successful")
	void pollCreationTest(){
		Poll poll = new Poll(1, "Wie spät ist es?", "Hans", "2021-01-01", "2021-01-03", "1Uhr,2Uhr,3Uhr", "0,1,1");
		assertNotNull(poll);
		assertEquals(poll.getId(), 1);
	}


	@Test
	@DisplayName("should test if setter method for username is working")
	void setUsernameTest(){
		Poll poll = new Poll(1, "Wie spät ist es?", "Hans", "2021-01-01", "2021-01-03", "1Uhr,2Uhr,3Uhr", "0,1,1");
		poll.setUsername("Hannah");
		assertEquals("Hannah", poll.getUsername());


	}

}
