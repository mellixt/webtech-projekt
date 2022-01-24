package htw.berlin.webtech.demo;

import htw.berlin.webtech.persistence.PollRepository;
import htw.berlin.webtech.service.PollService;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class PollServiceTest implements WithAssertions {

    @Mock
    private PollRepository repository;

    @InjectMocks
    private PollService underTest;

    @Test
    @DisplayName("should return true if delete of poll was successful")
    void returnTrueIfDeleteSuccessful() {
        // Arrange: ID Wertzuweisung, return-Wert (TRUE) angeben
        Long givenId = 111L;
        doReturn(true).when(repository).existsById(givenId);

        // Act: result deklarieren
        boolean result = underTest.deleteById(givenId);

        // Assert: verify method call + check if result = true
        verify(repository).deleteById(givenId);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("should return false if poll to delete does not exist")
    void returnFalseIfPollDoesNotExist() {
        // Arrange: ID Wertzuweisung, return-Wert (FALSE) angeben
        Long givenId = 111L;
        doReturn(false).when(repository).existsById(givenId);

        // Act: result deklarieren
        boolean result = underTest.deleteById(givenId);

        // Assert: verify no method call happening on mock + check if result = false
        verifyNoMoreInteractions(repository);
        assertThat(result).isFalse();
    }
}
