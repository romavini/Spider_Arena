public class PrintGameScreen {

    static void printGameScreen(String[][] player, int cont, String error) {
        System.out.println();
        System.out.println();
        System.out.println(error);
        System.out.println();
        System.out.println(cont +" shifts! (missing "+(200- cont)+" for you to win)");
        System.out.println(Spider_Arena.life +" vidas!");
        System.out.println(Spider_Arena.points +" points! (missing "+(10 - Spider_Arena.points)+" for you to win)");
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
    }

    static void winOrLoseGameScreen() {
        if (Spider_Arena.life > 0) {
            System.out.println("Congratulations!! You won!!");
        } else{
            System.out.println("Better luck next time!");
        }
    }
}
