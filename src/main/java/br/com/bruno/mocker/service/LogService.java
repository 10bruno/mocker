package br.com.bruno.mocker.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LogService {

    public void showLog(String text) {
        log.info(text);
    }

}
