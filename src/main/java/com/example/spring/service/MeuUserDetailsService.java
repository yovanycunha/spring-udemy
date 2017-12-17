package com.example.spring.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.spring.entity.Usuario;
import com.example.spring.repository.UsuarioRepository;

@Service
public class MeuUserDetailsService implements UserDetailsService {

	private final UsuarioRepository userRepository;

	@Autowired
	public MeuUserDetailsService(UsuarioRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		Usuario usuario = userRepository.findByEmail(userName);
		if (usuario == null) {
			throw new UsernameNotFoundException(String.format("User do not exists", userName));
		}
		return new UserRepositoryUserDetails(usuario);
	}

	private final static class UserRepositoryUserDetails extends Usuario implements UserDetails {

		private static final long serialVersionUID = 1L;

		private UserRepositoryUserDetails(Usuario usuario) {
			super(usuario);
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return (Collection<? extends GrantedAuthority>) getPerfis();
		}

		@Override
		public String getUsername() {
			return getEmail();
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}

		@Override
		public String getPassword() {
			return getSenha();
		}

	}
}
