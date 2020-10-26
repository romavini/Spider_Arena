package io.github.mdcdxcvi.spider_arena;

public class Mine {
    public static void mine(String[][] player, boolean[][] p1, int i, int j, int u, int v, int limy, int limx, int cont_G, int points){
        double dist;
        if (p1[i][j] && cont_G != 1) {
            Spider_Arena.life--;
            p1[i][j] = false;
            for (int g = 0; g < limy; g++) {
                for (int h = 0; h < limx; h++) {
                    dist = Math.sqrt((u-g)*(u-g)+(v-h)*(v-h));
                    if (dist <= 3) {
                        player[g][h] = "#M#";
                        points++;
                        u = (limy-1);
                        v = (limx-1);
                        player[u][v] = " M ";
                    } else{
                        dist = Math.sqrt((i-g)*(i-g)+(j-h)*(j-h));
                        if (dist <= 3) {
                            player[g][h] = " * ";
                        }
                    }

                }
            }
            player[i][j] = "#H#";
        }
        if (p1[u][v]) {
            p1[u][v] = false;
            points++;
            for (int g = 0; g < limy; g++) {
                for (int h = 0; h < limx; h++) {

                    dist = Math.sqrt((u-g)*(u-g)+(v-h)*(v-h));
                    if (dist <= 3) {
                        player[g][h] = " * ";
                    }
                }
            }
        }
        for (int k = 0; k < limy; k++) {
            for (int l = 0; l < limx; l++) {
                if (player[k][l].equals(" * ") || player[k][l].equals("***")) {
                    if (p1[k][l]) {
                        p1[k][l] = false;
                        for (int g = 0; g < limy; g++) {
                            for (int h = 0; h < limx; h++) {
                                dist = Math.sqrt((k-g)*(k-g)+(l-h)*(l-h));
                                if (dist <= 3) {
                                    if (g == i && h == j){
                                        Spider_Arena.life--;
                                        player[g][h] = "#H#";
                                    } else{
                                        if (g == u && h == v) {
                                            player[g][h] = "#M#";
                                            points++;
                                            u = (limy-1);
                                            v = (limx-1);
                                            player[u][v] = " M ";
                                        }
                                        player[g][h] = " * ";
                                    }
                                }
                            }
                        }
                        player[k][l] = "*#*";
                    }
                }
            }
        }
    }
}
