package TicTacToe;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import mockit.MockUp;

public class TicTacToeTest {

  @InjectMocks
  @Spy
  private TicTacToe ticTacToe;

  @BeforeClass
  void setUp() {
	MockitoAnnotations.initMocks(this);
  }

  @Test
  void test_isMatrixFull_full() throws Exception {
	char[][] matrix = new char[3][3];
	matrix[0][0] = 'o';
	matrix[0][1] = 'x';
	matrix[0][2] = 'x';
	matrix[1][0] = 'x';
	matrix[1][1] = 'o';
	matrix[1][2] = 'x';
	matrix[2][0] = 'x';
	matrix[2][1] = 'o';
	matrix[2][2] = 'o';
	Assert.assertTrue(ticTacToe.isMatrixFull(matrix));
  }
  
  @Test
  void test_isMatrixFull_NotFull() throws Exception {
	char[][] matrix = new char[3][3];
	matrix[0][0] = 'o';
	matrix[0][1] = 'x';
	matrix[0][2] = 'x';
	matrix[1][0] = 'x';
	matrix[1][1] = 'o';
	matrix[1][2] = 'x';
	matrix[2][0] = 'x';
	matrix[2][1] = 'o';
	matrix[2][2] = '-';
	Assert.assertFalse(ticTacToe.isMatrixFull(matrix));
  }
  
  @Test
  void test_hasPlayerWon_Tie() throws Exception {
	char[][] matrix = new char[3][3];
	matrix[0][0] = 'x';
	matrix[0][1] = 'o';
	matrix[0][2] = 'o';
	matrix[1][0] = 'o';
	matrix[1][1] = 'x';
	matrix[1][2] = 'x';
	matrix[2][0] = 'o';
	matrix[2][1] = 'x';
	matrix[2][2] = 'o';
	Assert.assertEquals(ticTacToe.hasPlayerWon(matrix), ' ');
  }
  
  @Test
  void test_hasPlayerWon_x() throws Exception {
	char[][] matrix = new char[3][3];
	matrix[0][0] = 'x';
	matrix[0][1] = 'o';
	matrix[0][2] = 'o';
	matrix[1][0] = 'x';
	matrix[1][1] = '0';
	matrix[1][2] = 'x';
	matrix[2][0] = 'x';
	matrix[2][1] = 'o';
	matrix[2][2] = 'o';
	Assert.assertEquals(ticTacToe.hasPlayerWon(matrix), 'x');
  }
  
  @Test
  void test_hasPlayerWon_o() throws Exception {
	char[][] matrix = new char[3][3];
	matrix[0][0] = 'o';
	matrix[0][1] = 'x';
	matrix[0][2] = 'x';
	matrix[1][0] = 'x';
	matrix[1][1] = 'o';
	matrix[1][2] = 'x';
	matrix[2][0] = 'x';
	matrix[2][1] = 'o';
	matrix[2][2] = 'o';
	Assert.assertEquals(ticTacToe.hasPlayerWon(matrix), 'o');
  }
}
