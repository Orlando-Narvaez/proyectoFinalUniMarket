package co.edu.uniquindio.unimarket.services.interfaces;

import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public interface CloudinaryService
{
    Map uploadImage(File file, String carp) throws Exception;

    Map deleteImage(String idImage) throws Exception;

    File convert(MultipartFile image) throws IOException;
}