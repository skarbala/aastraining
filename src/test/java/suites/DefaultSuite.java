package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import tests.CalculationTest;
import tests.EmailValidationTest;
import tests.NewSavingRequestTest;
import tests.SavingsCalculatorTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    SavingsCalculatorTest.class,
    CalculationTest.class,
    NewSavingRequestTest.class,
    EmailValidationTest.class
})
public class DefaultSuite {
}
