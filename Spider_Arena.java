import java.util.Random;
import java.io.*;

class Spider_Arena{
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
                                    if (u == i) {
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

                Mine(player, p1, i, j, u, v, limy, limx, cont_G, points);




                System.out.println();
                System.out.println();
                System.out.println(error);
                System.out.println();
                System.out.println(cont+" shifts! (missing "+(200-cont)+" for you to win)");
                System.out.println(life +" vidas!");
                System.out.println(points +" points! (missing "+(10 - points)+" for you to win)");
                System.out.println();
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("|"+ player[0][0]+"|"+ player[0][1]+"|"+ player[0][2]+"|"+ player[0][3]+"|"+ player[0][4]+"|"+ player[0][5]+"|"+ player[0][6]+"|"+ player[0][7]+"|"+ player[0][8]+"|"+ player[0][9]+"|"+ player[0][10]+"|"+ player[0][11]+"|"+ player[0][12]+"|"+ player[0][13]+"|"+ player[0][14]+"|"+ player[0][15]+"|"+ player[0][16]+"|"+ player[0][17]+"|"+ player[0][18]+"|");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("|"+ player[1][0]+"|"+ player[1][1]+"|"+ player[1][2]+"|"+ player[1][3]+"|"+ player[1][4]+"|"+ player[1][5]+"|"+ player[1][6]+"|"+ player[1][7]+"|"+ player[1][8]+"|"+ player[1][9]+"|"+ player[1][10]+"|"+ player[1][11]+"|"+ player[1][12]+"|"+ player[1][13]+"|"+ player[1][14]+"|"+ player[1][15]+"|"+ player[1][16]+"|"+ player[1][17]+"|"+ player[1][18]+"|");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("|"+ player[2][0]+"|"+ player[2][1]+"|"+ player[2][2]+"|"+ player[2][3]+"|"+ player[2][4]+"|"+ player[2][5]+"|"+ player[2][6]+"|"+ player[2][7]+"|"+ player[2][8]+"|"+ player[2][9]+"|"+ player[2][10]+"|"+ player[2][11]+"|"+ player[2][12]+"|"+ player[2][13]+"|"+ player[2][14]+"|"+ player[2][15]+"|"+ player[2][16]+"|"+ player[2][17]+"|"+ player[2][18]+"|");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("|"+ player[3][0]+"|"+ player[3][1]+"|"+ player[3][2]+"|"+ player[3][3]+"|"+ player[3][4]+"|"+ player[3][5]+"|"+ player[3][6]+"|"+ player[3][7]+"|"+ player[3][8]+"|"+ player[3][9]+"|"+ player[3][10]+"|"+ player[3][11]+"|"+ player[3][12]+"|"+ player[3][13]+"|"+ player[3][14]+"|"+ player[3][15]+"|"+ player[3][16]+"|"+ player[3][17]+"|"+ player[3][18]+"|");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("|"+ player[4][0]+"|"+ player[4][1]+"|"+ player[4][2]+"|"+ player[4][3]+"|"+ player[4][4]+"|"+ player[4][5]+"|"+ player[4][6]+"|"+ player[4][7]+"|"+ player[4][8]+"|"+ player[4][9]+"|"+ player[4][10]+"|"+ player[4][11]+"|"+ player[4][12]+"|"+ player[4][13]+"|"+ player[4][14]+"|"+ player[4][15]+"|"+ player[4][16]+"|"+ player[4][17]+"|"+ player[4][18]+"|");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("|"+ player[5][0]+"|"+ player[5][1]+"|"+ player[5][2]+"|"+ player[5][3]+"|"+ player[5][4]+"|"+ player[5][5]+"|"+ player[5][6]+"|"+ player[5][7]+"|"+ player[5][8]+"|"+ player[5][9]+"|"+ player[5][10]+"|"+ player[5][11]+"|"+ player[5][12]+"|"+ player[5][13]+"|"+ player[5][14]+"|"+ player[5][15]+"|"+ player[5][16]+"|"+ player[5][17]+"|"+ player[5][18]+"|");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("|"+ player[6][0]+"|"+ player[6][1]+"|"+ player[6][2]+"|"+ player[6][3]+"|"+ player[6][4]+"|"+ player[6][5]+"|"+ player[6][6]+"|"+ player[6][7]+"|"+ player[6][8]+"|"+ player[6][9]+"|"+ player[6][10]+"|"+ player[6][11]+"|"+ player[6][12]+"|"+ player[6][13]+"|"+ player[6][14]+"|"+ player[6][15]+"|"+ player[6][16]+"|"+ player[6][17]+"|"+ player[6][18]+"|");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("|"+ player[7][0]+"|"+ player[7][1]+"|"+ player[7][2]+"|"+ player[7][3]+"|"+ player[7][4]+"|"+ player[7][5]+"|"+ player[7][6]+"|"+ player[7][7]+"|"+ player[7][8]+"|"+ player[7][9]+"|"+ player[7][10]+"|"+ player[7][11]+"|"+ player[7][12]+"|"+ player[7][13]+"|"+ player[7][14]+"|"+ player[7][15]+"|"+ player[7][16]+"|"+ player[7][17]+"|"+ player[7][18]+"|");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("|"+ player[8][0]+"|"+ player[8][1]+"|"+ player[8][2]+"|"+ player[8][3]+"|"+ player[8][4]+"|"+ player[8][5]+"|"+ player[8][6]+"|"+ player[8][7]+"|"+ player[8][8]+"|"+ player[8][9]+"|"+ player[8][10]+"|"+ player[8][11]+"|"+ player[8][12]+"|"+ player[8][13]+"|"+ player[8][14]+"|"+ player[8][15]+"|"+ player[8][16]+"|"+ player[8][17]+"|"+ player[8][18]+"|");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("|"+ player[9][0]+"|"+ player[9][1]+"|"+ player[9][2]+"|"+ player[9][3]+"|"+ player[9][4]+"|"+ player[9][5]+"|"+ player[9][6]+"|"+ player[9][7]+"|"+ player[9][8]+"|"+ player[9][9]+"|"+ player[9][10]+"|"+ player[9][11]+"|"+ player[9][12]+"|"+ player[9][13]+"|"+ player[9][14]+"|"+ player[9][15]+"|"+ player[9][16]+"|"+ player[9][17]+"|"+ player[9][18]+"|");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("|"+ player[10][0]+"|"+ player[10][1]+"|"+ player[10][2]+"|"+ player[10][3]+"|"+ player[10][4]+"|"+ player[10][5]+"|"+ player[10][6]+"|"+ player[10][7]+"|"+ player[10][8]+"|"+ player[10][9]+"|"+ player[10][10]+"|"+ player[10][11]+"|"+ player[10][12]+"|"+ player[10][13]+"|"+ player[10][14]+"|"+ player[10][15]+"|"+ player[10][16]+"|"+ player[10][17]+"|"+ player[10][18]+"|");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("|"+ player[11][0]+"|"+ player[11][1]+"|"+ player[11][2]+"|"+ player[11][3]+"|"+ player[11][4]+"|"+ player[11][5]+"|"+ player[11][6]+"|"+ player[11][7]+"|"+ player[11][8]+"|"+ player[11][9]+"|"+ player[11][10]+"|"+ player[11][11]+"|"+ player[11][12]+"|"+ player[11][13]+"|"+ player[11][14]+"|"+ player[11][15]+"|"+ player[11][16]+"|"+ player[11][17]+"|"+ player[11][18]+"|");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("|"+ player[12][0]+"|"+ player[12][1]+"|"+ player[12][2]+"|"+ player[12][3]+"|"+ player[12][4]+"|"+ player[12][5]+"|"+ player[12][6]+"|"+ player[12][7]+"|"+ player[12][8]+"|"+ player[12][9]+"|"+ player[12][10]+"|"+ player[12][11]+"|"+ player[12][12]+"|"+ player[12][13]+"|"+ player[12][14]+"|"+ player[12][15]+"|"+ player[12][16]+"|"+ player[12][17]+"|"+ player[12][18]+"|");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("|"+ player[13][0]+"|"+ player[13][1]+"|"+ player[13][2]+"|"+ player[13][3]+"|"+ player[13][4]+"|"+ player[13][5]+"|"+ player[13][6]+"|"+ player[13][7]+"|"+ player[13][8]+"|"+ player[13][9]+"|"+ player[13][10]+"|"+ player[13][11]+"|"+ player[13][12]+"|"+ player[13][13]+"|"+ player[13][14]+"|"+ player[13][15]+"|"+ player[13][16]+"|"+ player[13][17]+"|"+ player[13][18]+"|");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("|"+ player[14][0]+"|"+ player[14][1]+"|"+ player[14][2]+"|"+ player[14][3]+"|"+ player[14][4]+"|"+ player[14][5]+"|"+ player[14][6]+"|"+ player[14][7]+"|"+ player[14][8]+"|"+ player[14][9]+"|"+ player[14][10]+"|"+ player[14][11]+"|"+ player[14][12]+"|"+ player[14][13]+"|"+ player[14][14]+"|"+ player[14][15]+"|"+ player[14][16]+"|"+ player[14][17]+"|"+ player[14][18]+"|");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("|"+ player[15][0]+"|"+ player[15][1]+"|"+ player[15][2]+"|"+ player[15][3]+"|"+ player[15][4]+"|"+ player[15][5]+"|"+ player[15][6]+"|"+ player[15][7]+"|"+ player[15][8]+"|"+ player[15][9]+"|"+ player[15][10]+"|"+ player[15][11]+"|"+ player[15][12]+"|"+ player[15][13]+"|"+ player[15][14]+"|"+ player[15][15]+"|"+ player[15][16]+"|"+ player[15][17]+"|"+ player[15][18]+"|");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("|"+ player[16][0]+"|"+ player[16][1]+"|"+ player[16][2]+"|"+ player[16][3]+"|"+ player[16][4]+"|"+ player[16][5]+"|"+ player[16][6]+"|"+ player[16][7]+"|"+ player[16][8]+"|"+ player[16][9]+"|"+ player[16][10]+"|"+ player[16][11]+"|"+ player[16][12]+"|"+ player[16][13]+"|"+ player[16][14]+"|"+ player[16][15]+"|"+ player[16][16]+"|"+ player[16][17]+"|"+ player[16][18]+"|");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("|"+ player[17][0]+"|"+ player[17][1]+"|"+ player[17][2]+"|"+ player[17][3]+"|"+ player[17][4]+"|"+ player[17][5]+"|"+ player[17][6]+"|"+ player[17][7]+"|"+ player[17][8]+"|"+ player[17][9]+"|"+ player[17][10]+"|"+ player[17][11]+"|"+ player[17][12]+"|"+ player[17][13]+"|"+ player[17][14]+"|"+ player[17][15]+"|"+ player[17][16]+"|"+ player[17][17]+"|"+ player[17][18]+"|");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("|"+ player[18][0]+"|"+ player[18][1]+"|"+ player[18][2]+"|"+ player[18][3]+"|"+ player[18][4]+"|"+ player[18][5]+"|"+ player[18][6]+"|"+ player[18][7]+"|"+ player[18][8]+"|"+ player[18][9]+"|"+ player[18][10]+"|"+ player[18][11]+"|"+ player[18][12]+"|"+ player[18][13]+"|"+ player[18][14]+"|"+ player[18][15]+"|"+ player[18][16]+"|"+ player[18][17]+"|"+ player[18][18]+"|");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("|"+ player[19][0]+"|"+ player[19][1]+"|"+ player[19][2]+"|"+ player[19][3]+"|"+ player[19][4]+"|"+ player[19][5]+"|"+ player[19][6]+"|"+ player[19][7]+"|"+ player[19][8]+"|"+ player[19][9]+"|"+ player[19][10]+"|"+ player[19][11]+"|"+ player[19][12]+"|"+ player[19][13]+"|"+ player[19][14]+"|"+ player[19][15]+"|"+ player[19][16]+"|"+ player[19][17]+"|"+ player[19][18]+"|");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("|"+ player[20][0]+"|"+ player[20][1]+"|"+ player[20][2]+"|"+ player[20][3]+"|"+ player[20][4]+"|"+ player[20][5]+"|"+ player[20][6]+"|"+ player[20][7]+"|"+ player[20][8]+"|"+ player[20][9]+"|"+ player[20][10]+"|"+ player[20][11]+"|"+ player[20][12]+"|"+ player[20][13]+"|"+ player[20][14]+"|"+ player[20][15]+"|"+ player[20][16]+"|"+ player[20][17]+"|"+ player[20][18]+"|");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("|"+ player[21][0]+"|"+ player[21][1]+"|"+ player[21][2]+"|"+ player[21][3]+"|"+ player[21][4]+"|"+ player[21][5]+"|"+ player[21][6]+"|"+ player[21][7]+"|"+ player[21][8]+"|"+ player[21][9]+"|"+ player[21][10]+"|"+ player[21][11]+"|"+ player[21][12]+"|"+ player[21][13]+"|"+ player[21][14]+"|"+ player[21][15]+"|"+ player[21][16]+"|"+ player[21][17]+"|"+ player[21][18]+"*");
                System.out.println("----------------------------------------------------------------------------*");
                System.out.println("|"+ player[22][0]+"|"+ player[22][1]+"|"+ player[22][2]+"|"+ player[22][3]+"|"+ player[22][4]+"|"+ player[22][5]+"|"+ player[22][6]+"|"+ player[22][7]+"|"+ player[22][8]+"|"+ player[22][9]+"|"+ player[22][10]+"|"+ player[22][11]+"|"+ player[22][12]+"|"+ player[22][13]+"|"+ player[22][14]+"|"+ player[22][15]+"|"+ player[22][16]+"|"+ player[22][17]+"|"+ player[22][18]+"*");
                System.out.println("------------------------------------------------------------------------*****");

                System.out.println();
                if (life > 0) {
                    System.out.println("You have "+teleport+" teleports, "+bombs+" bombs e "+mines+" mines");
                    System.out.println("W = up; S = down; A = left; D = right; T = teleport; Q = bomb; R = mine");
                    System.out.println();
                    text_D = readerInput.readLine();
                    cont++;
                }
            }
            if (life > 0) {
                System.out.println("Congratulations!! You won!!");
            } else{
                System.out.println("Better luck next time!");
            }
        } catch(Exception e){
            System.out.println("Reading mistake!");
        }
    }
    public static void Mine(String[][] player, boolean[][] p1, int i, int j, int u, int v, int limy, int limx, int cont_G, int points){
        double dist;
        if (p1[i][j] && cont_G != 1) {
            life--;
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
                                        life--;
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
