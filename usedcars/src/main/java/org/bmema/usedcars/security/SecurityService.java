package org.bmema.usedcars.security;

import org.bmema.usedcars.dao.Dao;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SecurityService implements UserDetailsService {

	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

//	protected static Logger logger = Logger.getLogger("Security Service");
//	
	Dao dao; 

	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}
//
//	public UserDetails loadUserByUsername(String username)
//			throws UsernameNotFoundException, DataAccessException {
//		
//		logger.info("loadUserByUsername called for username: " + username);
//		UserDetails user = null;
//		
//		try {
//			User dbUser = dao.getUser(username);
//			user = new org.springframework.security.core.userdetails.User(
//					dbUser.getUsername(), 
//					dbUser.getPassword().toLowerCase(),
//					true,
//					true,
//					true,
//					true,
//					getAuthorities(dbUser.getAccess()) );
//			logger.info(dbUser.getUsername() + " " + dbUser.getPassword().toLowerCase() + getAuthorities(dbUser.getAccess()));
//		} catch (NotFoundException e) {
//			logger.error("Error in retrieving user", e);
//		} catch (Exception e) {
//			logger.error("Error in retrieving user", e);
//		}
//		return user;
//	}
//	
//	/**
//	 * Retrieves the correct ROLE type depending on the access level, where access level is an Integer.
//	 * Basically, this interprets the access value whether it's for a regular user or admin.
//	 * 
//	 * @param access an integer value representing the access of the user
//	 * @return collection of granted authorities
//	 */
//	public Collection<GrantedAuthority> getAuthorities(Integer access) {
//
//		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);
//		
//		/** 	All users are granted with ROLE_USER access		*/
//	logger.debug("Grant ROLE_USER to this user");
//	authList.add(new SimpleGrantedAuthority("ROLE_USER"));
//	
//	/** 	Check if this user has admin access 
//	 		We interpret Integer(1) as an admin user		*/
//	if ( access.compareTo(1) == 0) {
//		logger.debug("Grant ROLE_ADMIN to this user");
//		authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//		}
//
//		return authList;
//  }
	
}
