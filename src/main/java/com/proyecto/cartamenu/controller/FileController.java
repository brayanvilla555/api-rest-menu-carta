package com.proyecto.cartamenu.controller;

import com.proyecto.cartamenu.business.services.FileService;
import com.proyecto.cartamenu.model.entity.File;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;


import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/archivos")
public class FileController {
    private final FileService fileService;

    @PostMapping
    public ResponseEntity<File> subirArchivo(@RequestParam("file") MultipartFile file) throws IOException {
        return ResponseEntity.ok(fileService.subirArchivo(file));
    }

    @GetMapping("/{filename}")
    public ResponseEntity<Resource> verArchivo(@PathVariable String filename) {
        try {
            Resource resource = fileService.obtenerArchivo(filename);
            String contentType = fileService.determinarTipoContenido(resource.getFile().toPath());

            // Construir la respuesta HTTP
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (IOException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
