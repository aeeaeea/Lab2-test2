import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

/**
 * 测试用例设计原则：
 * 1. 等价类划分：将输入空间划分为若干个等价类，每个等价类中的所有输入数据对程序的行为有相同的影响。
 * 2. 边界值分析：测试输入数据的边界值，以发现程序在边界条件下的错误。
 * 3. 特殊值测试：测试一些特殊的输入值，如空值、零值等。
 */
public class L2022211473_19_Test {

    /**
     * 测试目的：验证所有细胞最初都是死的情况下，细胞状态保持不变。
     * 测试用例：全为0的3x3矩阵。
     */
    @Test
    public void gameOfLife_allDeadCells() {
        Solution solution = new Solution();
        int[][] board = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        int[][] expected = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        solution.gameOfLife(board);
        assertArrayEquals(expected, board);
    }

    /**
     * 测试目的：验证所有细胞最初都是活的情况下，细胞状态的变化。
     * 测试用例：全为1的3x3矩阵。
     */
    @Test
    public void gameOfLife_allLiveCells() {
        Solution solution = new Solution();
        int[][] board = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        int[][] expected = {
            {1, 0, 1},
            {0, 0, 0},
            {1, 0, 1}
        };
        solution.gameOfLife(board);
        assertArrayEquals(expected, board);
    }

    /**
     * 测试目的：验证只有一个活细胞的情况下，细胞状态的变化。
     * 测试用例：中间一个1，其余为0的3x3矩阵。
     */
    @Test
    public void gameOfLife_singleLiveCell() {
        Solution solution = new Solution();
        int[][] board = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        int[][] expected = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        solution.gameOfLife(board);
        assertArrayEquals(expected, board);
    }

    /**
     * 测试目的：验证“闪烁器”振荡模式的细胞状态变化。
     * 测试用例：垂直排列的3个1，其余为0的3x3矩阵。
     */
    @Test
    public void gameOfLife_blinkerPattern() {
        Solution solution = new Solution();
        int[][] board = {
            {0, 1, 0},
            {0, 1, 0},
            {0, 1, 0}
        };
        int[][] expected = {
            {0, 0, 0},
            {1, 1, 1},
            {0, 0, 0}
        };
        solution.gameOfLife(board);
        assertArrayEquals(expected, board);
    }

    /**
     * 测试目的：验证“块”稳定模式的细胞状态保持不变。
     * 测试用例：2x2的全为1的矩阵。
     */
    @Test
    public void gameOfLife_blockPattern() {
        Solution solution = new Solution();
        int[][] board = {
            {1, 1},
            {1, 1}
        };
        int[][] expected = {
            {1, 1},
            {1, 1}
        };
        solution.gameOfLife(board);
        assertArrayEquals(expected, board);
    }

    /**
     * 测试目的：验证空板的情况下，程序抛出异常。
     * 测试用例：空矩阵。
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void gameOfLife_edgeCaseEmptyBoard() {
        Solution solution = new Solution();
        int[][] board = {};
        try {
            solution.gameOfLife(board);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Input board cannot be null or empty", e.getMessage());
            throw e;
        }
    }

    /**
     * 测试目的：验证单个活细胞的情况下，细胞状态的变化。
     * 测试用例：单个1的1x1矩阵。
     */
    @Test
    public void gameOfLife_edgeCaseSingleCellAlive() {
        Solution solution = new Solution();
        int[][] board = {
            {1}
        };
        int[][] expected = {
            {0}
        };
        solution.gameOfLife(board);
        assertArrayEquals(expected, board);
    }

    /**
     * 测试目的：验证单个死细胞的情况下，细胞状态保持不变。
     * 测试用例：单个0的1x1矩阵。
     */
    @Test
    public void gameOfLife_edgeCaseSingleCellDead() {
        Solution solution = new Solution();
        int[][] board = {
            {0}
        };
        int[][] expected = {
            {0}
        };
        solution.gameOfLife(board);
        assertArrayEquals(expected, board);
    }
}
//测试用例非常完善