package com.hieukt.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hieukt.entity.RoleEntity;
import com.hieukt.entity.UserEntity;
import com.hieukt.repository.UserRepository;
import com.hieukt.utils.MyUserDetail;

@Service
public class MyUserDetailsService implements UserDetailsService {
	private final Logger log = LoggerFactory.getLogger(MyUserDetailsService.class);

	@Autowired
	private UserRepository userRepository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.findOneByUserName(username);
		if (user == null) {
			log.error("Username not found");
			throw new UsernameNotFoundException("Username not found");
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (RoleEntity role : user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		MyUserDetail myUserDetail = new MyUserDetail(username, user.getPassword(), true, true, true, true, authorities);
		BeanUtils.copyProperties(user, myUserDetail);
		return myUserDetail;
	}

}
