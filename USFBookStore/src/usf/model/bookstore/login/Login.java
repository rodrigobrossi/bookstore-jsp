package usf.model.bookstore.login;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import usf.model.bookstore.basic.ModelBasic;

public class Login implements ModelBasic,ILogin {

	private String login;
	private String passwd;
	private int permissions;
	private int id;

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		if (passwd != null) {
			this.passwd = getPassword(passwd, ILogin.SHA_256);
		}
	}

	public int getPermissions() {
		return permissions;
	}

	public void setPermissions(int permissions) {
		this.permissions = permissions;
	}

	public Login() {
		// Empty constructor
	}

	public Login(String login, String passwd, int permissions) {
		super();
		this.login = login;

		if (passwd != null) {
			this.passwd = getPassword(passwd, ILogin.SHA_256);
		}
		this.permissions = permissions;
	}

	Login(int id, String login, String passwd, int permissions) {
		super();
		
		this.id = id;
		this.login = login;

		if (passwd != null) {
			this.passwd = getPassword(passwd, ILogin.SHA_256);
		}
		this.permissions = permissions;
	}

	/**
	 * Generates a MD5 as an example.
	 * 
	 * @param pwd
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	@SuppressWarnings("unchecked")
	private static byte[] generatesMD5(String pwd) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(pwd.getBytes());
		byte[] hashMd5 = md.digest();
		return hashMd5;
	}

	private static String stringHexa(byte[] bytes) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
			int parteBaixa = bytes[i] & 0xf;
			if (parteAlta == 0)
				s.append('0');
			s.append(Integer.toHexString(parteAlta | parteBaixa));
		}
		return s.toString();
	}

	/**
	 * Create the Login
	 * seguir. MD5 SHA-1 SHA-256
	 * 
	 * @see ILogin
	 * @param frase
	 * @param algoritmo
	 * @return
	 */
	private static byte[] gerarHash(String frase, String algoritmo) {
		try {
			MessageDigest md = MessageDigest.getInstance(algoritmo);
			md.update(frase.getBytes());
			return md.digest();
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

	/**
	 * The static code here is responsible to generate the minimum of application security
	 * @param pwd
	 * @param algorithm
	 * @return A hash code based on one of the algorithms: MD5, SHA-1 or SHA-256
	 */
	public static String getPassword(String pwd, String algorithm) {
		return stringHexa(gerarHash(pwd, algorithm));
	}

	@Override
	public int getId() {
		return id;
	}

}
