public class RestaUm {
	public static void main(String[] args) {
		
		Tabuleiro T=new Tabuleiro();
		
		System.out.println("Tabuleiro  inicial:");
		T.mostraTabuleiro();
		
		CSVReader csv = new CSVReader();
		csv.setDataSource("/home/jonathan/eclipse-workspace/Resta Um/src/arq001.csv");
		String commands[] = csv.requestCommands();
	
		for(int i=0;i<commands.length;i++){
			T.modificaTabuleiro(commands[i]);
			
			T.mostraTabuleiro();
		}
	}
}
