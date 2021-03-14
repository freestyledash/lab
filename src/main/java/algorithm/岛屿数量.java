package algorithm;

/**
 * Description
 * https://leetcode-cn.com/problems/number-of-islands/
 *
 * 搜索
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2021/03/13
 */
public class 岛屿数量 {

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    //开始搜索 DFS
                    search(grid, i, j);
                    result++;
                }

            }
        }

        return result;
    }

    void search(char[][] grid, int x, int y) {
        if (!(x >= 0 && grid.length > x && y >= 0 && grid[x].length > y)) {
            return;
        }
        if (grid[x][y] == '1') {
            //清理
            grid[x][y] = '0';

            //dfs
            search(grid, x + 1, y);
            search(grid, x - 1, y);
            search(grid, x, y + 1);
            search(grid, x, y - 1);
        }

    }

}
