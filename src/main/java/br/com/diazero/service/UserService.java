package br.com.diazero.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.diazero.model.User;
import br.com.diazero.model.UserLogin;
import br.com.diazero.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	public UserRepository repository;

	public User Register(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String passwordEncoder = encoder.encode(user.getPassword());
		user.setPassword(passwordEncoder);

		return repository.save(user);
	}

	public Optional<UserLogin> login(Optional<UserLogin> userLogin) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<User> user = repository.findByUser(userLogin.get().getUser());

		if (user.isPresent()) {
			if (encoder.matches(userLogin.get().getPassword(), user.get().getPassword())) {

				String auth = userLogin.get().getUser() + ":" + userLogin.get().getPassword();
				byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodeAuth);

				userLogin.get().setToken(authHeader);
				userLogin.get().setUser(user.get().getUser());

				return userLogin;
			}
		}
		return null;
	}
}
