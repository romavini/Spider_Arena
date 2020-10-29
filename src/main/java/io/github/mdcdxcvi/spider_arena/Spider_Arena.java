package io.github.mdcdxcvi.spider_arena;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Spider_Arena {
    static int life = 3;
    static int points = 0;

    public static void main (String[] args){
        BufferedReader readerInput;
        readerInput = new BufferedReader(new InputStreamReader(System.in));
        Random random = new Random();

        try{
            int limy = 23;
            int limx = 19;
            String[][] player = new String  [limy][limx];
            boolean[][] p1 = new boolean [limy][limx];

            for (int i = 0; i < limy; i++) {
                for (int j = 0; j < limx; j++) {
                    player[i][j] = "   ";
                }
            }

            double dist;
            int tm	= 60;
            int teleport = 7;
            int bM	= 1000;
            int bombs = 20;
            int mines = 20;
            int cont = 0;
            int prob;
            int dice = 20;
            int i = 0;
            int j = 0;
            int u = (limy-1);
            int v = (limx-1);
            int a, b, c, d, cont_G, cont_T, contTM, shot, aim_x, aim_y;
            boolean start = false;

            String text_D = " ";
            String error;


            while(life > 0 && cont <= 200 && points <= 10){

                if (cont != 0) {
                    start = true;
                }

                for (int g = 0; g < limy; g++) {
                    for (int h = 0; h < limx; h++) {
                        if (p1[g][h]) {
                            player[g][h] = " ~ ";
                        } else{
                            player[g][h] = "   ";
                        }
                    }
                }

                player[u][v]  = " M ";
                player[i][j]  = " H ";
                cont_T   = 0;
                contTM = 0;
                cont_G 	 = 0;
                shot     = 10;
                int a1 = ((i - u) * (i - u)) + ((j - v) * (j - v));
                dist = Math.sqrt(a1);
                String ops = Double.toString(a1);
                String ops1 = Double.toString(dist);
                error = "i: "+i+" j: "+j+" u: "+u+" v: "+v+" sqrt of: "+ops+" and end of: "+ops1;

                c = u;
                d = v;

                if (start) {
                    prob = random.nextInt(27);
                    if (prob > 11) {
                        if (bM > 0) {
                            bM--;
                            if (u < i){
                                if (v < j) {
                                    aim_y = (i-u);
                                    aim_x = (j-v);
                                    if ((aim_y-3) <= aim_x && (aim_y+3) >= aim_x) {
                                        shot = 7;
                                    } else{
                                        if (aim_x == 1) {
                                            shot = 6;
                                        } else{
                                            if (aim_y == 1) {
                                                shot = 0;
                                            } else{
                                                prob = random.nextInt(12);
                                            }
                                        }
                                    }
                                } else{
                                    if (v > j) {
                                        aim_y = (i-u);
                                        aim_x = (v-j);
                                        if ((aim_y-3) <= aim_x && (aim_y+3) >= aim_x) {
                                            shot = 5;
                                        } else{
                                            if (aim_x == 1) {
                                                shot = 6;
                                            } else{
                                                if (aim_y == 1) {
                                                    shot = 4;
                                                } else{
                                                    prob = random.nextInt(12);
                                                }
                                            }
                                        }
                                    } else{
                                        shot = 6;
                                    }
                                }
                            } else{
                                if (u > i) {
                                    if (v < j) {
                                        aim_y = (u-i);
                                        aim_x = (j-v);
                                        if ((aim_y-3) <= aim_x && (aim_y+3) >= aim_x) {
                                            shot = 1;
                                        } else{
                                            if (aim_x == 1) {
                                                shot = 2;
                                            } else{
                                                if (aim_y == 1) {
                                                    shot = 0;
                                                } else{
                                                    prob = random.nextInt(12);
                                                }
                                            }
                                        }
                                    } else{
                                        if (v > j) {
                                            aim_y = (u-i);
                                            aim_x = (v-j);
                                            if ((aim_y-3) <= aim_x && (aim_y+3) >= aim_x) {
                                                shot = 3;
                                            } else{
                                                if (aim_x == 1) {
                                                    shot = 2;
                                                } else{
                                                    if (aim_y == 1) {
                                                        shot = 4;
                                                    } else{
                                                        prob = random.nextInt(12);
                                                    }
                                                }
                                            }
                                        } else{
                                            shot = 2;
                                        }
                                    }
                                } else{
                                    if (v < j) {
                                        shot = 0;
                                    } else{
                                        if (v > j) {
                                            shot = 4;
                                        } else{
                                            bM++;
                                        }
                                    }
                                }
                            }


                            switch (shot){
                                case 0: // Shoot right / center
                                    for (int h = v; h < limx; h++) {
                                        player[u][h] = "***";
                                    }
                                    break;
                                case 1: // Shoot right / up
                                    d = v;
                                    for (int g = u; g >= 0; g--) {
                                        if (d < limx) {
                                            player[g][d] = "***";
                                        } else{
                                            g = -(g + 1);
                                        }
                                        d++;
                                    }
                                    d = v;
                                    break;
                                case 2: // Shoot up
                                    for (int g = u; g >= 0; g--) {
                                        player[g][v] = "***";
                                    }
                                    break;
                                case 3: // Shoot left / up
                                    d = v;
                                    for (int g = u; g >= 0; g--) {
                                        if (d >= 0) {
                                            player[g][d] = "***";
                                        } else{
                                            g = -(g + 1);
                                        }
                                        d--;
                                    }
                                    d = v;
                                    break;
                                case 4: // Shoot left / center
                                    for (int h = v; h >= 0; h--) {
                                        player[u][h] = "***";
                                    }
                                    break;
                                case 5: // Shoot Left / Down
                                    d = v;
                                    for (int g = u; g < limy; g++) {
                                        if (d >= 0) {
                                            player[g][d] = "***";
                                        } else{
                                            g = limy;
                                        }
                                        d--;
                                    }
                                    d = v;
                                    break;
                                case 6: // Shoot down
                                    for (int g = u; g < limy; g++) {
                                        player[g][v] = "***";
                                    }
                                    break;
                                case 7: // Shoot Right / Down
                                    d = v;
                                    for (int g = u; g < limy; g++) {
                                        if (d < limx) {
                                            player[g][d] = "***";
                                        } else{
                                            g = limy;
                                        }
                                        d++;
                                    }
                                    d = v;
                                    break;
                            }
                        }
                    }

                    if (prob < 4) {
                        if (u < i) {
                            if (random.nextInt(dice) == 0) {
                                v++;
                            } else{
                                u++;
                            }
                        } else{
                            if (u > i) {
                                if (random.nextInt(dice) == 0) {
                                    v--;
                                } else{
                                    u--;
                                }
                            } else{
                                if (v < j) {
                                    if (random.nextInt(dice) == 0) {
                                        u++;
                                    } else{
                                        v++;
                                    }
                                }
                                if (v > j) {
                                    if (random.nextInt(dice) == 0) {
                                        u--;
                                    } else{
                                        v--;
                                    }
                                }
                            }
                        }
                    } else{

                        if (prob < 8){
                            if (v < j) {
                                if (random.nextInt(dice) == 0) {
                                    u++;
                                } else{
                                    v++;
                                }
                            } else{
                                if (v > j) {
                                    if (random.nextInt(dice) == 0) {
                                        u--;
                                    } else{
                                        v--;
                                    }
                                } else{
                                    if (u < i) {
                                        if (random.nextInt(dice) == 0) {
                                            v++;
                                        } else{
                                            u++;
                                        }
                                    } else{
                                        if (u > i) {
                                            if (random.nextInt(dice) == 0) {
                                                v--;
                                            } else{
                                                u--;
                                            }
                                        }
                                    }
                                }
                            }
                        } else{

                            if (prob < 12) {
                                if (tm > 0) {
                                    tm--;
                                    contTM = 1;
                                    u = random.nextInt(limy);
                                    v = random.nextInt(limx);
                                } else {
                                    prob++;
                                }
                            }
                        }
                    }
                }

                if (u < 0 || u > (limy-1) || v < 0 || v > (limx-1)){
                    u = c;
                    v = d;
                    player[u][v] = " M ";
                } else{
                    if (contTM == 1) {
                        player[c][d] = "0+0";
                        player[u][v] = "0M0";
                        player[u][v] = "0M0";

                    } else{
                        player[c][d] = "   ";
                        player[u][v] = " M ";
                    }
                }

                a = i;
                b = j;


                if (text_D.equals("W") || text_D.equals("w")){
                    i--;
                } else{
                    if (text_D.equals("S") || text_D.equals("s")) {
                        i++;
                    } else{
                        if (text_D.equals("A") || text_D.equals("a")) {
                            j--;
                        } else{
                            if (text_D.equals("D") || text_D.equals("d")) {
                                j++;
                            } else{
                                if (text_D.equals("T") || text_D.equals("t") || text_D.equals("wt") || text_D.equals("st") || text_D.equals("at") || text_D.equals("dt") || text_D.equals("tw") || text_D.equals("ts") || text_D.equals("ta") || text_D.equals("td")) {
                                    if (teleport > 0) {
                                        i =  random.nextInt(limy);
                                        j =  random.nextInt(limx);
                                        teleport--;
                                        error = "TELEPORT!!!!";
                                        cont_T = 1;
                                    } else{
                                        error = "You don't have any more teleports";
                                    }
                                } else{
                                    if (text_D.equals("Q") || text_D.equals("q") || text_D.equals("qt") || text_D.equals("tq")) {
                                        if (bombs > 0) {
                                            error = "BOMB!!!!!";
                                            bombs--;
                                            for (int g = 0; g < limy; g++) {
                                                for (int h = 0; h < limx; h++) {
                                                    dist = Math.sqrt((i-g)*(i-g)+(j-h)*(j-h));
                                                    if (dist <= 3){
                                                        if (player[g][h].equals(" M ")){
                                                            points++;
                                                            u = (limy-1);
                                                            v = (limx-1);
                                                            player[u][v] = " M ";
                                                        }

                                                        player[g][h] = " * ";
                                                        player[g][h] = " * ";

                                                    }
                                                }
                                            }
                                        } else{
                                            error = "You don't have any more bombs";
                                        }
                                    } else{
                                        if (text_D.equals("R") || text_D.equals("r")) {
                                            if (mines > 0) {
                                                error = "Land Mine!!!!!";
                                                mines--;
                                                p1[i][j] = true;
                                                cont_G = 1;
                                            } else{
                                                error = "You don't have any more mines";
                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (i < 0 || i > (limy-1) || j < 0 || j > (limx-1)){
                    i = a;
                    j = b;
                    player[i][j] = " H ";
                    if (player[i][j].equals("***")) {
                        life--;
                        player[i][j] = "*H*";

                    }
                    error = "You cannot go in that direction!!";
                } else{
                    if (cont_T == 1) {
                        player[a][b] = "000";
                        if (player[i][j].equals("***")) {
                            life--;
                            player[i][j] = "*H*";
                        } else{
                            player[i][j] = "0H0";
                        }
                    } else{
                        if (cont_G == 1) {
                        } else{
                            if (player[a][b].equals("***")) {
                                player[a][b] = "***";
                            } else{
                                if (p1[a][b]) {
                                    player[a][b] = " ~ ";
                                } else{
                                    player[a][b] = "   ";
                                }
                            }
                            if (player[i][j].equals("***")) {
                                life--;
                                player[i][j] = "*H*";
                            } else{
                                player[i][j] = " H ";
                            }
                        }
                    }
                }

                if (u == i && j == v) {
                    life--;
                    player[i][j] = " X ";
                    u 		= (limy-1);
                    v 		= (limx-1);
                }

                Mine.mine(player, p1, i, j, u, v, limy, limx, cont_G, points);

                PrintGameScreen.printGameScreen(player, cont, error);

                if (life > 0) {
                    System.out.println("You have "+teleport+" teleports, "+bombs+" bombs e "+mines+" mines");
                    System.out.println("W = up; S = down; A = left; D = right; T = teleport; Q = bomb; R = mine");
                    System.out.println();
                    text_D = readerInput.readLine();
                    cont++;
                }
            }

            PrintGameScreen.winOrLoseGameScreen();

        } catch(Exception e){
            System.out.println("Reading mistake!");
        }
    }

}
