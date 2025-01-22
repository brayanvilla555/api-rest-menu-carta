package com.proyecto.cartamenu.business.services;

import com.proyecto.cartamenu.model.entity.File;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

public interface FileService {
    File subirArchivo(MultipartFile file) throws IOException;

    Resource obtenerArchivo(String filename) throws IOException;

    String determinarTipoContenido(Path path) throws IOException;
}
