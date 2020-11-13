package TicTacToe;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import mockit.MockUp;

public class TicTacToeTest {

  @InjectMocks
  @Spy
  private TicTacToe ticTacToe;

  @BeforeClass
  void setUp() {
	MockitoAnnotations.initMocks(this);
  }

  @Test
  void test_pickupOrder() throws Exception {

  }
}
