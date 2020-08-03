package cn.com.lacus.www;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode685 {
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

    class SubSolution extends Solution {
        private int[] parent = null;

        private int find(int u) {

            while (u != parent[u]) {
                //压缩路径
                parent[u] = parent[parent[u]];
                u = parent[u];

            }
            return u;
        }

        /**
         * @param edges
         * @return 需要考虑有没有环和重复的父节点
         */
        @Override
        public int[] findRedundantDirectedConnection(int[][] edges) {


            int[] backedge = new int[2];//存放最后一个后向边(环)
            int[] pending = new int[2];//存放最后一个重复的父节点
            parent = new int[edges.length + 1];

            for (int[] edge : edges) {

                if (parent[edge[1]] == 0) {//合并有向边
                    parent[edge[1]] = edge[0];
                } else {//有重复的父节点
                    pending = new int[]{edge[0], edge[1]};
                    backedge = new int[]{parent[edge[1]], edge[1]};
                    edge[1] = 0;
                }
            }
            for (int i = 0; i <= edges.length; i++) {
                parent[i] = i;
            }

            for (int[] e : edges) {

                if (e[1] == 0) {
                    continue;
                }
                //判断有没有环
                if (find(e[0]) == e[1]) {
                    return backedge[0] != 0 ? backedge : e;
                }
                parent[e[1]] = e[0];
            }

            return pending;
        }

    }
}
