import java.util.Random;
import java.io.*;
class Spider_Arena{
	static int V 			= 3;
	static int Points		= 0;
	public static void main (String args[]){
		BufferedReader bufferReader;
		bufferReader = new BufferedReader(new InputStreamReader(System.in));
		Random generator = new Random();
		try{
			int Limy = 23;
			int Limx = 19;
			String 	P[][] 	= new String  [Limy][Limx];
			boolean P_1[][] = new boolean [Limy][Limx];

			for (int i = 0; i < Limy; i++) {
				for (int j = 0; j < Limx; j++) {
					P[i][j] = "   ";
				}
			}

			double dist		= 0;
			int T_M			= 60;
			int T 			= 7;
			int B_M			= 1000;
			int B 			= 20;
			int G 			= 20;
			int cont 		= 0;
			int prob   		= 0;
			int dice		= 20; //rolled dice for monster chase
			int YOUCANTSTOP = 0;
			int i 			= 0;
			int j 			= 0;
			int u 			= (Limy-1);
			int v 			= (Limx-1);
			int a, b, c, d, cont_G, cont_T, cont_T_M, shot, mira_x, mira_y;
			boolean start = false;

			String D = " ";
			String ERRO = " ";


			while(V > 0 && cont <= 200 && Points <= 10){

			if (cont != 0) {
				start = true;
			}

				for (int g = 0; g < Limy; g++) {
					for (int h = 0; h < Limx; h++) {
						if (P_1[g][h] == true) {
							P[g][h] = " ~ ";
						} else{
							P[g][h] = "   ";
						}
					}
				}

				P[u][v]  = " M ";
				P[i][j]  = " H ";
				cont_T   = 0;
				cont_T_M = 0;
				cont_G 	 = 0;
				shot     = 10;
				YOUCANTSTOP = 0;
				dist = Math.sqrt(((i-u)*(i-u))+((j-v)*(j-v)));
				double dist1 = (((i-u)*(i-u))+((j-v)*(j-v)));
				String ops = Double.toString(dist1);
				String ops1 = Double.toString(dist);
				ERRO = "i: "+i+" j: "+j+" u: "+u+" v: "+v+" sqrt de: "+ops+" e fim de: "+ops1;

				c = u;
				d = v;

				if (start == true) {	
					prob = generator.nextInt(27);
					//prob = 20;
					//System.out.println(prob+"<---"); //------------------------------------------
					//System.out.println("u: "+u+" v: "+v+" i: "+i+" j: "+j+" mira_x: "+mira_x+" mira_y: "+mira_y);

					if (prob > 11) {
						if (B_M > 0) {
							B_M--;
							//prob = generator.nextInt(8);
							//prob = 1;
							if (u < i){
								if (v < j) {
									mira_y = (i-u);
									mira_x = (j-v);
									if ((mira_y-3) <= mira_x && (mira_y+3) >= mira_x) {
										shot = 7;
									} else{
										if (mira_x == 1) {
											shot = 6;	
										} else{
											if (mira_y == 1) {
												shot = 0;
											} else{
												prob = generator.nextInt(12);
											}
										}
									}
								} else{
									if (v > j) {
									mira_y = (i-u);
									mira_x = (v-j);
									if ((mira_y-3) <= mira_x && (mira_y+3) >= mira_x) {
										shot = 5;
									} else{
										if (mira_x == 1) {
											shot = 6;	
										} else{
											if (mira_y == 1) {
												shot = 4;
											} else{
												prob = generator.nextInt(12);
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
										mira_y = (u-i);
										mira_x = (j-v);
										if ((mira_y-3) <= mira_x && (mira_y+3) >= mira_x) {
											shot = 1;
										} else{
											if (mira_x == 1) {
												shot = 2;	
											} else{
												if (mira_y == 1) {
													shot = 0;
												} else{
													prob = generator.nextInt(12);
												}
											}
										}
									} else{
										if (v > j) {
											mira_y = (u-i);
											mira_x = (v-j);
											if ((mira_y-3) <= mira_x && (mira_y+3) >= mira_x) {
												shot = 3;
											} else{
												if (mira_x == 1) {
													shot = 2;	
												} else{
													if (mira_y == 1) {
														shot = 4;
													} else{
														prob = generator.nextInt(12);
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
												B_M++;
											}
										}
									}
								}
							}


							//System.out.println("shot--->"+shot); //------------------------------------------
							switch (shot){
								case 0: // Shoot right / center
								for (int h = v; h < Limx; h++) {
									P[u][h] = "***";
								}
								break;
								case 1: // Shoot right / up
								d = v;
								for (int g = u; g >= 0; g--) {
									if (d < Limx) {
										P[g][d] = "***";
									} else{
										g = -(g + 1);
									}
									d++;
								}
								d = v;
								break;
								case 2: // Shoot up
								for (int g = u; g >= 0; g--) {
									P[g][v] = "***";
								}	
								break;
								case 3: // Shoot left / up
								d = v;
								for (int g = u; g >= 0; g--) {
									if (d >= 0) {
										P[g][d] = "***";
									} else{
										g = -(g + 1);
									}
									d--;
								}
								d = v;
								break;
								case 4: // Shoot left / center
								for (int h = v; h >= 0; h--) {
									P[u][h] = "***";
								}
								break;
								case 5: // Shoot Left / Down
								d = v;
								for (int g = u; g < Limy; g++) {
									if (d >= 0) {
										P[g][d] = "***";
									} else{
										g = Limy;
									}
									d--;
								}
								d = v;
								break;
								case 6: //Shoot down
								for (int g = u; g < Limy; g++) {
									P[g][v] = "***";
								}
								break;
								case 7: // Shoot Right / Down
								d = v;
								for (int g = u; g < Limy; g++) {
									if (d < Limx) {
										P[g][d] = "***";
									} else{
										g = Limy;
									}
									d++;
								}
								d = v;
								break;
								}
							}
						}

					//prob = 20;
					if (prob < 4) {
						if (u < i) {	
							if (generator.nextInt(dice) == 0) {
							 	v++;
							 } else{
							 	u++;
							 }
						} else{
							if (u > i) {
								if (generator.nextInt(dice) == 0) {
								 	v--;
								 } else{
								 	u--;
								 }	
							} else{
								if (v < j) {	
									if (generator.nextInt(dice) == 0) {
										u++;
									} else{
									 	v++;
									}
								}
								if (v > j) {
									if (generator.nextInt(dice) == 0) {
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
								if (generator.nextInt(dice) == 0) {
								 	u++;
								 } else{
								 	v++;
								 }
							} else{
								if (v > j) {
									if (generator.nextInt(dice) == 0) {
									 	u--;
								 	} else{
									 	v--;
								 	}	
								} else{
									if (u < i) {	
										if (generator.nextInt(dice) == 0) {
										 	v++;
										 } else{
										 	u++;
										 }
									} else{
										if (u > i) {
											if (generator.nextInt(dice) == 0) {
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
								if (T_M > 0) {
									T_M--;
									cont_T_M = 1;
									u = generator.nextInt(Limy);
									v = generator.nextInt(Limx);
								} else {
									prob++;
								}
							}
						}
					}
				}

				if (u < 0 || u > (Limy-1) || v < 0 || v > (Limx-1)){
					u = c;
					v = d;
					P[u][v] = " M ";
				} else{
					if (cont_T_M == 1) {
						P[c][d] = "0+0";
						P[u][v] = "0M0";	
				//System.out.println("Teste 1"); //------------------------------------------
					} else{
						P[c][d] = "   ";
						P[u][v] = " M ";
					}
				}



				a = i;
				b = j;


				

				if (D.equals("W") || D.equals("w")){
					i--;
				} else{
					if (D.equals("S") || D.equals("s")) {
						i++;
					} else{
						if (D.equals("A") || D.equals("a")) {
							j--;
						} else{
							if (D.equals("D") || D.equals("d")) {
								j++;
							} else{
								if (D.equals("T") || D.equals("t") || D.equals("wt") || D.equals("st") || D.equals("at") || D.equals("dt") || D.equals("tw") || D.equals("ts") || D.equals("ta") || D.equals("td")) {
									if (T > 0) {
										i =  generator.nextInt(Limy);
										j =  generator.nextInt(Limx);
										T--;
										ERRO = "TELEPORT!!!!";
										cont_T = 1;
									} else{
										ERRO = "You don't have any more teleports";
									}
								} else{
									if (D.equals("Q") || D.equals("q") || D.equals("qt") || D.equals("tq")) {
										if (B > 0) {
											ERRO = "BOMB!!!!!";
											B--;
											for (int g = 0; g < Limy; g++) {
												for (int h = 0; h < Limx; h++) {
													dist = Math.sqrt((i-g)*(i-g)+(j-h)*(j-h));
													if (dist <= 3){
														if (P[g][h] == " M "){
															Points++;
															u = (Limy-1);
															v = (Limx-1);
															P[u][v] = " M ";
														}
														//System.out.println("Teste 4 g: "+g+" h: "+h); //------------------------------------------
														P[g][h] = " * ";
														//System.out.println("Teste 5 g: "+g+" h: "+h); //------------------------------------------
													}
												}	
											}
										} else{
											ERRO = "You don't have any more bombs";
										}
									} else{
										if (D.equals("R") || D.equals("r")) {
											if (G > 0) {
												ERRO = "Land Mine!!!!!";
												G--;
												P_1[i][j] = true;
												cont_G = 1;
											} else{
												ERRO = "You don't have any more mines";
											}

										}
									}
								}
							}
						}
					}
				}
				if (i < 0 || i > (Limy-1) || j < 0 || j > (Limx-1)){
					i = a;
					j = b;
					P[i][j] = " H ";
					YOUCANTSTOP = 1;
					if (P[i][j] == "***") {
						V--;
						P[i][j] = "*H*";
						YOUCANTSTOP = 1;
					}
					ERRO = "You cannot go in that direction!!";
				} else{
					if (cont_T == 1) {
						if (P[a][b] == "***") {
							P[a][b] = "000";
						} else{
							P[a][b] = "000";
						}
						if (P[i][j] == "***") {
							V--;
							P[i][j] = "*H*";
						} else{
							P[i][j] = "0H0";
						}
					} else{
						if (cont_G == 1) {
						} else{
							if (P[a][b] == "***") {
								P[a][b] = "***";
							} else{
								if (P_1[a][b] == true) {
									P[a][b] = " ~ ";
								} else{
									P[a][b] = "   ";
								}
							}
							if (P[i][j] == "***") {
								V--;
								P[i][j] = "*H*";
							} else{
								P[i][j] = " H ";
							}
						}
					}
				}


				if (u == i && j == v) {
					V--;
					P[i][j] = " X ";
					u 		= (Limy-1);
					v 		= (Limx-1);
				}

				Mina(P, P_1, i, j, u, v, Limy, Limx, YOUCANTSTOP, cont_G, Points);
				
					
					

				System.out.println();
				System.out.println();
				System.out.println(ERRO);
				ERRO = " ";
				System.out.println();
				System.out.println(cont+" shifts! (missing "+(200-cont)+" for you to win)");
				System.out.println(V+" lives!");
				System.out.println(Points+" ports! (missing "+(10 - Points)+" for you to win)");
				System.out.println();
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("|"+P[0][0]+"|"+P[0][1]+"|"+P[0][2]+"|"+P[0][3]+"|"+P[0][4]+"|"+P[0][5]+"|"+P[0][6]+"|"+P[0][7]+"|"+P[0][8]+"|"+P[0][9]+"|"+P[0][10]+"|"+P[0][11]+"|"+P[0][12]+"|"+P[0][13]+"|"+P[0][14]+"|"+P[0][15]+"|"+P[0][16]+"|"+P[0][17]+"|"+P[0][18]+"|");
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("|"+P[1][0]+"|"+P[1][1]+"|"+P[1][2]+"|"+P[1][3]+"|"+P[1][4]+"|"+P[1][5]+"|"+P[1][6]+"|"+P[1][7]+"|"+P[1][8]+"|"+P[1][9]+"|"+P[1][10]+"|"+P[1][11]+"|"+P[1][12]+"|"+P[1][13]+"|"+P[1][14]+"|"+P[1][15]+"|"+P[1][16]+"|"+P[1][17]+"|"+P[1][18]+"|");
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("|"+P[2][0]+"|"+P[2][1]+"|"+P[2][2]+"|"+P[2][3]+"|"+P[2][4]+"|"+P[2][5]+"|"+P[2][6]+"|"+P[2][7]+"|"+P[2][8]+"|"+P[2][9]+"|"+P[2][10]+"|"+P[2][11]+"|"+P[2][12]+"|"+P[2][13]+"|"+P[2][14]+"|"+P[2][15]+"|"+P[2][16]+"|"+P[2][17]+"|"+P[2][18]+"|");
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("|"+P[3][0]+"|"+P[3][1]+"|"+P[3][2]+"|"+P[3][3]+"|"+P[3][4]+"|"+P[3][5]+"|"+P[3][6]+"|"+P[3][7]+"|"+P[3][8]+"|"+P[3][9]+"|"+P[3][10]+"|"+P[3][11]+"|"+P[3][12]+"|"+P[3][13]+"|"+P[3][14]+"|"+P[3][15]+"|"+P[3][16]+"|"+P[3][17]+"|"+P[3][18]+"|");
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("|"+P[4][0]+"|"+P[4][1]+"|"+P[4][2]+"|"+P[4][3]+"|"+P[4][4]+"|"+P[4][5]+"|"+P[4][6]+"|"+P[4][7]+"|"+P[4][8]+"|"+P[4][9]+"|"+P[4][10]+"|"+P[4][11]+"|"+P[4][12]+"|"+P[4][13]+"|"+P[4][14]+"|"+P[4][15]+"|"+P[4][16]+"|"+P[4][17]+"|"+P[4][18]+"|");
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("|"+P[5][0]+"|"+P[5][1]+"|"+P[5][2]+"|"+P[5][3]+"|"+P[5][4]+"|"+P[5][5]+"|"+P[5][6]+"|"+P[5][7]+"|"+P[5][8]+"|"+P[5][9]+"|"+P[5][10]+"|"+P[5][11]+"|"+P[5][12]+"|"+P[5][13]+"|"+P[5][14]+"|"+P[5][15]+"|"+P[5][16]+"|"+P[5][17]+"|"+P[5][18]+"|");
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("|"+P[6][0]+"|"+P[6][1]+"|"+P[6][2]+"|"+P[6][3]+"|"+P[6][4]+"|"+P[6][5]+"|"+P[6][6]+"|"+P[6][7]+"|"+P[6][8]+"|"+P[6][9]+"|"+P[6][10]+"|"+P[6][11]+"|"+P[6][12]+"|"+P[6][13]+"|"+P[6][14]+"|"+P[6][15]+"|"+P[6][16]+"|"+P[6][17]+"|"+P[6][18]+"|");
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("|"+P[7][0]+"|"+P[7][1]+"|"+P[7][2]+"|"+P[7][3]+"|"+P[7][4]+"|"+P[7][5]+"|"+P[7][6]+"|"+P[7][7]+"|"+P[7][8]+"|"+P[7][9]+"|"+P[7][10]+"|"+P[7][11]+"|"+P[7][12]+"|"+P[7][13]+"|"+P[7][14]+"|"+P[7][15]+"|"+P[7][16]+"|"+P[7][17]+"|"+P[7][18]+"|");
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("|"+P[8][0]+"|"+P[8][1]+"|"+P[8][2]+"|"+P[8][3]+"|"+P[8][4]+"|"+P[8][5]+"|"+P[8][6]+"|"+P[8][7]+"|"+P[8][8]+"|"+P[8][9]+"|"+P[8][10]+"|"+P[8][11]+"|"+P[8][12]+"|"+P[8][13]+"|"+P[8][14]+"|"+P[8][15]+"|"+P[8][16]+"|"+P[8][17]+"|"+P[8][18]+"|");
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("|"+P[9][0]+"|"+P[9][1]+"|"+P[9][2]+"|"+P[9][3]+"|"+P[9][4]+"|"+P[9][5]+"|"+P[9][6]+"|"+P[9][7]+"|"+P[9][8]+"|"+P[9][9]+"|"+P[9][10]+"|"+P[9][11]+"|"+P[9][12]+"|"+P[9][13]+"|"+P[9][14]+"|"+P[9][15]+"|"+P[9][16]+"|"+P[9][17]+"|"+P[9][18]+"|");
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("|"+P[10][0]+"|"+P[10][1]+"|"+P[10][2]+"|"+P[10][3]+"|"+P[10][4]+"|"+P[10][5]+"|"+P[10][6]+"|"+P[10][7]+"|"+P[10][8]+"|"+P[10][9]+"|"+P[10][10]+"|"+P[10][11]+"|"+P[10][12]+"|"+P[10][13]+"|"+P[10][14]+"|"+P[10][15]+"|"+P[10][16]+"|"+P[10][17]+"|"+P[10][18]+"|");
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("|"+P[11][0]+"|"+P[11][1]+"|"+P[11][2]+"|"+P[11][3]+"|"+P[11][4]+"|"+P[11][5]+"|"+P[11][6]+"|"+P[11][7]+"|"+P[11][8]+"|"+P[11][9]+"|"+P[11][10]+"|"+P[11][11]+"|"+P[11][12]+"|"+P[11][13]+"|"+P[11][14]+"|"+P[11][15]+"|"+P[11][16]+"|"+P[11][17]+"|"+P[11][18]+"|");
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("|"+P[12][0]+"|"+P[12][1]+"|"+P[12][2]+"|"+P[12][3]+"|"+P[12][4]+"|"+P[12][5]+"|"+P[12][6]+"|"+P[12][7]+"|"+P[12][8]+"|"+P[12][9]+"|"+P[12][10]+"|"+P[12][11]+"|"+P[12][12]+"|"+P[12][13]+"|"+P[12][14]+"|"+P[12][15]+"|"+P[12][16]+"|"+P[12][17]+"|"+P[12][18]+"|");
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("|"+P[13][0]+"|"+P[13][1]+"|"+P[13][2]+"|"+P[13][3]+"|"+P[13][4]+"|"+P[13][5]+"|"+P[13][6]+"|"+P[13][7]+"|"+P[13][8]+"|"+P[13][9]+"|"+P[13][10]+"|"+P[13][11]+"|"+P[13][12]+"|"+P[13][13]+"|"+P[13][14]+"|"+P[13][15]+"|"+P[13][16]+"|"+P[13][17]+"|"+P[13][18]+"|");
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("|"+P[14][0]+"|"+P[14][1]+"|"+P[14][2]+"|"+P[14][3]+"|"+P[14][4]+"|"+P[14][5]+"|"+P[14][6]+"|"+P[14][7]+"|"+P[14][8]+"|"+P[14][9]+"|"+P[14][10]+"|"+P[14][11]+"|"+P[14][12]+"|"+P[14][13]+"|"+P[14][14]+"|"+P[14][15]+"|"+P[14][16]+"|"+P[14][17]+"|"+P[14][18]+"|");
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("|"+P[15][0]+"|"+P[15][1]+"|"+P[15][2]+"|"+P[15][3]+"|"+P[15][4]+"|"+P[15][5]+"|"+P[15][6]+"|"+P[15][7]+"|"+P[15][8]+"|"+P[15][9]+"|"+P[15][10]+"|"+P[15][11]+"|"+P[15][12]+"|"+P[15][13]+"|"+P[15][14]+"|"+P[15][15]+"|"+P[15][16]+"|"+P[15][17]+"|"+P[15][18]+"|");
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("|"+P[16][0]+"|"+P[16][1]+"|"+P[16][2]+"|"+P[16][3]+"|"+P[16][4]+"|"+P[16][5]+"|"+P[16][6]+"|"+P[16][7]+"|"+P[16][8]+"|"+P[16][9]+"|"+P[16][10]+"|"+P[16][11]+"|"+P[16][12]+"|"+P[16][13]+"|"+P[16][14]+"|"+P[16][15]+"|"+P[16][16]+"|"+P[16][17]+"|"+P[16][18]+"|");
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("|"+P[17][0]+"|"+P[17][1]+"|"+P[17][2]+"|"+P[17][3]+"|"+P[17][4]+"|"+P[17][5]+"|"+P[17][6]+"|"+P[17][7]+"|"+P[17][8]+"|"+P[17][9]+"|"+P[17][10]+"|"+P[17][11]+"|"+P[17][12]+"|"+P[17][13]+"|"+P[17][14]+"|"+P[17][15]+"|"+P[17][16]+"|"+P[17][17]+"|"+P[17][18]+"|");
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("|"+P[18][0]+"|"+P[18][1]+"|"+P[18][2]+"|"+P[18][3]+"|"+P[18][4]+"|"+P[18][5]+"|"+P[18][6]+"|"+P[18][7]+"|"+P[18][8]+"|"+P[18][9]+"|"+P[18][10]+"|"+P[18][11]+"|"+P[18][12]+"|"+P[18][13]+"|"+P[18][14]+"|"+P[18][15]+"|"+P[18][16]+"|"+P[18][17]+"|"+P[18][18]+"|");
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("|"+P[19][0]+"|"+P[19][1]+"|"+P[19][2]+"|"+P[19][3]+"|"+P[19][4]+"|"+P[19][5]+"|"+P[19][6]+"|"+P[19][7]+"|"+P[19][8]+"|"+P[19][9]+"|"+P[19][10]+"|"+P[19][11]+"|"+P[19][12]+"|"+P[19][13]+"|"+P[19][14]+"|"+P[19][15]+"|"+P[19][16]+"|"+P[19][17]+"|"+P[19][18]+"|");
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("|"+P[20][0]+"|"+P[20][1]+"|"+P[20][2]+"|"+P[20][3]+"|"+P[20][4]+"|"+P[20][5]+"|"+P[20][6]+"|"+P[20][7]+"|"+P[20][8]+"|"+P[20][9]+"|"+P[20][10]+"|"+P[20][11]+"|"+P[20][12]+"|"+P[20][13]+"|"+P[20][14]+"|"+P[20][15]+"|"+P[20][16]+"|"+P[20][17]+"|"+P[20][18]+"|");
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("|"+P[21][0]+"|"+P[21][1]+"|"+P[21][2]+"|"+P[21][3]+"|"+P[21][4]+"|"+P[21][5]+"|"+P[21][6]+"|"+P[21][7]+"|"+P[21][8]+"|"+P[21][9]+"|"+P[21][10]+"|"+P[21][11]+"|"+P[21][12]+"|"+P[21][13]+"|"+P[21][14]+"|"+P[21][15]+"|"+P[21][16]+"|"+P[21][17]+"|"+P[21][18]+"*");
				System.out.println("----------------------------------------------------------------------------*");
				System.out.println("|"+P[22][0]+"|"+P[22][1]+"|"+P[22][2]+"|"+P[22][3]+"|"+P[22][4]+"|"+P[22][5]+"|"+P[22][6]+"|"+P[22][7]+"|"+P[22][8]+"|"+P[22][9]+"|"+P[22][10]+"|"+P[22][11]+"|"+P[22][12]+"|"+P[22][13]+"|"+P[22][14]+"|"+P[22][15]+"|"+P[22][16]+"|"+P[22][17]+"|"+P[22][18]+"*");
				System.out.println("------------------------------------------------------------------------*****");

				System.out.println();
				if (V > 0) {
					System.out.println("You have "+T+" teleportes, "+B+" bombs "+G+" mines");
					System.out.println("W = up; S = low; A = left; D = right; T = teleport; Q = bombs; R = mine");
					System.out.println();
					D = bufferReader.readLine();
					cont++;
				}
			}
			if (V > 0) {
				System.out.println("Congratulations!! YOU WON!!");
			} else{
				System.out.println("More luck next time!");
			}
		} catch(Exception e){
			System.out.println("Reading mistake!");
		}
	}
	public static void Mina(String P[][], boolean P_1[][], int i, int j, int u, int v, int Limy, int Limx, int YOUCANTSTOP, int cont_G, int Points){
		double dist = 0;
		if (P_1[i][j] == true && cont_G != 1) {
			V--;
			P_1[i][j] = false;
			for (int g = 0; g < Limy; g++) {
				for (int h = 0; h < Limx; h++) {
					dist = Math.sqrt((u-g)*(u-g)+(v-h)*(v-h));
					if (dist <= 3) {
						P[g][h] = "#M#";
						Points++;
						u = (Limy-1);
						v = (Limx-1);
						P[u][v] = " M ";
					} else{
						dist = Math.sqrt((i-g)*(i-g)+(j-h)*(j-h));
						if (dist <= 3) {
							P[g][h] = " * ";
						}
					}
					//System.out.println("Teste 5 g: "+g+" h: "+h); //------------------------------------------
				}	
			}
			P[i][j] = "#H#";
		}
		if (P_1[u][v] == true) {
			P_1[u][v] = false;
			Points++;
			for (int g = 0; g < Limy; g++) {
				for (int h = 0; h < Limx; h++) {
					//System.out.println("Teste 4 g: "+g+" h: "+h); //------------------------------------------
					dist = Math.sqrt((u-g)*(u-g)+(v-h)*(v-h));
					if (dist <= 3) {
						P[g][h] = " * ";
					}
				}
			}	
		}
		for (int k = 0; k < Limy; k++) {
			for (int l = 0; l < Limx; l++) {
				if (P[k][l] == " * " || P[k][l] == "***") {
					if (P_1[k][l] == true) {
						P_1[k][l] = false;
						for (int g = 0; g < Limy; g++) {
							for (int h = 0; h < Limx; h++) {
								dist = Math.sqrt((k-g)*(k-g)+(l-h)*(l-h));
								if (dist <= 3) {
									if (g == i && h == j){
										V--;
										P[g][h] = "#H#";
									} else{
										if (g == u && h == v) {
											P[g][h] = "#M#";
											Points++;
											u = (Limy-1);
											v = (Limx-1);
											P[u][v] = " M ";
											P[g][h] = " * ";
										} else{
											P[g][h] = " * ";
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