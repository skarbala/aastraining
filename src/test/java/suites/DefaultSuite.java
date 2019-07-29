package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import tests.CalculationTest;
import tests.SavingsCalculatorTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    SavingsCalculatorTest.class,
    CalculationTest.class
})
public class DefaultSuite {
}
