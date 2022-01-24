package htw.berlin.webtech.demo;

import htw.berlin.webtech.persistence.PollEntity;
import htw.berlin.webtech.persistence.PollRepository;
import htw.berlin.webtech.web.api.Poll;
import org.apache.juli.logging.Log;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Null;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import htw.berlin.webtech.service.PollService;
import org.xmlunit.builder.Input;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class WebtechApplicationTests {

/*	@Test
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


	}*/

	@Mock
	private Poll poll;

/*	@BeforeEach
	void setup() {
		poll = Mockito.mock(Poll.class);
	}*/

	@Test
	@DisplayName("should test if poll creation with mock was successful")
	void testWithMockito(){

		//Arrange
		//Poll poll = Mockito.mock(Poll.class);

		//Assert
		assertNotNull(poll);
	}

}
