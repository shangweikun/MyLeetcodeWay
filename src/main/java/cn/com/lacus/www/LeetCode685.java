package cn.com.lacus.www;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public int[] findRedundantDirectedConnection(int[][] edges) {

        if (edges.length == 0) return null;

        final int length = edges.length;
        int[][] map = new int[length + 1][length + 1];
        Set set = new HashSet();

        for (int i = 1; i < length; i++) {
            Arrays.fill(map[i], 0);
        }

        int tmp = -1;
        int right = -1;

        for (int i = 0; i < length; i++) {
            if (!set.add(edges[i][1])) {
                right = edges[i][1];
                tmp = i;
            }
            map[edges[i][0]][edges[i][1]] = 1;
        }

        if (right > 0) {
            for (int i = tmp; i >= 0; i--) {
                if (edges[i][1] == right) {
                    map[edges[i][0]][right] = 0;
                    if (checkMap1(map, edges[i][0]) && checkMap(map, right)) {
                        return edges[i];
                    }
                }
            }

        } else {
            for (int i = length - 1; i > 0; i--) {
                map[edges[i][0]][edges[i][1]] = 0;
                for (int j = 1; j <= length; j++) {
                    if (map[edges[i][1]][j] == 1)
                        return edges[i];
                }
            }
        }


        return null;
    }

    private boolean checkMap(int[][] map, int right) {
        for (int i = 1; i < map.length; i++) {
            if (map[i][right] == 1 && map[right][i] == 1) return false;
        }
        return true;
    }

    private boolean checkMap1(int[][] map, int left) {
        for (int j = 1; j < map.length; j++) {
            if (map[j][left] == 1) return true;
            if (map[left][j] == 1) return true;
        }
        return false;
    }
}