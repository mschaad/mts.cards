package mts.cards;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  CardTests.class,
  RankTests.class,
  SuitTests.class,
  DefaultDeckTests.class,
  CardFactoryTests.class
})
public class CardsTestSuite {

}
