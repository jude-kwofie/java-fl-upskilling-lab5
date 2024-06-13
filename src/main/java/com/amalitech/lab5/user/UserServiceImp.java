package com.amalitech.lab5.user;

import com.amalitech.lab5.user.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;


    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserModel getUserById(long id) {
        return null;
    }

    @Override
    public List<UserModel> getAllUsers() {
        return null;
    }

    @Override
    public UserModel createUser(UserModel user) {
        return null;
    }

    @Override
    public UserModel updateUser(long id, UserModel user) {
        return null;
    }

    @Override
    public void deleteUser(long id) {

    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return   userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }
}
