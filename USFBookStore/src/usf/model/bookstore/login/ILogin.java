package usf.model.bookstore.login;

/**
 * @author rbrossi
 * Login interface to be used into the LoginDAO in 
 * @see LoginDAO
 */
public interface ILogin {
	/*
	 * Permissoes do sistema
	 */
	public static int ADMIM = 0;
	public static int ADV_USER = 1;
	public static int USER = 2;
	public static int CLIENT = 3;
	
	/*
	 * Algorítimos de criptografia para usuários.
	 */
	public static String MD5 = "MD5";
	public static String SHA_1 = "SHA-1";
	public static String SHA_256 = "SHA-256";
}
