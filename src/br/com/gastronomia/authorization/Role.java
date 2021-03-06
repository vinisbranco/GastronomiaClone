package br.com.gastronomia.authorization;

/* Must be Prime Numbers */
public class Role {
	public static final long ADMINISTRATOR = 2;
	public static final long USER = 3;

	/*
        Get the specific prime number associated with the @role
	 */
	public static long getPrimeNumberFromRole(String role) {
		switch (role) {
		case "administrator":
			return Role.ADMINISTRATOR;

		case "user":
			return Role.USER;

		default:
			return -1;
		}
	}

	/*
        Merge a variety of roles and return the sum
	 */
	public static long merge(long... roles) {
		long rolesSum = 1;

		for (long r : roles)
			rolesSum *= r;

		return rolesSum;
	}
}
