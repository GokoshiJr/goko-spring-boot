package com.goko.Aspects.services;

import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService {
    @Override
    public String getGreeting(String user, String phrase) {
        return user + ", " + phrase;
    }
}
