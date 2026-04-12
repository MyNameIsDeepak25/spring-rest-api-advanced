//package com.infy.ems.security;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService{
//	
//	@Autowired
//	private UserRepository repo;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		User user = repo.findById(username).orElseThrow(()->new UsernameNotFoundException("User Not FOund"));
//		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), 
//				List.of(new SimpleGrantedAuthority(user.getRole()))
//				
//				);
//	}
//	 
//
//}
