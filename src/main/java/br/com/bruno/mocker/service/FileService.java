package br.com.bruno.mocker.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
@Slf4j
public class FileService {

    @Autowired
    public LogService logService;

    public String getFileContent(String path) throws IOException {
        String fileContent = Files.readString(Path.of(path));
        logService.showLog(fileContent);
        return fileContent;
    }

}
