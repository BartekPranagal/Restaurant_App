package com.example.restaurant_app.controller;

import com.example.restaurant_app.model.dto.backup.Backup;
import com.example.restaurant_app.service.BackupService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/backup")
public class BackupController {

    private final BackupService backupService;

    @GetMapping(produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> getBackupFile(@RequestParam String format) throws JsonProcessingException {

        Backup backup = backupService.getFullBackup();
        ObjectMapper mapper = getMapper(format);

        return ResponseEntity.status(200)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "export." + format + "\"")
                .body(new ByteArrayResource(mapper.writeValueAsString(backup).getBytes(StandardCharsets.UTF_8)));
    }

    @PostMapping
    public void handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        ObjectMapper mapper = new XmlMapper();
        if(file.getContentType().equals("application/json")){
            mapper = new ObjectMapper();
        }
        Backup backup = mapper.readValue(file.getInputStream(), Backup.class);
        backupService.uploadBackup(backup);
    }

    private ObjectMapper getMapper(String format) {
        if(format.equals("xml")) {
            return new XmlMapper();
        } else {
            return new ObjectMapper();
        }
    }
}
