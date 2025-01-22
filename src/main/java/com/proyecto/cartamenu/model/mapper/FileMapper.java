package com.proyecto.cartamenu.model.mapper;

import com.proyecto.cartamenu.business.services.impl.ProductoServiceImpl;
import com.proyecto.cartamenu.model.dto.FileDto;
import com.proyecto.cartamenu.model.entity.File;
import com.proyecto.cartamenu.model.require.FileRequest;

public class FileMapper {
    public static FileDto toFileDto(File file){
        if(file == null){
            return null;
        }

        if(file.getNombre() != null && file.getExtencion() != null){
            return FileDto.builder()
                    .nombre(file.getNombre())
                    .url(ProductoServiceImpl.generarUrlImagen(file.getNombre().concat(".").concat(file.getExtencion())))
                    .build();
        }
        return FileDto.builder()
                .nombre(file.getNombre())
                .build();
    }

    public static File toFile(FileRequest fileRequest){
        if(fileRequest == null){
            return null;
        }
        return File.builder()
                .id(fileRequest.getId())
                .build();
    }


}
