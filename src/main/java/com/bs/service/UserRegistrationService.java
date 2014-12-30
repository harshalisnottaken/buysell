package com.bs.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sun.misc.BASE64Encoder;

import com.bs.domain.User;
import com.bs.repository.UserRepository;
import com.bs.repository.UserRepositoryCustom;

@Service
public class UserRegistrationService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRepositoryCustom userRepositoryCustom;

	public void registerUser(User user) {
		user.setPassword(makePasswordHash(user.getPassword(), Integer.toString(new SecureRandom().nextInt())));
		userRepository.save(user);
	}
	
	 private String makePasswordHash(String password, String salt) {
	        try {
	            String saltedAndHashed = password + "," + salt;
	            MessageDigest digest = MessageDigest.getInstance("MD5");
	            digest.update(saltedAndHashed.getBytes());
	            BASE64Encoder encoder = new BASE64Encoder();
	            byte hashedBytes[] = (new String(digest.digest(), "UTF-8")).getBytes();
	            return encoder.encode(hashedBytes) + "," + salt;
	        } catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException("MD5 is not available", e);
	        } catch (UnsupportedEncodingException e) {
	            throw new RuntimeException("UTF-8 unavailable?  Not a chance", e);
	        }
	    }

	public void updatePassword(User user) {
		user.setPassword(makePasswordHash(user.getPassword(), Integer.toString(new SecureRandom().nextInt())));
		userRepositoryCustom.updatePassword(user);
	}

	public void updateUser(User user) {
		userRepositoryCustom.updateUser(user);
	}

	public User retrieveUser(String emailId) {
		return userRepository.findOne(emailId);
	}

	public boolean checkUserExistsOrNot(String emailId) {
		return userRepository.exists(emailId);
	}
}
