package com.proyecto.cartamenu.business.services.impl;

import com.proyecto.cartamenu.business.services.FileService;
import com.proyecto.cartamenu.model.entity.File;
import com.proyecto.cartamenu.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private static final String UPLOAD_DIR = "imagenes-productos/";
    private final FileRepository fileRepository;

    @Override
    public File subirArchivo(MultipartFile file) throws IOException {
        this.crearDirectorio();
        String extencion = Objects.requireNonNull(file.getOriginalFilename()).split("\\.")[1];
        String nombreUnico = this.generarNombreArchivo();
        this.guardarArchivoEnRuta(nombreUnico, extencion,file);

        File fileBd = new File();
        fileBd.setPath(UPLOAD_DIR + nombreUnico.concat(".").concat(extencion));
        fileBd.setNombre(nombreUnico);
        fileBd.setExtencion(extencion);

        return this.guardarEnBd(fileBd);
    }

    @Override
    public Resource obtenerArchivo(String filename) throws IOException {
        Path filePath = Paths.get(UPLOAD_DIR).resolve(filename).normalize();
        Resource resource = new UrlResource(filePath.toUri());

        if (!resource.exists() || !resource.isReadable()) {
            throw new IOException("Archivo no encontrado o no es accesible.");
        }

        return resource;
    }

    @Override
    public String determinarTipoContenido(Path filePath) throws IOException {
        String contentType = Files.probeContentType(filePath);

        if (contentType == null) {
            contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }

        return contentType;
    }

    private void crearDirectorio(){
        Path directorioPath = Paths.get(UPLOAD_DIR);
        if(Files.notExists(directorioPath)) {
            try {
                Files.createDirectories(directorioPath);
            }catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Error al crear directorio", e);
            }
        }
    }

    private String generarNombreArchivo(){
        return UUID.randomUUID().toString() + "-" + System.currentTimeMillis();
    }

    private void guardarArchivoEnRuta(String fileName, String extencion ,MultipartFile file) throws IOException {
        Path filePath = Paths.get(UPLOAD_DIR, fileName.concat(".").concat(extencion));
        Files.write(filePath, file.getBytes());
    }

    private File guardarEnBd(File file) {
        return fileRepository.save(file);
    }

}
