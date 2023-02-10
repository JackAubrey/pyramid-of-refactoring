package pl.refactoring.interpreter.emerging.specs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.refactoring.interpreter.emerging.RealEstate;
import pl.refactoring.interpreter.emerging.Spec;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AndSpecTest {

    private Spec yesSpec;

    @BeforeEach
    void setUp() {
        yesSpec = mock(Spec.class);

        when(yesSpec.isSatisfiedBy(any(RealEstate.class)))
                .thenReturn(true);
    }

    @Test
    void shouldVerifyTwoComponentsInCaseOfYesResults() {
        // Given
        AndSpec andSpec = new AndSpec(yesSpec, yesSpec);

        // when
        boolean satisfiedBy = andSpec.isSatisfiedBy(mock(RealEstate.class));

        // then
        assertTrue(satisfiedBy);

        verify(yesSpec, times(2)).isSatisfiedBy(any(RealEstate.class));
    }

    @Test
    void shouldVerifyThreeComponentsInCaseOfYesResults() {
        // Given
        AndSpec andSpec = new AndSpec(yesSpec, yesSpec, yesSpec);

        // when
        boolean satisfiedBy = andSpec.isSatisfiedBy(mock(RealEstate.class));

        // then
        assertTrue(satisfiedBy);

        verify(yesSpec, times(3)).isSatisfiedBy(any(RealEstate.class));
    }
}