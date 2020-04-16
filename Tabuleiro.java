public class Tabuleiro {
	Peca vPecas[][];
	
	Tabuleiro(){
		vPecas=new Peca[7][7]; 			//criação do tabuleiro com uma matriz de peças
		for(int y=6;y>=0;y--) {			//cria as peças nas posições em que elas devem iniciar
			if (y==0||y==1||y==5||y==6) {
				for (int x=2;x<=4;x++) {
					vPecas[x][y]=new Peca(x,y);	
				}
			}else if (y==2||y==4||y==3) {
				for (int x=0;x<=6;x++) {
					vPecas[x][y]=new Peca(x,y);		 
				}
			}	
		}vPecas[3][3]=null;				//define que o espaço no centro do tabuleiro é vazio
	}
	
	
	void mostraTabuleiro() { 			
		for(int y=6;y>=0;y--) {
			System.out.print(y+1);
			if (y==0||y==1||y==5||y==6) {
				System.out.print("    ");
				for (int x=2;x<=4;x++) {
					if (vPecas[x][y]==null)
						System.out.print(" -");		//printa - nas posições que contém peças
					else 
						System.out.print(" P");		//printa P nas posições que contém peças
				}
				System.out.print("    ");			//printa espaço nas posições que circundam o tabuleiro
			}else if (y==2||y==4||y==3) {
				for (int x=0;x<=6;x++) {
					if (vPecas[x][y]==null)
						System.out.print(" -");
					else 
						System.out.print(" P");		 
				}
			}System.out.print("\n");	
		}
		System.out.println("  a b c d e f g");
		System.out.print("\n");
	}
	
	void modificaTabuleiro(String s) {
		//primeiro o método capta os dados do comando e transforma em posições de matriz:
		char convertLetra[]= {'a','b','c','d','e','f','g'};
		int posX1 = 0,posX2=0;
		
		char l=s.charAt(0);
		int posY1 =Character.getNumericValue(s.charAt(1))-1;
		char m=s.charAt(3);
		int posY2 =Character.getNumericValue(s.charAt(4))-1;
		
		System.out.println("Source: "+l+""+s.charAt(1));
		System.out.println("Target: "+m+""+s.charAt(4));
		
		for (int k=0;k<7;k++) {
			if(l==convertLetra[k])
				posX1 = k;
			if(m==convertLetra[k])
				posX2=k;
		}
		//após isso o método deixa vazio o espaço de onde a peça movida saiu 
		if (vPecas[posX2][posY2]==null) {
			vPecas[posX2][posY2]=vPecas[posX1][posY1];
			vPecas[posX2][posY2].i=posX2;
			vPecas[posX2][posY2].j=posY2;
			
			vPecas[posX1][posY1]=null;
		
		//por fim, também exclui a peça entre as duas posições do comando
		
			if (posX1!=posX2)
				vPecas[(posX1+posX2)/2][posY1]=null;
			else
				vPecas[posX1][(posY1+posY2)/2]=null;
		}else
			System.out.println("Posição de destino já ocupada.");
	}			
}        
   

