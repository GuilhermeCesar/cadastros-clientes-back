package com.essencia.service;

import com.essencia.config.FileStatorageConfig;
import com.essencia.exception.FileStorageException;
import com.essencia.exception.MyFileNotFoundException;
import com.essencia.utils.HashUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService {

    private final Path fileStorageLocalition;

    @Autowired
    public FileStorageService(FileStatorageConfig fileStatorageConfig){
        this.fileStorageLocalition = Paths
                                .get(fileStatorageConfig.getUploadDir())
                                .toAbsolutePath()
                                .normalize();
        try {
            Files.createDirectories(this.fileStorageLocalition);
        }catch (Exception e) {
            throw new FileStorageException("Não foi possivel criar o diretório", e);
        }
    }

    public String storeFile(MultipartFile file){
        String filename = HashUtils.getFilehashSha1(file.getOriginalFilename());

        try {
            if(filename.contains("..")){
                throw new FileStorageException("Desculpe! O nome do arquivo contem caracteres inválidos ".concat(filename));
            }

            Path targetLocation = this.fileStorageLocalition.resolve(filename);
            Files.copy(file.getInputStream(),targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return filename;

        }catch (IOException ex){
            throw new FileStorageException("Não é possivel armazenar o arquivo, Tente Novamente", ex);
        }
    }


    public Resource loadFileAsResouce(String fileName){
        Path filePath = this.fileStorageLocalition.resolve(fileName).normalize();

        try{
            Resource resource = new UrlResource(filePath.toUri());

            if(!resource.exists()) {
                throw new MyFileNotFoundException("Arquivo não existe ".concat(fileName));
            }

            return resource;
        }catch (MalformedURLException ex){
            throw new MyFileNotFoundException("Arquivo não existe ".concat(fileName),ex);
        }
    }
}
