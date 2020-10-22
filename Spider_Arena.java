import java.io.*;
import java.util.Random;

class Spider_Arena {
  public static final String THREE_ASTERISKS = "***";
  public static final int MAGIC_NUMBER_12 = 12;
  public static final int MAGIC_NUMBER_3 = 3;
  public static final String SPACE = " ";
  public static final String THREE_SPACES = "   ";
  public static final String MSPACE_M_SPACE = " M ";
  public static final String SPACE_ASTERIKS_SPACE = " * ";
  public static final String THREE_ZEROS = "000";
  static int V = MAGIC_NUMBER_3;
  static int Pontos = 0;
  public static final int DICE = 20;
  private static final Random gerador = new Random();

  public static void main(String args[]) {
    BufferedReader entrada;
    entrada = new BufferedReader(new InputStreamReader(System.in));
    try {
      int Limy = 23;
      int Limx = 19;
      String[][] P = generatePArray(Limy, Limx);
      boolean[][] P_1 = new boolean[Limy][Limx];

      double dist = 0;
      int T_M = 60;
      int T = 7;
      int B_M = 1000;
      int B = 20;
      int G = 20;
      int cont = 0;
      int prob = 0;
      int YOUCANTSTOP = 0;
      int i = 0;
      int j = 0;
      int u = (Limy - 1);
      int v = (Limx - 1);
      int a, b, c, d, cont_G, cont_T, cont_T_M, shot, mira_x, mira_y;
      boolean shouldStart = false;

      String D = SPACE;
      String ERRO = SPACE;

      while (V > 0 && cont <= 200 && Pontos <= 10) {

        if (cont != 0)
          shouldStart = true;

        for (int g = 0; g < Limy; g++) {
          for (int h = 0; h < Limx; h++) {
            if (P_1[g][h] == true) {
              P[g][h] = " ~ ";
            } else {
              P[g][h] = THREE_SPACES;
            }
          }
        }

        P[u][v] = MSPACE_M_SPACE;
        P[i][j] = " H ";
        cont_T = 0;
        cont_T_M = 0;
        cont_G = 0;
        shot = 10;
        YOUCANTSTOP = 0;
        double dist1 =  (((i - u) * (i - u)) + ((j - v) * (j - v)));
        dist = Math.sqrt(dist1);
        String ops = Double.toString(dist1);
        String ops1 = Double.toString(dist);
        ERRO =
            "i: "
                + i
                + " j: "
                + j
                + " u: "
                + u
                + " v: "
                + v
                + " sqrt de: "
                + ops
                + " e fim de: "
                + ops1;

        c = u;
        d = v;

        if (shouldStart) {
          prob = gerador.nextInt(27);
          if (prob > 11) {
            if (B_M > 0) {
              B_M--;
              if (u < i) {
                if (v < j) {
                  mira_y = (i - u);
                  mira_x = (j - v);
                  if ((mira_y - MAGIC_NUMBER_3) <= mira_x && (mira_y + MAGIC_NUMBER_3) >= mira_x) {
                    shot = 7;
                  } else {
                    if (mira_x == 1) {
                      shot = 6;
                    } else {
                      if (mira_y == 1) {
                        shot = 0;
                      } else {
                        prob = gerador.nextInt(MAGIC_NUMBER_12);
                      }
                    }
                  }
                } else {
                  if (v > j) {
                    mira_y = (i - u);
                    mira_x = (v - j);
                    if ((mira_y - MAGIC_NUMBER_3) <= mira_x && (mira_y + MAGIC_NUMBER_3) >= mira_x) {
                      shot = 5;
                    } else {
                      if (mira_x == 1) {
                        shot = 6;
                      } else {
                        if (mira_y == 1) {
                          shot = 4;
                        } else {
                          prob = gerador.nextInt(MAGIC_NUMBER_12);
                        }
                      }
                    }
                  } else {
                    shot = 6;
                  }
                }
              } else {
                if (u > i) {
                  if (v < j) {
                    mira_y = (u - i);
                    mira_x = (j - v);
                    if ((mira_y - MAGIC_NUMBER_3) <= mira_x && (mira_y + MAGIC_NUMBER_3) >= mira_x) {
                      shot = 1;
                    } else {
                      if (mira_x == 1) {
                        shot = 2;
                      } else {
                        if (mira_y == 1) {
                          shot = 0;
                        } else {
                          prob = gerador.nextInt(MAGIC_NUMBER_12);
                        }
                      }
                    }
                  } else {
                    if (v > j) {
                      mira_y = (u - i);
                      mira_x = (v - j);
                      if ((mira_y - MAGIC_NUMBER_3) <= mira_x && (mira_y + MAGIC_NUMBER_3) >= mira_x) {
                        shot = MAGIC_NUMBER_3;
                      } else {
                        if (mira_x == 1) {
                          shot = 2;
                        } else {
                          if (mira_y == 1) {
                            shot = 4;
                          } else {
                            prob = gerador.nextInt(MAGIC_NUMBER_12);
                          }
                        }
                      }
                    } else {
                      shot = 2;
                    }
                  }
                } else {
                  if (u == i) {
                    if (v < j) {
                      shot = 0;
                    } else {
                      if (v > j) {
                        shot = 4;
                      } else {
                        B_M++;
                      }
                    }
                  }
                }
              }

              switch (shot) {
                case 0: // Atirar para direita/centro
                  for (int h = v; h < Limx; h++) {
                    P[u][h] = THREE_ASTERISKS;
                  }
                  break;
                case 1: // Atirar para direita/cima
                  d = v;
                  for (int g = u; g >= 0; g--) {
                    if (d < Limx) {
                      P[g][d] = THREE_ASTERISKS;
                    } else {
                      g = -(g + 1);
                    }
                    d++;
                  }
                  d = v;
                  break;
                case 2: // Atirar para cima
                  for (int g = u; g >= 0; g--) {
                    P[g][v] = THREE_ASTERISKS;
                  }
                  break;
                case MAGIC_NUMBER_3: // Atirar para esquerda/cima
                  d = v;
                  for (int g = u; g >= 0; g--) {
                    if (d >= 0) {
                      P[g][d] = THREE_ASTERISKS;
                    } else {
                      g = -(g + 1);
                    }
                    d--;
                  }
                  d = v;
                  break;
                case 4: // Atirar para esquerda/centro
                  for (int h = v; h >= 0; h--) {
                    P[u][h] = THREE_ASTERISKS;
                  }
                  break;
                case 5: // Atirar para esquerda/baixo
                  d = v;
                  for (int g = u; g < Limy; g++) {
                    if (d >= 0) {
                      P[g][d] = THREE_ASTERISKS;
                    } else {
                      g = Limy;
                    }
                    d--;
                  }
                  d = v;
                  break;
                case 6: // Atirar para baixo
                  for (int g = u; g < Limy; g++) {
                    P[g][v] = THREE_ASTERISKS;
                  }
                  break;
                case 7: // Atirar para direita/baixo
                  d = v;
                  for (int g = u; g < Limy; g++) {
                    if (d < Limx) {
                      P[g][d] = THREE_ASTERISKS;
                    } else {
                      g = Limy;
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
              if (isDiceZero()) {
                v++;
              } else {
                u++;
              }
            } else {
              if (u > i) {
                if (isDiceZero()) {
                  v--;
                } else {
                  u--;
                }
              } else {
                if (v < j) {
                  if (isDiceZero()) {
                    u++;
                  } else {
                    v++;
                  }
                }
                if (v > j) {
                  if (isDiceZero()) {
                    u--;
                  } else {
                    v--;
                  }
                }
              }
            }
          } else {
            //isnt this the same as prob < 4 - could be separate method
            if (prob < 8) {
              if (v < j) {
                if (isDiceZero()) {
                  u++;
                } else {
                  v++;
                }
              } else {
                if (v > j) {
                  if (isDiceZero()) {
                    u--;
                  } else {
                    v--;
                  }
                } else {
                  if (u < i) {
                    if (isDiceZero()) {
                      v++;
                    } else {
                      u++;
                    }
                  } else {
                    if (u > i) {
                      if (isDiceZero()) {
                        v--;
                      } else {
                        u--;
                      }
                    }
                  }
                }
              }
            } else {

              if (prob < MAGIC_NUMBER_12) {
                if (T_M > 0) {
                  T_M--;
                  cont_T_M = 1;
                  u = gerador.nextInt(Limy);
                  v = gerador.nextInt(Limx);
                } else {
                  prob++;
                }
              }
            }
          }
        }

        if (u < 0 || u > (Limy - 1) || v < 0 || v > (Limx - 1)) {
          u = c;
          v = d;
          P[u][v] = MSPACE_M_SPACE;
        } else {
          if (cont_T_M == 1) {
            P[c][d] = "0+0";
            P[u][v] = "0M0";
            P[u][v] = "0M0";

          } else {
            P[c][d] = THREE_SPACES;
            P[u][v] = MSPACE_M_SPACE;
          }
        }

        a = i;
        b = j;

        if (D.equalsIgnoreCase("W")) {
          i--;
        } else {
          if (D.equalsIgnoreCase("S")) {
            i++;
          } else {
            if (D.equalsIgnoreCase("A")) {
              j--;
            } else {
              if (D.equalsIgnoreCase("D")) {
                j++;
              } else {
                if (isWHAT(D)) {
                  if (T > 0) {
                    i = gerador.nextInt(Limy);
                    j = gerador.nextInt(Limx);
                    T--;
                    ERRO = "TELEPORTE!!!!";
                    cont_T = 1;
                  } else {
                    ERRO = "Voce nao tem mais teleportes";
                  }
                } else {
                  if (isWHAT2(D)) {
                    if (B > 0) {
                      ERRO = "BOMBA!!!!!";
                      B--;
                      for (int g = 0; g < Limy; g++) {
                        for (int h = 0; h < Limx; h++) {
                          dist = Math.sqrt((i - g) * (i - g) + (j - h) * (j - h));
                          if (dist <= MAGIC_NUMBER_3) {
                            if (P[g][h] == MSPACE_M_SPACE) {
                              Pontos++;
                              u = (Limy - 1);
                              v = (Limx - 1);
                              P[u][v] = MSPACE_M_SPACE;
                            }

                            P[g][h] = SPACE_ASTERIKS_SPACE;

                            P[g][h] = SPACE_ASTERIKS_SPACE;
                          }
                        }
                      }
                    } else {
                      ERRO = "Voce nao tem mais bombas";
                    }
                  } else {
                    if (D.equalsIgnoreCase("R")) {
                      if (G > 0) {
                        ERRO = "Mina Terrestre!!!!!";
                        G--;
                        P_1[i][j] = true;
                        cont_G = 1;
                      } else {
                        ERRO = "Voce nao tem mais minas";
                      }
                    }
                  }
                }
              }
            }
          }
        }
        if (i < 0 || i > (Limy - 1) || j < 0 || j > (Limx - 1)) {
          i = a;
          j = b;
          P[i][j] = " H ";
          YOUCANTSTOP = 1;
          if (P[i][j] == THREE_ASTERISKS) {
            V--;
            P[i][j] = "*H*";
            YOUCANTSTOP = 1;
          }
          ERRO = "Voce nao pode avancar nesse sentido!!";
        } else {
          if (cont_T == 1) {
            if (P[a][b] == THREE_ASTERISKS) {
              P[a][b] = THREE_ZEROS;
            } else {
              P[a][b] = THREE_ZEROS;
            }
            if (P[i][j] == THREE_ASTERISKS) {
              V--;
              P[i][j] = "*H*";
            } else {
              P[i][j] = "0H0";
            }
          } else {
            if (cont_G == 1) {
            } else {
              if (P[a][b] == THREE_ASTERISKS) {
                P[a][b] = THREE_ASTERISKS;
              } else {
                if (P_1[a][b] == true) {
                  P[a][b] = " ~ ";
                } else {
                  P[a][b] = THREE_SPACES;
                }
              }
              if (P[i][j].equals(THREE_ASTERISKS)) {
                V--;
                P[i][j] = "*H*";
              } else {
                P[i][j] = " H ";
              }
            }
          }
        }

        if (u == i && j == v) {
          V--;
          P[i][j] = " X ";
          u = (Limy - 1);
          v = (Limx - 1);
        }

        Mina(P, P_1, i, j, u, v, Limy, Limx, YOUCANTSTOP, cont_G, Pontos);

        System.out.println();
        System.out.println();
        System.out.println(ERRO);
        ERRO = SPACE;
        System.out.println();
        System.out.println(cont + " turnos! (faltam " + (200 - cont) + " para voce ganhar)");
        System.out.println(V + " vidas!");
        System.out.println(Pontos + " portos! (faltam " + (10 - Pontos) + " para voce ganhar)");
        System.out.println();
        System.out.println(
            "-----------------------------------------------------------------------------");
        System.out.println(
            "|" + P[0][0] + "|" + P[0][1] + "|" + P[0][2] + "|" + P[0][MAGIC_NUMBER_3] + "|" + P[0][4] + "|"
                + P[0][5] + "|" + P[0][6] + "|" + P[0][7] + "|" + P[0][8] + "|" + P[0][9] + "|"
                + P[0][10] + "|" + P[0][11] + "|" + P[0][MAGIC_NUMBER_12] + "|" + P[0][13] + "|" + P[0][14] + "|"
                + P[0][15] + "|" + P[0][16] + "|" + P[0][17] + "|" + P[0][18] + "|");
        System.out.println(
            "-----------------------------------------------------------------------------");
        System.out.println(
            "|" + P[1][0] + "|" + P[1][1] + "|" + P[1][2] + "|" + P[1][MAGIC_NUMBER_3] + "|" + P[1][4] + "|"
                + P[1][5] + "|" + P[1][6] + "|" + P[1][7] + "|" + P[1][8] + "|" + P[1][9] + "|"
                + P[1][10] + "|" + P[1][11] + "|" + P[1][MAGIC_NUMBER_12] + "|" + P[1][13] + "|" + P[1][14] + "|"
                + P[1][15] + "|" + P[1][16] + "|" + P[1][17] + "|" + P[1][18] + "|");
        System.out.println(
            "-----------------------------------------------------------------------------");
        System.out.println(
            "|" + P[2][0] + "|" + P[2][1] + "|" + P[2][2] + "|" + P[2][MAGIC_NUMBER_3] + "|" + P[2][4] + "|"
                + P[2][5] + "|" + P[2][6] + "|" + P[2][7] + "|" + P[2][8] + "|" + P[2][9] + "|"
                + P[2][10] + "|" + P[2][11] + "|" + P[2][MAGIC_NUMBER_12] + "|" + P[2][13] + "|" + P[2][14] + "|"
                + P[2][15] + "|" + P[2][16] + "|" + P[2][17] + "|" + P[2][18] + "|");
        System.out.println(
            "-----------------------------------------------------------------------------");
        System.out.println(
            "|" + P[MAGIC_NUMBER_3][0] + "|" + P[MAGIC_NUMBER_3][1] + "|" + P[MAGIC_NUMBER_3][2] + "|" + P[MAGIC_NUMBER_3][MAGIC_NUMBER_3] + "|" + P[MAGIC_NUMBER_3][4] + "|"
                + P[MAGIC_NUMBER_3][5] + "|" + P[MAGIC_NUMBER_3][6] + "|" + P[MAGIC_NUMBER_3][7] + "|" + P[MAGIC_NUMBER_3][8] + "|" + P[MAGIC_NUMBER_3][9] + "|"
                + P[MAGIC_NUMBER_3][10] + "|" + P[MAGIC_NUMBER_3][11] + "|" + P[MAGIC_NUMBER_3][MAGIC_NUMBER_12] + "|" + P[MAGIC_NUMBER_3][13] + "|" + P[MAGIC_NUMBER_3][14] + "|"
                + P[MAGIC_NUMBER_3][15] + "|" + P[MAGIC_NUMBER_3][16] + "|" + P[MAGIC_NUMBER_3][17] + "|" + P[MAGIC_NUMBER_3][18] + "|");
        System.out.println(
            "-----------------------------------------------------------------------------");
        System.out.println(
            "|" + P[4][0] + "|" + P[4][1] + "|" + P[4][2] + "|" + P[4][MAGIC_NUMBER_3] + "|" + P[4][4] + "|"
                + P[4][5] + "|" + P[4][6] + "|" + P[4][7] + "|" + P[4][8] + "|" + P[4][9] + "|"
                + P[4][10] + "|" + P[4][11] + "|" + P[4][MAGIC_NUMBER_12] + "|" + P[4][13] + "|" + P[4][14] + "|"
                + P[4][15] + "|" + P[4][16] + "|" + P[4][17] + "|" + P[4][18] + "|");
        System.out.println(
            "-----------------------------------------------------------------------------");
        System.out.println(
            "|" + P[5][0] + "|" + P[5][1] + "|" + P[5][2] + "|" + P[5][MAGIC_NUMBER_3] + "|" + P[5][4] + "|"
                + P[5][5] + "|" + P[5][6] + "|" + P[5][7] + "|" + P[5][8] + "|" + P[5][9] + "|"
                + P[5][10] + "|" + P[5][11] + "|" + P[5][MAGIC_NUMBER_12] + "|" + P[5][13] + "|" + P[5][14] + "|"
                + P[5][15] + "|" + P[5][16] + "|" + P[5][17] + "|" + P[5][18] + "|");
        System.out.println(
            "-----------------------------------------------------------------------------");
        System.out.println(
            "|" + P[6][0] + "|" + P[6][1] + "|" + P[6][2] + "|" + P[6][MAGIC_NUMBER_3] + "|" + P[6][4] + "|"
                + P[6][5] + "|" + P[6][6] + "|" + P[6][7] + "|" + P[6][8] + "|" + P[6][9] + "|"
                + P[6][10] + "|" + P[6][11] + "|" + P[6][MAGIC_NUMBER_12] + "|" + P[6][13] + "|" + P[6][14] + "|"
                + P[6][15] + "|" + P[6][16] + "|" + P[6][17] + "|" + P[6][18] + "|");
        System.out.println(
            "-----------------------------------------------------------------------------");
        System.out.println(
            "|" + P[7][0] + "|" + P[7][1] + "|" + P[7][2] + "|" + P[7][MAGIC_NUMBER_3] + "|" + P[7][4] + "|"
                + P[7][5] + "|" + P[7][6] + "|" + P[7][7] + "|" + P[7][8] + "|" + P[7][9] + "|"
                + P[7][10] + "|" + P[7][11] + "|" + P[7][MAGIC_NUMBER_12] + "|" + P[7][13] + "|" + P[7][14] + "|"
                + P[7][15] + "|" + P[7][16] + "|" + P[7][17] + "|" + P[7][18] + "|");
        System.out.println(
            "-----------------------------------------------------------------------------");
        System.out.println(
            "|" + P[8][0] + "|" + P[8][1] + "|" + P[8][2] + "|" + P[8][MAGIC_NUMBER_3] + "|" + P[8][4] + "|"
                + P[8][5] + "|" + P[8][6] + "|" + P[8][7] + "|" + P[8][8] + "|" + P[8][9] + "|"
                + P[8][10] + "|" + P[8][11] + "|" + P[8][MAGIC_NUMBER_12] + "|" + P[8][13] + "|" + P[8][14] + "|"
                + P[8][15] + "|" + P[8][16] + "|" + P[8][17] + "|" + P[8][18] + "|");
        System.out.println(
            "-----------------------------------------------------------------------------");
        System.out.println(
            "|" + P[9][0] + "|" + P[9][1] + "|" + P[9][2] + "|" + P[9][MAGIC_NUMBER_3] + "|" + P[9][4] + "|"
                + P[9][5] + "|" + P[9][6] + "|" + P[9][7] + "|" + P[9][8] + "|" + P[9][9] + "|"
                + P[9][10] + "|" + P[9][11] + "|" + P[9][MAGIC_NUMBER_12] + "|" + P[9][13] + "|" + P[9][14] + "|"
                + P[9][15] + "|" + P[9][16] + "|" + P[9][17] + "|" + P[9][18] + "|");
        System.out.println(
            "-----------------------------------------------------------------------------");
        System.out.println(
            "|" + P[10][0] + "|" + P[10][1] + "|" + P[10][2] + "|" + P[10][MAGIC_NUMBER_3] + "|" + P[10][4] + "|"
                + P[10][5] + "|" + P[10][6] + "|" + P[10][7] + "|" + P[10][8] + "|" + P[10][9] + "|"
                + P[10][10] + "|" + P[10][11] + "|" + P[10][MAGIC_NUMBER_12] + "|" + P[10][13] + "|" + P[10][14]
                + "|" + P[10][15] + "|" + P[10][16] + "|" + P[10][17] + "|" + P[10][18] + "|");
        System.out.println(
            "-----------------------------------------------------------------------------");
        System.out.println(
            "|" + P[11][0] + "|" + P[11][1] + "|" + P[11][2] + "|" + P[11][MAGIC_NUMBER_3] + "|" + P[11][4] + "|"
                + P[11][5] + "|" + P[11][6] + "|" + P[11][7] + "|" + P[11][8] + "|" + P[11][9] + "|"
                + P[11][10] + "|" + P[11][11] + "|" + P[11][MAGIC_NUMBER_12] + "|" + P[11][13] + "|" + P[11][14]
                + "|" + P[11][15] + "|" + P[11][16] + "|" + P[11][17] + "|" + P[11][18] + "|");
        System.out.println(
            "-----------------------------------------------------------------------------");
        System.out.println(
            "|" + P[MAGIC_NUMBER_12][0] + "|" + P[MAGIC_NUMBER_12][1] + "|" + P[MAGIC_NUMBER_12][2] + "|" + P[MAGIC_NUMBER_12][MAGIC_NUMBER_3] + "|" + P[MAGIC_NUMBER_12][4] + "|"
                + P[MAGIC_NUMBER_12][5] + "|" + P[MAGIC_NUMBER_12][6] + "|" + P[MAGIC_NUMBER_12][7] + "|" + P[MAGIC_NUMBER_12][8] + "|" + P[MAGIC_NUMBER_12][9] + "|"
                + P[MAGIC_NUMBER_12][10] + "|" + P[MAGIC_NUMBER_12][11] + "|" + P[MAGIC_NUMBER_12][MAGIC_NUMBER_12] + "|" + P[MAGIC_NUMBER_12][13] + "|" + P[MAGIC_NUMBER_12][14]
                + "|" + P[MAGIC_NUMBER_12][15] + "|" + P[MAGIC_NUMBER_12][16] + "|" + P[MAGIC_NUMBER_12][17] + "|" + P[MAGIC_NUMBER_12][18] + "|");
        System.out.println(
            "-----------------------------------------------------------------------------");
        System.out.println(
            "|" + P[13][0] + "|" + P[13][1] + "|" + P[13][2] + "|" + P[13][MAGIC_NUMBER_3] + "|" + P[13][4] + "|"
                + P[13][5] + "|" + P[13][6] + "|" + P[13][7] + "|" + P[13][8] + "|" + P[13][9] + "|"
                + P[13][10] + "|" + P[13][11] + "|" + P[13][MAGIC_NUMBER_12] + "|" + P[13][13] + "|" + P[13][14]
                + "|" + P[13][15] + "|" + P[13][16] + "|" + P[13][17] + "|" + P[13][18] + "|");
        System.out.println(
            "-----------------------------------------------------------------------------");
        System.out.println(
            "|" + P[14][0] + "|" + P[14][1] + "|" + P[14][2] + "|" + P[14][MAGIC_NUMBER_3] + "|" + P[14][4] + "|"
                + P[14][5] + "|" + P[14][6] + "|" + P[14][7] + "|" + P[14][8] + "|" + P[14][9] + "|"
                + P[14][10] + "|" + P[14][11] + "|" + P[14][MAGIC_NUMBER_12] + "|" + P[14][13] + "|" + P[14][14]
                + "|" + P[14][15] + "|" + P[14][16] + "|" + P[14][17] + "|" + P[14][18] + "|");
        System.out.println(
            "-----------------------------------------------------------------------------");
        System.out.println(
            "|" + P[15][0] + "|" + P[15][1] + "|" + P[15][2] + "|" + P[15][MAGIC_NUMBER_3] + "|" + P[15][4] + "|"
                + P[15][5] + "|" + P[15][6] + "|" + P[15][7] + "|" + P[15][8] + "|" + P[15][9] + "|"
                + P[15][10] + "|" + P[15][11] + "|" + P[15][MAGIC_NUMBER_12] + "|" + P[15][13] + "|" + P[15][14]
                + "|" + P[15][15] + "|" + P[15][16] + "|" + P[15][17] + "|" + P[15][18] + "|");
        System.out.println(
            "-----------------------------------------------------------------------------");
        System.out.println(
            "|" + P[16][0] + "|" + P[16][1] + "|" + P[16][2] + "|" + P[16][MAGIC_NUMBER_3] + "|" + P[16][4] + "|"
                + P[16][5] + "|" + P[16][6] + "|" + P[16][7] + "|" + P[16][8] + "|" + P[16][9] + "|"
                + P[16][10] + "|" + P[16][11] + "|" + P[16][MAGIC_NUMBER_12] + "|" + P[16][13] + "|" + P[16][14]
                + "|" + P[16][15] + "|" + P[16][16] + "|" + P[16][17] + "|" + P[16][18] + "|");
        System.out.println(
            "-----------------------------------------------------------------------------");
        System.out.println(
            "|" + P[17][0] + "|" + P[17][1] + "|" + P[17][2] + "|" + P[17][MAGIC_NUMBER_3] + "|" + P[17][4] + "|"
                + P[17][5] + "|" + P[17][6] + "|" + P[17][7] + "|" + P[17][8] + "|" + P[17][9] + "|"
                + P[17][10] + "|" + P[17][11] + "|" + P[17][MAGIC_NUMBER_12] + "|" + P[17][13] + "|" + P[17][14]
                + "|" + P[17][15] + "|" + P[17][16] + "|" + P[17][17] + "|" + P[17][18] + "|");
        System.out.println(
            "-----------------------------------------------------------------------------");
        System.out.println(
            "|" + P[18][0] + "|" + P[18][1] + "|" + P[18][2] + "|" + P[18][MAGIC_NUMBER_3] + "|" + P[18][4] + "|"
                + P[18][5] + "|" + P[18][6] + "|" + P[18][7] + "|" + P[18][8] + "|" + P[18][9] + "|"
                + P[18][10] + "|" + P[18][11] + "|" + P[18][MAGIC_NUMBER_12] + "|" + P[18][13] + "|" + P[18][14]
                + "|" + P[18][15] + "|" + P[18][16] + "|" + P[18][17] + "|" + P[18][18] + "|");
        System.out.println(
            "-----------------------------------------------------------------------------");
        System.out.println(
            "|" + P[19][0] + "|" + P[19][1] + "|" + P[19][2] + "|" + P[19][MAGIC_NUMBER_3] + "|" + P[19][4] + "|"
                + P[19][5] + "|" + P[19][6] + "|" + P[19][7] + "|" + P[19][8] + "|" + P[19][9] + "|"
                + P[19][10] + "|" + P[19][11] + "|" + P[19][MAGIC_NUMBER_12] + "|" + P[19][13] + "|" + P[19][14]
                + "|" + P[19][15] + "|" + P[19][16] + "|" + P[19][17] + "|" + P[19][18] + "|");
        System.out.println(
            "-----------------------------------------------------------------------------");
        System.out.println(
            "|" + P[20][0] + "|" + P[20][1] + "|" + P[20][2] + "|" + P[20][MAGIC_NUMBER_3] + "|" + P[20][4] + "|"
                + P[20][5] + "|" + P[20][6] + "|" + P[20][7] + "|" + P[20][8] + "|" + P[20][9] + "|"
                + P[20][10] + "|" + P[20][11] + "|" + P[20][MAGIC_NUMBER_12] + "|" + P[20][13] + "|" + P[20][14]
                + "|" + P[20][15] + "|" + P[20][16] + "|" + P[20][17] + "|" + P[20][18] + "|");
        System.out.println(
            "-----------------------------------------------------------------------------");
        System.out.println(
            "|" + P[21][0] + "|" + P[21][1] + "|" + P[21][2] + "|" + P[21][MAGIC_NUMBER_3] + "|" + P[21][4] + "|"
                + P[21][5] + "|" + P[21][6] + "|" + P[21][7] + "|" + P[21][8] + "|" + P[21][9] + "|"
                + P[21][10] + "|" + P[21][11] + "|" + P[21][MAGIC_NUMBER_12] + "|" + P[21][13] + "|" + P[21][14]
                + "|" + P[21][15] + "|" + P[21][16] + "|" + P[21][17] + "|" + P[21][18] + "*");
        System.out.println(
            "----------------------------------------------------------------------------*");
        System.out.println(
            "|" + P[22][0] + "|" + P[22][1] + "|" + P[22][2] + "|" + P[22][MAGIC_NUMBER_3] + "|" + P[22][4] + "|"
                + P[22][5] + "|" + P[22][6] + "|" + P[22][7] + "|" + P[22][8] + "|" + P[22][9] + "|"
                + P[22][10] + "|" + P[22][11] + "|" + P[22][MAGIC_NUMBER_12] + "|" + P[22][13] + "|" + P[22][14]
                + "|" + P[22][15] + "|" + P[22][16] + "|" + P[22][17] + "|" + P[22][18] + "*");
        System.out.println(
            "------------------------------------------------------------------------*****");

        System.out.println();
        if (V > 0) {
          System.out.println("Voce tem " + T + " teleportes, " + B + " bombas e " + G + " minas");
          System.out.println(
              "W = cima; S = baixo; A = esquerda; D = direira; T = teleporte; Q = bomba; R = mina");
          System.out.println();
          D = entrada.readLine();
          cont++;
        }
      }
      if (V > 0) {
        System.out.println("Parabens!! Voce ganhou!!");
      } else {
        System.out.println("Mais sorte na proxima vez!");
      }
    } catch (Exception e) {
      System.out.println("Erro de Leitura!");
    }
  }

  private static boolean isDiceZero() {
    return gerador.nextInt(DICE) == 0;
  }


  // change name
  private static boolean isWHAT2(String d) {
    return d.equalsIgnoreCase("Q") || d.equals("qt") || d.equals("tq");
  }

  //change name to what this method checks (what letters "T","t","wt"... means)
  private static boolean isWHAT(String d) {
    return d.equals("T")
            || d.equals("t")
            || d.equals("wt")
            || d.equals("st")
            || d.equals("at")
            || d.equals("dt")
            || d.equals("tw")
            || d.equals("ts")
            || d.equals("ta")
            || d.equals("td");
  }

  private static String[][] generatePArray(int limy, int limx) {
    String p[][] = new String[limy][limx];
    for (int i = 0; i < limy; i++) {
      for (int j = 0; j < limx; j++) {
        p[i][j] = THREE_SPACES;
      }
    }
    return p;
  }

  public static void Mina(
      String P[][],
      boolean P_1[][],
      int i,
      int j,
      int u,
      int v,
      int Limy,
      int Limx,
      int YOUCANTSTOP,
      int cont_G,
      int Pontos) {
    double dist = 0;
    if (P_1[i][j] == true && cont_G != 1) {
      V--;
      P_1[i][j] = false;
      for (int g = 0; g < Limy; g++) {
        for (int h = 0; h < Limx; h++) {
          dist = Math.sqrt((u - g) * (u - g) + (v - h) * (v - h));
          if (dist <= MAGIC_NUMBER_3) {
            P[g][h] = "#M#";
            Pontos++;
            u = (Limy - 1);
            v = (Limx - 1);
            P[u][v] = MSPACE_M_SPACE;
          } else {
            dist = Math.sqrt((i - g) * (i - g) + (j - h) * (j - h));
            if (dist <= MAGIC_NUMBER_3) {
              P[g][h] = SPACE_ASTERIKS_SPACE;
            }
          }
        }
      }
      P[i][j] = "#H#";
    }
    if (P_1[u][v] == true) {
      P_1[u][v] = false;
      Pontos++;
      for (int g = 0; g < Limy; g++) {
        for (int h = 0; h < Limx; h++) {

          dist = Math.sqrt((u - g) * (u - g) + (v - h) * (v - h));
          if (dist <= MAGIC_NUMBER_3) {
            P[g][h] = SPACE_ASTERIKS_SPACE;
          }
        }
      }
    }
    for (int k = 0; k < Limy; k++) {
      for (int l = 0; l < Limx; l++) {
        if (P[k][l] == SPACE_ASTERIKS_SPACE || P[k][l] == THREE_ASTERISKS) {
          if (P_1[k][l] == true) {
            P_1[k][l] = false;
            for (int g = 0; g < Limy; g++) {
              for (int h = 0; h < Limx; h++) {
                dist = Math.sqrt((k - g) * (k - g) + (l - h) * (l - h));
                if (dist <= MAGIC_NUMBER_3) {
                  if (g == i && h == j) {
                    V--;
                    P[g][h] = "#H#";
                  } else {
                    if (g == u && h == v) {
                      P[g][h] = "#M#";
                      Pontos++;
                      u = (Limy - 1);
                      v = (Limx - 1);
                      P[u][v] = MSPACE_M_SPACE;
                      P[g][h] = SPACE_ASTERIKS_SPACE;
                    } else {
                      P[g][h] = SPACE_ASTERIKS_SPACE;
                    }
                  }
                }
              }
            }
            P[k][l] = "*#*";
          }
        }
      }
    }
  }
}
