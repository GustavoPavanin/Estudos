
public class TesteConexao {

	public static void main(String[] args) {

		
		try (Conexao conexao = new Conexao()){
			conexao.leDados();
		} catch(IllegalStateException ex) {
			System.out.println("Deu erro na conexao");
		}
		
		//---------Código legado--------------
		
//		Conexao con = null;
//		try {
//			con = new Conexao();
//			con.leDados();
//		} catch (IllegalStateException ex) {
//			System.out.println("Deu erro na conexao");
//		} finally {
//			System.out.println("finally");
//			/* Complexidade desnecessária
//			if(con != null) {
//				con.close();
//			} 
//			*/
//			
//		}
	}

}
